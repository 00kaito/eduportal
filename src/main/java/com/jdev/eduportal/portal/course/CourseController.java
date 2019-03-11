package com.jdev.eduportal.portal.course;

import com.jdev.eduportal.portal.auth.UserRepository;
import com.jdev.eduportal.service.CourseService;
import com.jdev.eduportal.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
    UserRepository userRepository;

    CourseService courseService;
    QuestionService questionService;

    public CourseController(UserRepository userRepository, CourseService courseService, QuestionService questionService) {
        this.userRepository = userRepository;
        this.courseService = courseService;
        this.questionService = questionService;
    }

    @GetMapping({"", "/", "index"})
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/list")
    public String courseList(Model model) {
        model.addAttribute("courses", courseService.getList());
    return "courses";
    }
}
