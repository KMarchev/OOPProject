package Commands;

import Exceptions.CommandException;
import Exceptions.FileException;
import Interfaces.Executable;

import java.util.Scanner;

public class Program {
    public static void run(){
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
            } catch (CommandException c) {
                System.err.println("CommandException: "+c.getMessage());
            }catch (FileException f){
                System.err.println("FileException: "+f.getMessage());
            }catch (Exception e){
                System.err.println("Unknown exception: "+e.getMessage());
            }
        }

        console.close();
        System.out.println("Goodbye!");
    }
}
