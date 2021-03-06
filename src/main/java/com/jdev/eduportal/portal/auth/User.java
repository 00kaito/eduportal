package com.jdev.eduportal.portal.auth;

import com.jdev.eduportal.portal.course.Course;
import com.jdev.eduportal.portal.course.MemoProgress;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Email is mandatory")
    private String password;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_course"))
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    private List<MemoProgress> memoProgresses;


    public User() {
    }

    public User(@NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Email is mandatory") String email, @NotBlank(message = "Email is mandatory") String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(@NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Email is mandatory") String email) {
        this.name = name;
        this.email = email;
    }

    public void getMemoProgressByCourse(Long id){
        Optional<Course> course = this.getCourses().stream().filter(c -> c.getId() == id).findFirst();
        if(null == course || null == course.get()){
            throw new IllegalStateException("Course id not exist");
        }
        List<List<MemoProgress>> specificCourseMemoProgress = course.get().getQuestions().stream().map(c -> c.getMemoProgresses()).collect(Collectors.toList());
    }


}
