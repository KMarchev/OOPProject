package Exceptions;

/**
 * Exception thrown when a file-related error occurs.
 */
public class FileException extends Exception {

    /**
     * Constructs a FileException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception
     */
    public FileException(String message) {
        super(message);
    }
}
