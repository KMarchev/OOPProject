package Shapes;

import Helpers.AttributeGetter;
import Interfaces.Shape;

/**
 * Represents a line shape with start and end coordinates, stroke color, and stroke width.
 */
public class Line implements Shape {
    private int x1,y1,x2,y2, stroke_width;
    private String stroke;

    /**
     * Constructs a Line from an SVG element string.
     *
     * @param line the SVG line representing the line
     */
    public Line(String line){
        x1=Integer.parseInt(AttributeGetter.getAttribute(line,"x1"));
        y1=Integer.parseInt(AttributeGetter.getAttribute(line,"y1"));
        x2=Integer.parseInt(AttributeGetter.getAttribute(line,"x2"));
        y2=Integer.parseInt(AttributeGetter.getAttribute(line,"y2"));
        stroke_width=Integer.parseInt(AttributeGetter.getAttribute(line,"stroke-width"));
        stroke=AttributeGetter.getColour(AttributeGetter.getAttribute(line,"stroke"));
    }

    /**
     * Constructs a Line from command arguments.
     *
     * @param params the array of parameters: [create, line, x1, y1, x2, y2, stroke-width, stroke]
     */
    public Line(String[] params){
        x1=Integer.parseInt(params[2]);
        y1=Integer.parseInt(params[3]);
        x2=Integer.parseInt(params[4]);
        y2=Integer.parseInt(params[5]);
        stroke_width=Integer.parseInt(params[6]);
        stroke=AttributeGetter.getColour(params[7]);
    }


    /**
     * Prints detailed information about this line to the console.
     */
    @Override
    public void showInfo() {
        System.out.printf("""
                Shape: Line
                X1: %d
                Y1: %d
                X2: %d
                Y2: %d
                Stroke: %s
                Stroke-width: %d
                """,x1, y1, x2, y2, stroke, stroke_width);
    }

    /**
     * Returns the SVG representation of this line as a string.
     *
     * @return the SVG format string of this line
     */
    @Override
    public String toSVGFormat() {
        return String.format("  <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\" stroke-width=\"%d\" />",x1, y1, x2, y2, stroke, stroke_width);
    }

    /**
     * Translates the line's start and end points by the given deltas.
     * Coordinates are not allowed to go below zero.
     *
     * @param dx the delta to translate on the x-axis
     * @param dy the delta to translate on the y-axis
     */
    @Override
    public void translate(int dx, int dy) {
        setX1(Math.max(0,this.x1+dx));
        setX2(Math.max(0,this.x2+dx));
        setY1(Math.max(0,this.y1+dy));
        setY2(Math.max(0,this.y2+dy));
    }

    /**
     * Determines if the line lies completely within the rectangular area
     * defined by (x1, y1) and (x2, y2), considering the stroke width.
     *
     * @param x1 the minimum x-coordinate of the area
     * @param y1 the minimum y-coordinate of the area
     * @param x2 the maximum x-coordinate of the area
     * @param y2 the maximum y-coordinate of the area
     * @return true if the line is completely within the area, false otherwise
     */
    @Override
    public boolean within(int x1, int y1, int x2, int y2) {
        int lineMinX = Math.min(this.x1, this.x2) - stroke_width;
        int lineMaxX = Math.max(this.x1, this.x2) + stroke_width;
        int lineMinY = Math.min(this.y1, this.y2) - stroke_width;
        int lineMaxY = Math.max(this.y1, this.y2) + stroke_width;

        return lineMinX>=x1&&lineMaxX<=x2&&
                lineMinY>=y1&&lineMaxY<=y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
