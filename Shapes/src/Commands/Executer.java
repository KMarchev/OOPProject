package Commands;

import Exceptions.CommandException;
import File_Management.Open;
import Interfaces.Executable;

import java.util.HashMap;
import java.util.Map;

public class Executer {
    private static final Map<String, Executable> executerMap=new HashMap<>();

    static {
        executerMap.put("open", new Open());
        executerMap.put("print", new Print());
        executerMap.put("saveas", new SaveAs());
        executerMap.put("save",new Save());
        executerMap.put("create", new Create());
        executerMap.put("clear", new Clear());
        executerMap.put("erase", new Erase());
    }

    public static Executable executable(String[] args) throws CommandException {
        if(args.length==0){
            throw new CommandException("No arguments!");
        }else{
            String command=args[0].toLowerCase();
            Executable exec=executerMap.get(command);
            if(exec==null){
                throw new CommandException("Invalid command!");
            }
            return exec;
        }
    }
}
