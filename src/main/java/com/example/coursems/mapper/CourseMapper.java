package com.example.coursems.mapper;

import com.example.coursems.entity.Course;
import com.example.coursems.model.course.CourseCreatDTO;
import com.example.coursems.model.course.CourseDTO;
import com.example.coursems.model.course.CoursePartialDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    /**
     * Class mapper
     * Method map course to courseDTO
     *
     * @param course input
     * @return CourseDTO
     */
    public CourseDTO courseMapToCourseDTO(Course course) {
        return new CourseDTO(course.getId(), course.getName(), course.getDescription());
    }

    /**
     * Class mapper
     * Method map courseCreate to course
     *
     * @param courseCreatDTO input
     * @return Course
     */
    public Course courseCreateDTOMapToCourse(CourseCreatDTO courseCreatDTO) {
        return new Course(courseCreatDTO.getId(), courseCreatDTO.getName(), courseCreatDTO.getDescription());
    }

    /**
     * Class mapper
     * Method update course from courseDTO
     *
     * @param course    input
     * @param courseDTO input
     * @return Course
     */
    public Course updateCourseFromCourseDTO(Course course, CourseDTO courseDTO) {
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        return course;
    }

    /**
     * Class mapper
     * method update partial from coursePartialDTO
     *
     * @param course input
     * @param coursePartialDTO input
     * @return Courrse
     */
    public Course updatePartialFromCoursePartialDTO(Course course, CoursePartialDTO coursePartialDTO) {
        if (coursePartialDTO.getName() != null) {
            course.setName(coursePartialDTO.getName());
        }
        if (coursePartialDTO.getDescription() != null) {
            course.setDescription(coursePartialDTO.getDescription());
        }
        return course;
    }
}
