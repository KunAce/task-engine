package com.kunace.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/createCourse")
    public void createCourse() {
        Course course = new Course();
        course.setCourseName("UnknownCourse");
        course.setDescription("UnknownDescription");
        courseService.addCourse(course);
    }
}
