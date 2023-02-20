package com.example.siknus_ed_tech_system.Controller;


import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Entity.Enrollment;
import com.example.siknus_ed_tech_system.Entity.User;
import com.example.siknus_ed_tech_system.Pojo.BlogsPojo;
import com.example.siknus_ed_tech_system.Pojo.CoursesPojo;
import com.example.siknus_ed_tech_system.Service.BlogsService;
import com.example.siknus_ed_tech_system.Service.CoursesService;
import com.example.siknus_ed_tech_system.Service.EnrollmentServices;
import com.example.siknus_ed_tech_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CoursesService courseService;
    private final BlogsService blogsService;
    private final UserService userService;
    private final EnrollmentServices enrollmentServices;



    @GetMapping("/addcourse") //first maa chaine kura
    public String getSetting(Model model) {
        model.addAttribute("addcourse",new CoursesPojo());
        return "addcourses";
    }

    @PostMapping ("/savecourses")
    public String saveUser(@Valid CoursesPojo coursesPojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/admin/addcourse";
        }
        courseService.save(coursesPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
        return "redirect:/admin/courselist";
    }

    @GetMapping("/editcourse/{id}")
    public String editApplication(@PathVariable("id") Integer id, Model model) {
        Courses courses = courseService.findById(id);
        model.addAttribute("addcourse", new CoursesPojo(courses));
        return "addcourses";
    }

    @GetMapping("/deletecourse/{id}")
    public String deleteMembers(@PathVariable("id") Integer id) {
        courseService.deleteById(id);
        return "redirect:/admin/courselist";
    }



    @GetMapping("/addblog") //first maa chaine kura
    public String getBlogs(Model model) {
        model.addAttribute("addblog",new BlogsPojo());
        return "BlogAdmin";
    }
    @PostMapping ("/saveblog")
    public String saveBlogs(@Valid BlogsPojo blogsPojo) {
        blogsService.save(blogsPojo);
        return "redirect:/admin/addblog";
    }

    @GetMapping("/userlist") //first maa chaine kura
    public String getUserList(Model model) {
        List<User> users=userService.findAll();
        model.addAttribute("userlist",users);
        return "userslist";
    }

    @GetMapping("/courselist")
    public String getCourseList(Model model) {
        List<Courses> courses=courseService.findAll();
        model.addAttribute("courselist",courses);
        return "listCourse";
    }

    @GetMapping("/Enrollmentlist")
    public String getEnrollmentList(Model model) {
        List<Enrollment> enrollments=enrollmentServices.findAll();
        model.addAttribute("enrolllist",enrollments);
        return "dashboard";
    }


    @GetMapping("/profile")
    public String getProfilePage() {

        return "adminprofile";
    }








    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }


}
