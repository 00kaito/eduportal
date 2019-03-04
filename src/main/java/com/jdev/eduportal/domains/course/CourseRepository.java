package com.jdev.eduportal.domains.course;

import com.jdev.eduportal.domains.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
