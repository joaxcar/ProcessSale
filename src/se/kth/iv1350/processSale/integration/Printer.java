package se.kth.iv1350.processSale.integration;

/**
 * A singelton that prints
 */
public class Printer {

    private static final Printer PRINTER = new Printer();

    /**
     * Create new instance of <code>Printer</code>
     */
    private Printer(){}

    /**
     * Request the printer object
     *
     * @return the singelton printer
     */
    public static Printer getPrinter(){
        return PRINTER;
    }

    /**
     * Ask external printer to print receipt
     *
     * @param text <code>String</code> to print
     */
    public void print(String text){
        System.out.println(text);
    }
}
