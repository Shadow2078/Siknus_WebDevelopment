package com.example.siknus_ed_tech_system.Service.Impl;

import com.example.siknus_ed_tech_system.Entity.Blogs;
import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Pojo.BlogsPojo;
import com.example.siknus_ed_tech_system.Pojo.CoursesPojo;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;
import com.example.siknus_ed_tech_system.Repo.BlogsRepo;
import com.example.siknus_ed_tech_system.Repo.CoursesRepo;
import com.example.siknus_ed_tech_system.Service.BlogsService;
import com.example.siknus_ed_tech_system.Service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogsServiceImpl implements BlogsService {
    private final BlogsRepo blogsRepo;

    @Override
    public BlogsPojo save(BlogsPojo blogsPojo){
        Blogs blogs;
        if (blogsPojo.getId() != null) {
            blogs = blogsRepo.findById(blogsPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            blogs = new Blogs();
        }
        blogs.setBlogtitle(blogsPojo.getBlogtitle());
        blogs.setBlogcontent(blogsPojo.getBlogcontent());

//        courses.setPassword(PasswordEncoderUtil.getInstance().encode(coursesPojo.getPassword()));

//            if(userPojo.getImage()!=null){
//                StringBuilder fileNames = new StringBuilder();
//                System.out.println(UPLOAD_DIRECTORY);
//                Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());
//                fileNames.append(userPojo.getImage().getOriginalFilename());
//                Files.write(fileNameAndPath, userPojo.getImage().getBytes());
//                user.setImage(userPojo.getImage().getOriginalFilename());
//            }

        blogsRepo.save(blogs);
        return new BlogsPojo(blogs);
    }
}