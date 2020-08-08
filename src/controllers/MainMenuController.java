/*
 * Listens for events on the menu form.
 * Implements the ActionListener interface which contains a single method,
 * "actionPerformed"
 */
package controllers;

import datacontainers.ClassroomDC;
import datacontainers.CourseDC;
import datacontainers.FacultyDC;
import datacontainers.StudentDC;
import utilities.ClassroomIO;
import utilities.CourseIO;
import utilities.FacultyIO;
import utilities.StudentIO;
import view.MainMenu;

import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {

    // File location
    String fileLocation;

    /**
     * Constructor
     * @param fileLocation
     */
    public MainMenuController(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    // The data models are instantiated here and passed to the
    // constructors for the controllers
    ClassroomDC classroomDC = new ClassroomDC();
    CourseDC  courseDC = new CourseDC();
    FacultyDC facultyDC = new FacultyDC();
    StudentDC studentDC = new StudentDC();


    // The main menu form gets created here. Notice it takes this controller object
    // as an argument to the constructor
    private MainMenu mainMenu = new MainMenu(this);

    /**
     * The ActionListener interface contains a single method, actionPerformed
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {

        //  Figure out which button was clicked
        String menuItemClicked = event.getActionCommand();

        // create the controller which will open the correct form (refer to the controller constructor
        // methods do determine which data container classes need to be passed to the controller constructors)
        if (menuItemClicked.equals("Add Classroom")) {
            InputClassroomFormController inputController = new InputClassroomFormController(classroomDC);
        } else if (menuItemClicked.equals("List Classrooms")) {
            ReportClassroomController reportController = new ReportClassroomController(classroomDC);
        }  if (menuItemClicked.equals("Add Course")) {
            InputCourseFormController inputController = new InputCourseFormController(courseDC, classroomDC);
        } else if (menuItemClicked.equals("List Courses")) {
            ReportCourseController reportController = new ReportCourseController(courseDC);
        }  if (menuItemClicked.equals("Add Faculty")) {
            InputFacultyFormController inputFacultyController = new InputFacultyFormController(facultyDC, courseDC);
        } else if (menuItemClicked.equals("List Faculty")) {
            ReportFacultyController reportController = new ReportFacultyController(facultyDC);
        }  if (menuItemClicked.equals("Add Student")) {
            InputStudentFormController inputController = new InputStudentFormController(studentDC, courseDC);
        } else if (menuItemClicked.equals("List Students")) {
            ReportStudentController reportController = new ReportStudentController(studentDC);
        } else if (menuItemClicked.equals("Exit")) {
            System.exit(0);
        } else if (menuItemClicked.equals("Save Data")) {
            ClassroomIO.writeJSONFile(fileLocation, classroomDC);
            CourseIO.writeJSONFile(fileLocation, courseDC);
            FacultyIO.writeJSONFile(fileLocation, facultyDC);
            StudentIO.writeJSONFile(fileLocation, studentDC);
        } else if (menuItemClicked.equals("Load Data")) {
            classroomDC.setListOfClassrooms(ClassroomIO.readJSONFile(fileLocation));
            courseDC.setListOfCourses(CourseIO.readJSONFile(fileLocation));
            facultyDC.setListOfFaculty(FacultyIO.readJSONFile(fileLocation));
            studentDC.setListOfStudents(StudentIO.readJSONFile(fileLocation));
        }

    }

    // Getter used in the Application.java class
    public MainMenu getMainMenu() {
        return mainMenu;
    }
}