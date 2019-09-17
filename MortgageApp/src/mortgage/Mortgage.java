package mortgage;

public class Mortgage {

    private double interestRate;
    private int years;
    private double creditAmount;
    private String balance;
    private String osn;
    private String perc;
    private int month;
    private String payment;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Mortgage(String balance, String osn, String perc, int month, String payment) {
        this.balance = balance;
        this.osn = osn;
        this.perc = perc;
        this.month = month;
        this.payment = payment;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOsn() {
        return osn;
    }

    public void setOsn(String osn) {
        this.osn = osn;
    }

    public String getPerc() {
        return perc;
    }

    public void setPerc(String perc) {
        this.perc = perc;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Mortgage(double interestRate, int years, double creditAmount) {
        this.interestRate = interestRate;
        this.years = years;
        this.creditAmount = creditAmount;
    }

    public Mortgage() {
    }
}
