package se.kth.iv1350.processSale.model;

public class Cash {

    private int thousand;
    private int fiveHundred;
    private int hundred;
    private int fifty;
    private int twenty;
    private int ten;
    private int five;
    private int one;
    private int quarter;

    public Cash(int thousand, int fiveHundred, int hundred, int fifty, int twenty, int ten, int five, int one, int quarter) {
        this.thousand = thousand;
        this.fiveHundred = fiveHundred;
        this.hundred = hundred;
        this.fifty = fifty;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.one = one;
        this.quarter = quarter;
    }
    public Cash(){
        thousand = 0;
        fiveHundred = 0;
        hundred = 0;
        fifty = 0;
        twenty = 0;
        ten = 0;
        five = 0;
        one = 0;
        quarter = 0;
    }

    private double sum(){
        double sum = thousand + fiveHundred + hundred + fifty + twenty + ten + five + one + (quarter * 0.25);
        return sum;
    }
    public String toString(){
        return Double.toString(sum());
    }

    public double getAmount(){
        return sum();
    }

    public void addCash(Cash newCash){
        thousand += newCash.getThousand();
        fiveHundred += newCash.getFiveHundred();
        hundred += newCash.getHundred();
        fifty += newCash.getFifty();
        twenty += newCash.getTwenty();
        ten += newCash.getTen();
        five += newCash.getFive();
        one += newCash.getOne();
        quarter += newCash.getQuarter();
    }
    public void subtractCash(Cash newCash){
        thousand -= newCash.getThousand();
        fiveHundred -= newCash.getFiveHundred();
        hundred -= newCash.getHundred();
        fifty -= newCash.getFifty();
        twenty -= newCash.getTwenty();
        ten -= newCash.getTen();
        five -= newCash.getFive();
        one -= newCash.getOne();
        quarter -= newCash.getQuarter();
    }

    public int getThousand() {
        return thousand;
    }

    public int getFiveHundred() {
        return fiveHundred;
    }

    public int getHundred() {
        return hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public int getTwenty() {
        return twenty;
    }

    public int getTen() {
        return ten;
    }

    public int getFive() {
        return five;
    }

    public int getOne() {
        return one;
    }

    public int getQuarter() {
        return quarter;
    }

}
