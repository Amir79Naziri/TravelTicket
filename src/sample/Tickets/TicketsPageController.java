package sample.Tickets;

import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
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
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketsPageController implements Initializable
{

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

    public TicketsPageController() throws IOException
    {

    }

    @FXML
    void GoHome(ActionEvent event) throws IOException, InterruptedException
    {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
        mainPage.getChildren().add(load);
        list.setOpacity(0.5);


        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(f -> {
            Stage stage;
            stage = (Stage) HomeButton.getScene().getWindow();
            Scene scene = new Scene(rootHome);
            stage.setScene(scene);
            stage.show();
        });
        pause.play();

    }

    @FXML
    void GoProfile(ActionEvent event)
    {
        Stage stage;
        stage = (Stage) HomeButton.getScene().getWindow();
        Scene scene = new Scene(rootProfile);
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
