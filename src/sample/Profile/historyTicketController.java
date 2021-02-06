package sample.Profile;

import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.FileHandler;
import model.Ticket;
import model.TicketStorage;
import model.User;
import model.connections.userInformationClient.Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class historyTicketController
{

    private Ticket currentTicket;
    private User currentUser;
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label arrDate;

    @FXML
    private Label arrTime;

    @FXML
    private Label depDate;

    @FXML
    private Label depTime;

    @FXML
    private Label origin;

    @FXML
    private Label destination;

    @FXML
    private ImageView logo;

    @FXML
    private JFXButton retrieveBTN;

    @FXML
    void retrieve(ActionEvent event) throws IOException
    {

        TicketStorage ticketStorage = (TicketStorage) FileHandler.load("Files/ticketStorage.ser");
        ticketStorage.getTickets().put(currentTicket.getId(), currentTicket);
        FileHandler.save(ticketStorage, "Files/ticketStorage.ser");

        currentUser.removeTicket(currentTicket.getId());
        connect(currentUser);
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
        profileController.serCurrentUser(currentUser);

        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setEveryThing(Ticket ticket, User currentUser)
    {
        this.currentUser = currentUser;
        this.currentTicket = ticket;

        depDate.setText(ticket.getDepartureDate().toString());

        String dh = ticket.getDepartureHour() + "";
        String dm = ticket.getDepartureMinute() + "";
        String ah = ticket.getArrivalHour() + "";
        String am = ticket.getArrivalMinute() + "";
        if( ticket.getDepartureHour() < 10 )
            dh = "0" + ticket.getDepartureHour();

        if( ticket.getDepartureMinute() < 10 )
            dm = "0" + ticket.getDepartureMinute();

        if( ticket.getArrivalHour() < 10 )
            ah = "0" + ticket.getArrivalHour();

        if( ticket.getArrivalMinute() < 10 )
            am = "0" + ticket.getArrivalMinute();

        depTime.setText(dh + ":" + dm);
        arrDate.setText(ticket.getArrivalDate().toString());
        arrTime.setText(ah + ":" + am);
        origin.setText(ticket.getDepartureCity());
        destination.setText(ticket.getArrivalCity());
        try {
            FileInputStream input = new FileInputStream("src/sample/Tickets/Pictures/" + ticket.getAirLineName() + ".png");
            Image image = new Image(input);
            logo.setImage(image);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Client connect (User user)
    {
        Client client = new Client ("127.0.0.1","Logout", user);
        new Thread (client).start ();
        return client;
    }


    private String serverResponse(Client client) {
        return client.getLogoutResult ();
    }


}
