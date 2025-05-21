package Interfaces;


/**
 * Represents a command or action that can be executed with arguments.
 */
public interface Executable {
    /**
     * Executes the command with the given arguments.
     *
     * @param args the array of arguments for the command
     * @throws Exception if an error occurs during execution
     */
    void run(String[] args) throws Exception;
}
