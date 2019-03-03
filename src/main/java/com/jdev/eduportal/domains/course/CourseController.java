package com.jdev.eduportal.domains.course;

import com.jdev.eduportal.domains.user.User;
import com.jdev.eduportal.domains.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CourseController {
    UserRepository userRepository;
    CourseRepository courseRepository;

    public CourseController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping({"","/","index"})
    public String getIndexPage(){
        User user = new User();
        user.setName("Jan Kowalski");
        user.setEmail("jan@kowalski.com");

        Course course1 = new Course();
        course1.setCourseName("Java Pierwsze Kroki");
        Course course2 = new Course();
        course2.setCourseName("Java Zaawansowana");
        Course course3 = new Course();
        course3.setCourseName("React Kurs Video");

        initCourseContent(course1, course2, course3);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

//        user.getMemoProgresses();

        user.setCourses(Arrays.asList(course1, course2, course3));
        userRepository.save(user);

        return "index";
    }

    private void initCourseContent(Course course1, Course course2, Course course3) {
        CourseContent courseContent1 = new CourseContent();
        CourseContent courseContent2 = new CourseContent();
        CourseContent courseContent3 = new CourseContent();
        CourseContent courseContent4 = new CourseContent();
        CourseContent courseContent5 = new CourseContent();
        CourseContent courseContent6 = new CourseContent();

        courseContent1.setQuestion("Pytanie 1 Kursu 1");
        courseContent1.setAnswer("Odpowiedź 1  Kursu 1");
        courseContent2.setQuestion("Pytanie 2  Kursu 1");
        courseContent2.setAnswer("Odpowiedź 2  Kursu 1");
        course1.setCourseContents(Arrays.asList(courseContent1, courseContent2));
//        courseContent1.setCourse(course1);
//        courseContent2.setCourse(course1);

        courseContent3.setQuestion("Pytanie 1 Kursu 2");
        courseContent3.setAnswer("Odpowiedź 1  Kursu 2");
        courseContent4.setQuestion("Pytanie 2  Kursu 2");
        courseContent4.setAnswer("Odpowiedź 2  Kursu 2");
        course2.setCourseContents(Arrays.asList(courseContent3, courseContent4));
//        courseContent3.setCourse(course2);
//        courseContent4.setCourse(course2);

        courseContent5.setQuestion("Pytanie 1 Kursu 3");
        courseContent5.setAnswer("Odpowiedź 1  Kursu 3");
        courseContent6.setQuestion("Pytanie 2  Kursu 3");
        courseContent6.setAnswer("Odpowiedź 2  Kursu 3");
        course3.setCourseContents(Arrays.asList(courseContent5, courseContent6));
//        courseContent5.setCourse(course3);
//        courseContent6.setCourse(course3);
    }
}
