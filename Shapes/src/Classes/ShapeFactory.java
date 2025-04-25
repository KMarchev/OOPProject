package Classes;

import Interfaces.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Class<? extends Shape>> shapeMap=new HashMap<>();

    static {
        shapeMap.put("rect", Rectangle.class);
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
}
