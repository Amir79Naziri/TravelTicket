package sample.Profile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import sample.Search.SearchController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileController implements Initializable {
    private ObservableList<Pane> pastTickets;
    @FXML
    private ListView<Pane> ticketHistoryList;
    @FXML
    protected StackPane mainPane;
    protected AnchorPane load;
    @FXML
    private JFXButton paymentButton;
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXButton changePassButton;

    @FXML
    private JFXTextField securityNumberField;

    @FXML
    private JFXTextField emailField;

    @FXML
    private JFXTextField bankNumberField;

    @FXML
    private JFXButton editButton;

    @FXML
    private JFXTextField phoneNumberField;

    static Parent homeRoot, loginRoot, bankRoot, changePassRoot;

    private final Pane pane1 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));

    public ProfileController() throws IOException {
    }

    @FXML
    void edit() {
        if (editButton.getText().equals("Edit")) {
            editButton.setText("Save");
            nameField.setEditable(true);
            lastNameField.setEditable(true);
            securityNumberField.setEditable(true);
            emailField.setEditable(true);
            phoneNumberField.setEditable(true);
            bankNumberField.setEditable(true);
        }
        else if (editButton.getText().equals("Save")) {
            editButton.setText("Edit");
            nameField.setEditable(false);
            lastNameField.setEditable(false);
            securityNumberField.setEditable(false);
            emailField.setEditable(false);
            phoneNumberField.setEditable(false);
            bankNumberField.setEditable(false);
            //TODO update the user
        }
    }

    @FXML
    void changePass() throws IOException {
        load = FXMLLoader.load(getClass().getResource("/sample/Profile/changePassword.fxml"));
        mainPane.getChildren().add(load);
        try {
            changePassRoot = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Search/Search.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        SearchController searchController = loader.getController();
        //searchController.test("Hello");

        homeRoot = loader.getRoot();
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
