package GUI.component;
import GUI.pages.AddTreatment;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import module.VisitModule;

public class RecordTreatment extends HBox {

    Label Date = null ;
    ScrollPane scrollPane_description = null ;
        Label description = null ;
    ScrollPane scrollPane_medicine = null ;
        Label medicine = null ;

    public RecordTreatment(Stage stage, PatientModule patientModule , VisitModule visitModule){

        super();

        Date = new Label(visitModule.getDate());
        Date.setFont(new Font("Arial",22));
        Date.setTextFill(Color.rgb(30,96,137));
        Date.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        description = new Label(visitModule.getDescription());
        description.setFont(new Font("Arial",25));
        description.setTextFill(Color.rgb(30,96,137));
        description.setWrapText(true);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setPrefWidth(450);

        scrollPane_description = new ScrollPane(description);
        scrollPane_description.setPrefSize(500,200);
        scrollPane_description.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_description.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        medicine = new Label(visitModule.getMedecine());
        medicine.setFont(new Font("Arial",25));
        medicine.setTextFill(Color.rgb(30,96,137));
        medicine.setWrapText(true);
        medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        medicine.setPrefWidth(450);

        scrollPane_medicine = new ScrollPane(medicine);
        scrollPane_medicine.setPrefSize(500,200);
        scrollPane_medicine.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_medicine.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        getChildren().addAll(scrollPane_medicine,scrollPane_description,Date);
        setSpacing(0);
        setStyle("-fx-border-width: 0 0 2 0; -fx-border-color: red #1E6089 #1E6089 red;");

        setOnMouseClicked(e->{

            AddTreatment addTreatment = new AddTreatment(stage,patientModule,visitModule);

        });
    }
}