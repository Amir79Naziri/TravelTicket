package sample.login;


import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PhoneLoginController extends Controller
        implements Initializable {

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private Hyperlink enterWithEmailLink;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private JFXTextField phoneNumberCode;

    @FXML
    private Label invalidPhoneNumberWarnLabel;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        super.actionHandler (event);
        if (event.getSource () == enterWithEmailLink)
        {

            Stage stage;
            Parent root;

            stage = (Stage) enterWithEmailLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("loginView_2.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpLink){

            Stage stage;
            Parent root;

            stage = (Stage) signUpLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/sample/signup/signUpView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void keyHandler(KeyEvent event) {
//        for (char c : phoneNumber.getText ().toCharArray ())
//            if (c >= '9' || c <= '0')
//            {
//                //TODO : warn user
//                System.out.println ("invalid phone number");
//                break;
//            }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        super.initialize (location, resources);
        invalidPhoneNumberWarnLabel.setVisible (false);
    }
}