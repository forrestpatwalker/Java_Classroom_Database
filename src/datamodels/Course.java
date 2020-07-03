package datamodels;

import exceptionhandlers.MissingDataException;
import exceptionhandlers.InvalidDataException;
import interfaces.IClassroom;
import interfaces.ICourse;

import java.util.Objects;


public class Course implements ICourse{

    private String courseID;
    private String courseName;
    private IClassroom classroom;

    public void setCourseID(String p_courseID) throws InvalidDataException, MissingDataException {

        if (p_courseID.isEmpty()){
            throw new MissingDataException("Course ID required");
        }
        if (!p_courseID.matches("^[a-zA-Z]{4}[0-9]{3}$")){
            throw new InvalidDataException("Invalid Course ID");
        }
        this.courseID = p_courseID.substring(0, 4).toUpperCase() +
                p_courseID.substring(4, 7);
    }

    public void setCourseName(String p_courseName) throws MissingDataException{

        if (p_courseName.isEmpty()){
            throw new MissingDataException("Course name required");
        }
        this.courseName = p_courseName;
    }

    public void setClassroom(IClassroom p_classroom) throws MissingDataException {
        this.classroom = Objects.requireNonNullElseGet(p_classroom, Classroom::new);
    }

    public String getCourseID() { return courseID; }

    public String getCourseName() { return courseName; }

    public IClassroom getClassroom() { return classroom; }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", classroom= " + classroom.toString() + '}';
    }

}
