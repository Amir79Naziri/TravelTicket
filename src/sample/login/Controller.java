package sample.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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

    @FXML
    protected Label invalidPasswordWarnLabel;

    @FXML
    protected Label connectionLostWarnLabel;

    protected boolean isPasswordValid()
    {
        boolean validPassword = true;
        if (password.getText ().length () == 0)
        {
            if (!invalidPasswordWarnLabel.isVisible ())
                invalidPasswordWarnLabel.setVisible (true);

            validPassword = false;
        }
        else
        {
            if (invalidPasswordWarnLabel.isVisible ())
                invalidPasswordWarnLabel.setVisible (false);
        }
        return validPassword;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        couldNotFindYourAccountWarnLabel.setVisible (false);
        invalidPasswordWarnLabel.setVisible (false);
        connectionLostWarnLabel.setVisible (false);
    }
}
