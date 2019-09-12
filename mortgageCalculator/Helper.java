import java.text.DecimalFormat;

public class Helper {
    public String doubleFormatter(double d) {
        return new DecimalFormat("#0.00").format(d);
    }
    public void printer(int i, String osnForm, String percForm, String payment, String balanceForm) {
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
}
