package sample.signup;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.NullUser;
import model.User;
import model.connections.userInformationClient.Client;

import java.net.URL;
import java.util.ResourceBundle;


public class EmailSignUpController extends Controller{

    @FXML
    private JFXTextField email;

    @FXML
    private Hyperlink backToLoginLink;

    @FXML
    private Hyperlink signUpWithPhoneNumberLink;

    @FXML
    private Label invalidEmailWarnLabel;

    @FXML
    private Label emailExistsWarnLabel;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        if (event.getSource () == signUpButton)
        {
            boolean validPassword = super.isPasswordValid (), validEmail = true;


            if (email.getText ().length () == 0)
            {
                if (!invalidEmailWarnLabel.isVisible ())
                    invalidEmailWarnLabel.setVisible (true);

                validEmail = false;
            }
            else
            {
                if (invalidEmailWarnLabel.isVisible ())
                    invalidEmailWarnLabel.setVisible (false);
            }
            if (validPassword && validEmail)
            {
                // TODO : sign up
                Client client = connect ();
                try {
                    Thread.sleep (3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace ();
                }
                System.out.println (serverResponse (client, emailExistsWarnLabel));
//                System.out.println ("sign up");
            }
        }
        else if (event.getSource () == backToLoginLink)
        {
            Stage stage;
            Parent root;

            stage = (Stage) backToLoginLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/sample/login/loginView_2.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpWithPhoneNumberLink)
        {
            Stage stage;
            Parent root;

            stage = (Stage) signUpWithPhoneNumberLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("signUpView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        super.initialize (location, resources);
        invalidEmailWarnLabel.setVisible (false);
        emailExistsWarnLabel.setVisible (false);
    }

    private Client connect ()
    {
        Client client = new Client ("127.0.0.1",email.getText ()
                , password.getText (),"SignUp");
        new Thread (client).start ();
        return client;
    }
}
