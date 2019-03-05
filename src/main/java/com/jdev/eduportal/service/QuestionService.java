package com.jdev.eduportal.service;

import com.jdev.eduportal.domains.course.Course;
import com.jdev.eduportal.domains.course.Question;
import com.jdev.eduportal.domains.course.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    QuestionRepository questionRepo;
    DbSecureRemover dbSecureRemover;

    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
        dbSecureRemover = new DbSecureRemover(questionRepo);

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

    public boolean removeQuestion(Question question){
        if(question !=null){
            removeQuestion(question.getId());
            return true;
        }
        return false;
    }

    public boolean removeQuestion(Long questionId){
        return dbSecureRemover.removeElementById(questionId);
    }

    public Optional<Question> findQuestionById(Long id){
        return questionRepo.findById(id);
    }

}
