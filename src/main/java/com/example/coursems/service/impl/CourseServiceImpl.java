package com.example.coursems.service.impl;

import com.example.coursems.builder.course.CoursePageBuilder;
import com.example.coursems.cmd.ConstException;
import com.example.coursems.entity.Course;
import com.example.coursems.exception.DuplicateIdException;
import com.example.coursems.exception.InvalidPageParamException;
import com.example.coursems.exception.NotFoundException;
import com.example.coursems.mapper.CourseMapper;
import com.example.coursems.model.course.CourseCreatDTO;
import com.example.coursems.model.course.CourseDTO;
import com.example.coursems.model.course.CoursePage;
import com.example.coursems.model.course.CoursePartialDTO;
import com.example.coursems.repository.CourseRepository;
import com.example.coursems.service.CourseService;
import com.example.coursems.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    /**
     * Service layer
     * Constructor injection
     *
     * @param courseRepository Dependency injection
     * @param courseMapper     Dependency injection
     */
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    /**
     * Service layer
     * Method get list use customize page
     *
     * @param page input
     * @param size input
     * @return CoursePage
     */
    @Override
    public CoursePage getAllCourseService(Integer page, Integer size) {
        if (page < 0 || size <= 0) {
            throw new InvalidPageParamException(ConstException.INVALID_PAGE_PARAMETER, String.valueOf(page), String.valueOf(size));
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursePage = courseRepository.findAllCourse(pageable);
        return new CoursePageBuilder()
                .setPage(page + 1)
                .setData(coursePage.getContent())
                .setNext(page, size, coursePage.getTotalElements(), coursePage.getTotalPages())
                .setPrevious(page + 1, size, coursePage.getTotalElements())
                .setSize(size)
                .setTotalPages(coursePage.getTotalPages())
                .setTotalElement(coursePage.getTotalElements())
                .build();
    }

    /**
     * Service layer
     * Method find course by id
     *
     * @param id input
     * @return CourseDTO
     */
    @Override
    public CourseDTO findByIdCourse(String id) {
        UUIDUtil.validateUUID(id);
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ConstException.COURSE_NOT_FOUND, id)
        );
        return courseMapper.courseMapToCourseDTO(course);
    }

    /**
     * Service layer
     * Method create new a course
     *
     * @param courseCreatDTO input
     * @return CourseDTO
     */
    @Override
    public CourseDTO createNewCourse(CourseCreatDTO courseCreatDTO) {
        UUIDUtil.validateUUID(courseCreatDTO.getId());
        Optional<String> courseId = courseRepository.findByIdCourseDuplicate(courseCreatDTO.getId());
        if (courseId.isPresent()) {
            throw new DuplicateIdException(ConstException.COURSE_ID_IS_DUPLICATE, courseCreatDTO.getId());
        }
        Course course = courseRepository.save(courseMapper.courseCreateDTOMapToCourse(courseCreatDTO));
        return courseMapper.courseMapToCourseDTO(course);
    }

    /**
     * Service layer
     * Method update course
     *
     * @param id        input
     * @param courseDTO input
     * @return CourseDTO
     */
    @Override
    public CourseDTO updateCourse(String id, CourseDTO courseDTO) {
        UUIDUtil.validateUUID(id);
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ConstException.COURSE_NOT_FOUND, id)
        );
        courseRepository.save(courseMapper.updateCourseFromCourseDTO(course, courseDTO));
        return courseMapper.courseMapToCourseDTO(course);
    }

    /**
     * Service layer
     * Method delete a course
     *
     * @param id input
     */
    @Override
    public void deleteCourse(String id) {
        UUIDUtil.validateUUID(id);
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ConstException.COURSE_NOT_FOUND, id)
        );
        courseRepository.delete(course);
    }

    /**
     * Service layer
     * Method delete partial course
     *
     * @param id input
     */
    @Override
    public CourseDTO updatePartial(String id, CoursePartialDTO coursePartialDTO) {
        UUIDUtil.validateUUID(id);
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ConstException.COURSE_NOT_FOUND, id)
        );

        courseRepository.save(courseMapper.updatePartialFromCoursePartialDTO(course, coursePartialDTO));
        return courseMapper.courseMapToCourseDTO(course);
    }
}
