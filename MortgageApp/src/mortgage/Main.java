package mortgage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/mortgage.fxml"));
        primaryStage.setTitle("With L.O.V.");
        primaryStage.setScene(new Scene(root, 700, 771));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
