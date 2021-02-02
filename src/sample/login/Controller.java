package sample.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable
{
    @FXML
    protected JFXPasswordField password;

    @FXML
    protected JFXButton loginButton;

    @FXML
    protected Label couldNotFindYourAccountWarnLabel;



    protected void actionHandler(ActionEvent event) throws Exception {
        if (event.getSource () == loginButton)
        {
            // TODO : login here
            System.out.println ("log in");
        }

    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        couldNotFindYourAccountWarnLabel.setVisible (false);
    }
}
