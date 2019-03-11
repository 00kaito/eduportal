package com.jdev.eduportal.portal.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/signup")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/signup")
    public String registerPage(@ModelAttribute User user){
        service.createUser(user);
        return "register";
    }

    @PostMapping("/signin")
    public String loginPage(@ModelAttribute User user){
        if(service.verifyUser(user.getEmail(), user.getPassword())){
            return "index";
        }
        return "register";
    }

    @GetMapping("/enroll/{id}")
    public String enroll(@PathVariable long id) {
        service.enrollInCourse(id);
        return "courses";
    }


}
