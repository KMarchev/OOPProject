package File_Management;

import Interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements Shape {
    private List<Shape> shapeList=new ArrayList<>();
    private String fileName="";

    private static ShapeList instance;

    private ShapeList(){

    }

    public static ShapeList getInstance(){
        if(instance==null){
            instance=new ShapeList();
        }
        return instance;
    }

    @Override
    public void showInfo() {
        for(Shape shape:shapeList){
            shape.showInfo();
            System.out.println("\n");
        }
    }

    @Override
    public String toSVGFormat() {
        StringBuilder myStringBuilder=new StringBuilder();
        for(Shape shape:shapeList){
            myStringBuilder.append(shape.toSVGFormat());
            myStringBuilder.append("\n");
        }
        return myStringBuilder.toString();
    }

    @Override
    public void translate(int dx, int dy) {
        for(Shape shape:shapeList){
            shape.translate(dx, dy);
        }
    }

    @Override
    public boolean within(int x1, int y1, int x2, int y2) {
        for(Shape shape:shapeList){
            if(!shape.within(x1,y1,x2,y2)) return false;
        }
        return true;
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public int getSize() {
        return shapeList.size();
    }

    public Shape getShape(int index) {
        return (index >= 0 && index < shapeList.size()) ? shapeList.get(index) : null;
    }

    public void removeShape(int index) {
        if (index >= 0 && index < shapeList.size()) {
            shapeList.remove(index);
        }
    }

    public void clearShape() {
        shapeList.clear();
    }

    public void setFileName(String fileName){ this.fileName=fileName; }

    public String getFileName(){ return fileName; }

    public List<Shape> getShapeList(){
        return shapeList;
    }
}
