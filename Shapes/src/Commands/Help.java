package Commands;

import Interfaces.Executable;

public class Help implements Executable {
    @Override
    public void run(String[] args) throws Exception {
        System.out.print("""
                List of commands:
                
                open <file_name> \t\\\\ opens file with name "file_name"
                
                print \t\\\\ prints all shapes on the list
                
                create rect <x> <y> <width> <height> <fill> \t\\\\ creates new shape of type line
                
                create circle <cx> <cy> <r> <fill> \t\\\\ creates new shape of type line
                
                create line <x1> <y1> <x2> <y2> <stroke_width> <stroke> \t\\\\ creates new shape of type line
                
                translate <x> <y> \t\\\\ for all shapes
                
                translate <n> <x> <y> \t\\\\ n - index of shape
                
                within <x1> <y1> <x2> <y2> \t\\\\ for all shapes within area
                
                within <shape> <x1> <y1> <x2> <y2> \t\\\\ specific shape within area
                
                save \t\\\\ saves current file
                
                saveas <file_name> \t\\\\ saves file as "file_name"
                
                close \t\\\\ unloads file
                
                exit \t\\\\ closes the program
                
                help \t\\\\ list of all commands
                
                """);
    }
}
