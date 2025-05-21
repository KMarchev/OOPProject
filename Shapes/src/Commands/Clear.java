package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

/**
 * Command to clear all shapes from the ShapeList.
 */

public class Clear implements Executable {
    /**
     * Executes the clear command.
     *
     * @param args command arguments; expects exactly one argument (the command name).
     * @throws CommandException if the argument count is incorrect.
     * @throws Exception for other execution errors.
     */

    @Override
    public void run(String[] args) throws Exception {
        if(args.length!=1){
            throw new CommandException("Not enough arguments to run this command");
        }
        ShapeList.getInstance().clearShape();
        System.out.println("Shape list cleared.");
    }
}
