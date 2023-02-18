package com.example.siknus_ed_tech_system.Pojo;

import com.example.siknus_ed_tech_system.Entity.User;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private Integer id;

    private String email;
    private  String birthday;
    private  String fullname;

    private  String gender;
    private  String password;

    private MultipartFile image;

    public UserPojo(User user) {
        this.id=user.getId();
        this.email=user.getEmail();
        this.birthday=user.getBirthday();
        this.fullname=user.getFullname();
        this.gender=user.getGender();
        this.password=user.getPassword();
    }
}