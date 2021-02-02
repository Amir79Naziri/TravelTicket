package sample.Tickets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketsPageController implements Initializable
{

    private ObservableList<Pane> tickets;

    private ObservableList<String> choices;

    @FXML
    private ListView<Pane> list;


    @FXML
    private ChoiceBox<String> timeOrder;

    private final Pane pane1 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane4 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
    private final Pane pane5 = FXMLLoader.load(getClass().getResource("Ticket.fxml"));

    public TicketsPageController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        choices = FXCollections.observableArrayList();
        choices.addAll("Time Ascending", "Time Descending");
        timeOrder.setItems(choices);

        tickets = FXCollections.observableArrayList();
        tickets.addAll(pane1, pane2, pane3, pane4, pane5);
        list.setItems(tickets);
    }
}
