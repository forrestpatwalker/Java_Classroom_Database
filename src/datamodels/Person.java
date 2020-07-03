package datamodels;

import exceptionhandlers.MissingDataException;
import interfaces.IPerson;
import java.time.LocalDate;

public class Person implements IPerson{

    private String name;
    private String address;
    private java.time.LocalDate dateOfBirth;

    public void setName(String p_name) throws MissingDataException {
        if(p_name.isEmpty()){
            throw new MissingDataException("Name required");
        }
        this.name = p_name;
    }

    public void setAddress(String p_address) throws MissingDataException {
        if (p_address.isEmpty()){
            throw new MissingDataException("Address required");
        }
        this.address = p_address;
    }

    public void setDateOfBirth(LocalDate p_dateOfBirth) throws MissingDataException {
        if(p_dateOfBirth == null){
            this.dateOfBirth = null;
            throw new MissingDataException("Date of birth required");
        }
        this.dateOfBirth = p_dateOfBirth;
    }

    public String getName() {return name; }

    public String getAddress() { return address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    @Override
    public String toString() {
        return "name=" + name +", address=" + address + ", datOfBirth=" + dateOfBirth;
    }
}
//name=Luke Skywalker, address=Tatooine, dateOfBirth=2018-05-04