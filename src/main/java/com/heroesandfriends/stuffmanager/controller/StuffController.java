package com.heroesandfriends.stuffmanager.controller;

import com.heroesandfriends.stuffmanager.dto.StuffDTO;
import com.heroesandfriends.stuffmanager.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John Spangenberg
 */

@RestController
public class StuffController {


    @Autowired
    StuffService stuffService;

    @RequestMapping(value="sysapi/v1/stuff", method=RequestMethod.GET)
    public List<StuffDTO> stuff(@RequestParam(value="projectId", required=false) Long projectId) {

        List<StuffDTO> stuffDTOs = new ArrayList<StuffDTO>();

        if (projectId != null && projectId > 0) {
            stuffDTOs = stuffService.getStuff(projectId);
        }

        return stuffDTOs;
    }

    /**
     *
     * @param stuff
     * @return
     */
    @RequestMapping(value="sysapi/v1/stuff", method= RequestMethod.POST)
    public List<StuffDTO> create(@RequestBody StuffDTO stuff) {
        return stuffService.create(stuff);
    }


    /**
     *
     * @param stuff
     * @return
     */
    @RequestMapping(value="sysapi/v1/stuff", method= RequestMethod.PUT)
    public List<StuffDTO> update(@RequestBody StuffDTO stuff) {
        return stuffService.update(stuff);
    }

}
