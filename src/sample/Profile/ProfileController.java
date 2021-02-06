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
import model.Ticket;
import model.User;
import model.connections.userInformationClient.Client;
import sample.Bank.BankPageController;
import sample.Search.SearchController;
import sample.Tickets.TicketController;


import java.io.IOException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileController implements Initializable {
    private ArrayList<Ticket> tikcetsList = new ArrayList<>();
    private User currentUser;
    private ObservableList<Pane> pastTickets = FXCollections.observableArrayList();;
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

    @FXML
    private Label invalidPassword;

    @FXML
    private Label invalidEmail;

    @FXML
    private Label invalidPhoneNumber;
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
    @FXML
    private Label invalidAmount;
    //


    static Parent homeRoot, loginRoot, bankRoot;

    private final Pane pane1 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane2 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));
    private final Pane pane3 = FXMLLoader.load(getClass().getResource("historyTicket.fxml"));

    public ProfileController() throws IOException {
        currentUser = new User("", "", -1);
    }

    @FXML
    void edit() throws InterruptedException {
        if (editButton.getText().equals("Edit")) {
            editButton.setText("Save");

            invalidEmail.setVisible(false);
            invalidPhoneNumber.setVisible(false);

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

            User tempUser = new User("", "", 1);

            tempUser.setId(currentUser.getId());
            tempUser.setFirstName(nameField.getText());
            tempUser.setLastName(lastNameField.getText());
            tempUser.setSocialSecurityNumber(securityNumberField.getText());
            tempUser.setEmail(emailField.getText());
            tempUser.setPhoneNumber(phoneNumberField.getText());
            tempUser.setBankAccountNumber(bankNumberField.getText());
            Client client = connect(tempUser);
            Thread.sleep(2000);
            String res = serverResponse(client);

            switch (res)
            {
                case "Error_1":
                    invalidEmail.setVisible(true);
                    invalidPhoneNumber.setVisible(true);
                    break;
                case "Error_2":
                    invalidPhoneNumber.setVisible(true);
                    currentUser.setEmail (tempUser.getEmail ());
                    break;
                case "Error_3":
                    invalidEmail.setVisible(true);
                    currentUser.setPhoneNumber (tempUser.getPhoneNumber ());
                    break;
                case "Error_4":
                    System.err.println("Error_4");;
                    break;
                default:
                    currentUser.setEmail (tempUser.getEmail ());
                    currentUser.setPhoneNumber (tempUser.getPhoneNumber ());
            }
            currentUser.setFirstName (tempUser.getFirstName ());
            currentUser.setLastName (tempUser.getLastName ());
            currentUser.setBankAccountNumber (tempUser.getBankAccountNumber ());
            currentUser.setSocialSecurityNumber (tempUser.getSocialSecurityNumber ());
            updateAccountFields();
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
        //todo uncomment
//        if (currentUser.changePassword(newPassField.getText(), currPassField.getText())) {
//            invalidPassword.setVisible(false);
//            connect(currentUser);
//        }
//        else
//            invalidPassword.setVisible(true);

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
            ArrayList<Ticket> filteredTickets = new ArrayList<>();
            pastTickets.removeAll();
            ticketHistoryList.getItems().clear();

            for(Ticket ticket : tikcetsList) {
                if(ticket.getDepartureDate().equals(date))
                    filteredTickets.add(ticket);
            }

            for(Ticket ticket : filteredTickets)
                addToPane(ticket);

            ticketHistoryList.refresh();
        }
    }

    private Client connect (User user)
    {
        Client client = new Client ("127.0.0.1","Logout", user);
        new Thread (client).start ();
        return client;
    }


    private String serverResponse(Client client)
    {
        return client.getLogoutResult ();
    }














    @FXML
    void goToBank(ActionEvent event) throws IOException, InterruptedException {
        invalidAmount.setVisible(false);
        String price = amount.getText();
        double paymentValue = 0.0;
        if (!price.equals("") && !price.equals("0")) {
            paymentValue = Double.parseDouble(price);

            AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
            mainPane.getChildren().add(load);
            ticketHistoryList.setOpacity(0.5);


            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            double finalPaymentValue = paymentValue;
            pause.setOnFinished(f -> {
                Stage stage;
                stage = (Stage) homeButton.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/Search/Search.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
                }

                BankPageController bankPageController = loader.getController();
                bankPageController.setPrice(currentUser, finalPaymentValue, "wallet");

                bankRoot = loader.getRoot();
                Scene scene = new Scene(bankRoot);
                stage.setScene(scene);
                stage.show();
            });
            pause.play();

        }
        else {
            invalidAmount.setVisible(true);
        }

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
        searchController.setCurrentUser(currentUser);

        homeRoot = loader.getRoot();
        Scene scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void goToLogout()throws IOException{
        connect(currentUser);
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
        updateAccountFields();

        updateTicketList(user.getTickets());

        balance.setText(String.valueOf(currentUser.getWallet().getValue()));
        available.setText(String.valueOf(currentUser.getWallet().getValue()));

    }

    private void updateAccountFields() {
        nameField.setText(currentUser.getFirstName());
        lastNameField.setText(currentUser.getLastName());
        securityNumberField.setText(currentUser.getSocialSecurityNumber());
        emailField.setText(currentUser.getEmail());
        phoneNumberField.setText(currentUser.getPhoneNumber());
        bankNumberField.setText(currentUser.getBankAccountNumber());
    }

    private void updateTicketList(HashMap<Integer, Ticket> tickets) {
        for(Map.Entry<Integer, Ticket> set : tickets.entrySet())
        {
            Ticket temp = set.getValue();
            tikcetsList.add(temp);
            addToPane(temp);
        }
    }

    public void addToPane(Ticket temp)
    {
        Pane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("historyTicket.fxml"));
        try {
            pane = loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

//        HistoryTicketController historyTicketController = loader.getController();
//        historyTicketController.setEveryThing(temp, currentUser);
        pastTickets.add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        pastTickets = FXCollections.observableArrayList();
//        pastTickets.addAll(pane1, pane2, pane3);
        ticketHistoryList.setItems(pastTickets);
    }
}
