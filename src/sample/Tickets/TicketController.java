package sample.Tickets;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TicketController  implements Initializable
{

    @FXML
    private Label cost;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Random random = new Random();
        cost.setText( Integer.toString( random.nextInt(2000) ) + '$' );

    }
}
