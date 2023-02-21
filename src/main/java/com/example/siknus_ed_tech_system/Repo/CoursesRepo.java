package com.example.siknus_ed_tech_system.Repo;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursesRepo extends JpaRepository<Courses, Integer> {

//    Optional<Courses> finByEmail(String s);
}
