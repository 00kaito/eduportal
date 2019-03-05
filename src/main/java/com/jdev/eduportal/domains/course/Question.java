package com.jdev.eduportal.domains.course;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Course course;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<MemoProgress> memoProgresses;

    public Question() {
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(String question, String answer, Course course) {
        this.question = question;
        this.answer = answer;
        this.course = course;
    }
}
