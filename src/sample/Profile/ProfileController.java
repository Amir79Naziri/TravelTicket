package sample.Profile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;
import model.connections.userInformationClient.Client;
import sample.Search.SearchController;


import java.io.IOException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileController implements Initializable {
    private User currentUser;
    private ObservableList<Pane> pastTickets;
    @FXML
    private ListView<Pane> ticketHistoryList;
    @FXML
    protected StackPane mainPane;
    protected AnchorPane load;
    @FXML
    private BorderPane borderPane;
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

    //Change Password Fields
    @FXML
    private AnchorPane changePasswordPane;

    @FXML
    private JFXPasswordField currPassField;

    @FXML
    private JFXPasswordField newPassField;

    @FXML
    private JFXPasswordField repeatPassField;

    @FXML
    private JFXButton changeButton;

    @FXML
    private JFXButton cancelButton;
    //


    //Travel History fields
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXButton searchButton;
    //

    //Wallet fields
    @FXML
    private Label balance;
    @FXML
    private Label available;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXButton pay;
    //


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
            nameField.setDisable(false);
            lastNameField.setDisable(false);
            securityNumberField.setDisable(false);
            emailField.setDisable(false);
            phoneNumberField.setDisable(false);
            bankNumberField.setDisable(false);
        }
        else if (editButton.getText().equals("Save")) {
            editButton.setText("Edit");
            nameField.setDisable(true);
            lastNameField.setDisable(true);
            securityNumberField.setDisable(true);
            emailField.setDisable(true);
            phoneNumberField.setDisable(true);
            bankNumberField.setDisable(true);
            //TODO update the user
        }
    }

    @FXML
    void changePass() throws IOException {
        borderPane.setOpacity(0.4);
        changePasswordPane.setVisible(true);
        editButton.setDisable(true);
        changePassButton.setDisable(true);
    }

    @FXML
    void changePassword() {
        //TODO update the user
        borderPane.setOpacity(1);
        changePasswordPane.setVisible(false);
        editButton.setDisable(false);
        changePassButton.setDisable(false);
    }

    @FXML
    void cancel() {
        borderPane.setOpacity(1);
        changePasswordPane.setVisible(false);
        editButton.setDisable(false);
        changePassButton.setDisable(false);
    }

    @FXML
    void searchTickets(){
        LocalDate date = datePicker.getValue();
        if (date != null) {
            //TODO search tickets for the date
        }
    }

    private Client connect ()
    {
        Client client = new Client ("127.0.0.1","Logout",currentUser);
        new Thread (client).start ();
        return client;
    }


    private String serverResponse(Client client)
    {
        return client.getLogoutResult ();
    }














    @FXML
    void goToBank(ActionEvent event) throws IOException, InterruptedException {
        String price = amount.getText();


        try {
            bankRoot = FXMLLoader.load(getClass().getResource("/sample/Bank/BankPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
        mainPane.getChildren().add(load);
        ticketHistoryList.setOpacity(0.5);


        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(f -> {
            Stage stage;
            stage = (Stage) pay.getScene().getWindow();
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
        searchController.test("Hello");

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

    public void serCurrentUser(User user) {
        this.currentUser = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pastTickets = FXCollections.observableArrayList();
        pastTickets.addAll(pane1, pane2, pane3);
        ticketHistoryList.setItems(pastTickets);
    }
}
