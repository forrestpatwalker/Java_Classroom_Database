package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import datacontainers.FacultyDC;
import datamodels.Faculty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class FacultyIO {

    public static void writeJSONFile(String fileLocation, FacultyDC facultyDataContainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "\\faculty.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(facultyDataContainer.getListOfFaculty(), jsonFile);

        } catch (Exception exp) {
            ConsoleLogger.log(Level.WARNING, FacultyIO.class.getName());
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    public static ArrayList<Faculty> readJSONFile(String fileLocation) {

        ArrayList<Faculty> listOfFaculty = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "\\faculty.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Faculty[] facultyArray = gson.fromJson(jsonFile, Faculty[].class);

            // Convert to arraylist for the data model
            listOfFaculty.addAll(Arrays.asList(facultyArray));
        } catch (Exception e) {
            ConsoleLogger.log(Level.WARNING, FacultyIO.class.getName());
        } finally {
            return listOfFaculty;
        }
    }
}
