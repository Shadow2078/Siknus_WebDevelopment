package com.example.siknus_ed_tech_system.Pojo;

import com.example.siknus_ed_tech_system.Entity.Blogs;
import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.User;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogsPojo {
    private Integer id;

    private String blogtitle;
    private  String blogcontent;


//    private String image;

//    private MultipartFile image;

    public BlogsPojo(Blogs blogs) {
        this.id=blogs.getId();
        this.blogtitle=blogs.getBlogtitle();
        this.blogcontent=blogs.getBlogcontent();

    }
}