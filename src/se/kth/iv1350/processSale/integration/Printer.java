package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;

public class Printer {

    public Printer(){
    }

    public void printReciept(ReceiptDTO receipt){
        System.out.println("Printing receipt from register: " + receipt.getRegisterID());
    }
}
