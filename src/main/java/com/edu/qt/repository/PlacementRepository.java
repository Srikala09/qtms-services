package com.edu.qt.repository;

import com.edu.qt.model.Placement;
import com.edu.qt.model.Student;
import com.edu.qt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementRepository extends CrudRepository<Placement,Integer> {
    List<Placement> findPlacementByCourse(String course);

    List<Placement> findByCourseContains(String course);

    List<Placement> findByCompanynameContains(String companyname);
}

