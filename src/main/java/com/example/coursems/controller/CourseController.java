package com.example.coursems.controller;

import com.example.coursems.controller.base.BaseCourseController;
import com.example.coursems.model.course.CourseCreatDTO;
import com.example.coursems.model.course.CourseDTO;
import com.example.coursems.model.course.CoursePage;
import com.example.coursems.model.course.CoursePartialDTO;
import com.example.coursems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController implements BaseCourseController {
    private CourseService courseService;

    /**
     * Controller layer
     * Constructor injection
     *
     * @param courseService Dependency injection
     */
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Controller layer
     * Method get list use pagination
     *
     * @param page input
     * @param size input
     * @return ResponseEntity<CoursePage>
     */
    @GetMapping
    @Override
    public ResponseEntity<CoursePage> getPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                              @RequestParam(name = "size", defaultValue = "10") Integer size) {
        CoursePage coursePage = courseService.getAllCourseService(page - 1, size);
        return new ResponseEntity<>(coursePage, HttpStatus.OK);
    }

    /**
     * Controller layer
     * Method get by id
     *
     * @param id input
     * @return ResponseEntity<CourseDTO>
     */
    @GetMapping("/getId/{courseId}")
    @Override
    public ResponseEntity<CourseDTO> getById(@PathVariable("courseId") String id) {
        return ResponseEntity.ok(courseService.findByIdCourse(id));
    }

    /**
     * Controller layer
     * method create new a course
     *
     * @param courseCreatDTO input
     * @return ResponseEntity<CourseDTO>
     */
    @PostMapping("/create")
    @Override
    public ResponseEntity<CourseDTO> create(@RequestBody CourseCreatDTO courseCreatDTO) {
        return new ResponseEntity<>(courseService.createNewCourse(courseCreatDTO), HttpStatus.CREATED);
    }

    /**
     * Controller layer
     * Method update a course
     *
     * @param id        input
     * @param courseDTO input
     * @return ResponseEntity<CourseDTO>
     */
    @PutMapping("/update/{courseId}")
    @Override
    public ResponseEntity<CourseDTO> update(@PathVariable("courseId") String id,
                                            @RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDTO));
    }

    /**
     * Controller layer
     * Method delete a course
     *
     * @param id input
     */
    @DeleteMapping("/delete/{courseId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable("courseId") String id) {
        courseService.deleteCourse(id);
    }

    /**
     * Controller layer
     * Method update partial a course
     *
     * @param id               input
     * @param coursePartialDTO input
     * @return ResponseEntity<CourseDTO>
     */
    @PatchMapping("/updatePartial/{CourseId}")
    @Override
    public ResponseEntity<CourseDTO> updatePartial(@PathVariable("CourseId") String id,
                                                   @RequestBody CoursePartialDTO coursePartialDTO) {
        return ResponseEntity.ok(courseService.updatePartial(id, coursePartialDTO));
    }
}
