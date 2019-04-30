package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Reciept;

public class AccountingSystem {
    public AccountingSystem(){

    }

    public void makeEntry(Reciept reciept){
        System.out.println("Updating accounting system with reciept from register:" + reciept.registerID);
    }
}
