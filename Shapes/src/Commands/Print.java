package Commands;

import File_Management.ShapeList;
import Interfaces.Executable;

/**
 * Command to print information about all shapes currently stored in the ShapeList.
 */
public class Print implements Executable {

    /**
     * Executes the print command by displaying details of all shapes.
     *
     * @param args command arguments (ignored).
     * @throws Exception for any errors during execution.
     */
    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Printing information for all shapes("+ShapeList.getInstance().getSize()+") currently on the list:\n");
        ShapeList.getInstance().showInfo();

    }
}
