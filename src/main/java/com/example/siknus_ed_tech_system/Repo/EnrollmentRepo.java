package com.example.siknus_ed_tech_system.Repo;

import com.example.siknus_ed_tech_system.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
}
