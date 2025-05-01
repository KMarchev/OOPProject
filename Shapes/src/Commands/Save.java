package Commands;

import Exceptions.CommandException;
import File_Management.FileSaver;
import File_Management.ShapeList;
import Interfaces.Executable;

public class Save implements Executable {
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
