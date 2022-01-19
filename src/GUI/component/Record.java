package GUI.component;

import GUI.pages.ProfilePatient;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;

public class Record extends HBox {

    Label name = null ;
    Label num_id = null ;
    Label phone_number = null ;

    public Record(Stage stage, PatientModule patientModule) {

        name = new Label(patientModule.getName());
        name.setContentDisplay(ContentDisplay.RIGHT);
        name.setTextFill(Color.WHITE);
        name.setFont(new Font("Arial",30));
        name.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name.setPrefSize(550,20);
        name.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        num_id = new Label(patientModule.getId_patient());
        num_id.setTextFill(Color.WHITE);
        num_id.setFont(new Font("Arial",30));
        num_id.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        num_id.setPrefSize(350,20);
        num_id.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        phone_number = new Label(patientModule.getMobilephone());
        phone_number.setTextFill(Color.WHITE);
        phone_number.setFont(new Font("Arial",30));
        phone_number.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_number.setPrefSize(400,20);
        phone_number.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137), CornerRadii.EMPTY, Insets.EMPTY)));

        getChildren().addAll(phone_number,num_id,name);

        HBox.setHgrow(name, Priority.ALWAYS);
        HBox.setMargin(name,new Insets(7,15,0,600));

        HBox.setHgrow(num_id, Priority.ALWAYS);
        HBox.setMargin(num_id,new Insets(7,-530,0,300));

        HBox.setHgrow(phone_number, Priority.ALWAYS);
        HBox.setMargin(phone_number,new Insets(7,0,0,10));

        setSpacing(20);
        setPrefSize(1120,50);

        setOnMouseClicked(e->{

            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

        });
    }
}