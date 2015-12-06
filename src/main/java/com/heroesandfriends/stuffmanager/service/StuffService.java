package com.heroesandfriends.stuffmanager.service;

import com.heroesandfriends.stuffmanager.dto.StuffDTO;
import com.heroesandfriends.stuffmanager.entity.Project;
import com.heroesandfriends.stuffmanager.entity.Stuff;
import com.heroesandfriends.stuffmanager.repository.ProjectRepository;
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

    /**
     * Returns stuff for a project.
     * Stuff not paginated.
     * @param projectId
     * @return
     */
    public List<StuffDTO> getStuf(Long projectId) {
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
    public List<StuffDTO> create(StuffDTO stuffDTO) {
        Project project = projectRepository.findOne(stuffDTO.getProjectId());

        if (project != null) {
            Stuff stuff = new Stuff(stuffDTO.getTitle(), stuffDTO.getDescription());
            project.getStuff().add(stuff);
            projectRepository.save(project);
        }

        return getStuf(project.getProjectId());
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
                stuffDTOs.add(stuffDTO);
            }
        }
    }
}
