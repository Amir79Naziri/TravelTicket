package sample.Search;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.FileHandler;
import model.TicketStorage;
import model.User;
import sample.Profile.ProfileController;
import sample.Tickets.TicketsPageController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SearchController implements Initializable {
    private String originLocation;
    private String destinationLocation;
    private LocalDate choosedDate;
    private String trainOrAirplane;
    private User currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Pane inTrain;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Pane outTrain;

    @FXML
    private ImageView outPlane;

    @FXML
    private Label originFault,destinationFault,dateFault;

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
    void searchButtonHandler() throws IOException
    {
        boolean situation = true;
        if (Destination.getValue() == null) {
            destinationFault.setVisible(true);

            situation = false;
        } else {
            destinationLocation = Destination.getValue();
            destinationFault.setVisible(false);
        }

        if (Origin.getValue() == null) {
            originFault.setVisible(true);

            situation = false;
        } else {
            originLocation = Origin.getValue();
            originFault.setVisible(false);
        }

        originLocation = Origin.getValue();
        destinationLocation = Destination.getValue();
        choosedDate = datePicker.getValue();

        try {
            if (datePicker.getValue() == null) {
                dateFault.setVisible(true);

                situation = false;
            } else {
                choosedDate = datePicker.getValue();
                dateFault.setVisible(false);
            }

        } catch (NullPointerException e) {
            dateFault.setVisible(true);

            situation = false;
        }

        if (situation) {

            if (TrainCheckBox.isSelected())
                trainOrAirplane = "train";
            else
                trainOrAirplane = "airplain";

            AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
            mainPane.getChildren().add(load);

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(f -> {
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
                ticketsPageController.setSearchDetails(originLocation, destinationLocation, choosedDate, trainOrAirplane, currentUser);

                Parent root = loader.getRoot();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            });
            pause.play();

        }
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
        profileController.serCurrentUser(currentUser);


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
