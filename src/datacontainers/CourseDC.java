package datacontainers;

import interfaces.ICourse;

import java.util.ArrayList;
import java.util.List;

public class CourseDC {

    private List<ICourse> listOfCourses = new ArrayList<>();

    public CourseDC(){ }

    public List<ICourse> getListOfCourses() { return listOfCourses; }

    public void setListOfCourses(List<ICourse> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
}
