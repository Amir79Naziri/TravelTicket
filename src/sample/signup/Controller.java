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
            // TODO : sign up
            System.out.println ("sign up");
        }
    }

    @FXML
    void keyHandler(KeyEvent event) {

    }
}
