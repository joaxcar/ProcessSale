package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.SaleDTO;

public class Printer {

    public Printer(){
    }

    public void printReciept(SaleDTO sale){
        System.out.println("Printing reciept!");
    }
}
