package com.edu.qt.controller;
import com.edu.qt.dto.PlacementDTO;
import com.edu.qt.model.Placement;
import com.edu.qt.service.PlacementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

@RestController
public class PlacementController {
    @Autowired
    PlacementService placementService;
    PlacementDTO placementDTO;
    ModelMapper modelMapper = new ModelMapper();

    public PlacementController() {
    }

    //  @GetMapping(value = "/user/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/placement/all", produces = "application/json")
    public List<PlacementDTO> fetchAllPlacements() {
        System.out.println("In controller...");
        List<Placement> PlacementsList = placementService.fetchAllPlacements();
        List<PlacementDTO> Placements = Arrays.asList(modelMapper.map(PlacementsList, PlacementDTO[].class));
        return Placements;
    }

    @GetMapping(value = "/placement/course/{course}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlacementDTO> fetchPlacementsByCourse(@PathVariable("course") String course) {
        System.out.println("Fetching Placements by course ...");
        List<Placement> PlacementsList = placementService.fetchPlacementByCourse(course);
        List<PlacementDTO> placements = Arrays.asList(modelMapper.map(PlacementsList, PlacementDTO[].class));
        return placements;
    }

    @GetMapping(value = "/placement/companyname/{company_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlacementDTO> fetchPlacementsByCompanyname(@PathVariable("company_name") String companyname) {
        System.out.println("Fetching Placements by course ...");
        List<Placement> PlacementsList = placementService.fetchPlacementByCompanyname(companyname);
        List<PlacementDTO> placements = Arrays.asList(modelMapper.map(PlacementsList, PlacementDTO[].class));
        return placements;
    }


    @PostMapping(value = "/placement/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPlacement(@RequestBody PlacementDTO placementDTO) {
        //this.userDTO = userDTO;
        System.out.println("number of placements in this course==" + placementDTO.getCourse());
        Placement placement = modelMapper.map(placementDTO, Placement.class);
        placementService.persistPlacement(placement);
        return ResponseEntity.ok().body("Placement details registered successfully.");
    }
  /* private User  generateUser(UserDTO userDTO,User user) {
        user.setCourse(userDTO.getName());
        .setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());
        student.setStatus(studentDTO.getStatus());
        student.setName(studentDTO.getName());
        return student ;
    }*/

}
