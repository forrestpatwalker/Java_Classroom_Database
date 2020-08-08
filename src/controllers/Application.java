/*
 * This is the main entry into the application. It creates a menu controller object
 * and the controller object creates the forms and the data models as needed
 */
package controllers;

import utilities.ConsoleLogger;
import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        String fileLocation = "./";

        if (args.length == 0) {

            ConsoleLogger.fileLocation(fileLocation);

            // Create main menu controller, the controller creates the menu form
            MainMenuController controller = new MainMenuController(fileLocation);

            // Retrieve the main menu form from the controller and make it visible
            controller.getMainMenu().setVisible(true);
        }
        else {
            ConsoleLogger.fileLocation(fileLocation);

            // Create main menu controller, the controller creates the menu form
            MainMenuController controller = new MainMenuController(fileLocation);

            // Retrieve the main menu form from the controller and make it visible
            controller.getMainMenu().setVisible(true);

            JOptionPane.showMessageDialog(controller.getMainMenu(), "Invalid number of arguments", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }

    }
}
