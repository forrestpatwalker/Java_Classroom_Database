package datamodels;

import exceptionhandlers.MissingDataException;
import interfaces.ICourse;
import java.util.ArrayList;
import exceptionhandlers.InvalidDataException;

public class Student extends Person {

    private float gpa;
    private java.time.LocalDate dateOfGraduation;
    private int studentID;
    private ArrayList<ICourse> listOfCourses = new ArrayList<>();

    public void setGPA(float p_gpa) throws MissingDataException {
        if (p_gpa <= 0.0) {
            this.gpa = 0;
            throw new MissingDataException("GPA required");
        }
        this.gpa = p_gpa;
    }

    public void setDateOfGraduation(java.time.LocalDate p_dateOfGraduation){
        this.dateOfGraduation = p_dateOfGraduation;
    }

    public void setStudentID(int p_studentID) throws InvalidDataException, MissingDataException {
        if(String.valueOf(p_studentID) == null){
            throw new MissingDataException("Student ID required");
        }
        if(String.valueOf(p_studentID).length() != 7){
            throw new InvalidDataException("Invalid Student Id: " + p_studentID);
        }
        if(String.valueOf(p_studentID).charAt(0) == '0'){
            throw new InvalidDataException("Student ID cannot start with 0: " + p_studentID);
        }
        if(p_studentID < 0){
            throw new InvalidDataException("Student ID cannot be less than zero");
        }
        this.studentID = p_studentID;
    }

    public void setStudentID(String p_studentID) throws InvalidDataException, MissingDataException{
        if(p_studentID.isEmpty()){
            throw new MissingDataException("Student ID required");
        }
        if(p_studentID.length() != 7){
            throw new InvalidDataException("Student ID must be 7 characters long: " + p_studentID);
        }
        if(p_studentID.charAt(0) == '0'){
            throw new InvalidDataException("Student ID cannot start with a 0: " + p_studentID);
        }
        if(Integer.parseInt(p_studentID) < 0){
            throw new InvalidDataException("Student ID cannot be less than zero");
        }
        this.studentID = Integer.parseInt(p_studentID);
    }

    public float getGPA() { return gpa; }
    public java.time.LocalDate getDateOfGraduation() { return dateOfGraduation; }
    public int getStudentID() { return studentID; }
    public ArrayList<ICourse> getListOfCourses() { return listOfCourses; }

    @Override
    public String toString(){
        return "Student{" + "name=" + getName() + ", address=" + getAddress() + ", dateOfBirth=" + getDateOfBirth() +
                ", studentID=" + studentID + ", dateOfGraduation=" + dateOfGraduation + ", gpa=" + gpa + ", listOfCourses=" + listOfCourses;
    }

}