package com.jdev.eduportal.domains.course;

import com.jdev.eduportal.domains.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Question> questions;

    @ManyToMany(mappedBy = "courses")
    private List<User> users;

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
}
