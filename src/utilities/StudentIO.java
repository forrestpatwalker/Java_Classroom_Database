package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import datacontainers.StudentDC;
import datamodels.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class StudentIO {

    public static void writeJSONFile(String fileLocation, StudentDC studentDataContainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "\\student.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(studentDataContainer.getListOfStudents(), jsonFile);

        } catch (Exception exp) {
            ConsoleLogger.log(Level.WARNING, StudentIO.class.getName());
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    public static ArrayList<Student> readJSONFile(String fileLocation) {

        ArrayList<Student> listOfStudents = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "\\student.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Student[] studentArray = gson.fromJson(jsonFile, Student[].class);

            // Convert to arraylist for the data model
            listOfStudents.addAll(Arrays.asList(studentArray));
        } catch (Exception e) {
            ConsoleLogger.log(Level.WARNING, StudentIO.class.getName());
        } finally {
            return listOfStudents;
        }
    }
}
