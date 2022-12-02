package com.edu.qt.service;

import com.edu.qt.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.edu.qt.model.User;
import com.edu.qt.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public List<User> fetchAllUsers() {
        List<User> users = (List<User>)userRepository.findAll();
        return  users;
    }


    public List<User> fetchUsersByName(String name) {
        List<User> Users= this.userRepository.findByNameContains(name);
        System.out.println(Users);
        return Users;
    }

   /*public void createUser(User user) {
        userRepository.save(user);
        System.out.println("User Created");
    }*/

  /* private List<User>  generateUsers() {
         List<User> users = new ArrayList<>();
         User user = new User();
        // user.setId(1);
         //user.setName("pavan");
         //user.setPass("pass");
         users.add(user);
          return users ;
    }
*/
  public void  persistUser(User user) {
       userRepository.save(user);
       System.out.println("User successfully saved");
   }
}
