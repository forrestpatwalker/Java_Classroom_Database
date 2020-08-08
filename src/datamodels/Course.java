package datamodels;

import exceptionhandlers.InvalidDataException;
import exceptionhandlers.MissingDataException;
import utilities.ConsoleLogger;

import java.io.IOException;
import java.util.logging.Level;

public class Course {

    private String courseID;
    private String courseName;
    private Classroom classroom;



    public void setCourseID(String p_courseID) throws InvalidDataException, MissingDataException {

        if (p_courseID.isEmpty()){
            ConsoleLogger.log(Level.WARNING, Course.class.getName());
            throw new MissingDataException("Course ID required");
        }
        if (!p_courseID.matches("^[a-zA-Z]{4}[0-9]{3}$")){
            ConsoleLogger.log(Level.WARNING, Course.class.getName());
            throw new InvalidDataException("Invalid Course ID");
        }
        this.courseID = p_courseID.substring(0, 4).toUpperCase() +
                p_courseID.substring(4, 7);
    }

    public void setCourseName(String p_courseName) throws MissingDataException{

        if (p_courseName.isEmpty()){
            ConsoleLogger.log(Level.WARNING, Course.class.getName());
            throw new MissingDataException("Course name required");
        }
        this.courseName = p_courseName;
    }

    public void setClassroom(Classroom p_classroom) throws MissingDataException, IOException {
        if (p_classroom == null){
            this.classroom = new Classroom();
        }
        else {
            this.classroom = p_classroom;
        }
    }

    public String getCourseID() { return courseID; }

    public String getCourseName() { return courseName; }

    public Classroom getClassroom() { return classroom; }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", classroom= " + classroom.toString() + '}';
    }

}
