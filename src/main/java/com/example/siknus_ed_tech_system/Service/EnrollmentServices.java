package com.example.siknus_ed_tech_system.Service;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.Enrollment;
import com.example.siknus_ed_tech_system.Pojo.EnrollmentPojo;

import java.util.List;

public interface EnrollmentServices {
    EnrollmentPojo save(EnrollmentPojo enrollmentPojo);

    List<Enrollment> findAll();

}
