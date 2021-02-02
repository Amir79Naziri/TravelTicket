package sample.login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class EmailLoginController extends Controller
{
    @FXML
    private JFXTextField email;

    @FXML
    protected Hyperlink signUpLink;

    @FXML
    private Hyperlink enterWithPhoneNumberLink;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        super.actionHandler (event);
        if (event.getSource () == enterWithPhoneNumberLink)
        {
            // TODO : go to enter with phone number scene
            System.out.println ("go to enter with email");
            Stage stage;
            Parent root;

            stage = (Stage) enterWithPhoneNumberLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("loginView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpLink){
            // TODO : go to sign up scene
            System.out.println ("go to sign UP");
        }
    }
}
