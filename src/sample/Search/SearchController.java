package sample.Search;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SearchController implements Initializable {


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
    private ChoiceBox<String> Origin;
    private ObservableList<String> OriginList;

    @FXML
    private ChoiceBox<String> Destination;
    private ObservableList<String> DestinationList;


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

    public void test(String string){
        System.out.println(string);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        OriginList = FXCollections.observableArrayList();
        OriginList.addAll("Tehran", "Shiraz",
                "Mashhad", "Isfahan",
                "Kish");
        Origin.setItems(OriginList);

        DestinationList = FXCollections.observableArrayList();
        DestinationList.addAll("Tehran", "Shiraz",
                "Mashhad", "Isfahan",
                "Kish");
        Destination.setItems(DestinationList);

    }



}
