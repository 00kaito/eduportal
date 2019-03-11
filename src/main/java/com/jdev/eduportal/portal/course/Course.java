package com.jdev.eduportal.portal.course;

import com.jdev.eduportal.portal.auth.User;
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

    private String name;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Question> questions;

    @ManyToMany(mappedBy = "courses")
    private List<User> users;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
