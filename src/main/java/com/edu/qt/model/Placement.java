package com.edu.qt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity(name = "qtms_placement")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "placement_generator")
    @SequenceGenerator(name="placement_generator", sequenceName = "qtms_placement_seq")
    @Column(name = "id")
    Integer id ;

    @Column(name = "course")
    String course ;

    @Column(name = "company_name")
    String companyname;


    @Column(name = "exp")
    String exp ;

    @Column(name = "sal_package")
    String salary;
    @Column(name = "date_of_drive")
    String date_of_drive ;

    @Column(name ="requiremnts")
    String  requiremnts ;

}
