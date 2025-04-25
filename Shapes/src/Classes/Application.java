package Classes;

import Commands.Executer;
import Exceptions.CommandException;
import Interfaces.Executable;
import Interfaces.Shape;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("SVG Editor (type 'help' for commands, 'exit' to quit)");

        while (true) {
            System.out.print("> ");
            String line = console.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            try {
                Executable cmd = Executer.executable(parts);
                cmd.run(parts);
            } catch (CommandException e) {
                System.out.println("CommandException: "+e.getMessage());
            }catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        console.close();
        System.out.println("Goodbye!");
    }
}