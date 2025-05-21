package Shapes;

import Helpers.AttributeGetter;
import Interfaces.Shape;

/**
 * Represents a circle shape with center coordinates, radius, and fill color.
 */
public class Circle implements Shape {
    private int cx, cy, r;
    private String fill;

    /**
     * Constructs a Circle from an SVG element string.
     *
     * @param line the SVG line representing the circle
     */
    public Circle(String line){
        cx=Integer.parseInt(AttributeGetter.getAttribute(line, "cx"));
        cy=Integer.parseInt(AttributeGetter.getAttribute(line, "cy"));
        r=Integer.parseInt(AttributeGetter.getAttribute(line, "r"));
        fill=AttributeGetter.getColour(AttributeGetter.getAttribute(line,"fill"));
    }

    /**
     * Constructs a Circle from command arguments.
     *
     * @param params the array of parameters: [create, circle, cx, cy, r, fill]
     */
    public Circle(String[] params){
        cx=Integer.parseInt(params[2]);
        cy=Integer.parseInt(params[3]);
        r=Integer.parseInt(params[4]);
        fill=AttributeGetter.getColour(params[5]);
    }

    /**
     * Prints detailed information about this circle to the console.
     */
    @Override
    public void showInfo() {
        System.out.printf("""
                        Shape: Circle
                        CX: %d
                        CY: %d
                        Radius: %d
                        Fill: %s"""
                ,cx, cy, r, fill);
    }

    /**
     * Returns the SVG representation of this circle as a string.
     *
     * @return the SVG format string of this circle
     */
    @Override
    public String toSVGFormat() {
        return String.format("  <circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />", cx, cy, r, fill);
    }

    /**
     * Translates the circle's position by the given deltas.
     * The circle's center is moved by (dx, dy), but will not move
     * closer to the origin than its radius.
     *
     * @param dx the delta to translate on the x-axis
     * @param dy the delta to translate on the y-axis
     */
    @Override
    public void translate(int dx, int dy) {
        setCx(Math.max(r,this.cx+dx));
        setCy(Math.max(r,this.cy+dy));
    }

    /**
     * Determines if the circle lies completely within the rectangular area
     * defined by (x1, y1) and (x2, y2).
     *
     * @param x1 the minimum x-coordinate of the area
     * @param y1 the minimum y-coordinate of the area
     * @param x2 the maximum x-coordinate of the area
     * @param y2 the maximum y-coordinate of the area
     * @return true if the circle is completely within the area, false otherwise
     */
    @Override
    public boolean within(int x1, int y1, int x2, int y2) {
        return cx - r >= x1 && cx + r <= x2
                && cy - r >= y1 && cy + r <= y2;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
