package sample.Tickets;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TicketController  implements Initializable
{

    @FXML
    private Label cost;

    @FXML
    private JFXButton purchaseButton;

    @FXML
    void purchase(MouseEvent event)
    {
        System.out.println(cost.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Random random = new Random();
        cost.setText( Integer.toString( random.nextInt(2000) ) + '$' );

    }
}
