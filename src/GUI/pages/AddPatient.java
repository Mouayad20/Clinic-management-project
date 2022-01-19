package GUI.pages;

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

public class AddPatient {

    public Stage stage = new Stage();
    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
            Label name = null ;
            TextField nameTF = null;
            Label num = null ;
            TextField numTF = null;
            Label name_of_father = null ;
            TextField name_of_fatherTF = null;
            Label name_of_mother = null ;
            TextField name_of_motherTF = null;
            Label birth = null ;
            TextField birthTF = null;
            Label phone_number = null ;
            TextField phone_numberTF = null;
            Label job = null ;
            TextField jobTF = null;
            Label old_siks = null ;
            TextArea description = null ;
            Label nots = null ;
            TextArea warning = null ;
        Button submit = null ;
        Label Date = null;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;

    /**
     * used for add by the name of the patient
     * @param text
     * @param stage
     */

    public AddPatient(Stage stage, String text){

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name = new Label("     الاسم      :");
        name.setFont( new Font("Arial",30) );
        name.setTextFill(Color.WHITE);
        nameTF = new TextField(text);
        nameTF.setPromptText("________________________");
        nameTF.setFont(new Font("Arial",30));
        nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        nameTF.setStyle("-fx-color: White;");
        nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nameTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        num = new Label("     الرقم      :");
        num.setFont( new Font("Arial",30) );
        num.setTextFill(Color.WHITE);
        numTF = new TextField();
        numTF.setPromptText("________________________");
        numTF.setFont(new Font("Arial",30));
        numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        numTF.setStyle("-fx-color: White;");
        numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        numTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_father = new Label(" اسم الأب     :");
        name_of_father.setFont( new Font("Arial",30) );
        name_of_father.setTextFill(Color.WHITE);
        name_of_fatherTF = new TextField();
        name_of_fatherTF.setPromptText("________________________");
        name_of_fatherTF.setFont(new Font("Arial",30));
        name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_fatherTF.setStyle("-fx-color: White;");
        name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_fatherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_mother = new Label("  اسم الأم     :");
        name_of_mother.setFont( new Font("Arial",30) );
        name_of_mother.setTextFill(Color.WHITE);
        name_of_motherTF = new TextField();
        name_of_motherTF.setPromptText("________________________");
        name_of_motherTF.setFont(new Font("Arial",30));
        name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_motherTF.setStyle("-fx-color: White;");
        name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_motherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        birth = new Label("تاريخ الميلاد :");
        birth.setFont( new Font("Arial",30) );
        birth.setTextFill(Color.WHITE);
        birthTF = new TextField();
        birthTF.setPromptText("______يوم-شهر-سنة________");
        birthTF.setFont(new Font("Arial",30));
        birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        birthTF.setStyle("-fx-color: White;");
        birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        birthTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        phone_number = new Label("رقم الموبايل  :");
        phone_number.setFont( new Font("Arial",30) );
        phone_number.setTextFill(Color.WHITE);
        phone_numberTF = new TextField();
        phone_numberTF.setPromptText("________________________");
        phone_numberTF.setFont(new Font("Arial",30));
        phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_numberTF.setStyle("-fx-color: White;");
        phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        phone_numberTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        job = new Label("     العمل    :");
        job.setFont( new Font("Arial",30) );
        job.setTextFill(Color.WHITE);
        jobTF = new TextField();
        jobTF.setPromptText("________________________");
        jobTF.setFont(new Font("Arial",30));
        jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        jobTF.setStyle("-fx-color: White;");
        jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        jobTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        old_siks = new Label("السوابق المرضية : ");
        old_siks.setFont( new Font("Arial",30) );
        old_siks.setTextFill(Color.WHITE);
        description = new TextArea();
        description.setPromptText("____________________________________________________________________________________________________________________________________________");
        description.setFont(new Font("Arial",30));
        description.setWrapText(true);
        description.setPrefSize(150,75);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        nots = new Label("الملاحظات :        ");
        nots.setFont( new Font("Arial",30) );
        nots.setTextFill(Color.WHITE);
        warning = new TextArea();
        warning.setPromptText("____________________________________________________________________________________________________________________________________________");
        warning.setFont(new Font("Arial",30));
        warning.setWrapText(true);
        warning.setPrefSize(150,75);
        warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        warning.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("تسجيل");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(150,45);

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

        primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                name_of_mother,name_of_motherTF,birth,birthTF,
                phone_number,phone_numberTF,job,jobTF,
                old_siks,description,nots,warning,submit,dr_name,Date);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(name, Pos.TOP_RIGHT);
        StackPane.setMargin(name,new Insets(50,50,0,0));
        StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
        StackPane.setMargin(nameTF,new Insets(42,190,0,950));

        StackPane.setAlignment(num, Pos.TOP_RIGHT);
        StackPane.setMargin(num,new Insets(150,50,0,0));
        StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
        StackPane.setMargin(numTF,new Insets(142,190,0,950));

        StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
        StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

        StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
        StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

        StackPane.setAlignment(birth, Pos.TOP_RIGHT);
        StackPane.setMargin(birth,new Insets(450,50,0,0));
        StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
        StackPane.setMargin(birthTF,new Insets(442,190,0,950));

        StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_number,new Insets(550,50,0,0));
        StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

        StackPane.setAlignment(job, Pos.TOP_RIGHT);
        StackPane.setMargin(job,new Insets(650,50,0,0));
        StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
        StackPane.setMargin(jobTF,new Insets(642,190,0,950));

        StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
        StackPane.setMargin(old_siks,new Insets(90,0,0,600));
        StackPane.setAlignment(description, Pos.TOP_LEFT);
        StackPane.setMargin(description,new Insets(140,750,500,150));

        StackPane.setAlignment(nots, Pos.TOP_LEFT);
        StackPane.setMargin(nots,new Insets(380,0,0,600));
        StackPane.setAlignment(warning, Pos.TOP_LEFT);
        StackPane.setMargin(warning,new Insets(430,750,200,150));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,0,80,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            Inquirers inquirers = new Inquirers(stage);
        });

        //System.out.println(birthTF.getText());

        submit.setOnAction(e->{

            PatientModule patientModule = new PatientModule();
            patientModule.setName(nameTF.getText());
            patientModule.setId_patient(numTF.getText());
            patientModule.setFather_name(name_of_fatherTF.getText());
            patientModule.setMother_name(name_of_motherTF.getText());
            patientModule.setBirthday(birthTF.getText());
            patientModule.setJob(jobTF.getText());
            patientModule.setDescreption(description.getText());
            patientModule.setWarning(warning.getText());
            patientModule.setMobilephone(phone_numberTF.getText());
            try {

                Main.db.InsertPatient(patientModule);
                Integer id =new Integer(Main.db.FetchPatientId(patientModule.getName(),patientModule.getId_patient(),patientModule.getBirthday()));
                patientModule.setId(id);
                Main.db.CreateTablePatient(id.toString());
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }



    /**
     * used for add by the number of the patient
     * @param text
     * @param stage
     */

    public AddPatient(String text,Stage stage){

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name = new Label("     الاسم      :");
        name.setFont( new Font("Arial",30) );
        name.setTextFill(Color.WHITE);
        nameTF = new TextField();
        nameTF.setPromptText("________________________");
        nameTF.setFont(new Font("Arial",30));
        nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        nameTF.setStyle("-fx-color: White;");
        nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nameTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        num = new Label("     الرقم      :");
        num.setFont( new Font("Arial",30) );
        num.setTextFill(Color.WHITE);
        numTF = new TextField(text);
        numTF.setPromptText("________________________");
        numTF.setFont(new Font("Arial",30));
        numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        numTF.setStyle("-fx-color: White;");
        numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        numTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_father = new Label(" اسم الأب     :");
        name_of_father.setFont( new Font("Arial",30) );
        name_of_father.setTextFill(Color.WHITE);
        name_of_fatherTF = new TextField();
        name_of_fatherTF.setPromptText("________________________");
        name_of_fatherTF.setFont(new Font("Arial",30));
        name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_fatherTF.setStyle("-fx-color: White;");
        name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_fatherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_mother = new Label("  اسم الأم     :");
        name_of_mother.setFont( new Font("Arial",30) );
        name_of_mother.setTextFill(Color.WHITE);
        name_of_motherTF = new TextField();
        name_of_motherTF.setPromptText("________________________");
        name_of_motherTF.setFont(new Font("Arial",30));
        name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_motherTF.setStyle("-fx-color: White;");
        name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_motherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        birth = new Label("تاريخ الميلاد :");
        birth.setFont( new Font("Arial",30) );
        birth.setTextFill(Color.WHITE);
        birthTF = new TextField();
        birthTF.setPromptText("______يوم-شهر-سنة________");
        birthTF.setFont(new Font("Arial",30));
        birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        birthTF.setStyle("-fx-color: White;");
        birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        birthTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        phone_number = new Label("رقم الموبايل  :");
        phone_number.setFont( new Font("Arial",30) );
        phone_number.setTextFill(Color.WHITE);
        phone_numberTF = new TextField();
        phone_numberTF.setPromptText("________________________");
        phone_numberTF.setFont(new Font("Arial",30));
        phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_numberTF.setStyle("-fx-color: White;");
        phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        phone_numberTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        job = new Label("     العمل    :");
        job.setFont( new Font("Arial",30) );
        job.setTextFill(Color.WHITE);
        jobTF = new TextField();
        jobTF.setPromptText("________________________");
        jobTF.setFont(new Font("Arial",30));
        jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        jobTF.setStyle("-fx-color: White;");
        jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        jobTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        old_siks = new Label("السوابق المرضية : ");
        old_siks.setFont( new Font("Arial",30) );
        old_siks.setTextFill(Color.WHITE);
        description = new TextArea();
        description.setPromptText("____________________________________________________________________________________________________________________________________________");
        description.setFont(new Font("Arial",30));
        description.setWrapText(true);
        description.setPrefSize(150,75);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        nots = new Label("الملاحظات :        ");
        nots.setFont( new Font("Arial",30) );
        nots.setTextFill(Color.WHITE);
        warning = new TextArea();
        warning.setPromptText("____________________________________________________________________________________________________________________________________________");
        warning.setFont(new Font("Arial",30));
        warning.setWrapText(true);
        warning.setPrefSize(150,75);
        warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        warning.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("تسجيل");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(150,45);

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

        primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                name_of_mother,name_of_motherTF,birth,birthTF,
                phone_number,phone_numberTF,job,jobTF,
                old_siks,description,nots,warning,submit,dr_name,Date);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(name, Pos.TOP_RIGHT);
        StackPane.setMargin(name,new Insets(50,50,0,0));
        StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
        StackPane.setMargin(nameTF,new Insets(42,190,0,950));

        StackPane.setAlignment(num, Pos.TOP_RIGHT);
        StackPane.setMargin(num,new Insets(150,50,0,0));
        StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
        StackPane.setMargin(numTF,new Insets(142,190,0,950));

        StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
        StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

        StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
        StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

        StackPane.setAlignment(birth, Pos.TOP_RIGHT);
        StackPane.setMargin(birth,new Insets(450,50,0,0));
        StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
        StackPane.setMargin(birthTF,new Insets(442,190,0,950));

        StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_number,new Insets(550,50,0,0));
        StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

        StackPane.setAlignment(job, Pos.TOP_RIGHT);
        StackPane.setMargin(job,new Insets(650,50,0,0));
        StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
        StackPane.setMargin(jobTF,new Insets(642,190,0,950));

        StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
        StackPane.setMargin(old_siks,new Insets(90,0,0,600));
        StackPane.setAlignment(description, Pos.TOP_LEFT);
        StackPane.setMargin(description,new Insets(140,750,500,150));

        StackPane.setAlignment(nots, Pos.TOP_LEFT);
        StackPane.setMargin(nots,new Insets(380,0,0,600));
        StackPane.setAlignment(warning, Pos.TOP_LEFT);
        StackPane.setMargin(warning,new Insets(430,750,200,150));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,0,80,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            Inquirers inquirers = new Inquirers(stage);
        });

        //System.out.println(birthTF.getText());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit.setOnAction(e->{

            PatientModule patientModule = new PatientModule();
            patientModule.setName(nameTF.getText());
            patientModule.setId_patient(numTF.getText());
            patientModule.setFather_name(name_of_fatherTF.getText());
            patientModule.setMother_name(name_of_motherTF.getText());
            patientModule.setBirthday(birthTF.getText());
            patientModule.setJob(jobTF.getText());
            patientModule.setDescreption(description.getText());
            patientModule.setWarning(warning.getText());
            patientModule.setMobilephone(phone_numberTF.getText());

            try {

                Main.db.InsertPatient(patientModule);
                Main.db.CreateTablePatient(Main.db.FetchPatientId(patientModule.getName(),patientModule.getId_patient(),patientModule.getBirthday()));
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }



    /**
     * this is used to edit patient info in database
     * @param stage
     * @param patientModule
     */

    public AddPatient(Stage stage,PatientModule patientModule){

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name = new Label("     الاسم      :");
        name.setFont( new Font("Arial",30) );
        name.setTextFill(Color.WHITE);
        nameTF = new TextField(patientModule.getName());
        nameTF.setPromptText("________________________");
        nameTF.setFont(new Font("Arial",30));
        nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        nameTF.setStyle("-fx-color: White;");
        nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nameTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        num = new Label("     الرقم      :");
        num.setFont( new Font("Arial",30) );
        num.setTextFill(Color.WHITE);
        numTF = new TextField(patientModule.getId_patient());
        numTF.setPromptText("________________________");
        numTF.setFont(new Font("Arial",30));
        numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        numTF.setStyle("-fx-color: White;");
        numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        numTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_father = new Label(" اسم الأب     :");
        name_of_father.setFont( new Font("Arial",30) );
        name_of_father.setTextFill(Color.WHITE);
        name_of_fatherTF = new TextField(patientModule.getFather_name());
        name_of_fatherTF.setPromptText("________________________");
        name_of_fatherTF.setFont(new Font("Arial",30));
        name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_fatherTF.setStyle("-fx-color: White;");
        name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_fatherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_mother = new Label("  اسم الأم     :");
        name_of_mother.setFont( new Font("Arial",30) );
        name_of_mother.setTextFill(Color.WHITE);
        name_of_motherTF = new TextField(patientModule.getMother_name());
        name_of_motherTF.setPromptText("________________________");
        name_of_motherTF.setFont(new Font("Arial",30));
        name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_motherTF.setStyle("-fx-color: White;");
        name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_motherTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        birth = new Label("تاريخ الميلاد :");
        birth.setFont( new Font("Arial",30) );
        birth.setTextFill(Color.WHITE);
        birthTF = new TextField(patientModule.getBirthday());
        birthTF.setPromptText("______يوم-شهر-سنة________");
        birthTF.setFont(new Font("Arial",30));
        birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        birthTF.setStyle("-fx-color: White;");
        birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        birthTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        phone_number = new Label("رقم الموبايل  :");
        phone_number.setFont( new Font("Arial",30) );
        phone_number.setTextFill(Color.WHITE);
        phone_numberTF = new TextField(patientModule.getMobilephone());
        phone_numberTF.setPromptText("________________________");
        phone_numberTF.setFont(new Font("Arial",30));
        phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_numberTF.setStyle("-fx-color: White;");
        phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        phone_numberTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        job = new Label("     العمل    :");
        job.setFont( new Font("Arial",30) );
        job.setTextFill(Color.WHITE);
        jobTF = new TextField(patientModule.getJob());
        jobTF.setPromptText("________________________");
        jobTF.setFont(new Font("Arial",30));
        jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        jobTF.setStyle("-fx-color: White;");
        jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        jobTF.setStyle("-fx-text-fill : White;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        old_siks = new Label("السوابق المرضية : ");
        old_siks.setFont( new Font("Arial",30) );
        old_siks.setTextFill(Color.WHITE);
        description = new TextArea(patientModule.getDescreption());
        description.setPromptText("____________________________________________________________________________________________________________________________________________");
        description.setFont(new Font("Arial",30));
        description.setWrapText(true);
        description.setPrefSize(150,75);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        nots = new Label("الملاحظات :        ");
        nots.setFont( new Font("Arial",30) );
        nots.setTextFill(Color.WHITE);
        warning = new TextArea(patientModule.getWarning());
        warning.setPromptText("____________________________________________________________________________________________________________________________________________");
        warning.setFont(new Font("Arial",30));
        warning.setWrapText(true);
        warning.setPrefSize(150,75);
        warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        warning.setStyle("-fx-text-fill : #5A84AD;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("تسجيل");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(150,45);

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

        primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                name_of_mother,name_of_motherTF,birth,birthTF,
                phone_number,phone_numberTF,job,jobTF,
                old_siks,description,nots,warning,submit,dr_name,Date);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(name, Pos.TOP_RIGHT);
        StackPane.setMargin(name,new Insets(50,50,0,0));
        StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
        StackPane.setMargin(nameTF,new Insets(42,190,0,950));

        StackPane.setAlignment(num, Pos.TOP_RIGHT);
        StackPane.setMargin(num,new Insets(150,50,0,0));
        StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
        StackPane.setMargin(numTF,new Insets(142,190,0,950));

        StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
        StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

        StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
        StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

        StackPane.setAlignment(birth, Pos.TOP_RIGHT);
        StackPane.setMargin(birth,new Insets(450,50,0,0));
        StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
        StackPane.setMargin(birthTF,new Insets(442,190,0,950));

        StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_number,new Insets(550,50,0,0));
        StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

        StackPane.setAlignment(job, Pos.TOP_RIGHT);
        StackPane.setMargin(job,new Insets(650,50,0,0));
        StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
        StackPane.setMargin(jobTF,new Insets(642,190,0,950));

        StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
        StackPane.setMargin(old_siks,new Insets(90,0,0,600));
        StackPane.setAlignment(description, Pos.TOP_LEFT);
        StackPane.setMargin(description,new Insets(140,750,500,150));

        StackPane.setAlignment(nots, Pos.TOP_LEFT);
        StackPane.setMargin(nots,new Insets(380,0,0,600));
        StackPane.setAlignment(warning, Pos.TOP_LEFT);
        StackPane.setMargin(warning,new Insets(430,750,200,150));


        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,0,80,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{

            Inquirers inquirers = new Inquirers(stage);

        });

        //System.out.println(birthTF.getText());

        submit.setOnAction(e->{

            PatientModule patientModule1 = new PatientModule();
            patientModule1.setId(patientModule.getId());
            patientModule1.setName(nameTF.getText());
            patientModule1.setId_patient(numTF.getText());
            patientModule1.setFather_name(name_of_fatherTF.getText());
            patientModule1.setMother_name(name_of_motherTF.getText());
            patientModule1.setBirthday(birthTF.getText());
            patientModule1.setJob(jobTF.getText());
            patientModule1.setDescreption(description.getText());
            patientModule1.setWarning(warning.getText());
            patientModule1.setMobilephone(phone_numberTF.getText());

            try {

                Main.db.UpdatePatient(patientModule1);
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule1);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}



/*
package GUI.pages;

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

public class AddPatient {

    public Stage stage = new Stage();
    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
            Label name = null ;
            TextField nameTF = null;
            Label num = null ;
            TextField numTF = null;
            Label name_of_father = null ;
            TextField name_of_fatherTF = null;
            Label name_of_mother = null ;
            TextField name_of_motherTF = null;
            Label birth = null ;
            TextField birthTF = null;
            Label phone_number = null ;
            TextField phone_numberTF = null;
            Label job = null ;
            TextField jobTF = null;
            Label old_siks = null ;
            TextArea description = null ;
            Label nots = null ;
            TextArea warning = null ;
        Button submit = null ;
        Label Date = null;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

        java.util.Date timeDate = null;
        SimpleDateFormat simpleDateFormat = null ;

        public AddPatient(Stage stage, String text){

            back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
            back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            back.setFont(new Font("Arial",25));
            back.setContentDisplay(ContentDisplay.TOP);
            back.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            name = new Label("     الاسم      :");
            name.setFont( new Font("Arial",30) );
            name.setTextFill(Color.WHITE);
            nameTF = new TextField(text);
            nameTF.setPromptText("________________________");
            nameTF.setFont(new Font("Arial",30));
            nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            nameTF.setStyle("-fx-color: White;");
            nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            nameTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            num = new Label("     الرقم      :");
            num.setFont( new Font("Arial",30) );
            num.setTextFill(Color.WHITE);
            numTF = new TextField();
            numTF.setPromptText("________________________");
            numTF.setFont(new Font("Arial",30));
            numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            numTF.setStyle("-fx-color: White;");
            numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            numTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            name_of_father = new Label(" اسم الأب     :");
            name_of_father.setFont( new Font("Arial",30) );
            name_of_father.setTextFill(Color.WHITE);
            name_of_fatherTF = new TextField();
            name_of_fatherTF.setPromptText("________________________");
            name_of_fatherTF.setFont(new Font("Arial",30));
            name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            name_of_fatherTF.setStyle("-fx-color: White;");
            name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            name_of_fatherTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            name_of_mother = new Label("  اسم الأم     :");
            name_of_mother.setFont( new Font("Arial",30) );
            name_of_mother.setTextFill(Color.WHITE);
            name_of_motherTF = new TextField();
            name_of_motherTF.setPromptText("________________________");
            name_of_motherTF.setFont(new Font("Arial",30));
            name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            name_of_motherTF.setStyle("-fx-color: White;");
            name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            name_of_motherTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            birth = new Label("تاريخ الميلاد :");
            birth.setFont( new Font("Arial",30) );
            birth.setTextFill(Color.WHITE);
            birthTF = new TextField();
            birthTF.setPromptText("______يوم-شهر-سنة________");
            birthTF.setFont(new Font("Arial",30));
            birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            birthTF.setStyle("-fx-color: White;");
            birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            birthTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            phone_number = new Label("رقم الموبايل  :");
            phone_number.setFont( new Font("Arial",30) );
            phone_number.setTextFill(Color.WHITE);
            phone_numberTF = new TextField();
            phone_numberTF.setPromptText("________________________");
            phone_numberTF.setFont(new Font("Arial",30));
            phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            phone_numberTF.setStyle("-fx-color: White;");
            phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            phone_numberTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            job = new Label("     العمل    :");
            job.setFont( new Font("Arial",30) );
            job.setTextFill(Color.WHITE);
            jobTF = new TextField();
            jobTF.setPromptText("________________________");
            jobTF.setFont(new Font("Arial",30));
            jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            jobTF.setStyle("-fx-color: White;");
            jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            jobTF.setStyle("-fx-text-fill : White;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            old_siks = new Label("السوابق المرضية : ");
            old_siks.setFont( new Font("Arial",30) );
            old_siks.setTextFill(Color.WHITE);
            description = new TextArea();
            description.setPromptText("____________________________________________________________________________________________________________________________________");
            description.setFont(new Font("Arial",30));
            description.setWrapText(true);
            description.setPrefSize(150,75);
            description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            description.setStyle("-fx-text-fill : #5A84AD;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            nots = new Label("الملاحظات:        ");
            nots.setFont( new Font("Arial",30) );
            nots.setTextFill(Color.WHITE);
            warning = new TextArea();
            warning.setPromptText("____________________________________________________________________________________________________________________________________");
            warning.setFont(new Font("Arial",30));
            warning.setWrapText(true);
            warning.setPrefSize(150,75);
            warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            warning.setStyle("-fx-text-fill : #5A84AD;");

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            submit = new Button("تسجيل");
            submit.setFont(new Font("Arial",25));
            submit.setTextFill(Color.WHITE);
            submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
            submit.setPrefSize(150,45);

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

            primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                                                name_of_mother,name_of_motherTF,birth,birthTF,
                                                phone_number,phone_numberTF,job,jobTF,
                                                old_siks,description,nots,warning,submit,dr_name,Date);

            StackPane.setAlignment(back, Pos.TOP_LEFT);
            StackPane.setMargin(back,new Insets(20,0,0,10));

            StackPane.setAlignment(name, Pos.TOP_RIGHT);
            StackPane.setMargin(name,new Insets(50,50,0,0));
            StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
            StackPane.setMargin(nameTF,new Insets(42,190,0,950));

            StackPane.setAlignment(num, Pos.TOP_RIGHT);
            StackPane.setMargin(num,new Insets(150,50,0,0));
            StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
            StackPane.setMargin(numTF,new Insets(142,190,0,950));

            StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
            StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
            StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
            StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

            StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
            StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
            StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
            StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

            StackPane.setAlignment(birth, Pos.TOP_RIGHT);
            StackPane.setMargin(birth,new Insets(450,50,0,0));
            StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
            StackPane.setMargin(birthTF,new Insets(442,190,0,950));

            StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
            StackPane.setMargin(phone_number,new Insets(550,50,0,0));
            StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
            StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

            StackPane.setAlignment(job, Pos.TOP_RIGHT);
            StackPane.setMargin(job,new Insets(650,50,0,0));
            StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
            StackPane.setMargin(jobTF,new Insets(642,190,0,950));

            StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
            StackPane.setMargin(old_siks,new Insets(90,0,0,600));
            StackPane.setAlignment(description, Pos.TOP_LEFT);
            StackPane.setMargin(description,new Insets(140,750,550,150));

            StackPane.setAlignment(nots, Pos.TOP_LEFT);
            StackPane.setMargin(nots,new Insets(380,0,0,600));
            StackPane.setAlignment(warning, Pos.TOP_LEFT);
            StackPane.setMargin(warning,new Insets(430,750,250,150));

            StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
            StackPane.setMargin(submit,new Insets(0,0,80,0));

            StackPane.setAlignment(Date,Pos.TOP_LEFT);
            StackPane.setMargin(Date,new Insets(760,0,0,15));

            StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
            StackPane.setMargin(dr_name,new Insets(760,0,0,1300));

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            stage.setScene(scene);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            back.setOnAction(e->{
                Inquirers inquirers = new Inquirers(stage);
            });

            //System.out.println(birthTF.getText());

            submit.setOnAction(e->{

                PatientModule patientModule = new PatientModule();
                patientModule.setName(nameTF.getText());
                patientModule.setId_patient(numTF.getText());
                patientModule.setFather_name(name_of_fatherTF.getText());
                patientModule.setMother_name(name_of_motherTF.getText());
                patientModule.setBirthday(birthTF.getText());
                patientModule.setJob(jobTF.getText());
                patientModule.setDescreption(description.getText());
                patientModule.setWarning(warning.getText());
                patientModule.setMobilephone(phone_numberTF.getText());
                try {

                    Main.db.InsertPatient(patientModule);
                    Integer id =new Integer(Main.db.FetchPatientId(patientModule.getName(),patientModule.getId_patient(),patientModule.getBirthday()));
                    patientModule.setId(id);
                    Main.db.CreateTablePatient(id.toString());
                    ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            });
        }

    */
/**
     * used for add by the number of the patient
     * @param text
     * @param stage
     *//*

        public AddPatient(String text,Stage stage){

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        dr_name = new HBox();
        dr = new Label("Dr.");
        dr.setFont( new Font("Arial",30) );
        dr.setTextFill( Color.rgb(30,96,137) );
        DRname = new Label( "Barakat" );
        DRname.setFont( new Font("Arial",30) );
        DRname.setTextFill(Color.WHITE);
        dr_name = new HBox(dr, DRname);
        HBox.setHgrow(dr_name, Priority.ALWAYS);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        name = new Label("     الاسم      :");
        name.setFont( new Font("Arial",30) );
        name.setTextFill(Color.WHITE);
        nameTF = new TextField();
        nameTF.setPromptText("________________________");
        nameTF.setFont(new Font("Arial",30));
        nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        nameTF.setStyle("-fx-color: White;");
        nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nameTF.setStyle("-fx-text-fill : White;");

        num = new Label("     الرقم      :");
        num.setFont( new Font("Arial",30) );
        num.setTextFill(Color.WHITE);
        numTF = new TextField(text);
        numTF.setPromptText("________________________");
        numTF.setFont(new Font("Arial",30));
        numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        numTF.setStyle("-fx-color: White;");
        numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        numTF.setStyle("-fx-text-fill : White;");

        name_of_father = new Label(" اسم الأب     :");
        name_of_father.setFont( new Font("Arial",30) );
        name_of_father.setTextFill(Color.WHITE);
        name_of_fatherTF = new TextField();
        name_of_fatherTF.setPromptText("________________________");
        name_of_fatherTF.setFont(new Font("Arial",30));
        name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_fatherTF.setStyle("-fx-color: White;");
        name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_fatherTF.setStyle("-fx-text-fill : White;");

        name_of_mother = new Label("  اسم الأم     :");
        name_of_mother.setFont( new Font("Arial",30) );
        name_of_mother.setTextFill(Color.WHITE);
        name_of_motherTF = new TextField();
        name_of_motherTF.setPromptText("________________________");
        name_of_motherTF.setFont(new Font("Arial",30));
        name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_motherTF.setStyle("-fx-color: White;");
        name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_motherTF.setStyle("-fx-text-fill : White;");

        birth = new Label("تاريخ الميلاد :");
        birth.setFont( new Font("Arial",30) );
        birth.setTextFill(Color.WHITE);
        birthTF = new TextField();
        birthTF.setPromptText("______يوم-شهر-سنة________");
        birthTF.setFont(new Font("Arial",30));
        birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        birthTF.setStyle("-fx-color: White;");
        birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        birthTF.setStyle("-fx-text-fill : White;");

        phone_number = new Label("رقم الموبايل  :");
        phone_number.setFont( new Font("Arial",30) );
        phone_number.setTextFill(Color.WHITE);
        phone_numberTF = new TextField();
        phone_numberTF.setPromptText("________________________");
        phone_numberTF.setFont(new Font("Arial",30));
        phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_numberTF.setStyle("-fx-color: White;");
        phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        phone_numberTF.setStyle("-fx-text-fill : White;");

        job = new Label("     العمل    :");
        job.setFont( new Font("Arial",30) );
        job.setTextFill(Color.WHITE);
        jobTF = new TextField();
        jobTF.setPromptText("________________________");
        jobTF.setFont(new Font("Arial",30));
        jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        jobTF.setStyle("-fx-color: White;");
        jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        jobTF.setStyle("-fx-text-fill : White;");

        old_siks = new Label("السوابق المرضية : ");
        old_siks.setFont( new Font("Arial",30) );
        old_siks.setTextFill(Color.WHITE);
        description = new TextArea();
        description.setPromptText("____________________________________________________________________________________________________________________________________");
        description.setFont(new Font("Arial",30));
        description.setWrapText(true);
        description.setPrefSize(150,75);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setStyle("-fx-text-fill : #5A84AD;");

        nots = new Label("الملاحظات:        ");
        nots.setFont( new Font("Arial",30) );
        nots.setTextFill(Color.WHITE);
        warning = new TextArea();
        warning.setPromptText("____________________________________________________________________________________________________________________________________");
        warning.setFont(new Font("Arial",30));
        warning.setWrapText(true);
        warning.setPrefSize(150,75);
        warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        warning.setStyle("-fx-text-fill : #5A84AD;");

        submit = new Button("تسجيل");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(150,45);

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        primary_layout = new StackPane();

        rec = new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                name_of_mother,name_of_motherTF,birth,birthTF,
                phone_number,phone_numberTF,job,jobTF,
                old_siks,description,nots,warning,submit,dr_name,Date);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(20,0,0,10));

        StackPane.setAlignment(name, Pos.TOP_RIGHT);
        StackPane.setMargin(name,new Insets(50,50,0,0));
        StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
        StackPane.setMargin(nameTF,new Insets(42,190,0,950));

        StackPane.setAlignment(num, Pos.TOP_RIGHT);
        StackPane.setMargin(num,new Insets(150,50,0,0));
        StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
        StackPane.setMargin(numTF,new Insets(142,190,0,950));

        StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
        StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

        StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
        StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

        StackPane.setAlignment(birth, Pos.TOP_RIGHT);
        StackPane.setMargin(birth,new Insets(450,50,0,0));
        StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
        StackPane.setMargin(birthTF,new Insets(442,190,0,950));

        StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_number,new Insets(550,50,0,0));
        StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

        StackPane.setAlignment(job, Pos.TOP_RIGHT);
        StackPane.setMargin(job,new Insets(650,50,0,0));
        StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
        StackPane.setMargin(jobTF,new Insets(642,190,0,950));

        StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
        StackPane.setMargin(old_siks,new Insets(90,0,0,600));
        StackPane.setAlignment(description, Pos.TOP_LEFT);
        StackPane.setMargin(description,new Insets(140,750,550,150));

        StackPane.setAlignment(nots, Pos.TOP_LEFT);
        StackPane.setMargin(nots,new Insets(380,0,0,600));
        StackPane.setAlignment(warning, Pos.TOP_LEFT);
        StackPane.setMargin(warning,new Insets(430,750,250,150));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(760,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(760,0,0,1300));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,0,80,0));
        scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
        stage.setScene(scene);
        back.setOnAction(e->{
            Inquirers inquirers = new Inquirers(stage);
        });
        System.out.println(birthTF.getText());

        submit.setOnAction(e->{
            PatientModule patientModule = new PatientModule();
            patientModule.setName(nameTF.getText());
            patientModule.setId_patient(numTF.getText());
            patientModule.setFather_name(name_of_fatherTF.getText());
            patientModule.setMother_name(name_of_motherTF.getText());
            patientModule.setBirthday(birthTF.getText());
            patientModule.setJob(jobTF.getText());
            patientModule.setDescreption(description.getText());
            patientModule.setWarning(warning.getText());
            patientModule.setMobilephone(phone_numberTF.getText());
            try {
                Main.db.InsertPatient(patientModule);
                Main.db.CreateTablePatient(Main.db.FetchPatientId(patientModule.getName(),patientModule.getId_patient(),patientModule.getBirthday()));
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }

    */
/**
     * this is used to edit patient info in database
     * @param stage
     * @param patientModule
     *//*

    public AddPatient(Stage stage,PatientModule patientModule){

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        dr_name = new HBox();
        dr = new Label("Dr.");
        dr.setFont( new Font("Arial",30) );
        dr.setTextFill( Color.rgb(30,96,137) );
        DRname = new Label( "Barakat" );
        DRname.setFont( new Font("Arial",30) );
        DRname.setTextFill(Color.WHITE);
        dr_name = new HBox(dr, DRname);
        HBox.setHgrow(dr_name, Priority.ALWAYS);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        name = new Label("     الاسم      :");
        name.setFont( new Font("Arial",30) );
        name.setTextFill(Color.WHITE);
        nameTF = new TextField(patientModule.getName());
        nameTF.setPromptText("________________________");
        nameTF.setFont(new Font("Arial",30));
        nameTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        nameTF.setStyle("-fx-color: White;");
        nameTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nameTF.setStyle("-fx-text-fill : White;");

        num = new Label("     الرقم      :");
        num.setFont( new Font("Arial",30) );
        num.setTextFill(Color.WHITE);
        numTF = new TextField(patientModule.getId_patient());
        numTF.setPromptText("________________________");
        numTF.setFont(new Font("Arial",30));
        numTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        numTF.setStyle("-fx-color: White;");
        numTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        numTF.setStyle("-fx-text-fill : White;");

        name_of_father = new Label(" اسم الأب     :");
        name_of_father.setFont( new Font("Arial",30) );
        name_of_father.setTextFill(Color.WHITE);
        name_of_fatherTF = new TextField(patientModule.getFather_name());
        name_of_fatherTF.setPromptText("________________________");
        name_of_fatherTF.setFont(new Font("Arial",30));
        name_of_fatherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_fatherTF.setStyle("-fx-color: White;");
        name_of_fatherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_fatherTF.setStyle("-fx-text-fill : White;");

        name_of_mother = new Label("  اسم الأم     :");
        name_of_mother.setFont( new Font("Arial",30) );
        name_of_mother.setTextFill(Color.WHITE);
        name_of_motherTF = new TextField(patientModule.getMother_name());
        name_of_motherTF.setPromptText("________________________");
        name_of_motherTF.setFont(new Font("Arial",30));
        name_of_motherTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        name_of_motherTF.setStyle("-fx-color: White;");
        name_of_motherTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        name_of_motherTF.setStyle("-fx-text-fill : White;");

        birth = new Label("تاريخ الميلاد :");
        birth.setFont( new Font("Arial",30) );
        birth.setTextFill(Color.WHITE);
        birthTF = new TextField(patientModule.getBirthday());
        birthTF.setPromptText("______يوم-شهر-سنة________");
        birthTF.setFont(new Font("Arial",30));
        birthTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        birthTF.setStyle("-fx-color: White;");
        birthTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        birthTF.setStyle("-fx-text-fill : White;");

        phone_number = new Label("رقم الموبايل  :");
        phone_number.setFont( new Font("Arial",30) );
        phone_number.setTextFill(Color.WHITE);
        phone_numberTF = new TextField(patientModule.getMobilephone());
        phone_numberTF.setPromptText("________________________");
        phone_numberTF.setFont(new Font("Arial",30));
        phone_numberTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        phone_numberTF.setStyle("-fx-color: White;");
        phone_numberTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        phone_numberTF.setStyle("-fx-text-fill : White;");

        job = new Label("     العمل    :");
        job.setFont( new Font("Arial",30) );
        job.setTextFill(Color.WHITE);
        jobTF = new TextField(patientModule.getJob());
        jobTF.setPromptText("________________________");
        jobTF.setFont(new Font("Arial",30));
        jobTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        jobTF.setStyle("-fx-color: White;");
        jobTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        jobTF.setStyle("-fx-text-fill : White;");

        old_siks = new Label("السوابق المرضية : ");
        old_siks.setFont( new Font("Arial",30) );
        old_siks.setTextFill(Color.WHITE);
        description = new TextArea(patientModule.getDescreption());
        description.setPromptText("____________________________________________________________________________________________________________________________________");
        description.setFont(new Font("Arial",30));
        description.setWrapText(true);
        description.setPrefSize(150,75);
        description.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description.setStyle("-fx-text-fill : #5A84AD;");

        nots = new Label("الملاحظات:        ");
        nots.setFont( new Font("Arial",30) );
        nots.setTextFill(Color.WHITE);
        warning = new TextArea(patientModule.getWarning());
        warning.setPromptText("____________________________________________________________________________________________________________________________________");
        warning.setFont(new Font("Arial",30));
        warning.setWrapText(true);
        warning.setPrefSize(150,75);
        warning.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        warning.setStyle("-fx-text-fill : #5A84AD;");

        submit = new Button("تسجيل");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(150,45);

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        primary_layout = new StackPane();

        rec = new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        primary_layout.getChildren().addAll(rec,back,name,nameTF,num,numTF,name_of_father,name_of_fatherTF,
                name_of_mother,name_of_motherTF,birth,birthTF,
                phone_number,phone_numberTF,job,jobTF,
                old_siks,description,nots,warning,submit,dr_name,Date);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(20,0,0,10));

        StackPane.setAlignment(name, Pos.TOP_RIGHT);
        StackPane.setMargin(name,new Insets(50,50,0,0));
        StackPane.setAlignment(nameTF, Pos.TOP_RIGHT);
        StackPane.setMargin(nameTF,new Insets(42,190,0,950));

        StackPane.setAlignment(num, Pos.TOP_RIGHT);
        StackPane.setMargin(num,new Insets(150,50,0,0));
        StackPane.setAlignment(numTF, Pos.TOP_RIGHT);
        StackPane.setMargin(numTF,new Insets(142,190,0,950));

        StackPane.setAlignment(name_of_father, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_father,new Insets(250,50,0,0));
        StackPane.setAlignment(name_of_fatherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_fatherTF,new Insets(242,190,0,950));

        StackPane.setAlignment(name_of_mother, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_mother,new Insets(350,50,0,0));
        StackPane.setAlignment(name_of_motherTF, Pos.TOP_RIGHT);
        StackPane.setMargin(name_of_motherTF,new Insets(342,190,0,950));

        StackPane.setAlignment(birth, Pos.TOP_RIGHT);
        StackPane.setMargin(birth,new Insets(450,50,0,0));
        StackPane.setAlignment(birthTF, Pos.TOP_RIGHT);
        StackPane.setMargin(birthTF,new Insets(442,190,0,950));

        StackPane.setAlignment(phone_number, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_number,new Insets(550,50,0,0));
        StackPane.setAlignment(phone_numberTF, Pos.TOP_RIGHT);
        StackPane.setMargin(phone_numberTF,new Insets(542,190,0,950));

        StackPane.setAlignment(job, Pos.TOP_RIGHT);
        StackPane.setMargin(job,new Insets(650,50,0,0));
        StackPane.setAlignment(jobTF, Pos.TOP_RIGHT);
        StackPane.setMargin(jobTF,new Insets(642,190,0,950));

        StackPane.setAlignment(old_siks, Pos.TOP_LEFT);
        StackPane.setMargin(old_siks,new Insets(90,0,0,600));
        StackPane.setAlignment(description, Pos.TOP_LEFT);
        StackPane.setMargin(description,new Insets(140,750,550,150));

        StackPane.setAlignment(nots, Pos.TOP_LEFT);
        StackPane.setMargin(nots,new Insets(380,0,0,600));
        StackPane.setAlignment(warning, Pos.TOP_LEFT);
        StackPane.setMargin(warning,new Insets(430,750,250,150));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(760,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(760,0,0,1300));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,0,80,0));
        scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
        stage.setScene(scene);
        back.setOnAction(e->{
            Inquirers inquirers = new Inquirers(stage);
        });
        System.out.println(birthTF.getText());

        submit.setOnAction(e->{
            PatientModule patientModule1 = new PatientModule();
            patientModule1.setId(patientModule.getId());
            patientModule1.setName(nameTF.getText());
            patientModule1.setId_patient(numTF.getText());
            patientModule1.setFather_name(name_of_fatherTF.getText());
            patientModule1.setMother_name(name_of_motherTF.getText());
            patientModule1.setBirthday(birthTF.getText());
            patientModule1.setJob(jobTF.getText());
            patientModule1.setDescreption(description.getText());
            patientModule1.setWarning(warning.getText());
            patientModule1.setMobilephone(phone_numberTF.getText());
            try {
                Main.db.UpdatePatient(patientModule1);
                ProfilePatient profilePatient = new ProfilePatient(stage,patientModule1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

}
*/
