package Main;

import Commands.Executer;
import Commands.Program;
import Exceptions.CommandException;
import Exceptions.FileException;
import Interfaces.Executable;

import java.util.Scanner;


/**
 * Entry point of the SVG Editor application.
 */
public class Application {

    /**
     * Main method that starts the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Program.run();
    }
}