package Main;

import Commands.Executer;
import Commands.Program;
import Exceptions.CommandException;
import Exceptions.FileException;
import Interfaces.Executable;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Program.run();
    }
}