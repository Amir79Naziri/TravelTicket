package sample.signup;


import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PhoneSignUpController extends Controller{

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private Hyperlink backToLoginLink;

    @FXML
    private Hyperlink signUpWithEmailLink;

    @FXML
    private Label invalidPhoneNumberWarnLabel;

    @FXML
    private Label phoneNumberExistsWarnLabel;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception {
        if (event.getSource () == signUpButton)
        {
            boolean validPassword = super.isPasswordValid (), validPhone;


            if (phoneNumber.getText ().length () != 10)
            {
                if (!invalidPhoneNumberWarnLabel.isVisible ())
                    invalidPhoneNumberWarnLabel.setVisible (true);

                validPhone = false;
            }
            else
            {
                validPhone = !invalidPhoneNumberWarnLabel.isVisible ();
            }

            if (validPassword && validPhone)
            {
                // TODO : sign up
                System.out.println ("sign up");
            }
        }
        else if (event.getSource () == backToLoginLink)
        {
            Stage stage;
            Parent root;

            stage = (Stage) backToLoginLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/sample/login/loginView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpWithEmailLink)
        {
            Stage stage;
            Parent root;

            stage = (Stage) signUpWithEmailLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("signUpView_2.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void keyHandler(KeyEvent event) {
        if (phoneNumber.getText ().length () != 10 &&
                phoneNumber.getText ().length () != 0)
        {
            if (!invalidPhoneNumberWarnLabel.isVisible ())
                invalidPhoneNumberWarnLabel.setVisible (true);
            return;
        }
        else
        {
            for (char c : phoneNumber.getText ().toCharArray ())
                if (c > '9' || c < '0')
                {
                    if (!invalidPhoneNumberWarnLabel.isVisible ())
                        invalidPhoneNumberWarnLabel.setVisible (true);
                    return;
                }
        }
        if (invalidPhoneNumberWarnLabel.isVisible ())
            invalidPhoneNumberWarnLabel.setVisible (false);
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        super.initialize (location, resources);
        invalidPhoneNumberWarnLabel.setVisible (false);
        phoneNumberExistsWarnLabel.setVisible (false);
    }
}
