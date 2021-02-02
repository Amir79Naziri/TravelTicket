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
    private Hyperlink signUpLink;

    @FXML
    private Hyperlink enterWithPhoneNumberLink;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        super.actionHandler (event);
        if (event.getSource () == enterWithPhoneNumberLink)
        {

            Stage stage;
            Parent root;

            stage = (Stage) enterWithPhoneNumberLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("loginView.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource () == signUpLink){

            Stage stage;
            Parent root;

            stage = (Stage) signUpLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/sample/signup/signUpView_2.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
