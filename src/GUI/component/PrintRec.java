package GUI.component;

import GUI.pages.ProfilePatient;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import module.VisitModule;
import javax.swing.*;
import java.awt.print.PrinterException;

public class PrintRec {
    VBox primary = null;
        HBox secondary = null;
            Button with = null;
            Button without = null;
    Button ignore = null;

    public PrintRec(Stage stage, StackPane layout, PatientModule patientModule, VisitModule visitModule) {

        with = new Button("طباعة مع الإضافات", GlyphsDude.createIcon(FontAwesomeIcon.PRINT, "25"));
        with.setFont(new Font("Arila", 20));
        with.setTextFill(Color.rgb(90, 132, 173));
        with.setContentDisplay(ContentDisplay.TOP);
        with.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        without = new Button("طباعة بدون الإضافات", GlyphsDude.createIcon(FontAwesomeIcon.PRINT, "25"));
        without.setFont(new Font("Arila", 20));
        without.setTextFill(Color.rgb(90, 132, 173));
        without.setContentDisplay(ContentDisplay.TOP);
        without.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        secondary = new HBox(without, with);
        secondary.setSpacing(25);
        secondary.setPadding(new Insets(50, 0, 0, 30));

        ignore = new Button("تجاهل");
        ignore.setFont(new Font("Arial", 20));
        ignore.setTextFill(Color.rgb(90, 132, 173));
        ignore.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox hBox = new HBox(ignore);
        hBox.setPadding(new Insets(30, 0, 0, 210));

        primary = new VBox(secondary, hBox);
        primary.setSpacing(22);
        primary.setPrefSize(500, 270);
        primary.setBackground(new Background(new BackgroundFill(Color.rgb(30, 96, 137),CornerRadii.EMPTY, Insets.EMPTY)));
        primary.setMaxWidth(480);
        primary.setMaxHeight(250);

        layout.getChildren().add(primary);

        ignore.setOnAction(e->{

            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

        });

        String conversDate = visitModule.getDate();

        int j = 0;
//        for (int i = visitModule.getDate().length()-1; i > 0 ; i--) {
//            conversDate.
//            j++;
//        }
        System.out.println(conversDate);
        System.out.println(visitModule.getDate());
        without.setOnAction(e->{
            String forprint = "\n\n\nالاسم : ";
            forprint = forprint + patientModule.getName();
            forprint = forprint  + " | التاريخ: " + conversDate;
            forprint = forprint+"\n\n" +"\n"+ visitModule.getMedecine();
            System.out.println(forprint);
            JTextArea  pageprint = new JTextArea(forprint);
            try {
                stage.hide();
                pageprint.setFont(new java.awt.Font("arial",50,16));
                pageprint.setMargin(new java.awt.Insets(2,2,2,2));
                pageprint.print();
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
            finally {
                stage.show();
            }
        });
    }
}
