package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;

/**
 * This class works as a placeholder for a real printer class
 */
public class Printer {

    public Printer(){
    }

    public void printReciept(ReceiptDTO receipt){
        System.out.println("\nPrintout of receipt: ");
        System.out.println(receipt.toString());
    }
}
