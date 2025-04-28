package Commands;

import File_Management.ShapeList;
import Interfaces.Executable;

public class Print implements Executable {
    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Printing information for all shapes("+ShapeList.getInstance().getSize()+") currently on the list:\n");
        ShapeList.getInstance().showInfo();

    }
}
