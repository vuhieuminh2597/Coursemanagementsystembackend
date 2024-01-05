package com.example.coursems.controller.base;

import com.example.coursems.model.course.CourseCreatDTO;
import com.example.coursems.model.course.CourseDTO;
import com.example.coursems.model.course.CoursePage;
import com.example.coursems.model.course.CoursePartialDTO;
import org.springframework.http.ResponseEntity;

public interface BaseCourseController {
    ResponseEntity<CoursePage> getPage(Integer page, Integer size);
    ResponseEntity<CourseDTO> getById (String id);
    ResponseEntity<CourseDTO> create (CourseCreatDTO newObject);
    ResponseEntity<CourseDTO> update (String id,CourseDTO object);
   void delete (String id);
    ResponseEntity<CourseDTO> updatePartial (String id, CoursePartialDTO object);
}
