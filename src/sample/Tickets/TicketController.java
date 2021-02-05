package sample.Tickets;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Ticket;
import model.User;

public class TicketController
{

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

    public void setEveryThing(Ticket ticket, User CurrentUser)
    {
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
    }

}
