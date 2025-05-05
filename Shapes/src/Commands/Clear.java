package Commands;

import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;

public class Clear implements Executable {
    @Override
    public void run(String[] args) throws Exception {
        if(args.length!=1){
            throw new CommandException("Not enough arguments to run this command");
        }
        ShapeList.getInstance().clearShape();
        System.out.println("Shape list cleared.");
    }
}
