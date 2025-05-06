package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

public class Erase implements Executable {
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
