package com.jdev.eduportal.domains.course;

import com.jdev.eduportal.domains.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemoProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer progressRate;
    private Integer repetitions;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_course_content", nullable = false)
    private CourseContent courseContent;
}
