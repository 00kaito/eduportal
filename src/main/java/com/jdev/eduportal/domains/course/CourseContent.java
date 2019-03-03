package com.jdev.eduportal.domains.course;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id", nullable=false)
    private Course course;

    @OneToMany(mappedBy = "courseContent", cascade = CascadeType.PERSIST)
    private List<MemoProgress> memoProgresses;

}
