package File_Management;

import java.io.File;
import java.io.FileWriter;


/**
 * Utility class for saving SVG files.
 */
public class FileSaver {

    /**
     * Saves the current shapes to the SVG file specified by ShapeList's filename.
     * If the file does not exist, it will be created.
     * Any existing content will be overwritten.
     */
    public static void saveFile(){
        try{
            File file=new File("../files/"+ShapeList.getInstance().getFileName()+".svg");
            FileWriter fileWriter=new FileWriter(file,false);
            fileWriter.write("""
                    <?xml version="1.0" standalone="no"?>
                    <!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
                      "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
                    <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
                    """);
            fileWriter.write(ShapeList.getInstance().toSVGFormat());
            fileWriter.write("</svg>");
            fileWriter.close();
        }catch (Exception e){
            System.err.println("Unknown exception"+e.getMessage());
        }
    }

    /**
     * Saves the current shapes to a new SVG file with the specified name.
     * If the file exists, it will be overwritten.
     *
     * @param name the name of the file (without extension) to save the shapes into
     */
    public static void saveFileAs(String name){
        try{
            File file=new File("../files/"+name+".svg");
            FileWriter fileWriter=new FileWriter(file, false);
            fileWriter.write("""
                    <?xml version="1.0" standalone="no"?>
                    <!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
                      "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
                    <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
                    """);
            fileWriter.write(ShapeList.getInstance().toSVGFormat());
            fileWriter.write("</svg>");
            fileWriter.close();
        }catch (Exception e){
            System.err.println("Unknown exception: "+e.getMessage());
        }
    }
}
