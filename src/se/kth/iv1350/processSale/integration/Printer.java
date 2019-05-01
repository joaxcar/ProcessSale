package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.RecieptDTO;

public class Printer {

    public Printer(){
    }

    public void printReciept(RecieptDTO reciept){
        System.out.println("Printing reciept from register: " + reciept.registerID);
    }
}
