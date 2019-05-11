package se.kth.iv1350.processSale.controller;

/**
 *
 */
public class OperationFailedException extends Exception {
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}
