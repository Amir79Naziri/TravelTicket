package sample.Profile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private ObservableList<Pane> pastTickets;
    @FXML
    private ListView<Pane> ticketHistoryList;

    private final Pane pane1 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));

    public ProfileController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pastTickets = FXCollections.observableArrayList();
        pastTickets.addAll(pane1, pane2, pane3);
        ticketHistoryList.setItems(pastTickets);
    }
}
