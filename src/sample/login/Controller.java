package sample.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.NullUser;
import model.User;
import model.connections.userInformationClient.Client;

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
            password.setText ("");
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

    protected User serverResponse(Client client)
    {
        User user = client.getLoginOrSignUpResult ();
        if (user == null){
            if (!connectionLostWarnLabel.isVisible ())
                connectionLostWarnLabel.setVisible (true);
            return null;
        }
        else
        {
            if (connectionLostWarnLabel.isVisible ())
                connectionLostWarnLabel.setVisible (false);
        }

        if (user instanceof NullUser) {
            if (!couldNotFindYourAccountWarnLabel.isVisible ())
                couldNotFindYourAccountWarnLabel.setVisible (true);
            return null;
        }
        else
        {
            if (!couldNotFindYourAccountWarnLabel.isVisible ())
                couldNotFindYourAccountWarnLabel.setVisible (false);
        }

        return user;
    }
}
