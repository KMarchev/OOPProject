package Classes;

import Interfaces.Shape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line implements Shape {
    private int x1,y1,x2,y2, stroke_width;
    private String stroke;
    public Line(String line){
        x1=Integer.parseInt(getAttribute(line,"x1"));
        y1=Integer.parseInt(getAttribute(line,"y1"));
        x2=Integer.parseInt(getAttribute(line,"x2"));
        y2=Integer.parseInt(getAttribute(line,"y2"));
        stroke_width=Integer.parseInt(getAttribute(line,"stroke-width"));
        stroke=getAttribute(line,"stroke");
    }

    public Line(String[] params){
        x1=Integer.parseInt(params[2]);
        y1=Integer.parseInt(params[3]);
        x2=Integer.parseInt(params[4]);
        y2=Integer.parseInt(params[5]);
        stroke_width=Integer.parseInt(params[6]);
        stroke=params[7];
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
                Shape: Line
                X1: %d
                Y1: %d
                X2: %d
                Y2: %d
                Stroke: %s
                Stroke-width: %d
                """,x1, y1, x2, y2, stroke, stroke_width);
    }

    @Override
    public String toSVGFormat() {
        return String.format("  <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\" stroke-width=\"%d\" />",x1, y1, x2, y2, stroke, stroke_width);
    }
}
