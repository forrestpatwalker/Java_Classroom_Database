package datamodels;

import exceptionhandlers.InvalidDataException;
import exceptionhandlers.MissingDataException;
import utilities.ConsoleLogger;

import java.util.ArrayList;
import java.util.logging.Level;

public class Student extends Person {

    private float gpa;
    private java.time.LocalDate dateOfGraduation;
    private int studentID;
    private ArrayList<Course> listOfCourses = new ArrayList<>();

    public void setGPA(float p_gpa) throws MissingDataException {
        if (p_gpa <= 0.0) {
            ConsoleLogger.log(Level.WARNING, Student.class.getName());
            this.gpa = 0;
            throw new MissingDataException("GPA required");
        }
        this.gpa = p_gpa;
    }

    public void setDateOfGraduation(java.time.LocalDate p_dateOfGraduation){
        this.dateOfGraduation = p_dateOfGraduation;
    }

    public void setStudentID(String p_studentID) throws InvalidDataException, MissingDataException{
        if(p_studentID.isEmpty()){
            ConsoleLogger.log(Level.WARNING, Student.class.getName());
            throw new MissingDataException("Student ID required");
        }
        if(p_studentID.length() != 7){
            ConsoleLogger.log(Level.WARNING, Student.class.getName());
            throw new InvalidDataException("Student ID must be 7 characters long: " + p_studentID);
        }
        if(p_studentID.charAt(0) == '0'){
            ConsoleLogger.log(Level.WARNING, Student.class.getName());
            throw new InvalidDataException("Student ID cannot start with a 0: " + p_studentID);
        }
        if(Integer.parseInt(p_studentID) < 0){
            ConsoleLogger.log(Level.WARNING, Student.class.getName());
            throw new InvalidDataException("Student ID cannot be less than zero");
        }
        this.studentID = Integer.parseInt(p_studentID);
    }

    public float getGPA() { return gpa; }
    public java.time.LocalDate getDateOfGraduation() { return dateOfGraduation; }
    public int getStudentID() { return studentID; }
    public ArrayList<Course> getListOfCourses() { return listOfCourses; }

    @Override
    public String toString(){
        return "Student{" + "name=" + getName() + ", address=" + getAddress() + ", dateOfBirth=" + getDateOfBirth() +
                ", studentID=" + studentID + ", dateOfGraduation=" + dateOfGraduation + ", gpa=" + gpa + ", listOfCourses=" + listOfCourses;
    }

}