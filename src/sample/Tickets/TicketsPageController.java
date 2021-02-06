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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.FileHandler;
import model.Ticket;
import model.TicketStorage;
import model.User;
import sample.Profile.ProfileController;
import sample.Search.SearchController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    @FXML
    private ChoiceBox<String> timeOrder;
    private ObservableList<String> choices;

    @FXML
    private JFXButton ProfileButton;

    @FXML
    private JFXButton HomeButton;

    @FXML
    private ListView<Pane> list;
    private ObservableList<Pane> tickets = FXCollections.observableArrayList();
    private ArrayList<Ticket> tikcetsList = new ArrayList<>();

    @FXML
    private ChoiceBox<String> airlines;
    private ObservableList<String> airlinesList;

    @FXML
    private AnchorPane mainPage;


    static Parent rootHome, rootProfile;

    @FXML
    private JFXButton searchbtn;

    public void setSearchDetails(String originLocation,String destinationLocation,String choosedDate,String trainOrAirplane,User currentUser)
    {
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.choosedDate = choosedDate;
        this.trainOrAirplane = trainOrAirplane;
        this.currentUser = currentUser;

        System.out.println(choosedDate);

        TicketStorage ticketStorage = (TicketStorage) FileHandler.load("Files/ticketStorage.ser");
        for(Map.Entry<Integer, Ticket> set : ticketStorage.getTickets().entrySet())
        {
            Ticket temp = set.getValue();
            if(temp.getDepartureCity().equals(originLocation) && temp.getArrivalCity().equals(destinationLocation))
            {
                tikcetsList.add(temp);
               addToPane(temp);
            }
        }

    }

    public void addToPane(Ticket temp)
    {
        Pane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Ticket.fxml"));
        try {
            pane = loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        TicketController ticketController = loader.getController();
        ticketController.setEveryThing(temp, currentUser);
        tickets.add(pane);
    }

    @FXML
    void GoHome(ActionEvent event) throws IOException, InterruptedException
    {
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

    @FXML
    void search(ActionEvent event)
    {
        ArrayList<Ticket> ok = new ArrayList<>();
        tickets.removeAll();
        list.getItems().clear();

        for(Ticket ticket : tikcetsList)
        {
            if(airlines.getValue() == null)
            {
                ok.add(ticket);
            }
            else
            {
                if(ticket.getAirLineName().equals(airlines.getValue()))
                    ok.add(ticket);
            }
        }

        if(timeOrder.getValue() != null)
        {

        }

        list.refresh();
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



        list.setItems(tickets);

        airlinesList = FXCollections.observableArrayList();
        airlinesList.addAll("American Airlines", "Chinese Airlines",
                "Turkish Airlines", "Qatar Airlines",
                "Bangladesh Airlines", "British Airlines","Pegasus Airlines");
        airlines.setItems(airlinesList);
    }
}
