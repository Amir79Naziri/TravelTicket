package sample.TicketAndPerson;




import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.stage.Stage;

import model.Ticket;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TicketAndPersonController implements Initializable {
    @FXML
    private JFXButton home;

    private Ticket currentTicket;
    private User currentUser;

    @FXML
    private Label DestDate,OriginDate,DestTime,OriginTime,DestLocation,OriginLocation,price,name,lastname,phoneNumber,email,SocialNumber;
@FXML
private ImageView companyIcon;

@FXML
private ArrayList<Object> inputAndOutputArray;


    @FXML
    void goToHomePage() throws IOException{

        Stage stage;
        Parent root;


            stage = (Stage) home.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/sample/Search/Search.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private JFXButton account;

    @FXML
    private JFXButton payOnline;

    @FXML
    public void onlinePayment() throws IOException {

        //TODO:send output to payment page ( inputAndOutputArray)

        Stage stage;
        Parent root;

        stage = (Stage) payOnline.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Bank/BankPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




    @FXML
    public void goToAccountPage() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/sample/Profile/profileView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //TODO :get current user and ticket ArrayList

        //inputAndOutputArray
        //currentUser=User(inputAndOutputArray[0]);
        //currentTicket=Ticket(inputAndOutputArray[1]);

/*
        name.setText(currentUser.getFirstName());
        lastname.setText(currentUser.getLastName());
        SocialNumber.setText(currentUser.getSocialSecurityNumber());
        email.setText(currentUser.getEmail());
        phoneNumber.setText(currentUser.getPhoneNumber());

        DestDate.setText(currentTicket.getArrivalYear()+"/"+currentTicket.getArrivalMonth()+"/"+currentTicket.getArrivalDay());
        OriginDate.setText(currentTicket.getDepartureYear()+"/"+currentTicket.getDepartureYear()+"/"+currentTicket.getDepartureDay());
        DestTime.setText(currentTicket.getArrivalHour()+":"+currentTicket.getArrivalMinute());
        OriginTime.setText(currentTicket.getDepartureHour()+":"+currentTicket.getDepartureMinute());
        DestLocation.setText(currentTicket.getArrivalCity());
        OriginTime.setText(currentTicket.getDepartureCity());
        ///
        price.setText(currentTicket.getSold()+" ");

        companyIcon.setImage(new Image("/sample/TicketAndPerson/Pictures/"+currentTicket.getAirLineName().split(" ")[0]+".png"));
        */


    }
}
