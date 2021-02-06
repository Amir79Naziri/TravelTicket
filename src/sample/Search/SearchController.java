package sample.Search;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import sample.Profile.ProfileController;
import sample.Tickets.TicketsPageController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SearchController implements Initializable {
    private String originLocation;
    private String destinationLocation;
    private String choosedDate;
    private String trainOrAirplane;
    private User currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @FXML
    private Pane inTrain;

    @FXML
    private DatePicker datePicker;

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
    void searchButtonHandler() throws IOException {

        originLocation = Origin.getValue();
        destinationLocation = Destination.getValue();
try {
    choosedDate = datePicker.getValue().toString();
}catch(NullPointerException e ){
    choosedDate="1000/1/1";
}

        if (TrainCheckBox.isSelected())
            trainOrAirplane = "train";
        else
            trainOrAirplane = "airplain";

        Stage stage;
        stage = (Stage) searchButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Tickets/TicketsPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        TicketsPageController ticketsPageController = loader.getController();
        ticketsPageController.setSearchDetails(originLocation,destinationLocation,choosedDate,trainOrAirplane,currentUser);

        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void goToHome() throws IOException {
        Stage stage;
        stage = (Stage) home.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Search/Search.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        SearchController searchController=loader.getController();
        searchController.setCurrentUser(currentUser);

        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToAccount() throws IOException {
        Stage stage;
        stage = (Stage) home.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Profile/profileView.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        ProfileController profileController=loader.getController();
        //TODO
        // profileController.setUser(currentUser);



        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        OriginList = FXCollections.observableArrayList();


        OriginList.addAll("Tehran", "Shiraz",
                "Mashhad", "Isfahan",
                "Kish");
        //OriginList add()  from list of tickets


        Origin.setItems(OriginList);


        DestinationList = FXCollections.observableArrayList();


        DestinationList.addAll("Tehran", "Shiraz",
                "Mashhad", "Isfahan",
                "Kish");

        //DestinationList add()  from list of tickets
        Destination.setItems(DestinationList);
    }


}
