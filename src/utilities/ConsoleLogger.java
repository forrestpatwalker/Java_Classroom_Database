package utilities;

import java.io.IOException;
import java.util.logging.*;

public class ConsoleLogger {

    public Handler fileHandler;
    public SimpleFormatter formatter;
    public static String classNames;
    public static String fileName;
    public static Logger LOGGER;


    private ConsoleLogger() throws IOException{
        LOGGER = Logger.getLogger(classNames);
        LOGGER.setLevel(Level.FINEST);
        fileHandler = new FileHandler(fileName + "\\logs.txt", true);
        formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        LOGGER.addHandler(fileHandler);

    }
    private static Logger getLOGGER(){
        if(LOGGER == null){
            try{
                new ConsoleLogger();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return LOGGER;
    }

    public static void log(Level level, String className){
        classNames = className;
        getLOGGER().log(level, className);
    }

    public static void fileLocation(String location){
        fileName = location;
    }
}
