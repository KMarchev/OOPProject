package Commands;

import Exceptions.CommandException;
import File_Management.Open;
import Interfaces.Executable;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages and provides command executables based on command strings.
 */
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
        executerMap.put("translate", new Translate());
        executerMap.put("within", new Within());
        executerMap.put("help", new Help());
    }

    /**
     * Returns the Executable corresponding to the first argument (command).
     *
     * @param args command arguments; first argument is the command name.
     * @return Executable instance mapped to the command.
     * @throws CommandException if no arguments are provided or command is invalid.
     */
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
