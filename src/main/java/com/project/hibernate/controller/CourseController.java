package com.project.hibernate.controller;


import java.util.List;

import javax.validation.Valid;

import com.project.hibernate.entity.Course;
import com.project.hibernate.repository.CourseRepository;
import com.project.hibernate.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;


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

    // SEARCH COURSE BY CATEGORY ID
//    @RequestMapping(value = "/searchCoursesByCategory", method = RequestMethod.POST)
//    public Page<Course> searchCourseByCategory(
//            @RequestParam(name="categoryId",   defaultValue="")     Integer categoryId,
//            @RequestParam(name="page", defaultValue="0") 	int page,
//            @RequestParam(name="size", defaultValue="5") 	int size) {
////        return courseRepository.searchByCategory("%"+categoryId+"%", new PageRequest(page, size));
//        return courseRepository.searchByCategory(categoryId, new PageRequest(page, size));
//    }


    // add
//    @Autowired
//    private ITutorialService tutorialService;
//    @GetMapping("tutorial")
//    public ResponseEntity<Tutorial> getTutorialById(@RequestParam("id") String id) {
//        Tutorial tutorial = tutorialService.getTutorialById(Integer.parseInt(id));
//        return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
//    }
//    @GetMapping("all-tutorials")
//    public ResponseEntity<List<Tutorial>> getAllTutorials() {
//        List<Tutorial> list = tutorialService.getAllTutorials();
//        return new ResponseEntity<List<Tutorial>>(list, HttpStatus.OK);
//    }
//    @PostMapping("tutorial")
//    public ResponseEntity<Void> createTutorial(@RequestBody Tutorial tutorial, UriComponentsBuilder builder) {
//        boolean flag = tutorialService.createTutorial(tutorial);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/tutorial?id={id}").buildAndExpand(tutorial.getTutorialId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//    @PutMapping("tutorial")
//    public ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial) {
//        tutorialService.updateTutorial(tutorial);
//        return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
//    }
//    @DeleteMapping("tutorial")
//    public ResponseEntity<Void> deleteTutorial(@RequestParam("id") String id) {
//        tutorialService.deleteTutorial(Integer.parseInt(id));
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }


}