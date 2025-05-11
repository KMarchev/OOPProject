package File_Management;

import java.io.File;
import java.io.FileWriter;

public class FileSaver {
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
