package Classes;

import Exceptions.CommandException;
import Interfaces.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Class<? extends Shape>> shapeMap=new HashMap<>();

    static {
        shapeMap.put("rect", Rectangle.class);
        shapeMap.put("circle", Circle.class);
        shapeMap.put("line", Line.class);
    }

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

    public static Class<? extends Shape> getShapeType(String[] args) throws CommandException {
        Class<? extends Shape> shapeClass = shapeMap.get(args[1]);
        if (shapeClass == null) {
            throw new CommandException("Invalid shape type: " + args[1]);
        }
        return shapeClass;
    }

    public static boolean checkMatchType(Shape shape, String[] args) throws CommandException {
        Class<? extends Shape> expectedClass = getShapeType(args);
        return expectedClass.isInstance(shape);
    }
}
