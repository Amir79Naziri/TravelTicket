package sample.Search;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class SearchController {


    @FXML
    private Pane inTrain;

    @FXML
    private Pane outTrain;

    @FXML
    private ImageView outPlane;

    @FXML
    private ImageView inPlane;

    @FXML
    private JFXCheckBox TrainCheckBox;

    @FXML
    private JFXCheckBox AirplaneCheckBox;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXButton home;
    @FXML
    private JFXButton account;


    @FXML
    void trainCheckBoxHandler() {
        if (TrainCheckBox.isSelected())
            AirplaneCheckBox.setSelected(false);
        inPlane.setVisible(false);
        outPlane.setVisible(false);
        inTrain.setVisible(true);
        outTrain.setVisible(true);

    }

    @FXML
    void airplaneCheckBoxHandler() {
        if (AirplaneCheckBox.isSelected())
            TrainCheckBox.setSelected(false);
        inPlane.setVisible(true);
        outPlane.setVisible(true);
        inTrain.setVisible(false);
        outTrain.setVisible(false);


    }
    @FXML
        void searchButtonHandler()throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) searchButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Tickets/TicketsPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
@FXML
    void goToHome()throws IOException{
    Stage stage;
    Parent root;

    stage = (Stage) home.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("/sample/Search/Search.fxml"));

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

}

    @FXML
    void goToAccount()throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }






}
