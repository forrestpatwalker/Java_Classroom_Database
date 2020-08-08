package datamodels;

import exceptionhandlers.InvalidDataException;
import exceptionhandlers.MissingDataException;
import utilities.ConsoleLogger;

import java.util.logging.Level;

public class Classroom {

    private String roomNumber = "XXX";
    private String typeOfRoom = "UNKNOWN";
    private int capacity;

    public void setRoomNumber(String p_roomNumber) throws InvalidDataException, MissingDataException {
        // Test for valid room number
        if (p_roomNumber.isEmpty()) {
            ConsoleLogger.log(Level.WARNING, Classroom.class.getName());
            throw new MissingDataException("Room number required");
        }
        if (!p_roomNumber.matches("^[a-zA-Z]{2}[0-9]{3}$")) {
            ConsoleLogger.log(Level.WARNING, Classroom.class.getName());
            throw new InvalidDataException("Invalid room number");
        }
        // If valid, set room number
        this.roomNumber = p_roomNumber.substring(0, 2).toUpperCase() +
                p_roomNumber.substring(2, 5);
    }

    public void setTypeOfRoom(String p_typeOfRoom) throws InvalidDataException, MissingDataException {
        // Test for valid room type
        if (p_typeOfRoom.isEmpty()) {
            ConsoleLogger.log(Level.WARNING, Classroom.class.getName());
            throw new MissingDataException("Room type required");
        }
        if ((!p_typeOfRoom.equalsIgnoreCase("LAB")) && (!p_typeOfRoom.equalsIgnoreCase("CLASSROOM"))
                && (!p_typeOfRoom.equalsIgnoreCase("LECTURE HALL"))) {
            ConsoleLogger.log(Level.WARNING, Classroom.class.getName());
            throw new InvalidDataException("Invalid room type");
        }
        // If valid, set room type
        typeOfRoom = p_typeOfRoom.toUpperCase();

    }

    public void setCapacity(String p_capacity) throws InvalidDataException {

        // Test for valid value
        try {
            Integer.parseInt(p_capacity);
            ConsoleLogger.log(Level.INFO,"Converted capacity from string to int");
        } catch (Exception exp) {
            ConsoleLogger.log(Level.WARNING, Classroom.class.getName());
            throw new InvalidDataException(this.getClass().getName() + ":Room capacity");
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

