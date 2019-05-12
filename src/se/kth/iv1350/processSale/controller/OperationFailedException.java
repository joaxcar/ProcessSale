package se.kth.iv1350.processSale.controller;

/**
 * Exception to be thrown if operation in controller fails
 */
public class OperationFailedException extends Exception {

    /**
     * Create new instance of exception, pass message and cause to superclass
     *
     * @param message description of exception
     * @param cause copy of original exception
     */
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}
