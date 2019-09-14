public class Main {
    public static void main(String[] args) {

        Mortgage mortgage = new Mortgage();
        mortgage.setCreditAmount(2500000.0);
        mortgage.setInterestRate(10.0);
        mortgage.setYears(20);

        Helper helper = new Helper();
        helper.mortgagePayment(mortgage);
    }
}


