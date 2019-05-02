package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;

/**
 * This class works as a placeholder for a real printer class
 */
public class Printer {

    /**
     * Create new instance of <code>Printer</code>
     */
    public Printer(){}

    /**
     * Ask external printer to print receipt
     *
     * @param receipt <code>Receipt</code> to print
     */
    public void printReciept(ReceiptDTO receipt){
        System.out.println("\nPrintout of receipt: ");
        System.out.println(receipt.toString());
    }
}
