package File_Management;

import Classes.ShapeFactory;
import Interfaces.Executable;
import Interfaces.Shape;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Open implements Executable {

    @Override
    public void run(String[] args) {
        System.out.println("Reading from file: "+args[1]+".svg\n");
        try{
            File file=new File("File/"+args[1]+".svg");
            Scanner scanner=new Scanner(file);
            int count=0;
            while(scanner.hasNextLine()){
                String line=scanner.nextLine().trim();
                if(line.startsWith("<")){
                    int spaceIndex = line.indexOf(" ");
                    int endIndex = (spaceIndex != -1) ? spaceIndex : line.indexOf(">");

                    if (endIndex == -1) {
                        continue;
                    }

                    String shapeName = line.substring(1, endIndex);
                    Shape shape=ShapeFactory.createShape(shapeName, line);

                    if(shape!=null){
                        ShapeList.getInstance().addShape(shape);
                        System.out.println("Shape read successfully! "+(++count)+" shapes read in total.\n");
                    }
                }
            }
            System.out.println("Total shapes in list: " + ShapeList.getInstance().getSize());


        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }
}
