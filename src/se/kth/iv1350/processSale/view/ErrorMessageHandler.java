package se.kth.iv1350.processSale.view;

/**
 * Handles printing of error messages to the user
 */
public class ErrorMessageHandler {

    /**
     * Print given message as an error message to user
     *
     * @param msg message to print to user
     */
    public void printErrorMessage(String msg){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("ERROR:  ");
        errorMsg.append(msg);
        System.out.println(errorMsg);
    }
}
