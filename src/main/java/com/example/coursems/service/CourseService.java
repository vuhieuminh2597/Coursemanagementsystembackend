package com.example.coursems.service;

import com.example.coursems.model.course.CourseCreatDTO;
import com.example.coursems.model.course.CourseDTO;
import com.example.coursems.model.course.CoursePage;
import com.example.coursems.model.course.CoursePartialDTO;

public interface CourseService {
    CoursePage getAllCourseService(Integer page, Integer size);
    CourseDTO findByIdCourse (String id);
    CourseDTO createNewCourse (CourseCreatDTO courseCreatDTO);
    CourseDTO updateCourse (String id,CourseDTO courseDTO);
    void deleteCourse (String id);
    CourseDTO updatePartial(String id, CoursePartialDTO coursePartialDTO);
}
