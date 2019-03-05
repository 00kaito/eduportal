package com.jdev.eduportal.domains.course;

import com.jdev.eduportal.domains.user.User;
import com.jdev.eduportal.domains.user.UserRepository;
import com.jdev.eduportal.service.CourseService;
import com.jdev.eduportal.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Optional;

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

    @GetMapping({"","/","index"})
    public String getIndexPage(){
        User user = new User();
        user.setName("Jan Kowalski");
        user.setEmail("jan@kowalski.com");

        Course course = new Course();
        course.setCourseName("Java Pierwsze Kroki");

        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();

        question1.setQuestion("Pytanie 1 Kursu 1");
        question1.setAnswer("Odpowiedź 1  Kursu 1");
        question2.setQuestion("Pytanie 2  Kursu 1");
        question2.setAnswer("Odpowiedź 2  Kursu 1");
        question3.setQuestion("Pytanie 3  Kursu 1");
        question3.setAnswer("Odpowiedź 3  Kursu 1");
        question1.setCourse(course);
        question2.setCourse(course);
//
//        System.out.println(course.getId());
//        courseService.createNewCourse(course);
//        System.out.println(course.getId());
        questionService.addNewQuestion(question1, course);
        System.out.println(course.getId());

        questionService.addNewQuestion(question2, course);
        questionService.addNewQuestion(question3, course);

//        user.getMemoProgresses();

        user.setCourses(Arrays.asList(course));
        userRepository.save(user);

        return "index";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteCourse(){
            questionService.removeQuestion(1L);

        return "deleted: 1" ;
    }


        private void initCourseContent(Course course1, Course course2, Course course3) {


    }
}
