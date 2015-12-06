package com.heroesandfriends.stuffmanager.repository;

import static org.junit.Assert.assertEquals;
import com.heroesandfriends.stuffmanager.AbstractIntegrationTest;
import com.heroesandfriends.stuffmanager.entity.Project;
import com.heroesandfriends.stuffmanager.entity.Stuff;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author John Spangenberg
 */
public class ProjectRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    ProjectRepository projectRepository;

    Project project;

    @org.junit.Test
    public void findProjectById() {
        Project project = projectRepository.findOne(1L);
        assertEquals(1, project.getProjectId().longValue());
    }

    @org.junit.Test
    public void findStuffByProjectId() {
        Project project = projectRepository.findOne(1L);
        List<Stuff> stuff = project.getStuff();
        assertEquals(1, stuff.size());
    }
}
