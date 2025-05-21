package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

/**
 * Command to translate shapes by given x and y offsets.
 * Can translate all shapes or a specific shape by index.
 */
public class Translate implements Executable {

    /**
     * Executes the translate command.
     *
     * @param args command arguments; expects either:
     *             - 3 arguments: ["translate", "&lt;x&gt;", "&lt;y&gt;"] to translate all shapes
     *             - 4 arguments: ["translate", "&lt;index&gt;", "&lt;x&gt;", "&lt;y&gt;"] to translate a specific shape
     * @throws CommandException if argument count is incorrect, parameters are invalid, or shape index not found.
     * @throws Exception for other execution errors.
     */
    @Override
    public void run(String[] args) throws Exception {
        if(args.length!=3&&args.length!=4)
            throw new CommandException("Not enough arguments to run this command");
        try{
            int index=-1;
            int x=Integer.parseInt(args[args.length-2]);
            int y=Integer.parseInt(args[args.length-1]);
            if(args.length==4){
                index=Integer.parseInt(args[args.length-3]);
            }
            if(args.length==3){
                ShapeList.getInstance().translate(x, y);
                System.out.println("Shapes were translated successfully.");
            }else{
                if(ShapeList.getInstance().getShape(index)==null) throw new CommandException("Shape with the index \""+index+"\" is currently not present.");
                ShapeList.getInstance().getShape(index).translate(x, y);
                System.out.println("Shape was translated successfully.");
            }
        }catch (NumberFormatException ne){
            throw new CommandException("Invalid parameters");
        }catch (Exception e){
            throw e;
        }
    }
}
