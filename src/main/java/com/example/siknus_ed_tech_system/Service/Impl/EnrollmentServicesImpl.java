package com.example.siknus_ed_tech_system.Service.Impl;

import com.example.siknus_ed_tech_system.Config.PasswordEncoderUtil;
import com.example.siknus_ed_tech_system.Entity.Enrollment;
import com.example.siknus_ed_tech_system.Entity.User;
import com.example.siknus_ed_tech_system.Pojo.EnrollmentPojo;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;
import com.example.siknus_ed_tech_system.Repo.CoursesRepo;
import com.example.siknus_ed_tech_system.Repo.EnrollmentRepo;
import com.example.siknus_ed_tech_system.Repo.UserRepo;
import com.example.siknus_ed_tech_system.Service.EnrollmentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServicesImpl implements EnrollmentServices {
    private  final EnrollmentRepo enrollmentRepo;
    private  final UserRepo userRepo;
    private  final CoursesRepo coursesRepo;

    @Override
    public EnrollmentPojo save(EnrollmentPojo enrollmentPojo) {

        Enrollment enrollment=new Enrollment();

        enrollment.setUser_id(userRepo.findById(enrollmentPojo.getUser_id()).orElseThrow());
        enrollment.setCourses_id(coursesRepo.findById(enrollmentPojo.getCourse_id()).orElseThrow());


        enrollmentRepo.save(enrollment);
        return new EnrollmentPojo(enrollment);
    }

    @Override
    public List<Enrollment> findAll() {
        return this.enrollmentRepo.findAll();
    }

}

