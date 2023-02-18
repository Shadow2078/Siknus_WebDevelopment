package com.example.siknus_ed_tech_system.Repo;

import com.example.siknus_ed_tech_system.Entity.Blogs;
import com.example.siknus_ed_tech_system.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepo extends JpaRepository<Blogs, Integer> {
}
