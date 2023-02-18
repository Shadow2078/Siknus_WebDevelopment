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
@Table(name="enrollment")

public class Enrollment{
    @Id
    @SequenceGenerator(name = "jps_user_seq_gen", sequenceName = "jps_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "applied_course_FK", referencedColumnName = "id")
    private Courses courses_id;
    @ManyToOne
    @JoinColumn(name = "applied_User", referencedColumnName = "id")
    private User user_id;



}