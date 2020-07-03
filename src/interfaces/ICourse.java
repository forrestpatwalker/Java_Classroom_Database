package interfaces;

import exceptionhandlers.InvalidDataException;
import exceptionhandlers.MissingDataException;

public interface ICourse {

    public void setClassroom(IClassroom p_classroom) throws MissingDataException;
    public void setCourseName(String p_courseName) throws MissingDataException;
    public void setCourseID(String p_courseID) throws InvalidDataException, MissingDataException;

    public String getCourseName();
    public String getCourseID();
    public IClassroom getClassroom();

}