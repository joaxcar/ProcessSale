package se.kth.iv1350.processSale.integration;

/**
 * Thrown when an exception occurs in <code>ItemRegistry</code>, stores a message and the original exception
 */
public class ItemRegistryException extends Exception {

    /**
     * Create new instance of <code>ItemRegistryException</code>
     *
     * @param message information of the exception
     * @param cause original <code>Exception</code>
     */
    public ItemRegistryException(String message, Exception cause){
        super (message, cause);
    }
}
