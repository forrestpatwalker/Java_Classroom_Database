package datacontainers;

import datamodels.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyDC {

    private List<Faculty> faculty = new ArrayList<>();

    public FacultyDC(){ }

    public List<Faculty> getListOfFaculty() { return faculty; }

    public void setListOfFaculty(List<Faculty> listOfFaculty) {
        this.faculty = listOfFaculty;
    }
}
