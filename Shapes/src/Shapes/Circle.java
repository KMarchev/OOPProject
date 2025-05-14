package Shapes;

import Helpers.AttributeGetter;
import Interfaces.Shape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Circle implements Shape {
    private int cx, cy, r;
    private String fill;
    public Circle(String line){
        cx=Integer.parseInt(AttributeGetter.getAttribute(line, "cx"));
        cy=Integer.parseInt(AttributeGetter.getAttribute(line, "cy"));
        r=Integer.parseInt(AttributeGetter.getAttribute(line, "r"));
        fill=AttributeGetter.getColour(AttributeGetter.getAttribute(line,"fill"));
    }

    public Circle(String[] params){
        cx=Integer.parseInt(params[2]);
        cy=Integer.parseInt(params[3]);
        r=Integer.parseInt(params[4]);
        fill=AttributeGetter.getColour(params[5]);
    }

    private static String getAttribute(String line, String attribute){
        String pattern=attribute+"=\"([^\"]+)\"";
        Pattern p= Pattern.compile(pattern);
        Matcher m=p.matcher(line);
        if(m.find()){
            return m.group(1);
        }else{
            throw new IllegalArgumentException("Invalid argument!");
        }
    }

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

    @Override
    public String toSVGFormat() {
        return String.format("  <circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />", cx, cy, r, fill);
    }

    @Override
    public void translate(int dx, int dy) {
        setCx(Math.max(r,this.cx+dx));
        setCy(Math.max(r,this.cy+dy));
    }

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
