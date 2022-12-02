package com.edu.qt.repository;
import com.edu.qt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findByNameContains(String username);

}
