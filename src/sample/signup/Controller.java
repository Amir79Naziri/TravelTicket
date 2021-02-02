package sample.signup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;


public class Controller
{
    @FXML
    protected JFXPasswordField password;

    @FXML
    protected JFXPasswordField confirmPassword;

    @FXML
    protected JFXButton signUpButton;

    @FXML
    private Label passwordComplexityWarnLabel;

    @FXML
    private Label passwordMissMatchWarnLabel;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception {
        if (event.getSource () == signUpButton)
        {
            boolean PasswordComplexity = true, passwordMatch = true;
            if (!checkPasswordComplexity (password.getStyle ()))
            {
                // TODO : set passwordComplexityWarnLabel red
                System.out.println ("passwordComplexity error");
                PasswordComplexity = false;
            }

            if (!password.getText ().equals (confirmPassword.getText ()))
            {
                // TODO : set passwordMissMatchWarnLabel red
                System.out.println ("passwordMissMatch error");
                passwordMatch = false;
            }
            if (passwordMatch && PasswordComplexity)
            {
                // TODO : sign up
                System.out.println ("sign up");
            }
        }
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
}
