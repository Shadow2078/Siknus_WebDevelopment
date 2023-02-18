package com.example.siknus_ed_tech_system.Service;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Pojo.CoursesPojo;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;

import java.io.IOException;
import java.util.*;

public interface CoursesService {
    CoursesPojo save(CoursesPojo coursesPojo) throws IOException;
    List<Courses> findAll();

    Courses findById(Integer id);

    void deleteById(Integer id);
}

