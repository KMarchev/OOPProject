package Commands;

import Exceptions.CommandException;
import File_Management.FileSaver;
import File_Management.ShapeList;
import Interfaces.Executable;


/**
 * Command to save the current shapes to the opened file.
 */
public class Save implements Executable {


    /**
     * Executes the save command.
     *
     * @param args command arguments (ignored).
     * @throws CommandException if no file is currently opened.
     * @throws Exception for other errors during file saving.
     */
    @Override
    public void run(String[] args) throws Exception {
        if(ShapeList.getInstance().getFileName().isEmpty()){
            throw new CommandException("You haven't opened a file yet.");
        }else{
            FileSaver.saveFile();
            System.out.println("File saved.");
        }
    }
}
