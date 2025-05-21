package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

/**
 * Command to erase a shape from the ShapeList by its index.
 */

public class Erase implements Executable {

    /**
     * Executes the erase command.
     *
     * @param args command arguments; expects at least two arguments,
     *             where args[1] is the 1-based index of the shape to remove.
     * @throws CommandException if arguments are insufficient or invalid.
     * @throws Exception for other execution errors.
     */
    @Override
    public void run(String[] args) throws Exception {
        if(args.length<2) throw new CommandException("Not enough arguments to run this command");
        try{
            int index=Integer.parseInt(args[1])-1;
            if(ShapeList.getInstance().getSize()-1<index){
                System.out.println("Shape with this index is not present.");
            }else{
                ShapeList.getInstance().removeShape(index);
                System.out.println("Shape deleted successfully.");
            }
        }catch (Exception e){
            throw new CommandException("Invalid parameters.");
        }
    }
}
