package sample.TicketAndPerson;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class TicketAndPersonController {
    @FXML
    private JFXButton home;



    @FXML
    void goToHomePage() throws IOException{

        Stage stage;
        Parent root;


            stage = (Stage) home.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.Search.Search.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private JFXButton account;

    @FXML
    private JFXButton payOnline;

    @FXML
    public void onlinePayment() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) payOnline.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Bank/BankPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




    @FXML
    public void goToAccountPage() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
