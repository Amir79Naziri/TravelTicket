package sample.Profile;

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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private ObservableList<Pane> pastTickets;
    @FXML
    private ListView<Pane> ticketHistoryList;
    @FXML
    private StackPane mainPane;
    @FXML
    private JFXButton paymentButton;
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton logoutButton;

    static Parent homeRoot, loginRoot, bankRoot;

    private final Pane pane1 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));

    public ProfileController() throws IOException {
    }

    @FXML
    void goToBank(ActionEvent event) throws IOException, InterruptedException
    {
        try {
            bankRoot = FXMLLoader.load(getClass().getResource("/sample/Bank/BankPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
        mainPane.getChildren().add(load);
        ticketHistoryList.setOpacity(0.5);


        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(f -> {
            Stage stage;
            stage = (Stage) paymentButton.getScene().getWindow();
            Scene scene = new Scene(bankRoot);
            stage.setScene(scene);
            stage.show();
        });
        pause.play();

    }

    @FXML
    void goToHome()throws IOException{
        Stage stage;
        stage = (Stage) homeButton.getScene().getWindow();
        homeRoot = FXMLLoader.load(getClass().getResource("/sample/Search/Search.fxml"));

        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void goToLogout()throws IOException{
        try {
            loginRoot = FXMLLoader.load(getClass().getResource("/sample/login/loginView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage;
        stage = (Stage) logoutButton.getScene().getWindow();

        Scene scene = new Scene(loginRoot);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pastTickets = FXCollections.observableArrayList();
        pastTickets.addAll(pane1, pane2, pane3);
        ticketHistoryList.setItems(pastTickets);
    }
}
