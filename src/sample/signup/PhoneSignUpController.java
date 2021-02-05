package sample.signup;


import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.NullUser;
import model.User;
import model.connections.userInformationClient.Client;

import javax.swing.*;
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
    private JFXTextField phoneNumberCode;

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
                AnchorPane load = FXMLLoader.load(getClass().getResource("/sample/Loading/Loading.fxml"));
                mainPane.getChildren().add(load);
                Client client = connect ();


                PauseTransition pause = new PauseTransition(Duration.seconds(2));

                pause.setOnFinished(f -> {
                    User user = serverResponse (client, phoneNumberExistsWarnLabel);


                    if (user != null)
                    {
                        System.out.println (user.getPhoneNumber () + user.getEmail ());
                        // TODO : go to home page
                        Stage stage;
                        stage = (Stage) signUpButton.getScene().getWindow();
                        Scene scene = new Scene(profileRoot);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else
                    {
                        mainPane.getChildren ().remove (load);
                    }

                });
                pause.play();
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

    private Client connect ()
    {
        Client client = new Client ("127.0.0.1",phoneNumberCode.getText () +
                phoneNumber.getText (), password.getText (),"SignUp");
        new Thread (client).start ();
        return client;
    }
}
