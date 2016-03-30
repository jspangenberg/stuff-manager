package com.heroesandfriends.stuffmanager.service;

import com.heroesandfriends.stuffmanager.dto.StuffDTO;
import com.heroesandfriends.stuffmanager.entity.Project;
import com.heroesandfriends.stuffmanager.entity.Stuff;
import com.heroesandfriends.stuffmanager.exception.ProjectNotFoundException;
import com.heroesandfriends.stuffmanager.exception.StuffNotFoundException;
import com.heroesandfriends.stuffmanager.repository.ProjectRepository;
import com.heroesandfriends.stuffmanager.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John Spangenberg
 */

@Component("StuffService")
public class StuffService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StuffRepository stuffRepostory;

    /**
     * Returns stuff for a project.
     * Stuff not paginated.
     * @param projectId
     * @return
     */
    public List<StuffDTO> getStuff(Long projectId) {
        List<StuffDTO> stuffDTOs = new ArrayList<StuffDTO>();
        Project project = projectRepository.findOne(projectId);
        convert(stuffDTOs, project);
        return stuffDTOs;
    }


    /**
     *
     * @param stuffDTO
     * @return
     */
    public List<StuffDTO> create(StuffDTO stuffDTO) throws ProjectNotFoundException{

        Project project = projectRepository.findOne(stuffDTO.getProjectId());

        if (project != null) {
            Stuff stuff = new Stuff(stuffDTO.getProjectId(), stuffDTO.getTitle(), stuffDTO.getDescription());
            stuffRepostory.save(stuff);
        } else {
            throw new ProjectNotFoundException();
        }

        return getStuff(project.getProjectId());

    }

    /**
     *
     * @param stuffDTO
     * @return
     */
    public List<StuffDTO> update(StuffDTO stuffDTO) throws StuffNotFoundException {
        Stuff stuff = stuffRepostory.findOne(stuffDTO.getStuffId());

        if (stuff != null) {
            stuff.setTitle(stuffDTO.getTitle());
            stuff.setDescription(stuffDTO.getDescription());
            stuffRepostory.save(stuff);
        } else {
            throw new StuffNotFoundException();
        }

        return getStuff(stuff.getProjectId());
    }


    private void convert(List<StuffDTO> stuffDTOs, Project project) {
        if (project != null) {
            List<Stuff> stuffList = project.getStuff();
            StuffDTO stuffDTO = null;

            for (Stuff stuff : stuffList) {
                stuffDTO = new StuffDTO();
                stuffDTO.setStuffId(stuff.getStuffId());
                stuffDTO.setTitle(stuff.getTitle());
                stuffDTO.setDescription(stuff.getDescription());
                stuffDTO.setProjectId(stuff.getProjectId());
                stuffDTOs.add(stuffDTO);
            }
        }
    }

}
