package com.project.hibernate.controller;


import java.util.List;

import javax.validation.Valid;

import com.project.hibernate.entity.Course;
import com.project.hibernate.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    // Get All Notes

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAllCourses() {


        return courseService.listAll();
    }

    // Create a new Note

    @PostMapping("/insert")
    public Course createCourse(@Valid @RequestBody Course course) {

        return courseService.insert(course);
    }

    // Get a Single Note

    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Integer courseId) {
        Course fcourse = new Course();


        fcourse.setCourseId(courseId);
        Course course = courseService.getCourse(fcourse);
        if(course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(course);
    }

    // Update a Note

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
                                               @Valid @RequestBody Course course) {

        Course updatedCourse = courseService.update(course);
        if(updatedCourse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCourse);
    }

    // Delete a Note

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteNote(@PathVariable(value = "id") Integer courseId) {

        Course course = new Course();
        course.setCourseId(courseId);
        Course deletedCourse = courseService.delete(course);

        if(deletedCourse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}