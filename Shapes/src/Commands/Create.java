package Commands;

import Classes.ShapeFactory;
import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;
import Interfaces.Shape;

public class Create implements Executable {
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
