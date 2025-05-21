package Commands;

import Exceptions.CommandException;
import Exceptions.FileException;
import File_Management.FileSaver;
import File_Management.ShapeList;
import Interfaces.Executable;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Command to save the current shapes to a new file with a specified name.
 * If the file exists, prompts the user for confirmation to overwrite.
 */
public class SaveAs implements Executable {

    /**
     * Executes the saveas command.
     *
     * @param args command arguments; expects at least two arguments where args[1] is the new file name.
     * @throws CommandException if not enough arguments are provided.
     * @throws FileException if target directory does not exist or invalid user response on overwrite.
     * @throws Exception for other errors during file operations.
     */
    @Override
    public void run(String[] args) throws Exception {
        if(args.length<2){
            throw new CommandException("Not enough arguments to run this command");
        }

        File directory=new File("../files");
        if(!directory.exists()){
            throw new FileException("Directory doesn't exist");
        }

        File fileName=new File(directory+"/"+args[1]+".svg");
        if(fileName.exists()){
            System.out.print("File with the name \""+args[1]+"\" already exists. Do you want to proceed and delete all information that is written on it? Y/N\n> ");
            Scanner scanner=new Scanner(System.in);
            String answer=scanner.nextLine();
            switch (answer){
                case "Y":
                {
                    FileSaver.saveFileAs(args[1]);
                    System.out.println("Information saved to to file successfully");
                }
                break;
                case "N":
                    System.out.println("Operation cancelled!");
                    return;
                default:
                    throw new FileException("Your answer must be either Y(Yes) or N(No)!");
            }
        }else{
            FileSaver.saveFileAs(args[1]);
            System.out.println("Information saved to to file successfully");
        }
    }
}
