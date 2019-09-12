import java.text.DecimalFormat;

public class Mortgage {

    public void mortgagePayment(double interestRate, int years, double creditAmount) {
        Helper hp = new Helper();

        if(interestRate < 0 || years < 0 || creditAmount < 0) {
            throw new IllegalArgumentException("Loan parameters cannot be less than zero.");
        }

        double k = Math.pow(1 + interestRate/1200, years * 12);
        double coeff = (interestRate/1200 * k)/(k - 1);
        double balance = creditAmount;

        String payment = hp.doubleFormatter(coeff*creditAmount);
        String overpayment = hp.doubleFormatter(coeff*creditAmount * years * 12 - creditAmount);
        String sum = hp.doubleFormatter(coeff*creditAmount * years * 12);

        System.out.println("|*******|*****************|******************|***********|***********|");
        System.out.println("| Month | "+ "  Main debt     | " + "     Percent     |  " + "Payment  |  " + "Balance  |");
        System.out.println("|*******|*****************|******************|***********|***********|");

        for(int i = 1; i <= years*12 ; i++) {
            double pay = coeff * creditAmount - (creditAmount * interestRate / 1200);
            double osn = pay * Math.pow((1 + interestRate / 1200), i - 1);
            double perc = coeff * creditAmount - osn;
            balance = balance - osn;
            String osnForm = hp.doubleFormatter(osn);
            String percForm = hp.doubleFormatter(perc);
            String balanceForm = hp.doubleFormatter(balance);

            hp.printer(i, osnForm, percForm, payment, balanceForm);
            System.out.println("|-------|-----------------|------------------|-----------|-----------|");
        }

        System.out.print("Your monthly payment: " + payment + "\n" + "Credit amount: " + creditAmount + "\n"
                + "Total payable: " + sum + "\n"
                + "The interest overpayment will be: " + overpayment);
    }

}
