package File_Management;

import Interfaces.Shape;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton class that manages the list of shapes and the current file name.
 * Implements the Shape interface to provide operations on all stored shapes.
 */
public class ShapeList implements Shape {
    private List<Shape> shapeList=new ArrayList<>();
    private String fileName="";

    private static ShapeList instance;
/**
 * Private constructor to enforce singleton pattern.
 * */
    private ShapeList(){

    }

    /**
     * Returns the singleton instance of ShapeList.
     *
     * @return the single instance of ShapeList
     */
    public static ShapeList getInstance(){
        if(instance==null){
            instance=new ShapeList();
        }
        return instance;
    }

    /**
     * Displays information about all shapes in the list.
     */
    @Override
    public void showInfo() {
        for(Shape shape:shapeList){
            shape.showInfo();
            System.out.println("\n");
        }
    }

    /**
     * Returns the SVG representation of all shapes in the list.
     *
     * @return SVG formatted string representing all shapes
     */
    @Override
    public String toSVGFormat() {
        StringBuilder myStringBuilder=new StringBuilder();
        for(Shape shape:shapeList){
            myStringBuilder.append(shape.toSVGFormat());
            myStringBuilder.append("\n");
        }
        return myStringBuilder.toString();
    }

    /**
     * Translates all shapes by the specified delta in x and y directions.
     *
     * @param dx change in x coordinate
     * @param dy change in y coordinate
     */
    @Override
    public void translate(int dx, int dy) {
        for(Shape shape:shapeList){
            shape.translate(dx, dy);
        }
    }

    /**
     * Checks if all shapes are within the specified rectangular area.
     *
     * @param x1 one x coordinate of the rectangle
     * @param y1 one y coordinate of the rectangle
     * @param x2 the opposite x coordinate of the rectangle
     * @param y2 the opposite y coordinate of the rectangle
     * @return true if all shapes are within the rectangle, false otherwise
     */
    @Override
    public boolean within(int x1, int y1, int x2, int y2) {
        for(Shape shape:shapeList){
            if(!shape.within(x1,y1,x2,y2)) return false;
        }
        return true;
    }

    /**
     * Adds a shape to the list.
     *
     * @param shape the shape to add
     */
    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    /**
     * Returns the number of shapes currently in the list.
     *
     * @return the number of shapes
     */
    public int getSize() {
        return shapeList.size();
    }

    /**
     * Returns the shape at the specified index, or null if the index is invalid.
     *
     * @param index the index of the shape
     * @return the shape at the index or null if invalid
     */
    public Shape getShape(int index) {
        return (index >= 0 && index < shapeList.size()) ? shapeList.get(index) : null;
    }

    /**
     * Removes the shape at the specified index if valid.
     *
     * @param index the index of the shape to remove
     */
    public void removeShape(int index) {
        if (index >= 0 && index < shapeList.size()) {
            shapeList.remove(index);
        }
    }


    /**
     * Clears all shapes from the list.
     */
    public void clearShape() {
        shapeList.clear();
    }

    /**
     * Sets the current file name associated with the shape list.
     *
     * @param fileName the file name to set
     */
    public void setFileName(String fileName){ this.fileName=fileName; }


    /**
     * Returns the current file name associated with the shape list.
     *
     * @return the file name
     */
    public String getFileName(){ return fileName; }

    /**
     * Returns the list of shapes.
     *
     * @return the list of shapes
     */
    public List<Shape> getShapeList(){
        return shapeList;
    }
}
