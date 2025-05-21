package Exceptions;


/**
 * Exception thrown when a command encounters an error.
 */
public class CommandException extends Exception{

    /**
     * Constructs a CommandException with the specified detail message.
     *
     * @param msg the detail message explaining the cause of the exception
     */
    public CommandException(String msg){
        super(msg);
    }
}
