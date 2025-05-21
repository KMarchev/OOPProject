package Commands;

import Shapes.ShapeFactory;
import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;
import Interfaces.Shape;

/**
 * Command to create a new shape and add it to the ShapeList.
 */

public class Create implements Executable {
    /**
     * Executes the create command by instantiating a shape based on arguments.
     *
     * @param args command arguments; expects shape type and parameters.
     * @throws CommandException if shape type is invalid, constructor not found, or parameters are incorrect.
     * @throws Exception for other execution errors.
     */
    @Override
    public void run(String[] args) throws Exception {
        try{
            Shape shape=ShapeFactory.createShape(args);
            if(shape==null){
                throw new CommandException("Invalid shape type: "+args[1]);
            }
            ShapeList.getInstance().addShape(shape);
            System.out.println("Shape created successfully.");
        }catch(CommandException ce){
            throw ce;
        }catch(NoSuchMethodException e){
            throw new CommandException("Constructor not found for the shape: "+args[1]);
        }catch (Exception e){
            throw new CommandException("Invalid parameters; "+e.getMessage());
        }
    }
}
