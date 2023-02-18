package com.example.siknus_ed_tech_system.Pojo;

import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.Enrollment;
import com.example.siknus_ed_tech_system.Entity.User;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentPojo {
    private Integer id;
    private  int course_id;
    private  int user_id;

    public EnrollmentPojo(Enrollment enrollment) {
        this.id=enrollment.getId();
        this.course_id=enrollment.getCourses_id().getId();
        this.user_id=enrollment.getUser_id().getId();

    }
}