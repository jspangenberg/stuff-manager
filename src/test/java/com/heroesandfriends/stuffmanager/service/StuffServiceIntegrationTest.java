package com.heroesandfriends.stuffmanager.service;

import com.heroesandfriends.stuffmanager.AbstractIntegrationTest;
import com.heroesandfriends.stuffmanager.TestConfig;
import com.heroesandfriends.stuffmanager.dto.StuffDTO;
import com.heroesandfriends.stuffmanager.entity.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

import java.util.List;

/**
 * @author John Spangenberg
 */

@ContextConfiguration(classes = TestConfig.class)
public class StuffServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    StuffService stuffService;

    @org.junit.Test
    public void findStuffForProject() {
        List<StuffDTO> stuff =  stuffService.getStuff(1L);
        assertEquals(1, stuff.size());
    }

    @org.junit.Test
    public void createStuff() {
        StuffDTO stuffDTO = new StuffDTO();
        stuffDTO.setProjectId(1L);
        stuffDTO.setTitle("Some stuff");
        stuffDTO.setDescription("Some description");

        stuffService.create(stuffDTO);

        List<StuffDTO> stuff = stuffService.getStuff(1L);
        assertEquals(2, stuff.size());
    }

    @org.junit.Test
    public void updateStuff() {
        StuffDTO stuffDTO = new StuffDTO();
        stuffDTO.setTitle("New title");
        stuffDTO.setDescription("New Description");
        stuffDTO.setStuffId(1L);
        stuffDTO.setProjectId(1L);

        List<StuffDTO> stuffDTOs = stuffService.update(stuffDTO);
        assertEquals(1, stuffDTOs.size());
        assertEquals("New title", stuffDTOs.get(0).getTitle());
        assertEquals("New Description", stuffDTOs.get(0).getDescription());

    }
}
