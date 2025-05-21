package Shapes;

import Helpers.AttributeGetter;
import Interfaces.Shape;


/**
 * Represents a rectangle shape with position, size, and fill color.
 */
public class Rectangle implements Shape {
    private int x, y, width, height;
    private String fill;

    /**
     * Constructs a rectangle from command arguments.
     *
     * @param args the command arguments: [create, rectangle, x, y, width, height, fill]
     */
    public Rectangle(String[] args) {
        this.x = Integer.parseInt(args[2]);
        this.y = Integer.parseInt(args[3]);
        this.width = Integer.parseInt(args[4]);
        this.height = Integer.parseInt(args[5]);
        this.fill = AttributeGetter.getColour(args[6]);
    }


    /**
     * Constructs a rectangle from an SVG element line.
     *
     * @param line the SVG <rect> element line
     */
    public Rectangle(String line){
        this.x=Integer.parseInt(AttributeGetter.getAttribute(line,"x"));
        this.y=Integer.parseInt(AttributeGetter.getAttribute(line,"y"));
        this.width=Integer.parseInt(AttributeGetter.getAttribute(line,"width"));
        this.height=Integer.parseInt(AttributeGetter.getAttribute(line,"height"));
        this.fill=AttributeGetter.getColour(AttributeGetter.getAttribute(line, "fill"));
    }


    /**
     * Displays the rectangle's properties to the console.
     */
    @Override
    public void showInfo() {
        System.out.printf("Shape: Rectangle\nX:%d\nY:%d\nWidth:%d\nHeight:%d\nFill:%s",this.x, this.y, this.width, this.height, this.fill);
    }

    /**
     * Returns the rectangle as a formatted SVG string.
     *
     * @return the SVG representation of the rectangle
     */
    @Override
    public String toSVGFormat() {
        return String.format("  <rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />",this.x, this.y, this.width, this.height, this.fill);
    }

    /**
     * Translates the rectangle's position by the specified deltas, clamping to 0 if necessary.
     *
     * @param dx the x-axis translation
     * @param dy the y-axis translation
     */
    @Override
    public void translate(int dx, int dy) {
        setX(Math.max(0,this.x+dx));
        setY(Math.max(0,this.y+dy));
    }

    /**
     * Checks whether the rectangle fits entirely within the specified rectangular region.
     *
     * @param x1 the top-left x of the bounding box
     * @param y1 the top-left y of the bounding box
     * @param x2 the bottom-right x of the bounding box
     * @param y2 the bottom-right y of the bounding box
     * @return true if the rectangle is entirely within the bounding box, false otherwise
     */
    @Override
    public boolean within(int x1, int y1, int x2, int y2) {
        int rectMinX=x;
        int rectMaxX=x+width;
        int rectMinY=y;
        int rectMaxY=y+height;

        return rectMinX>=x1&&rectMaxX<=x2&&
                rectMinY>=y1&&rectMaxY<=y2;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
