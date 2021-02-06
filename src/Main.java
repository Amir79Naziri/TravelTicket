import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

/**
 * Travel Ticket Project
 */
public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/login/loginView.fxml"));
        primaryStage.setTitle("Travel Ticket");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable (false);
        primaryStage.show();
        primaryStage.getIcons().add(
                new Image (new FileInputStream (new File ("Icon/logo.png"))));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
