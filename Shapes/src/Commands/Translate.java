package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

public class Translate implements Executable {
    @Override
    public void run(String[] args) throws Exception {
        if(args.length==3){
            try{
                int x=Integer.parseInt(args[1]);
                int y=Integer.parseInt(args[2]);
                ShapeList.getInstance().transate(x, y);
                System.out.println("Shapes were translated successfully.");
            }catch (NumberFormatException ne){
                throw new CommandException("Invalid parameters");
            }catch (Exception e){
                throw e;
            }
        }else if(args.length==4){
            try{
                int index=Integer.parseInt(args[1])-1;
                int x=Integer.parseInt(args[2]);
                int y=Integer.parseInt(args[3]);
                if(ShapeList.getInstance().getShape(index)==null) throw new CommandException("Shape with the index \""+index+"\" is currently not present.");
                ShapeList.getInstance().getShape(index).transate(x, y);
                System.out.println("Shape was translated successfully.");
            }catch (NumberFormatException ne){
                throw new CommandException("Invalid parameters");
            }catch (Exception e){
                throw e;
            }
        }else throw new CommandException("Not enough arguments to run this command");
    }
}
