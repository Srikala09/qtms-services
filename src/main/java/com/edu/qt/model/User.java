package com.edu.qt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter

@Entity(name="qtms_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "qtms_users_seq")
    @Column(name = "id")
    Integer id ;

    @Column(name = "username")
    String name ;

    @Column(name = "password")
    String password ;

    @Column(name = "role")
    String role ;

    @Column(name = "course")
    String course ;

    @Column(name = "reportingto")
    String reportingto;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = password;
    }

    }
