package datamodels;

import exceptionhandlers.MissingDataException;
import interfaces.ICourse;
import java.util.ArrayList;
import exceptionhandlers.InvalidDataException;

public class Faculty extends Person {

    private java.time.LocalDate dateOfHire;
    private double salary;
    private String status = "Full Time";
    private ArrayList<ICourse> listOfCourses = new ArrayList<>();

    public void setDateOfHire(java.time.LocalDate p_dateOfHire){
        this.dateOfHire = p_dateOfHire;
    }

    public void setSalary(double p_salary) throws InvalidDataException{
        if(p_salary < 0.0){
            this.salary = 0.0;
            throw new InvalidDataException("Invalid Salary");
        }
        this.salary = p_salary;
    }

    public void setStatus(String p_status) throws MissingDataException {
        if (p_status.isEmpty()){
            this.status = "Full Time";
            throw new MissingDataException("Status required");
        }
        this.status = p_status;
    }

    public java.time.LocalDate getDateOfHire() { return dateOfHire; }
    public double getSalary() { return salary; }
    public String getStatus() { return status; }
    public ArrayList<ICourse> getListOfCourses() { return listOfCourses; }

    @Override
    public String toString(){
        return "Faculty{" + "name=" + getName() + ", address=" + getAddress() + ", dateOfBirth=" + getDateOfBirth() +
                ", dateOfHire=" + dateOfHire + ", salary=" + salary + ", status=" + status + ", listOfCourses=" + listOfCourses;
    }
}
