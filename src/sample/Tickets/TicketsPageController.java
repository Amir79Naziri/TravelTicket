package sample.Tickets;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;
import sample.Profile.ProfileController;
import sample.Search.SearchController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketsPageController implements Initializable
{
    private String originLocation;
    private String destinationLocation;
    private String choosedDate;
    private String trainOrAirplane;
    private User   currentUser;

    public TicketsPageController() throws IOException {
    }

    public void setSearchDetails(String originLocation,String destinationLocation,String choosedDate,String trainOrAirplane,User currentUser){
        this.originLocation=originLocation;
        this.destinationLocation=destinationLocation;
        this.choosedDate=choosedDate;
        this.trainOrAirplane=trainOrAirplane;
        this.currentUser=currentUser;
    }

    @FXML
    private ChoiceBox<String> timeOrder;
    private ObservableList<String> choices;

    @FXML
    private JFXButton ProfileButton;

    @FXML
    private JFXButton HomeButton;

    @FXML
    private ListView<Pane> list;
    private ObservableList<Pane> tickets;

    @FXML
    private ChoiceBox<String> airlines;
    private ObservableList<String> airlinesList;

    @FXML
    private AnchorPane mainPage;


    static Parent rootHome, rootProfile;


    private final Pane pane1 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane4 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane5 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane6 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane7 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane8 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));



    @FXML
    void GoHome(ActionEvent event) throws IOException, InterruptedException
    {
//        Stage stage;
//        stage = (Stage) HomeButton.getScene().getWindow();
//        Scene scene = new Scene(rootHome);
//        stage.setScene(scene);
//        stage.show();

        Stage stage;
        stage = (Stage) HomeButton.getScene().getWindow();
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
    void GoProfile(ActionEvent event)
    {
//        Stage stage;
//        stage = (Stage) HomeButton.getScene().getWindow();
//        Scene scene = new Scene(rootProfile);
//        stage.setScene(scene);
//        stage.show();


        Stage stage;
        stage = (Stage) HomeButton.getScene().getWindow();
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
    public void initialize(URL location, ResourceBundle resources)
    {

        try {
            rootHome = FXMLLoader.load(TicketsPageController.class.getResource("/sample/Search/Search.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rootProfile = FXMLLoader.load(TicketsPageController.class.getResource("/sample/Profile/ProfileView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        choices = FXCollections.observableArrayList();
        choices.addAll("Time Ascending", "Time Descending");
        timeOrder.setItems(choices);

        tickets = FXCollections.observableArrayList();
        tickets.addAll(pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8);
        list.setItems(tickets);

        airlinesList = FXCollections.observableArrayList();
        airlinesList.addAll("American Airline", "Chinese Airlines",
                "Turkish Airline", "Qatar Airlines",
                "Bangladesh Airline", "British Airlines","Pegasus Airlines");
        airlines.setItems(airlinesList);
    }
}
