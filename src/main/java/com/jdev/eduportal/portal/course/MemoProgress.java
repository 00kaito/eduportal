package com.jdev.eduportal.portal.course;

import com.jdev.eduportal.portal.auth.User;
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
    @JoinColumn(name = "fk_question", nullable = false)
    private Question question;
}
