package com.example.siknus_ed_tech_system.Service.Impl;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.User;
import com.example.siknus_ed_tech_system.Pojo.CoursesPojo;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;
import com.example.siknus_ed_tech_system.Repo.CoursesRepo;
import com.example.siknus_ed_tech_system.Service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepo coursesRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/courses";


    @Override
    public CoursesPojo save(CoursesPojo coursesPojo) throws IOException {
        Courses courses;
        if (coursesPojo.getId() != null) {
            courses = coursesRepo.findById(coursesPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            courses = new Courses();
        }
        courses.setCoursename(coursesPojo.getCoursename());
        courses.setCoursedescription(coursesPojo.getCoursedescription());
        courses.setInstructorsname(coursesPojo.getInstructorname());
        courses.setInstructorqualification(coursesPojo.getInstructorqualification());
        courses.setRate(coursesPojo.getRate());
        courses.setCourseoverview(coursesPojo.getCourseoverview());

            if(coursesPojo.getImage()!=null){
                StringBuilder fileNames = new StringBuilder();
                System.out.println(UPLOAD_DIRECTORY);
                Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, coursesPojo.getImage().getOriginalFilename());
                fileNames.append(coursesPojo.getImage().getOriginalFilename());
                Files.write(fileNameAndPath, coursesPojo.getImage().getBytes());
                courses.setImage(coursesPojo.getImage().getOriginalFilename());
            }

        coursesRepo.save(courses);
        return new CoursesPojo(courses);
    }

    @Override
    public List<Courses> findAll() {
        return findAllInList(coursesRepo.findAll());
    }

    @Override
    public Courses findById(Integer id) {
        Courses courses=coursesRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        courses=Courses.builder()
                .id(courses.getId())
                .coursedescription(courses.getCoursedescription())
                .coursename(courses.getCoursename())
                .courseoverview(courses.getCourseoverview())
                .instructorsname(courses.getInstructorsname())
                .imageBase64(getImageBase64(courses.getImage()))
                .rate(courses.getRate())
                .instructorqualification(courses.getInstructorqualification())
                .build();
        return courses;

    }

    @Override
    public void deleteById(Integer id) {
        coursesRepo.deleteById(id);
    }


    public List<Courses> findAllInList(List<Courses> list) {
        Stream<Courses> allJobsWithImage = list.stream().map(courses ->
                Courses.builder()
                        .id(courses.getId())
                        .coursedescription(courses.getCoursedescription())
                        .coursename(courses.getCoursename())
                        .courseoverview(courses.getCourseoverview())
                        .instructorsname(courses.getInstructorsname())
                        .imageBase64(getImageBase64(courses.getImage()))
                        .rate(courses.getRate())
                        .instructorqualification(courses.getInstructorqualification())
                        .build()
        );
        list = allJobsWithImage.toList();
        return list;
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/courses/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}