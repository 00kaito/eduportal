package com.jdev.eduportal.service;

import com.jdev.eduportal.portal.course.Course;
import com.jdev.eduportal.portal.course.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    CourseRepository courseRepo;


    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }



    public Course createNewCourse(Course course){
        return createNewCourse(course.getName(), course.getDescription());
    }


    public Course createNewCourse(String name, String description){
        Course course;
        if(null  == description || description.isEmpty()){
            course = new Course(name);
        }else{
            course = new Course(name, description);
        }
        courseRepo.save(course);
        return course;
    }

    public boolean removeCourse(Course course){
        if(course !=null && courseRepo.findById(course.getId()).isPresent()){
            courseRepo.delete(course);
            return true;
        }
        return false;
    }

    public Optional<Course> findCourseById(Long id){
        return courseRepo.findById(id);
    }


    public boolean removeCourseById(Long courseId){

        DbSecureRemover dbSecureRemover = new DbSecureRemover(courseRepo);
        return dbSecureRemover.removeElementById(courseId);
    }

    public List<Course> getList(){
        return courseRepo.findAll();
    }


}
