package sample.signup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
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
    protected JFXPasswordField confirmPassword;

    @FXML
    protected JFXButton signUpButton;

    @FXML
    protected Label passwordComplexityWarnLabel;

    @FXML
    protected Label passwordMissMatchWarnLabel;

    @FXML
    protected Label connectionLostWarnLabel;

    protected boolean isPasswordValid()
    {
        boolean PasswordComplexity = true, passwordMatch = true;
        if (!checkPasswordComplexity (password.getText ()))
        {
            if (!passwordComplexityWarnLabel.isVisible ())
                passwordComplexityWarnLabel.setVisible (true);
            PasswordComplexity = false;
        }
        else {
            if (passwordComplexityWarnLabel.isVisible ())
                passwordComplexityWarnLabel.setVisible (false);
        }

        if (!password.getText ().equals (confirmPassword.getText ()))
        {
            if (!passwordMissMatchWarnLabel.isVisible ())
                passwordMissMatchWarnLabel.setVisible (true);
            passwordMatch = false;
        }
        else
        {
            if (passwordMissMatchWarnLabel.isVisible ())
                passwordMissMatchWarnLabel.setVisible (false);
        }
        return PasswordComplexity && passwordMatch;
    }

    private boolean checkPasswordComplexity(String temp)
    {
        if (temp.length () >= 8)
            return containsLetter (temp) && containsNumber (temp);
        else
            return false;
    }

    private boolean containsNumber(String temp)
    {
        char[] chars = temp.toCharArray();
        for(char c : chars)
        {
            if(Character.isDigit(c))
            {
                return true;
            }
        }
        return false;
    }

    private boolean containsLetter(String temp)
    {
        char[] chars = temp.toCharArray();
        for(char c : chars)
        {
            if(Character.isLetter(c))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        passwordMissMatchWarnLabel.setVisible (false);
        passwordComplexityWarnLabel.setVisible (false);
        connectionLostWarnLabel.setVisible (false);
    }

    protected User serverResponse(Client client, Label warnLabel)
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

        if (user instanceof NullUser)
        {
            if (!warnLabel.isVisible ())
                warnLabel.setVisible (true);
            return null;
        }
        else
        {
            if (warnLabel.isVisible ())
                warnLabel.setVisible (false);
        }

        return user;
    }
}
