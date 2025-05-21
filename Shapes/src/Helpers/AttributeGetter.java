package Helpers;

import Enumerators.Colours;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for extracting attribute values and mapping color strings.
 */
public class AttributeGetter {
    private static final Map<String, Colours> coloursMap=new HashMap<>();

    static {
        coloursMap.put("red", Colours.RED);
        coloursMap.put("blue", Colours.BLUE);
        coloursMap.put("green", Colours.GREEN);
    }

    /**
     * Extracts the value of a specified attribute from a line of text.
     *
     * @param line      the string to search within (e.g., an SVG tag line)
     * @param attribute the attribute name to extract (e.g., "fill", "stroke")
     * @return the attribute value as a string
     * @throws IllegalArgumentException if the attribute is not found in the line
     */
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

    /**
     * Converts a color string to its corresponding colour enum name in lowercase.
     * Defaults to "red" if the color is not found.
     *
     * @param colour the color string (e.g., "blue", "green")
     * @return the lowercase string representation of the color enum
     */
    public static String getColour(String colour){
        return coloursMap.getOrDefault(colour, Colours.RED).toString().toLowerCase();
    }
}
