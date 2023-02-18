package com.example.siknus_ed_tech_system.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="courses")

public class Courses{
    @Id
    @SequenceGenerator(name = "jps_user_seq_gen", sequenceName = "jps_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "coursedescription")
    private String coursedescription;

    @Column(name = "instructorsname")
    private String instructorsname;

    @Column(name = "instructosqualification")
    private String instructorqualification;

    @Column(name = "rate")
    private String rate;

    @Column(name = "courseoverview")
    private String courseoverview;

    @Column(name = "image")
    private String image;

    @Transient
    private String imageBase64;



}