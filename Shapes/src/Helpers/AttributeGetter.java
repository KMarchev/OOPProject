package Helpers;

import Enumerators.Colours;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttributeGetter {
    private static final Map<String, Colours> coloursMap=new HashMap<>();

    static {
        coloursMap.put("red", Colours.red);
        coloursMap.put("blue", Colours.blue);
        coloursMap.put("green", Colours.green);
    }

    public static String getAttribute(String line, String attribute){
        String pattern=attribute+"=\"([^\"]+)\"";
        Pattern p= Pattern.compile(pattern);
        Matcher m=p.matcher(line);
        if(m.find()){
            return m.group(1);
        }else{
            throw new IllegalArgumentException("Invalid argument!");
        }
    }

    public static String getColour(String colour){
        return coloursMap.getOrDefault(colour, Colours.red).toString();
    }
}
