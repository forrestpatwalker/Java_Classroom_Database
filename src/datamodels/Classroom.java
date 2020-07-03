package datamodels;

import exceptionhandlers.MissingDataException;
import exceptionhandlers.InvalidDataException;
import interfaces.IClassroom;


public class Classroom implements IClassroom {

    private String roomNumber = "XXX";
    private String typeOfRoom = "UNKNOWN";
    private int capacity;

    public void setRoomNumber(String p_roomNumber) throws InvalidDataException, MissingDataException {
        // Test for valid room number
        if (p_roomNumber.isEmpty()) {
            throw new MissingDataException("Room number required");
        }
        if (!p_roomNumber.matches("^[a-zA-Z]{2}[0-9]{3}$")) {
            throw new InvalidDataException("Invalid room number");
        }
        // If valid, set room number
        this.roomNumber = p_roomNumber.substring(0, 2).toUpperCase() +
                p_roomNumber.substring(2, 5);
    }

    public void setTypeOfRoom(String p_typeOfRoom) throws InvalidDataException, MissingDataException {
        // Test for valid room type
        if (p_typeOfRoom.isEmpty()) {
            throw new MissingDataException("Room type required");
        }
        if ((!p_typeOfRoom.equalsIgnoreCase("LAB")) && (!p_typeOfRoom.equalsIgnoreCase("CLASSROOM"))
                && (!p_typeOfRoom.equalsIgnoreCase("LECTURE HALL"))) {
            throw new InvalidDataException("Invalid room type");
        }
        // If valid, set room type
        typeOfRoom = p_typeOfRoom.toUpperCase();
    }

    public void setCapacity(int p_capacity) throws InvalidDataException {

        // Test for valid value
        if (p_capacity <= 0) {
            throw new InvalidDataException("Room capacity " + p_capacity);
        }
        // If valid, set room capacity
        capacity = p_capacity;

    }

    public void setCapacity(String p_capacity) throws InvalidDataException {

        if(Integer.parseInt(p_capacity) <= 0){
            throw new InvalidDataException("Invalid room capacity");
        }
        // If valid, set room capacity
        capacity = Integer.parseInt(p_capacity);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Classroom{" + "roomNumber=" + roomNumber + ", typeOfRoom=" + typeOfRoom + ", capacity=" + capacity + '}';
    }
    
    
}

