package com.kunace.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;
    public void addCourse(Course course) {courseDao.save(course);}
}
