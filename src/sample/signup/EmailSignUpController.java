package sample.signup;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


public class EmailSignUpController extends Controller{

    @FXML
    private JFXTextField email;

    @FXML
    private Hyperlink backToLoginLink;

    @FXML
    private Hyperlink signUpWithPhoneNumberLink;




    @FXML
    protected
    void actionHandler(ActionEvent event) throws Exception{
        super.actionHandler (event);
        if (event.getSource () == backToLoginLink)
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

}
