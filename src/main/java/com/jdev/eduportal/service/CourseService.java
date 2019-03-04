package com.jdev.eduportal.service;

import com.jdev.eduportal.domains.course.Course;
import com.jdev.eduportal.domains.course.Question;
import com.jdev.eduportal.domains.course.QuestionRepository;
import com.jdev.eduportal.domains.course.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    CourseRepository courseRepo;
    QuestionRepository questionRepo;

    public CourseService(CourseRepository courseRepo, QuestionRepository questionRepo) {
        this.courseRepo = courseRepo;
        this.questionRepo = questionRepo;
    }



    public Course createNewCourse(Course course){
        return createNewCourse(course.getCourseName(), course.getDescription());
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



    public boolean addNewQuestion(Question question, Course course){
        return addNewQuestion( question.getQuestion(), question.getAnswer(), course);
    }

        public boolean addNewQuestion(String question, String answer, Course course){
        Question questionElement = new Question(question, answer, course);
        questionRepo.save(questionElement);
        if(questionRepo.findById(questionElement.getId()).isPresent()){
            return true;
        }
        return false;
    }

    public boolean removeQuestionById(Long questionId){
        Optional<Question> question = questionRepo.findById(questionId);
        if(question.isPresent()){
            questionRepo.delete(question.get());
            return true;
        }
        return false;
    }

}
