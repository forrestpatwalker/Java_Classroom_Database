package datacontainers;

import datamodels.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDC {

    private List<Student> students = new ArrayList<>();

    public StudentDC() { }

    public List<Student> getListOfStudents() { return students; }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.students = listOfStudents;
    }
}
