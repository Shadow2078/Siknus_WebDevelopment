package com.example.siknus_ed_tech_system.Controller;


import com.example.siknus_ed_tech_system.Entity.Courses;
import com.example.siknus_ed_tech_system.Pojo.CoursesPojo;
import com.example.siknus_ed_tech_system.Pojo.EnrollmentPojo;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;
import com.example.siknus_ed_tech_system.Service.CoursesService;
import com.example.siknus_ed_tech_system.Service.EnrollmentServices;
import com.example.siknus_ed_tech_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
        private final UserService userService;
        private final CoursesService coursesService;
        private final EnrollmentServices enrollmentServices;
        @GetMapping("/homepage") //first maa chaine kura
        public String getSetting(Model model) {
        return "index";
        }
        @GetMapping("/register") //first maa chaine kura
        public String getRegister(Model model) {
                model.addAttribute("user", new UserPojo());
                return "signup";
        }
        @PostMapping ("/saveuser")
        public String saveUser(@Valid UserPojo userPojo) {
                userService.save(userPojo);
                return "redirect:/login";
        }

        @GetMapping("/courseslist") //first maa chaine kura
        public String getCourses(Model model) {
                List<Courses> coursesList= coursesService.findAll();
                model.addAttribute("listofcourses", coursesList);
                return "courses";
        }

        @GetMapping("/moreinfomation/{id}")
        public String getMoreInfo(@PathVariable("id") Integer id , Model model, Principal principal) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
                        return "redirect:/login";
                }
                Courses courses= coursesService.findById(id);
                model.addAttribute("enroll", new EnrollmentPojo());
                model.addAttribute("courses", new CoursesPojo(courses));
                model.addAttribute("courses", courses);
                model.addAttribute("info",userService.findByEmail(principal.getName()));
                return "course-inner";
        }

        @PostMapping ("/saveEnroll")
        public String saveEnrollment(@Valid EnrollmentPojo enrollmentPojo) {
                enrollmentServices.save(enrollmentPojo);
                return "redirect:/user/homepage";
        }

        @GetMapping("/about")
        public String getPage() {
                return "/about";
        }

        @GetMapping("/blog")
        public String getBlog() {
                return "/blog";
        }

        @GetMapping("/contact")
        public String getContact() {
                return "/contact";
        }

        @GetMapping("/profile")
        public String getProfile() {
                return "/profile";
        }


}

