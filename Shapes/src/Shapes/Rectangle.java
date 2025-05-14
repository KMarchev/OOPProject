package Shapes;

import Helpers.AttributeGetter;
import Interfaces.Shape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rectangle implements Shape {
    private int x, y, width, height;
    private String fill;

    public Rectangle(){

    }

    public Rectangle(String[] args) {
        this.x = Integer.parseInt(args[2]);
        this.y = Integer.parseInt(args[3]);
        this.width = Integer.parseInt(args[4]);
        this.height = Integer.parseInt(args[5]);
        this.fill = AttributeGetter.getColour(args[6]);
    }

    public Rectangle(String line){
        this.x=Integer.parseInt(AttributeGetter.getAttribute(line,"x"));
        this.y=Integer.parseInt(AttributeGetter.getAttribute(line,"y"));
        this.width=Integer.parseInt(AttributeGetter.getAttribute(line,"width"));
        this.height=Integer.parseInt(AttributeGetter.getAttribute(line,"height"));
        this.fill=AttributeGetter.getColour(AttributeGetter.getAttribute(line, "fill"));
    }
    @Override
    public void showInfo() {
        System.out.printf("Shape: Rectangle\nX:%d\nY:%d\nWidth:%d\nHeight:%d\nFill:%s",this.x, this.y, this.width, this.height, this.fill);
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
    public String toSVGFormat() {
        return String.format("  <rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />",this.x, this.y, this.width, this.height, this.fill);
    }

    @Override
    public void translate(int dx, int dy) {
        setX(Math.max(0,this.x+dx));
        setY(Math.max(0,this.y+dy));
    }

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
