package Classes;

import Interfaces.Shape;
import org.w3c.dom.css.Rect;

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
        this.fill = args[6];
    }

    public Rectangle(String line){
        this.x=Integer.parseInt(getAttribute(line,"x"));
        this.y=Integer.parseInt(getAttribute(line,"y"));
        this.width=Integer.parseInt(getAttribute(line,"width"));
        this.height=Integer.parseInt(getAttribute(line,"height"));
        this.fill=getAttribute(line,"fill");
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
