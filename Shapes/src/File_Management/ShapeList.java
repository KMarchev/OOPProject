package File_Management;

import Interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements Shape {
    private static List<Shape> shapeList=new ArrayList<>();

    @Override
    public void showInfo() {
        for(Shape shape:shapeList){
            shape.showInfo();
            System.out.println("\n");
        }
    }

    public static void addShape(Shape shape){
        shapeList.add(shape);
    }

    public static Shape getShape(int index){
        return (index >= 0 && index < shapeList.size()) ? shapeList.get(index) : null;
    }

    public static void removeShape(int index){
        if(index>=0 && index<shapeList.size()){
            shapeList.remove(index);
        }
    }

    public static void clearShape(){
        shapeList.clear();
    }

    public static int getSize(){
        return shapeList.size();
    }

}
