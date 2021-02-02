package sample.Tickets;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TicketController  implements Initializable
{

    private static int temp = 0;

    @FXML
    private Label cost;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Random random = new Random();
        temp++;
        cost.setText( Integer.toString(100 + temp)+ "$" );

    }
}
