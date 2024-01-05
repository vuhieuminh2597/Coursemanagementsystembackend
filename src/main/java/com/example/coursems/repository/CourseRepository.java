package com.example.coursems.repository;

import com.example.coursems.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    @Query("SELECT c FROM Course c ")
    Page<Course> findAllCourse (Pageable pageable);
    @Query("SELECT c.id FROM  Course c WHERE c.id = :id")
    Optional<String> findByIdCourseDuplicate(String id);
}
