package Shapes;

import Exceptions.CommandException;
import Interfaces.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class responsible for creating shape instances dynamically.
 */
public class ShapeFactory {
    private static final Map<String, Class<? extends Shape>> shapeMap=new HashMap<>();

    static {
        shapeMap.put("rect", Rectangle.class);
        shapeMap.put("circle", Circle.class);
        shapeMap.put("line", Line.class);
    }


    /**
     * Creates a shape from an SVG line representation.
     *
     * @param shapeName the SVG tag name (e.g., "rect", "circle", "line")
     * @param line      the line of SVG text containing shape attributes
     * @return a new Shape instance, or null if the shape cannot be created
     */
    public static Shape createShape(String shapeName,String line){
        Class<? extends Shape> newShape=shapeMap.get(shapeName);
        if(newShape!=null){
            try{
                return newShape.getDeclaredConstructor(String.class).newInstance(line);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }


    /**
     * Creates a shape from an array of command-line parameters.
     *
     * @param params the shape creation parameters (e.g., ["create", "circle", "cx", "cy", "r", "fill"])
     * @return a new Shape instance
     * @throws Exception if the shape cannot be instantiated or parameters are invalid
     */
    public static Shape createShape(String[] params) throws Exception{
        Class<? extends Shape> newShape=shapeMap.get(params[1]);
        if(newShape!=null){
            try{
                return newShape.getDeclaredConstructor(String[].class).newInstance((Object) params);
            }catch(NoSuchMethodException e){
                throw new NoSuchMethodException("Constructor not found for the shape: "+params[1]);
            }
            catch (Exception e){
                throw new CommandException("Unknown error; " + e.getCause());
            }
        }
        return null;
    }

    /**
     * Gets the class type of the shape based on input arguments.
     *
     * @param args the command-line arguments (e.g., ["create", "rect", ...])
     * @return the Class object of the shape type
     * @throws CommandException if the shape type is invalid
     */
    public static Class<? extends Shape> getShapeType(String[] args) throws CommandException {
        Class<? extends Shape> shapeClass = shapeMap.get(args[1]);
        if (shapeClass == null) {
            throw new CommandException("Invalid shape type: " + args[1]);
        }
        return shapeClass;
    }


    /**
     * Checks whether the given shape matches the type specified in the arguments.
     *
     * @param shape the shape instance to check
     * @param args  the command-line arguments indicating the expected shape type
     * @return true if the shape matches the expected type, false otherwise
     * @throws CommandException if the shape type in arguments is invalid
     */
    public static boolean checkMatchType(Shape shape, String[] args) throws CommandException {
        Class<? extends Shape> expectedClass = getShapeType(args);
        return expectedClass.isInstance(shape);
    }
}
