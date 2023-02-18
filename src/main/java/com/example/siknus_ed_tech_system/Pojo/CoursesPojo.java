package com.example.siknus_ed_tech_system.Pojo;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.User;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursesPojo {
    private Integer id;

    private String coursename;
    private  String coursedescription;
    private  String instructorname;

    private  String instructorqualification;
    private  String rate;

    private  String courseoverview;


    private MultipartFile image;

    public CoursesPojo(Courses courses) {
        this.id=courses.getId();
        this.coursename=courses.getCoursename();
        this.coursedescription=courses.getCoursedescription();
        this.instructorname=courses.getInstructorsname();
        this.instructorqualification=courses.getInstructorqualification();
        this.rate=courses.getRate();
        this.courseoverview=courses.getCourseoverview();
    }
}