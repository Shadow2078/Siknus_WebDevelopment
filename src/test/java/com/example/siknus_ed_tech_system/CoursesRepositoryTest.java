package com.example.siknus_ed_tech_system;



import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Repo.CoursesRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoursesRepositoryTest {
    @Autowired
    private CoursesRepo coursesRepo;



    @Test
    @Order(1)
    public void saveCoursesTest() {


        Courses courses = Courses.builder()
                .coursename("rak")
                .coursedescription("a@g.com")
                .instructorsname("Suman")
                .instructorqualification("bsc")
                .rate("1200")
                .courseoverview("Hello")
                .build();


        coursesRepo.save(courses);

        Assertions.assertThat(courses.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCoursesTest() {

        Courses courses = Courses.builder()
                .coursename("rak")
                .coursedescription("a@g.com")
                .instructorsname("Suman")
                .instructorqualification("bsc")
                .rate("1200")
                .courseoverview("Hello")
                .build();

        coursesRepo.save(courses);


        Courses coursesCreated = coursesRepo.findById(courses.getId()).get();
        Assertions.assertThat(coursesCreated.getId()).isEqualTo(courses.getId());

    }

    @Test
    @Order(3)
    public void getListOfCoursesTest(){
        Courses courses = Courses.builder()
                .coursename("rak")
                .coursedescription("a@g.com")
                .instructorsname("Suman")
                .instructorqualification("bsc")
                .rate("1200")
                .courseoverview("Hello")
                .build();


        coursesRepo.save(courses);
        List<Courses> Courses = coursesRepo.findAll();
        Assertions.assertThat(Courses.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateCoursesTest(){
        Courses courses = Courses.builder()
                .coursename("rak")
                .coursedescription("a@g.com")
                .instructorsname("Suman")
                .instructorqualification("bsc")
                .rate("1200")
                .courseoverview("Hello")
                .build();



        coursesRepo.save(courses);

        Courses courses1  = coursesRepo.findById(courses.getId()).get();

        courses1.setCoursename("new name");

        Courses coursesUpdated  = coursesRepo.save(courses1);

        Assertions.assertThat(coursesUpdated.getCoursename()).isEqualTo("new name");

    }

//    @Test
//    @Order(5)
//    public void deleteCoursesTest(){
//
//        Courses courses = Courses.builder()
//                .coursename("rak")
//                .coursedescription("a@g.com")
//                .instructorsname("Suman")
//                .instructorqualification("bsc")
//                .rate("1200")
//                .courseoverview("Hello")
//                .build();
//
//
//
//        coursesRepo.save(courses);
//
////        @Query(value = "SELECT * from")
//
//        Courses courses1 = coursesRepo.findById(courses.getId()).get();
//
//        coursesRepo.delete(courses1);
//
//        Courses courses2 = null;
//        Optional<Courses> optionalCourses = coursesRepo.finByEmail("a@g.com");
//        if(optionalCourses.isPresent()){
//            courses2 = optionalCourses.get();
//        }
//
//        Assertions.assertThat(courses2).isNull();
////        Assertions.assertThat(User1.getId()).isNull();
//    }
}
