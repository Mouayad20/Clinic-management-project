package GUI.pages;

import GUI.component.RecordTreatment;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import module.VisitModule;
import sample.Main;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayTreatment {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec1 = null ;
        Button back = null ;
        HBox chekers = null ;
            RadioButton bydiscreption = null ;
            RadioButton bymedicine = null ;
            RadioButton bydate = null ;
        TextField search = null ;
        HBox DateTF = null ;
            TextField day = null ;
            TextField month = null ;
            TextField year = null ;
        VBox secondary_layout = null ;
            Label header = null ;
            ScrollPane scrollPane = null ;
                VBox content = null ;
                RecordTreatment[] recordTreatment = null ;
        Label sizeOfResult = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;
    VisitModule[] visitModules = null;
    Integer sizeOfResultInteger = 0;

    public DisplayTreatment(Stage stage , PatientModule patientModule) {

        primary_layout = new StackPane();

        rec1 = new Rectangle();
        rec1.setFill(Color.rgb(90, 132, 173));
        rec1.widthProperty().bind(primary_layout.widthProperty());
        rec1.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD, "30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        back.setFont(new Font("Arial", 25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bydiscreption = new RadioButton("حسب الوصف  ");
        bydiscreption.setFont(new Font("Arial", 25));
        bydiscreption.setTextFill(Color.WHITE);
        bydiscreption.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        bymedicine = new RadioButton("حسب الدواء  ");
        bymedicine.setFont(new Font("Arial", 25));
        bymedicine.setTextFill(Color.WHITE);
        bymedicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        bydate = new RadioButton("حسب التاريخ ");
        bydate.setSelected(true);
        bydate.setFont(new Font("Arial", 25));
        bydate.setTextFill(Color.WHITE);
        bydate.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        bydate.setSelected(true);

        chekers = new HBox(bydate, bymedicine, bydiscreption);
        chekers.setSpacing(15);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        sizeOfResult = new Label("عدد النتائج: "+sizeOfResultInteger.toString());
        sizeOfResult.setFont(new Font("arial",25));
        sizeOfResult.setTextFill(Color.WHITE);
        sizeOfResult.setCenterShape(false);
        sizeOfResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        search = new TextField();
        search.setPromptText(" حدد خيارك قم ابحث  ");
        search.setFont(new Font("Arial", 30));
        search.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        search.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        search.setStyle("-fx-text-fill : #1E6089;");

        search.textProperty().addListener(e->{

            if (bydiscreption.isSelected())
            {
                content.getChildren().clear();
                try {
                    visitModules = Main.db.FetchVisitsByDescription(patientModule,search.getText());
                    recordTreatment = new RecordTreatment[visitModules.length];
                    for (int i = 0; i <visitModules.length ; i++) {
                        recordTreatment[i] = new RecordTreatment(stage,patientModule,visitModules[i]);
                        content.getChildren().add(recordTreatment[i]);
                    }
                    sizeOfResultInteger = visitModules.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (bymedicine.isSelected())
            {
                content.getChildren().clear();
                try {
                    visitModules = Main.db.FetchVisitsByMedicene(patientModule,search.getText());
                    recordTreatment = new RecordTreatment[visitModules.length];
                    for (int i = 0; i <visitModules.length ; i++) {
                        recordTreatment[i] = new RecordTreatment(stage,patientModule,visitModules[i]);
                        content.getChildren().add(recordTreatment[i]);
                    }
                    sizeOfResultInteger = visitModules.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        content = new VBox();
        content.setSpacing(0);

        day = new TextField();
        day.setPromptText("اليوم");
        day.setFont(new Font("Arial", 30));
        day.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        day.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        day.setStyle("-fx-text-fill : #1E6089;");
        day.setPrefSize(125, 50);

        day.textProperty().addListener(e->{

            content.getChildren().clear();
            try {
                visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                recordTreatment = new RecordTreatment[visitModules.length];
                for (int i = 0; i <visitModules.length ; i++) {
                    recordTreatment[i] = new RecordTreatment(stage , patientModule,visitModules[i]);
                    content.getChildren().add(recordTreatment[i]);
                }
                sizeOfResultInteger = visitModules.length;
                sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        month = new TextField();
        month.setPromptText("الشهر");
        month.setFont(new Font("Arial", 30));
        month.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        month.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        month.setStyle("-fx-text-fill :  #1E6089;");
        month.setPrefSize(125, 50);

        month.textProperty().addListener(e->{

            content.getChildren().clear();
            try {
                visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                recordTreatment = new RecordTreatment[visitModules.length];
                for (int i = 0; i <visitModules.length ; i++) {
                    recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                    content.getChildren().add(recordTreatment[i]);
                }
                sizeOfResultInteger = visitModules.length;
                sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        year = new TextField();
        year.setPromptText("السنة");
        year.setFont(new Font("Arial", 30));
        year.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        year.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        year.setStyle("-fx-text-fill : #1E6089;");
        year.setPrefSize(125, 50);

        year.textProperty().addListener(e->{

            content.getChildren().clear();
            try {
                visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                recordTreatment = new RecordTreatment[visitModules.length];
                for (int i = 0; i <visitModules.length ; i++) {
                    recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                    content.getChildren().add(recordTreatment[i]);
                }
                sizeOfResultInteger = visitModules.length;
                sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        DateTF = new HBox(year, month, day);
        DateTF.setSpacing(15);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scrollPane = new ScrollPane(content);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-color : #5A84AD;");

        header = new Label("التاريخ                          وصف المعاينة                                           العلاجات                           ");
        header.setFont(new Font("Arial", 30));
        header.setTextFill(Color.WHITE);

        secondary_layout = new VBox(header, scrollPane);
        secondary_layout.setSpacing(15);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        dr_name = new HBox();
        dr = new Label("Dr.");
        dr.setFont(new Font("Arial", 30));
        dr.setTextFill(Color.rgb(30, 96, 137));
        DRname = new Label("Name");
        DRname.setFont(new Font("Arial", 30));
        DRname.setTextFill(Color.WHITE);
        dr_name = new HBox(dr, DRname);
        HBox.setHgrow(dr_name, Priority.ALWAYS);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        Date = new Label(s);
        Date.setFont(new Font("Arial", 35));
        Date.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (bydate.isSelected()) {
            try {
                visitModules = Main.db.FetchVisitsSortedByDate(patientModule);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (visitModules != null){
                recordTreatment = new RecordTreatment[visitModules.length];
                for (int i = 0; i < recordTreatment.length; i++) {
                    recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                    content.getChildren().add(recordTreatment[i]);
                }
                sizeOfResultInteger = visitModules.length;
                sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
            }

            primary_layout.getChildren().addAll(rec1, back, chekers, DateTF, secondary_layout, Date, dr_name,sizeOfResult);

            bymedicine.setOnMouseClicked(e -> {
                bydiscreption.setSelected(false);
                bydate.setSelected(false);
                search.clear();
                day.clear();
                month.clear();
                year.clear();
                primary_layout.getChildren().clear();
                primary_layout.getChildren().addAll(rec1, back, chekers, search, secondary_layout, Date, dr_name,sizeOfResult);
            });

            bydiscreption.setOnMouseClicked(e -> {
                bymedicine.setSelected(false);
                bydate.setSelected(false);
                primary_layout.getChildren().clear();
                search.clear();
                day.clear();
                month.clear();
                year.clear();
                primary_layout.getChildren().addAll(rec1, back, chekers, search, secondary_layout, Date, dr_name,sizeOfResult);

            });

            bydate.setOnMouseClicked(e -> {
                bydiscreption.setSelected(false);
                bymedicine.setSelected(false);
                search.clear();
                day.clear();
                month.clear();
                year.clear();
                primary_layout.getChildren().clear();
                primary_layout.getChildren().addAll(rec1, back, chekers, DateTF, secondary_layout, Date, dr_name,sizeOfResult);
            });

            StackPane.setAlignment(sizeOfResult, Pos.BOTTOM_CENTER);
            StackPane.setMargin(sizeOfResult, new Insets(0,0,40,0));

            StackPane.setAlignment(back, Pos.TOP_LEFT);
            StackPane.setMargin(back, new Insets(10, 0, 0, 10));

            StackPane.setAlignment(chekers, Pos.TOP_CENTER);
            StackPane.setMargin(chekers, new Insets(75, 200, 0, 500));

            StackPane.setAlignment(search, Pos.TOP_CENTER);
            StackPane.setMargin(search, new Insets(150, 200, 0, 200));

            StackPane.setAlignment(DateTF, Pos.TOP_CENTER);
            StackPane.setMargin(DateTF, new Insets(150, 200, 0, 565));

            StackPane.setAlignment(secondary_layout, Pos.CENTER);
            StackPane.setMargin(secondary_layout, new Insets(280, 200, 100, 200));

            StackPane.setAlignment(content, Pos.CENTER);
            StackPane.setMargin(content, new Insets(280, 350, 100, 350));

            StackPane.setAlignment(dr_name, Pos.TOP_LEFT);
            StackPane.setMargin(dr_name, new Insets(750, 0, 0, 1300));

            StackPane.setAlignment(Date, Pos.TOP_LEFT);
            StackPane.setMargin(Date, new Insets(750, 0, 0, 15));

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            scene = new Scene(primary_layout, Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            stage.setScene(scene);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            back.setOnAction(e->{

                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

            });
        }
    }
}



/*
package GUI.pages;

import GUI.component.RecordTreatment;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import module.VisitModule;
import sample.Main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayTreatment {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec1 = null ;
        Button back = null ;
        HBox chekers = null ;
            RadioButton bydiscreption = null ;
            RadioButton bymedicine = null ;
            RadioButton bydate = null ;
        TextField search = null ;
        HBox DateTF = null ;
            TextField day = null ;
            TextField month = null ;
            TextField year = null ;
        VBox secondary_layout = null ;
            Label header = null ;
            ScrollPane scrollPane = null ;
                VBox content = null ;
                    RecordTreatment[] recordTreatment = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

        java.util.Date timeDate = null;
        SimpleDateFormat simpleDateFormat = null ;
        VisitModule[] visitModules = null;
        Integer sizeOfResultInteger = 0;

        public DisplayTreatment(Stage stage , PatientModule patientModule) {

            primary_layout = new StackPane();

            rec1 = new Rectangle();
            rec1.setFill(Color.rgb(90, 132, 173));
            rec1.widthProperty().bind(primary_layout.widthProperty());
            rec1.heightProperty().bind(primary_layout.heightProperty());

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD, "30"));
            back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
            back.setFont(new Font("Arial", 25));
            back.setContentDisplay(ContentDisplay.TOP);
            back.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            bydiscreption = new RadioButton("حسب الوصف  ");
            bydiscreption.setFont(new Font("Arial", 25));
            bydiscreption.setTextFill(Color.WHITE);
            bydiscreption.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            bymedicine = new RadioButton("حسب الدواء  ");
            bymedicine.setFont(new Font("Arial", 25));
            bymedicine.setTextFill(Color.WHITE);
            bymedicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            bydate = new RadioButton("حسب التاريخ ");
            bydate.setSelected(true);
            bydate.setFont(new Font("Arial", 25));
            bydate.setTextFill(Color.WHITE);
            bydate.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            bydate.setSelected(true);

            chekers = new HBox(bydate, bymedicine, bydiscreption);
            chekers.setSpacing(15);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Label sizeOfResult = new Label("عدد النتائج: "+sizeOfResultInteger.toString());
            sizeOfResult.setFont(new Font("arial",25));
            sizeOfResult.setTextFill(Color.WHITE);
            sizeOfResult.setCenterShape(false);
            sizeOfResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

            search = new TextField();
            search.setPromptText(" حدد خيارك قم ابحث  ");
            search.setFont(new Font("Arial", 30));
            search.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
            search.setStyle("-fx-color: red;");
            search.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            search.setStyle("-fx-text-fill : blue;");
            search.textProperty().addListener(e->{
                if (bydiscreption.isSelected())
                {
                    content.getChildren().clear();
                    try {
                        visitModules = Main.db.FetchVisitsByDescription(patientModule,search.getText());
                        recordTreatment = new RecordTreatment[visitModules.length];
                        for (int i = 0; i <visitModules.length ; i++) {
                            recordTreatment[i] = new RecordTreatment(stage,patientModule,visitModules[i]);
                            content.getChildren().add(recordTreatment[i]);
                        }
                        sizeOfResultInteger = visitModules.length;
                        sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (bymedicine.isSelected())
                {
                    content.getChildren().clear();
                    try {
                        visitModules = Main.db.FetchVisitsByMedicene(patientModule,search.getText());
                        recordTreatment = new RecordTreatment[visitModules.length];
                        for (int i = 0; i <visitModules.length ; i++) {
                            recordTreatment[i] = new RecordTreatment(stage,patientModule,visitModules[i]);
                            content.getChildren().add(recordTreatment[i]);
                        }
                        sizeOfResultInteger = visitModules.length;
                        sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            content = new VBox();
            content.setSpacing(0);

            day = new TextField();
            day.setPromptText("اليوم");
            day.setFont(new Font("Arial", 30));
            day.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
            day.setStyle("-fx-color: red;");
            day.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            day.setStyle("-fx-text-fill : blue;");
            day.setPrefSize(125, 50);
            day.textProperty().addListener(e->{
                content.getChildren().clear();
                try {
                    visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                    recordTreatment = new RecordTreatment[visitModules.length];
                    for (int i = 0; i <visitModules.length ; i++) {
                        recordTreatment[i] = new RecordTreatment(stage , patientModule,visitModules[i]);
                        content.getChildren().add(recordTreatment[i]);
                    }
                    sizeOfResultInteger = visitModules.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            month = new TextField();
            month.setPromptText("الشهر");
            month.setFont(new Font("Arial", 30));
            month.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
            month.setStyle("-fx-color: red;");
            month.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            month.setStyle("-fx-text-fill : blue;");
            month.setPrefSize(125, 50);
            month.textProperty().addListener(e->{
                content.getChildren().clear();
                try {
                    visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                    recordTreatment = new RecordTreatment[visitModules.length];
                    for (int i = 0; i <visitModules.length ; i++) {
                        recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                        content.getChildren().add(recordTreatment[i]);
                    }
                    sizeOfResultInteger = visitModules.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            year = new TextField();
            year.setPromptText("السنة");
            year.setFont(new Font("Arial", 30));
            year.setBackground(new Background(new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, Insets.EMPTY)));
            year.setStyle("-fx-color: red;");
            year.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            year.setStyle("-fx-text-fill : blue;");
            year.setPrefSize(125, 50);
            year.textProperty().addListener(e->{
                content.getChildren().clear();
                try {
                    visitModules = Main.db.FetchPatientBySpecificDate(patientModule,day.getText(),month.getText(),year.getText());
                    recordTreatment = new RecordTreatment[visitModules.length];
                    for (int i = 0; i <visitModules.length ; i++) {
                        recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                        content.getChildren().add(recordTreatment[i]);
                    }
                    sizeOfResultInteger = visitModules.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            DateTF = new HBox(year, month, day);
            DateTF.setSpacing(15);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            scrollPane = new ScrollPane(content);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setStyle("-fx-color : #5A84AD;");    /////////////////////    here

            header = new Label("التاريخ                          وصف المعاينة                                           العلاجات                           ");
            header.setFont(new Font("Arial", 30));
            header.setTextFill(Color.WHITE);

            secondary_layout = new VBox(header, scrollPane);
            secondary_layout.setSpacing(15);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            dr_name = new HBox();
            dr = new Label("Dr.");
            dr.setFont(new Font("Arial", 30));
            dr.setTextFill(Color.rgb(30, 96, 137));
            DRname = new Label("Barakat");
            DRname.setFont(new Font("Arial", 30));
            DRname.setTextFill(Color.WHITE);
            dr_name = new HBox(dr, DRname);
            HBox.setHgrow(dr_name, Priority.ALWAYS);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            timeDate = new Date();
            simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
            String s = simpleDateFormat.format(timeDate);

            Date = new Label(s);
            Date.setFont(new Font("Arial", 35));
            Date.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (bydate.isSelected()) {
                try {
                    visitModules = Main.db.FetchVisitsSortedByDate(patientModule);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (visitModules != null){
                recordTreatment = new RecordTreatment[visitModules.length];
                for (int i = 0; i < recordTreatment.length; i++) {
                    recordTreatment[i] = new RecordTreatment(stage , patientModule , visitModules[i]);
                    content.getChildren().add(recordTreatment[i]);
                    }
                sizeOfResultInteger = visitModules.length;
                sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                }
                primary_layout.getChildren().addAll(rec1, back, chekers, DateTF, secondary_layout, Date, dr_name,sizeOfResult);

                bymedicine.setOnMouseClicked(e -> {
                    bydiscreption.setSelected(false);
                    bydate.setSelected(false);
                    search.clear();
                    day.clear();
                    month.clear();
                    year.clear();
                    primary_layout.getChildren().clear();
                    primary_layout.getChildren().addAll(rec1, back, chekers, search, secondary_layout, Date, dr_name,sizeOfResult);
                });
                bydiscreption.setOnMouseClicked(e -> {
                    bymedicine.setSelected(false);
                    bydate.setSelected(false);
                    primary_layout.getChildren().clear();
                    search.clear();
                    day.clear();
                    month.clear();
                    year.clear();
                    primary_layout.getChildren().addAll(rec1, back, chekers, search, secondary_layout, Date, dr_name,sizeOfResult);

                });
                bydate.setOnMouseClicked(e -> {
                    bydiscreption.setSelected(false);
                    bymedicine.setSelected(false);
                    search.clear();
                    day.clear();
                    month.clear();
                    year.clear();
                    primary_layout.getChildren().clear();
                    primary_layout.getChildren().addAll(rec1, back, chekers, DateTF, secondary_layout, Date, dr_name,sizeOfResult);
                });

                StackPane.setAlignment(sizeOfResult, Pos.BOTTOM_CENTER);
                StackPane.setMargin(sizeOfResult, new Insets(0,0,40,0));

                StackPane.setAlignment(back, Pos.TOP_LEFT);
                StackPane.setMargin(back, new Insets(20, 0, 0, 10));

                StackPane.setAlignment(chekers, Pos.TOP_CENTER);
                StackPane.setMargin(chekers, new Insets(75, 200, 0, 500));

                StackPane.setAlignment(search, Pos.TOP_CENTER);
                StackPane.setMargin(search, new Insets(150, 200, 0, 200));

                StackPane.setAlignment(DateTF, Pos.TOP_CENTER);
                StackPane.setMargin(DateTF, new Insets(150, 200, 0, 565));

                StackPane.setAlignment(secondary_layout, Pos.CENTER);
                StackPane.setMargin(secondary_layout, new Insets(280, 200, 100, 200));

                StackPane.setAlignment(content, Pos.CENTER);
                StackPane.setMargin(content, new Insets(280, 350, 100, 350));

                StackPane.setAlignment(dr_name, Pos.TOP_LEFT);
                StackPane.setMargin(dr_name, new Insets(790, 0, 0, 1300));

                StackPane.setAlignment(Date, Pos.TOP_LEFT);
                StackPane.setMargin(Date, new Insets(790, 0, 0, 15));

                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
                stage.setScene(scene);
                back.setOnAction(e->{
                    ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
                });


            }
        }
}
*/
