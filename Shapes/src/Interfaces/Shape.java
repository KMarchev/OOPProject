package Interfaces;

public interface Shape {
    void showInfo();
    String toSVGFormat();
    void translate(int dx, int dy);
    boolean within(int x1, int y1, int x2, int y2);
}
