package sample.Bank;


import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BankPageController implements Initializable {

    static Parent profileRoot;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private JFXButton payButton;
    @FXML
    private JFXButton cancelButton;

    @FXML
    void goToProfile(ActionEvent event) throws IOException, InterruptedException
    {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
        mainPane.getChildren().add(load);
        try {
            profileRoot = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(f -> {
            Stage stage;
            stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(profileRoot);
            stage.setScene(scene);
            stage.show();
        });
        pause.play();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
