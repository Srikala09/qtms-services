package com.edu.qt.service;

import com.edu.qt.model.Placement;
import com.edu.qt.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlacementService {
    @Autowired
    PlacementRepository placementRepository ;


    public List<Placement> fetchAllPlacements(){
        List<Placement> placements = (List<Placement>)placementRepository.findAll();
        return placements;
    }

    public List<Placement> fetchPlacementByCourse(String course) {
        List<Placement> placement=placementRepository.findByCourseContains(course);
        System.out.println("no of placements by course=="+placement.size());
        return placement;
    }
    public void  persistPlacement(Placement placement){
        placementRepository.save(placement);

    }

    public List<Placement> fetchPlacementByCompanyname(String companyname) {
        List<Placement> placement=placementRepository.findByCompanynameContains(companyname);
        System.out.println("no of placements by company=="+placement.size());
        return placement;
    }
    // public Placement fetchPlacementByCourse(String course){
    //    return placementRepository.findByCourse(course);
   // }
    /*public List<Placement> fetchPlacementByCourse(String course){
       // return placementRepository.findByPlacement(course);
        return placementRepository.findPlacementbByCourse(course);
    }
    public List<Placement> fetchPlacementByCourse(String course){
        List<Placement>  placement =  placementRepository.findByCourseContains(course);
        System.out.println("no of placements=="+placement.size());
        return placement ;
    }
    public void  persistPlacement(Placement placement){
        placementRepository.save(placement);
        System.out.println("Placements successfully saved");


    }
    public void  modifyCourse(Placement placement) {

        placementRepository.save(placement);

    }*/
}
