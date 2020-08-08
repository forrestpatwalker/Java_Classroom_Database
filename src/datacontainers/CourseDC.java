package datacontainers;

import datamodels.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDC {

    private List<Course> courses = new ArrayList<>();

    public CourseDC(){ }

    public List<Course> getListOfCourses() { return courses; }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.courses = listOfCourses;
    }
}
