package sample.TicketAndPerson;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TicketAndPersonController {


    @FXML
    private Pane inTrain;

    @FXML
    private Pane outTrain;

    @FXML
    private ImageView outPlane;

    @FXML
    private ImageView inPlane;

    @FXML
    private JFXCheckBox TrainCheckBox;

    @FXML
    private JFXCheckBox AirplaneCheckBox;

    @FXML
    void trainCheckBoxHandler() {
        if (TrainCheckBox.isSelected())
            AirplaneCheckBox.setSelected(false);
        inPlane.setVisible(false);
        outPlane.setVisible(false);
        inTrain.setVisible(true);
        outTrain.setVisible(true);

    }

    @FXML
    void airplaneCheckBoxHandler() {
        if (AirplaneCheckBox.isSelected())
            TrainCheckBox.setSelected(false);
        inPlane.setVisible(true);
        outPlane.setVisible(true);
        inTrain.setVisible(false);
        outTrain.setVisible(false);

    }

//    @FXML
//    void blurairplane(ActionEvent event) {
//        origintrain.setVisible(false);
//        origintrain.setVisible(false);
//        originairplain.setVisible(true);
//        destairplane.setVisible(true);
//    }

//    @FXML
//    void blurtrain(ActionEvent event) {
//        originairplain.setVisible(false);
//        destairplane.setVisible(false);
//        origintrain.setVisible(true);
//        origintrain.setVisible(true);
//    }





}
