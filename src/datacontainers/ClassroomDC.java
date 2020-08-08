/*
 *  This Class contains a list which will hold classroom objects created in the UI
 */
package datacontainers;

import datamodels.Classroom;

import java.util.ArrayList;
import java.util.List;

public class ClassroomDC {

    private List<Classroom> classrooms = new ArrayList<>();

    public ClassroomDC(){ }

    public List<Classroom> getListOfClassrooms() {
        return classrooms;
    }

    public void setListOfClassrooms(List<Classroom> listOfClassrooms) {
        this.classrooms = listOfClassrooms;
    }

}
