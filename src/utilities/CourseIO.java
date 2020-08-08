package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import datacontainers.CourseDC;
import datamodels.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class CourseIO {

    public static void writeJSONFile(String fileLocation, CourseDC courseDataContainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "\\course.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(courseDataContainer.getListOfCourses(), jsonFile);

        } catch (Exception exp) {
            ConsoleLogger.log(Level.WARNING, CourseIO.class.getName());
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    public static ArrayList<Course> readJSONFile(String fileLocation) {

        ArrayList<Course> listOfCourses = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "\\course.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Course[] courseArray = gson.fromJson(jsonFile, Course[].class);

            // Convert to arraylist for the data model
            listOfCourses.addAll(Arrays.asList(courseArray));
        } catch (Exception e) {
            ConsoleLogger.log(Level.WARNING, CourseIO.class.getName());
        } finally {
            return listOfCourses;
        }
    }
}
