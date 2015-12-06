package com.heroesandfriends.stuffmanager.service;

import com.heroesandfriends.stuffmanager.AbstractIntegrationTest;
import com.heroesandfriends.stuffmanager.TestConfig;
import com.heroesandfriends.stuffmanager.dto.StuffDTO;
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
        List<StuffDTO> stuff =  stuffService.getStuf(1L);
        assertEquals(1, stuff.size());
    }

    @org.junit.Test
    public void createStuff() {
        StuffDTO stuffDTO = new StuffDTO();
        stuffDTO.setProjectId(1L);
        stuffDTO.setTitle("Some stuff");
        stuffDTO.setDescription("Some description");

        stuffService.create(stuffDTO);

        List<StuffDTO> stuff = stuffService.getStuf(1L);
        assertEquals(2, stuff.size());
    }
}
