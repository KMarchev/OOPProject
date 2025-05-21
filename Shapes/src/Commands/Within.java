package Commands;

import Shapes.ShapeFactory;
import Exceptions.CommandException;
import File_Management.ShapeList;
import Interfaces.Executable;
import Interfaces.Shape;

/**
 * Command to list shapes within a specified rectangular area.
 * Can filter by shape type optionally.
 */
public class Within implements Executable {

    /**
     * Executes the within command.
     *
     * @param args command arguments; expects either:
     *             - 5 arguments: ["within", "&lt;x1&gt;", "&lt;y1&gt;", "&lt;x2&gt;", "&lt;y2&gt;"]
     *             - 6 arguments: ["within", "&lt;shapeType&gt;", "&lt;x1&gt;", "&lt;y1&gt;", "&lt;x2&gt;", "&lt;y2&gt;"]
     * @throws CommandException if argument count is invalid or coordinates are not integers.
     * @throws Exception for other execution errors.
     */
    @Override
    public void run(String[] args) throws Exception {
        if (args.length != 5 && args.length != 6) {
            throw new CommandException("Invalid number of arguments.");
        }

        try {
            int x1 = Integer.parseInt(args[args.length - 4]);
            int y1 = Integer.parseInt(args[args.length - 3]);
            int x2 = Integer.parseInt(args[args.length - 2]);
            int y2 = Integer.parseInt(args[args.length - 1]);

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);

            if(args.length==5) System.out.println("Shapes within specified area:");
            if(args.length==6) System.out.println("Shapes of type \'"+args[args.length-5]+"\' within specified area:");

            for (Shape shape : ShapeList.getInstance().getShapeList()) {
                boolean isWithin = shape.within(minX, minY, maxX, maxY);
                boolean matchesType = (args.length == 5) || ShapeFactory.checkMatchType(shape, args);

                if (isWithin && matchesType) {
                    shape.showInfo();
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            throw new CommandException("Coordinates must be integers.");
        } catch (Exception e) {
            throw e;
        }
    }
}
