package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

public class Translate implements Executable {
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
