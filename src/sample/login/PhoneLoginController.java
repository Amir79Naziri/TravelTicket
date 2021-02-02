package sample.login;


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


public class PhoneLoginController extends Controller{

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private Hyperlink enterWithEmailLink;

    @FXML
    protected Hyperlink signUpLink;

    @FXML
    private JFXTextField phoneNumberCode;

    @FXML
    private Label invalidPhoneNumberWarnLabel;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        super.actionHandler (event);
        if (event.getSource () == enterWithEmailLink)
        {
            // TODO : go to enter with email scene
            System.out.println ("go to enter with email");
            Stage stage;
            Parent root;

            stage = (Stage) enterWithEmailLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("loginView_2.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpLink){
            // TODO : go to sign up scene
            System.out.println ("go to sign UP");
        }
    }

    @FXML
    protected void keyHandler(KeyEvent event) {
        if (phoneNumber.getText ().length () != 10)
        {
            //TODO : warn user
            System.out.println ("invalid phone number");

        }
        else
        {
            for (char c : phoneNumber.getText ().toCharArray ())
                if (c >= '9' || c <= '0')
                {
                    //TODO : warn user
                    System.out.println ("invalid phone number");
                    break;
                }
        }
    }

}