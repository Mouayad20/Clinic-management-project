package GUI.pages;

import GUI.component.Record;
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
import sample.Main;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inquirers {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
        HBox chekers = null ;
            RadioButton byname = null ;
            RadioButton bynum = null ;
            RadioButton bydiag = null ;
        HBox search_box = null;
            TextField search = null ;
            Button add_butom = null;
        ScrollPane scrollPane = null ;
            VBox content = null ;
                Record[] record = null ;
        Label sizeOfResult = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;
    Integer sizeOfResultInteger = 0;

    public Inquirers(Stage stage){

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        byname = new RadioButton("حسب الاسم  ");
        byname.setFont(new Font("Arial",25));
        byname.setTextFill(Color.WHITE);
        byname.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        bynum = new RadioButton("حسب الرقم  ");
        bynum.setFont(new Font("Arial",25));
        bynum.setTextFill(Color.WHITE);
        bynum.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        bydiag = new RadioButton("حسب السوابق المرضية  ");
        bydiag.setFont(new Font("Arial",25));
        bydiag.setTextFill(Color.WHITE);
        bydiag.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        chekers = new HBox(bydiag,bynum,byname);
        chekers.setSpacing(20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        search = new TextField();
        search.setPromptText(" حدد خيارك ثم ابحث  ");
        search.setFont(new Font("Arial",30));
        search.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
        search.setStyle("-fx-color: red;");
        search.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        search.setStyle("-fx-text-fill : #1E6089;");
        HBox.setHgrow(search,Priority.ALWAYS);

        add_butom = new Button( "للإضافة",  GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"40")) ;
        add_butom.setFont(new Font("arial",20));
        add_butom.setDefaultButton(true);
        add_butom.setContentDisplay(ContentDisplay.RIGHT);

        search_box = new HBox(add_butom,search);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        content = new VBox();
        content.setSpacing(10);

        scrollPane = new ScrollPane(content);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        sizeOfResult = new Label("عدد النتائج: "+sizeOfResultInteger.toString());
        sizeOfResult.setFont(new Font("arial",25));
        sizeOfResult.setTextFill(Color.WHITE);
        sizeOfResult.setCenterShape(false);
        sizeOfResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        dr_name = new HBox();
        dr = new Label("Dr.");
        dr.setFont( new Font("Arial",30) );
        dr.setTextFill( Color.rgb(30,96,137) );
        DRname = new Label( "Name" );
        DRname.setFont( new Font("Arial",30) );
        DRname.setTextFill(Color.WHITE);
        dr_name = new HBox(dr, DRname);
        HBox.setHgrow(dr_name, Priority.ALWAYS);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        primary_layout = new StackPane();

        rec = new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        primary_layout.getChildren().addAll(rec,back,chekers,search_box,scrollPane,dr_name,Date,sizeOfResult);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(chekers, Pos.TOP_CENTER);
        StackPane.setMargin(chekers,new Insets(75,200,0,450));

        StackPane.setAlignment(search_box, Pos.TOP_CENTER);
        StackPane.setMargin(search_box,new Insets(150,200,0,200));

        StackPane.setAlignment(scrollPane, Pos.CENTER);
        StackPane.setMargin(scrollPane,new Insets(280,200,100,200));

        StackPane.setAlignment(sizeOfResult, Pos.BOTTOM_CENTER);
        StackPane.setMargin(sizeOfResult,new Insets(0,0,40,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        byname.setSelected(true);
        byname.setOnMouseClicked(e->{
            bynum.setSelected(false);
            bydiag.setSelected(false);
            content.getChildren().clear();
            search.clear();
        });

        bynum.setOnMouseClicked(e->{
            byname.setSelected(false);
            bydiag.setSelected(false);
            content.getChildren().clear();
            search.clear();
        });

        bydiag.setOnMouseClicked(e->{
            byname.setSelected(false);
            bynum.setSelected(false);
            content.getChildren().clear();
            search.clear();
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        search.textProperty().addListener(e->{

            content.getChildren().clear();

            if(byname.isSelected())
            {
                try {
                    PatientModule patientModule[]=Main.db.FetchPatientByName(search.getText());
                    if (patientModule != null){
                        record = new Record[patientModule.length];
                        for (int i=0 ; i<patientModule.length ; i++)
                        {
                            record[i] = new Record(stage,patientModule[i]);
                            content.getChildren().add(record[i]);
                        }}
                    sizeOfResultInteger = record.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (bynum.isSelected())
            {
                try {
                    PatientModule patientModule[]=Main.db.FetchPatinetPyId(search.getText());
                    if (patientModule !=null){
                        record = new Record[patientModule.length];
                        for (int i=0 ; i<patientModule.length ; i++)
                        {
                            record[i] = new Record(stage,patientModule[i]);
                            content.getChildren().add(record[i]);
                        }}
                    sizeOfResultInteger = record.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (bydiag.isSelected())
            {
                try {
                    PatientModule patientModule[]=Main.db.FetchPatinetPydescription(search.getText());
                    if (patientModule !=null){
                        record = new Record[patientModule.length];
                        for (int i=0 ; i<patientModule.length ; i++)
                        {
                            record[i] = new Record(stage,patientModule[i]);
                            content.getChildren().add(record[i]);
                        }}
                    sizeOfResultInteger = record.length;
                    sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        add_butom.setOnAction(e->{
            AddPatient addPatient;
            if (byname.isSelected())
                addPatient = new AddPatient(stage,search.getText());
            else if (bynum.isSelected())
                addPatient = new AddPatient(search.getText(),stage);
            else
                addPatient = new AddPatient(stage,"");

        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{

            MainMenu mainMenu = new MainMenu(stage);

        });

    }
}



/*
package GUI.pages;

import GUI.component.Record;
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
import sample.Main;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inquirers {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
        HBox chekers = null ;
            RadioButton byname = null ;
            RadioButton bynum = null ;
            RadioButton bydiag = null ;
        HBox search_box = null;
            TextField search = null ;
            Button add_butom = null;
        ScrollPane scrollPane = null ;
            VBox content = null ;
                Record[] record = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;


        java.util.Date timeDate = null;
        SimpleDateFormat simpleDateFormat = null ;
        Integer sizeOfResultInteger = 0;

        public Inquirers(Stage stage){

            back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
            back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            back.setFont(new Font("Arial",25));
            back.setContentDisplay(ContentDisplay.TOP);
            back.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            byname = new RadioButton("حسب الاسم  ");
            byname.setFont(new Font("Arial",25));
            byname.setTextFill(Color.WHITE);
            byname.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            bynum = new RadioButton("حسب الرقم  ");
            bynum.setFont(new Font("Arial",25));
            bynum.setTextFill(Color.WHITE);
            bynum.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            bydiag = new RadioButton("حسب التشخيص  ");
            bydiag.setFont(new Font("Arial",25));
            bydiag.setTextFill(Color.WHITE);
            bydiag.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            chekers = new HBox(bydiag,bynum,byname);
            chekers.setSpacing(20);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            search = new TextField();
            search.setPromptText(" حدد خيارك قم ابحث  ");
            search.setFont(new Font("Arial",30));
            search.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
            search.setStyle("-fx-color: red;");
            search.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            search.setStyle("-fx-text-fill : blue;");
            HBox.setHgrow(search,Priority.ALWAYS);

            add_butom = new Button( "للإضافة",  GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"40")) ;
            add_butom.setFont(new Font("arial",20));
            add_butom.setDefaultButton(true);

            search_box = new HBox(add_butom,search);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            content = new VBox();
            content.setSpacing(10);

            scrollPane = new ScrollPane(content);
            scrollPane.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            timeDate = new Date();
            simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
            String s = simpleDateFormat.format(timeDate);

            Date = new Label(s);
            Date.setFont(new Font("Arial",35));
            Date.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            dr_name = new HBox();
            dr = new Label("Dr.");
            dr.setFont( new Font("Arial",30) );
            dr.setTextFill( Color.rgb(30,96,137) );
            DRname = new Label( "Barakat" );
            DRname.setFont( new Font("Arial",30) );
            DRname.setTextFill(Color.WHITE);
            dr_name = new HBox(dr, DRname);
            HBox.setHgrow(dr_name, Priority.ALWAYS);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            primary_layout = new StackPane();

            rec = new Rectangle();
            rec.setFill(Color.rgb(90,132,173));
            rec.widthProperty().bind(primary_layout.widthProperty());
            rec.heightProperty().bind(primary_layout.heightProperty());

            Label sizeOfResult = new Label("عدد النتائج: "+sizeOfResultInteger.toString());
            sizeOfResult.setFont(new Font("arial",25));
            sizeOfResult.setTextFill(Color.WHITE);
            sizeOfResult.setCenterShape(false);
            sizeOfResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

            primary_layout.getChildren().addAll(rec,back,chekers,search_box,scrollPane,dr_name,Date,sizeOfResult);

            StackPane.setAlignment(back, Pos.TOP_LEFT);
            StackPane.setMargin(back,new Insets(20,0,0,10));

            StackPane.setAlignment(search_box, Pos.TOP_CENTER);
            StackPane.setMargin(search_box,new Insets(150,200,0,200));

            StackPane.setAlignment(chekers, Pos.TOP_CENTER);
            StackPane.setMargin(chekers,new Insets(75,200,0,500));

            StackPane.setAlignment(scrollPane, Pos.CENTER);
            StackPane.setMargin(scrollPane,new Insets(280,200,100,200));

            StackPane.setAlignment(Date,Pos.TOP_LEFT);
            StackPane.setMargin(Date,new Insets(750,0,0,15));

            StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
            StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

            StackPane.setAlignment(sizeOfResult, Pos.BOTTOM_CENTER);
            StackPane.setMargin(sizeOfResult,new Insets(0,0,40,0));

            byname.setSelected(true);
            byname.setOnMouseClicked(e->{
                bynum.setSelected(false);
                bydiag.setSelected(false);
                content.getChildren().clear();
                search.clear();
            });
            bynum.setOnMouseClicked(e->{
                byname.setSelected(false);
                bydiag.setSelected(false);
                content.getChildren().clear();
                search.clear();
            });
            bydiag.setOnMouseClicked(e->{
                byname.setSelected(false);
                bynum.setSelected(false);
                content.getChildren().clear();
                search.clear();
            });
            search.textProperty().addListener(e->{
                content.getChildren().clear();
               if(byname.isSelected())
               {
                   try {
                       PatientModule patientModule[]=Main.db.FetchPatientByName(search.getText());
                       if (patientModule != null){
                       record = new Record[patientModule.length];
                       for (int i=0 ; i<patientModule.length ; i++)
                       {
                           record[i] = new Record(stage,patientModule[i]);
                           content.getChildren().add(record[i]);
                       }}
                       sizeOfResultInteger = record.length;
                       sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }
               if (bynum.isSelected())
               {
                   try {
                       PatientModule patientModule[]=Main.db.FetchPatinetPyId(search.getText());
                       if (patientModule !=null){
                       record = new Record[patientModule.length];
                       for (int i=0 ; i<patientModule.length ; i++)
                       {
                           record[i] = new Record(stage,patientModule[i]);
                           content.getChildren().add(record[i]);
                       }}
                       sizeOfResultInteger = record.length;
                       sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }
               if (bydiag.isSelected())
               {
                   try {
                       PatientModule patientModule[]=Main.db.FetchPatinetPydescription(search.getText());
                       if (patientModule !=null){
                       record = new Record[patientModule.length];
                       for (int i=0 ; i<patientModule.length ; i++)
                       {
                           record[i] = new Record(stage,patientModule[i]);
                           content.getChildren().add(record[i]);
                       }}
                       sizeOfResultInteger = record.length;
                       sizeOfResult.setText("عدد النتائج: "+sizeOfResultInteger.toString());
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }

            });
            add_butom.setOnAction(e->{
                AddPatient addPatient;
                if (byname.isSelected())
                    addPatient = new AddPatient(stage,search.getText());
                else if (bynum.isSelected())
                    addPatient = new AddPatient(search.getText(),stage);
                else
                    addPatient = new AddPatient(stage,"");

            });

            scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-60);

            stage.setScene(scene);
            back.setOnAction(e->{
                MainMenu mainMenu = new MainMenu(stage);
            });
        }
}
*/
