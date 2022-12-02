package com.edu.qt.dto;


import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UserDTO {
    Integer id;
    String name;
    String password;
    String role;
    String course;
    String reportingto;
}
