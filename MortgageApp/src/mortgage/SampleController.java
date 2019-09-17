package mortgage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.Text;
import javafx.util.Duration;
import mortgage.assets.animations.Pulsing;
import mortgage.assets.animations.Shake;

public class SampleController {

    private String osnForm;
    private String percForm;
    private String balanceForm;
    private String paym;
    private ObservableList<Mortgage> data = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField creditAmount;

    @FXML
    private Button calculate;

    @FXML
    private Text textField;

    @FXML
    private TextField interestRate;

    @FXML
    private TextField years;

    @FXML
    private Label authText;

    @FXML
    private TableView<Mortgage> table;

    @FXML
    private TableColumn<Mortgage, Integer> month;

    @FXML
    private TableColumn<Mortgage, String> meinDebt;

    @FXML
    private TableColumn<Mortgage, String> percent;

    @FXML
    private TableColumn<Mortgage, String> payment;

    @FXML
    private TableColumn<Mortgage, String> balance;

    @FXML
    private Label authText1;

    @FXML
    private Label authText2;

    @FXML
    private Text total;

    @FXML
    private Text overpayment;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.0);

        calculate.setEffect(colorAdjust);

        calculate.setOnMouseEntered(e -> {

            Timeline fadeInTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new KeyValue(colorAdjust.brightnessProperty(), colorAdjust.brightnessProperty().getValue(), Interpolator.LINEAR)),
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(colorAdjust.brightnessProperty(), -0.2, Interpolator.LINEAR)
                    ));
            fadeInTimeline.setCycleCount(1);
            fadeInTimeline.setAutoReverse(false);
            fadeInTimeline.play();

        });
        calculate.setOnMouseExited(e -> {

            Timeline fadeOutTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(0),
                            new KeyValue(colorAdjust.brightnessProperty(), colorAdjust.brightnessProperty().getValue(), Interpolator.LINEAR)),
                    new KeyFrame(Duration.seconds(0.1), new KeyValue(colorAdjust.brightnessProperty(), 0, Interpolator.LINEAR)
                    ));
            fadeOutTimeline.setCycleCount(1);
            fadeOutTimeline.setAutoReverse(false);
            fadeOutTimeline.play();

        });
        pulseAnim();
        calculate.setOnAction(event -> {

            table.getItems().clear();

            month.setCellValueFactory(new PropertyValueFactory<>("month"));
            meinDebt.setCellValueFactory(new PropertyValueFactory<>("osn"));
            percent.setCellValueFactory(new PropertyValueFactory<>("perc"));
            payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
            balance.setCellValueFactory(new PropertyValueFactory<>("balance"));

            String interest = interestRate.getText().trim();
            if(interest.contains(",")) {
                interest = interest.replace(",", ".");
            }
            String credit = creditAmount.getText().trim();
            if(credit.contains(",")) {
                credit = credit.replace(",", ".");
            }
            String year = years.getText().trim();

            if(interest.equals("") || year.equals("") || credit.equals("")) {
                shakeAnim();
                textField.setText("Please, enter all parameters.");
            }
            else if(Double.valueOf(interest) <= 0 || Integer.valueOf(year) <= 0|| Double.valueOf(credit) <= 0) {
                shakeAnim();
                textField.setText("Parameters cannot be less than or equal to zero.");
            }
            else {
                helper(interest, year, credit);
                textField.setText("");
            }
        });
    }
    private void shakeAnim() {
        Shake creditAmountAnim = new Shake(creditAmount);
        Shake yearsAnim = new Shake(years);
        Shake interestRateAnim = new Shake(interestRate);
        Shake auth = new Shake(authText);
        Shake auth1 = new Shake(authText1);
        Shake auth2 = new Shake(authText2);
        auth.playAnim();
        auth1.playAnim();
        auth2.playAnim();
        yearsAnim.playAnim();
        creditAmountAnim.playAnim();
        interestRateAnim.playAnim();
    }
    private void pulseAnim() {
        Pulsing pulsing = new Pulsing(label);
        pulsing.playPulsing();
    }
    private void helper(String interest, String year, String credit) {

        double k = Math.pow(1 + Double.valueOf(interest) / 1200, Integer.valueOf(year) * 12);
        double coeff = (Double.valueOf(interest) / 1200 * k) / (k - 1);
        double balan = Double.valueOf(credit);

       String overpay = doubleFormatter(coeff * Double.valueOf(credit) * Integer.valueOf(year) * 12
                - Double.valueOf(credit));
        String sum = doubleFormatter(coeff*Double.valueOf(credit) * Integer.valueOf(year) * 12);

        total.setText("Total payable: " + sum);
        overpayment.setText("The interest overpayment will be: " + overpay);

        for (int i = 1; i <= Integer.valueOf(year) * 12; i++) {
            double pay = coeff * Double.valueOf(credit) - (Double.valueOf(credit) * Double.valueOf(Double.valueOf(interest)) / 1200);
            double osn = pay * Math.pow((1 + Double.valueOf(interest) / 1200), i - 1);
            double perc = coeff * Double.valueOf(credit) - osn;
            balan = balan - osn;
            osnForm = doubleFormatter(osn);
            percForm = doubleFormatter(perc);
            balanceForm = doubleFormatter(balan);
            paym = doubleFormatter(coeff * Double.valueOf(credit));

            data.add(new Mortgage(balanceForm, osnForm, percForm, i, paym));
            table.setItems(data);
        }
    }
    private static String doubleFormatter(double d) {
        return new DecimalFormat("#0.00").format(d);
    }
    private void setColumn() {

    }
}
