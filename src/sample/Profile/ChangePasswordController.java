package sample.Profile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;


import java.io.IOException;

public class ChangePasswordController extends ProfileController {
    @FXML
    private JFXPasswordField currPassField;

    @FXML
    private JFXPasswordField newPassField;

    @FXML
    private JFXPasswordField repeatPassField;

    @FXML
    private JFXButton changeButton;

    @FXML
    private JFXButton cancelButton;

    public ChangePasswordController() throws IOException {
    }

    @FXML
    void changePassword() {
        //TODO update the user
        mainPane.getChildren().remove(load);
    }

    @FXML
    void cancel() {
        mainPane.getChildren().remove(load);
    }
}
