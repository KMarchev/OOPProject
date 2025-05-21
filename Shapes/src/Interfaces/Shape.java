package Interfaces;

/**
 * Represents a geometric shape with common operations.
 */
public interface Shape {
    /**
     * Displays detailed information about the shape.
     */
    void showInfo();

    /**
     * Returns the SVG representation of the shape as a string.
     *
     * @return SVG formatted string of the shape
     */
    String toSVGFormat();

    /**
     * Translates (moves) the shape by the given delta values.
     *
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     */
    void translate(int dx, int dy);

    /**
     * Checks whether the shape lies entirely within the rectangular area defined by two points.
     *
     * @param x1 x-coordinate of the first corner
     * @param y1 y-coordinate of the first corner
     * @param x2 x-coordinate of the opposite corner
     * @param y2 y-coordinate of the opposite corner
     * @return true if the shape is within the specified rectangle; false otherwise
     */
    boolean within(int x1, int y1, int x2, int y2);
}
