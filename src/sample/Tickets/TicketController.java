package sample.Tickets;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Ticket;
import model.User;
import sample.Profile.ProfileController;
import sample.TicketAndPerson.TicketAndPersonController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketController
{

    private Ticket ticket;
    private User currentUser;

    @FXML
    private Label depDate;

    @FXML
    private Label depTime;

    @FXML
    private Label price;

    @FXML
    private Label arrDate;

    @FXML
    private Label arrTime;

    @FXML
    private Label origin;

    @FXML
    private Label destination;

    @FXML
    private ImageView logo;

    @FXML
    private JFXButton purchaseBTN;

    public void setEveryThing(Ticket ticket, User currentUser)
    {

        this.ticket = ticket;
        this.currentUser = currentUser;

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
        price.setText(ticket.getPrice() + "$");
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


    @FXML
    void purchase(ActionEvent event)
    {
        Stage stage;
        stage = (Stage) purchaseBTN.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/TicketAndPerson/TicketAndPerson.fxml"));
        try
        {
            loader.load();
        } catch (IOException e) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, e);
        }

        TicketAndPersonController ticketAndPersonController = loader.getController();
        ticketAndPersonController.setCurrentTicketAndUser(ticket, currentUser);

        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
