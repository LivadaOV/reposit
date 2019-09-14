import java.text.DecimalFormat;

public class Helper {

    private static String doubleFormatter(double d) {
        return new DecimalFormat("#0.00").format(d);
    }

    private static void printer(int i, String osnForm, String percForm, String payment, String balanceForm) {
        if (i < 10) {
            System.out.println("|   " + i + "   |     " + osnForm + "     |      " + percForm + "    | "
                    + payment + "  |" + balanceForm + " |");
        }
        else if(i >= 10 && i < 100) {
            System.out.println("|   " + i + "  |     " + osnForm + "     |      " + percForm + "    | "
                    + payment + "  |" + balanceForm + " |");
        }
        else if (i > 100){
            System.out.println("|  " + i + "  |     " + osnForm + "     |      " + percForm + "    | "
                    + payment + "  |" + balanceForm + " |");
        }
    }

    public static void mortgagePayment(Mortgage mortgage) {

        if(mortgage.getInterestRate() < 0 || mortgage.getYears() < 0 || mortgage.getCreditAmount() < 0) {
            throw new IllegalArgumentException("Loan parameters cannot be less than zero.");
        }

        double k = Math.pow(1 + mortgage.getInterestRate()/1200, mortgage.getYears() * 12);
        double coeff = (mortgage.getInterestRate()/1200 * k)/(k - 1);
        double balance = mortgage.getCreditAmount();

        String payment = doubleFormatter(coeff*mortgage.getCreditAmount());
        String overpayment = doubleFormatter(coeff * mortgage.getCreditAmount() * mortgage.getYears() * 12
                - mortgage.getCreditAmount());
        String sum = doubleFormatter(coeff*mortgage.getCreditAmount() * mortgage.getYears() * 12);

        System.out.println("|*******|*****************|******************|***********|***********|");
        System.out.println("| Month | "+ "  Main debt     | " + "     Percent     |  " + "Payment  |  " + "Balance  |");
        System.out.println("|*******|*****************|******************|***********|***********|");

        for(int i = 1; i <= mortgage.getYears()*12 ; i++) {
            double pay = coeff*mortgage.getCreditAmount()-(mortgage.getCreditAmount()*mortgage.getInterestRate()/1200);
            double osn = pay * Math.pow((1 + mortgage.getInterestRate() / 1200), i - 1);
            double perc = coeff * mortgage.getCreditAmount() - osn;
            balance = balance - osn;
            String osnForm = doubleFormatter(osn);
            String percForm =doubleFormatter(perc);
            String balanceForm = doubleFormatter(balance);

            printer(i, osnForm, percForm, payment, balanceForm);
            System.out.println("|-------|-----------------|------------------|-----------|-----------|");
        }

        System.out.print("Your monthly payment: " + payment + "\n" + "Credit amount: " + mortgage.getCreditAmount() + "\n"
                + "Total payable: " + sum + "\n"
                + "The interest overpayment will be: " + overpayment);
    }

}
