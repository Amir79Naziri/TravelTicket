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
    protected void actionHandler(ActionEvent event) throws Exception {
        super.actionHandler (event);
        if (event.getSource () == backToLoginLink)
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
//        if (event.getSource () == phoneNumber)
//        {
//            for (char c : phoneNumber.getText ().toCharArray ())
//                if (c >= '9' || c <= '0')
//                {
//                    //TODO : warn user
//                    System.out.println ("invalid phone number");
//                    break;
//                }
//        }
    }

}
