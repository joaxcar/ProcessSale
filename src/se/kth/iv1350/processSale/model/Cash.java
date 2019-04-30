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

    public Cash(double amount){
        thousand = (int) (amount % 1000);
        amount = amount / 1000;
        fiveHundred = (int) (amount % 500);
        amount = amount / 500;
        hundred = (int) (amount % 100);
        amount = amount / 100;
        fifty = (int) (amount % 50);
        amount = amount / 50;
        twenty = (int) (amount % 20);
        amount = amount / 20;
        ten = (int) (amount % 10);
        amount = amount / 10;
        five = (int) (amount % 5);
        amount = amount / 5;
        one = (int) (amount % 1);
        amount = amount / 1;
        quarter = (int) (amount % 0.25);
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
        return thousand + fiveHundred + hundred + fifty + twenty + ten + five + one + (quarter * 0.25);
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
