package sample.Bank;


import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Ticket;
import model.User;
import model.connections.userInformationClient.Client;
import sample.Profile.ProfileController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankPageController implements Initializable {

    static Parent profileRoot;

    private Ticket currentTicket;
    private User currentUser;
    private String purpose = "none";
    private double price = 0.0;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private JFXButton payButton;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private Label costLabel;

    public void setCurrentTicketAndUser(User user,Ticket ticket, String purpose) {
        this.currentUser = user;
        this.currentTicket = ticket;
        costLabel.setText(String.valueOf(ticket.getPrice()));
        this.purpose = purpose;
    }

    public void setPrice(User user, double price, String purpose) {
        this.currentUser = user;
        this.price = price;
        costLabel.setText(String.valueOf(price));
        this.purpose = purpose;
    }

    @FXML
    void goToProfile(ActionEvent event) throws IOException, InterruptedException
    {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
        mainPane.getChildren().add(load);
        try {
            profileRoot = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(f -> {
            Stage stage;
            stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Profile/profileView.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
            }

            ProfileController profileController = loader.getController();
            if (purpose.equals("wallet")) {
                if (event.getSource() != cancelButton) {
                    currentUser.getWallet().charge(this.price);
                    connect(currentUser);
                }
            }
            else {
                if (event.getSource() != cancelButton) {
                   currentUser.addTicket(currentTicket.getCode(), currentTicket);


                    // todo remove ticket from the tickets file
                    connect(currentUser);
                }
            }
            profileController.serCurrentUser(this.currentUser);

            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        });
        pause.play();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


}
