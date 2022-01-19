package GUI.pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import sample.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfilePatient {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec1 = null ;
        HBox content = null ;
            VBox info = null ;
                HBox box_name = null ;
                    Label name = null ;
                    Label label_name = null ;//
                HBox box_num = null ;
                    Label num = null ;
                    Label label_num = null ;//
                HBox box_name_of_father = null ;
                    Label name_of_father = null ;
                    Label label_name_of_father = null ;//
                HBox box_name_of_mother = null ;
                    Label name_of_mother = null ;
                    Label label_name_of_mother = null ;//
                HBox box_age = null ;
                    Label age = null ;
                    Label label_age = null ;//
                HBox box_phone_number = null ;
                    Label phone_number = null ;
                    Label label_phone_number = null ;//
                HBox box_job = null ;
                    Label job = null ;
                    Label label_job = null ;//
                VBox box_old_seks = null;
                    Label label_old_seks = null ;
                    ScrollPane scrollPane_old_seks = null;
                        Label old_seks = null ;//
                 VBox box_nots = null;
                    Label label_nots = null ;
                    ScrollPane scrollPane_nots = null;
                        Label nots = null ;//
        HBox options = null ;
            Rectangle rec2 = null ;
            Button add_treatment = null ;
            Button display_treatment = null ;
            Button edit_info = null ;
        Button exit = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;

    public ProfilePatient(Stage stage, PatientModule patientModule){

        primary_layout = new StackPane();

        rec1 =  new Rectangle();
        rec1.setFill(Color.rgb(90,132,173));
        rec1.widthProperty().bind(primary_layout.widthProperty());
        rec1.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_nots = new Label(" ملاحظات ");
        label_nots.setFont(new Font("Arial",40));
        label_nots.setUnderline(true);
        label_nots.setTextFill(Color.WHITE);
        label_nots.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));

        nots = new Label(patientModule.getWarning()) ;
        nots.setFont(new Font("Arial",30));
        nots.setTextFill(Color.WHITE);
        nots.setWrapText(true);
        nots.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
        nots.setPrefWidth(494);
        nots.setPrefHeight(1750);
        nots.setAlignment(Pos.TOP_LEFT);

        scrollPane_nots = new ScrollPane(nots);
        scrollPane_nots.setPrefWidth(550);
        scrollPane_nots.setPrefHeight(320);
        scrollPane_nots.setStyle("-fx-color:#5A84AD;");
        scrollPane_nots.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_nots.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));

        box_nots = new VBox(label_nots,scrollPane_nots);
        box_nots.setSpacing(5);
        box_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
        box_nots.setPrefSize(575,20);
        box_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
        box_nots.setStyle("-fx-border-width: 0 0.5 2 0; -fx-border-color: red white white red;");
        VBox.setMargin(label_nots,new Insets(3,150,0,150));
        VBox.setMargin(nots,new Insets(15,75,0,75));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_old_seks = new Label(" السوابق المرضية ");
        label_old_seks.setFont(new Font("Arial",40));
        label_old_seks.setUnderline(true);
        label_old_seks.setTextFill(Color.WHITE);
        label_old_seks.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        old_seks = new Label(patientModule.getDescreption()) ;
        old_seks.setFont(new Font("Arial",30));
        old_seks.setTextFill(Color.WHITE);
        old_seks.setWrapText(true);
        old_seks.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        old_seks.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
        old_seks.setPrefWidth(493);
        old_seks.setPrefHeight(1750);
        old_seks.setAlignment(Pos.TOP_LEFT);

        scrollPane_old_seks = new ScrollPane(old_seks);
        scrollPane_old_seks.setPrefWidth(550);
        scrollPane_old_seks.setPrefHeight(320);
        scrollPane_old_seks.setStyle("-fx-color:#5A84AD;");
        scrollPane_old_seks.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_old_seks.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane_old_seks.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));

        box_old_seks = new VBox(label_old_seks,scrollPane_old_seks);
        box_old_seks.setSpacing(5);
        box_old_seks.setPrefSize(575,20);
        box_old_seks.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        box_old_seks.setStyle("-fx-border-width: 0 0.5 2 0.5; -fx-border-color: red white white white;");
        VBox.setMargin(label_old_seks,new Insets(3,80,0,120));
        VBox.setMargin(old_seks,new Insets(15,75,0,75));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        name = new Label("الاسم        : ");
        name.setFont(new Font("Arial",30));
        name.setTextFill(Color.WHITE);

        label_name = new Label(patientModule.getName());
        label_name.setFont(new Font("Arial",30));
        label_name.setTextFill(Color.WHITE);

        box_name = new HBox(name,label_name);
        box_name.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        num = new Label("الرقم        : ");
        num.setFont(new Font("Arial",30));
        num.setTextFill(Color.WHITE);

        label_num = new Label(patientModule.getId_patient());
        label_num.setFont(new Font("Arial",30));
        label_num.setTextFill(Color.WHITE);

        box_num = new HBox(num,label_num);
        box_num.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_father = new Label("اسم الاب     : ");
        name_of_father.setFont(new Font("Arial",30));
        name_of_father.setTextFill(Color.WHITE);

        label_name_of_father = new Label(patientModule.getFather_name());
        label_name_of_father.setFont(new Font("Arial",30));
        label_name_of_father.setTextFill(Color.WHITE);

        box_name_of_father = new HBox(name_of_father,label_name_of_father);
        box_name_of_father.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name_of_mother = new Label("اسم الام     : ");
        name_of_mother.setFont(new Font("Arial",30));
        name_of_mother.setTextFill(Color.WHITE);

        label_name_of_mother = new Label(patientModule.getMother_name());
        label_name_of_mother.setFont(new Font("Arial",30));
        label_name_of_mother.setTextFill(Color.WHITE);

        box_name_of_mother = new HBox(name_of_mother,label_name_of_mother);
        box_name_of_mother.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        /////////////////////////// dont touch this is for the true age as number format not date format \\\\\\\\\\\\\\\\\\\\\\

        age = new Label("العمر       : ");
        age.setFont(new Font("Arial",30));
        age.setTextFill(Color.WHITE);

        String age_string = patientModule.getBirthday().substring(0,4);
        Integer smaller_age = new Integer(patientModule.getBirthday().substring(0,4));
        Date timeDate1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("Y");
        String string_age = simpleDateFormat1.format(timeDate1);
        Integer bigger_age = new Integer(string_age);
        Integer final_age = bigger_age - smaller_age;
        label_age = new Label(final_age.toString());
        label_age.setFont(new Font("Arial",30));
        label_age.setTextFill(Color.WHITE);

        box_age = new HBox(age,label_age);
        box_age.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        phone_number = new Label("رقم الموبايل : ");
        phone_number.setFont(new Font("Arial",30));
        phone_number.setTextFill(Color.WHITE);

        label_phone_number = new Label(patientModule.getMobilephone());
        label_phone_number.setFont(new Font("Arial",30));
        label_phone_number.setTextFill(Color.WHITE);

        box_phone_number = new HBox(phone_number,label_phone_number);
        box_phone_number.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        job = new Label("العمل        : ");
        job.setFont(new Font("Arial",30));
        job.setTextFill(Color.WHITE);

        label_job = new Label(patientModule.getJob());
        label_job.setFont(new Font("Arial",30));
        label_job.setTextFill(Color.WHITE);

        box_job = new HBox(job,label_job);
        box_job.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        info = new VBox(box_name,box_num,box_age,box_name_of_father,box_name_of_mother,box_phone_number,box_job);
        info.setSpacing(7);
        info.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        info.setPrefSize(575,0);
        info.setAlignment(Pos.CENTER_RIGHT);
        info.setStyle("-fx-border-width: 0 0 2 0.5; -fx-border-color: red white white white;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        content = new HBox(box_nots,box_old_seks,info);
        content.setSpacing(0);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        options = new HBox();

        rec2 =  new Rectangle();
        rec2.setFill(Color.rgb(30,96,137));
        rec2.setHeight(200);
        rec2.setWidth(850);

        add_treatment= new Button( " اضافة معاينة ",  GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"50")) ;
        add_treatment.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
        add_treatment.setFont(new Font("Arial",30));
        add_treatment.setContentDisplay(ContentDisplay.TOP);
        add_treatment.setTextFill(Color.rgb(90,132,173));

        display_treatment = new Button( " عرض المعاينات " ,  GlyphsDude.createIcon(FontAwesomeIcon.CLIPBOARD,"50")) ;
        display_treatment.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        display_treatment.setFont(new Font("Arial",30));
        display_treatment.setContentDisplay(ContentDisplay.TOP);
        display_treatment.setTextFill(Color.rgb(90,132,173));

        edit_info = new Button( " تعديل البيانات " ,  GlyphsDude.createIcon(FontAwesomeIcon.EDIT,"50")) ;
        edit_info.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        edit_info.setFont(new Font("Arial",30));
        edit_info.setContentDisplay(ContentDisplay.TOP);
        edit_info.setTextFill(Color.rgb(90,132,173));

        options.getChildren().addAll(add_treatment,display_treatment,edit_info);
        options.setSpacing(50);
        options.setPrefSize(750,100);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        exit = new Button(" خروج ");
        exit.setFont(new Font("Arial",25));
        exit.setTextFill(Color.WHITE);
        exit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        exit.setPrefSize(175,45);

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

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        primary_layout.getChildren().addAll(rec1,content,rec2,options,exit,Date,dr_name);

        StackPane.setAlignment(content, Pos.TOP_CENTER);
        StackPane.setMargin(content,new Insets(0,0,550,0));

        StackPane.setAlignment(rec2, Pos.TOP_CENTER);
        StackPane.setMargin(rec2,new Insets(400,385,400,325));

        StackPane.setAlignment(options, Pos.TOP_CENTER);
        StackPane.setMargin(options,new Insets(450,400,0,400));

        StackPane.setAlignment(exit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(exit,new Insets(0,100,80,70));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout, Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        add_treatment.setOnAction(e->{

            AddTreatment addTreatment = new AddTreatment(stage,patientModule);

        });

        display_treatment.setOnAction(e->{

            DisplayTreatment displayTreatment = new DisplayTreatment(stage,patientModule);

        });

        edit_info.setOnAction(e->{

            AddPatient addPatient = new AddPatient(stage,patientModule);

        });


        exit.setOnAction(e->{

            Inquirers inquirers = new Inquirers(stage);

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
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import module.PatientModule;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfilePatient {

    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec1 = null ;
        HBox content = null ;
            VBox info = null ;
                HBox box_name = null ;
                    Label name = null ;
                    Label label_name = null ;//
                HBox box_num = null ;
                    Label num = null ;
                    Label label_num = null ;//
                HBox box_name_of_father = null ;
                    Label name_of_father = null ;
                    Label label_name_of_father = null ;//
                HBox box_name_of_mother = null ;
                    Label name_of_mother = null ;
                    Label label_name_of_mother = null ;//
                HBox box_age = null ;
                    Label age = null ;
                    Label label_age = null ;//
                HBox box_phone_number = null ;
                    Label phone_number = null ;
                    Label label_phone_number = null ;//
                HBox box_job = null ;
                    Label job = null ;
                    Label label_job = null ;//
            ScrollPane scrollPane_old_seks = null;
                VBox box_old_seks = null;
                    Label label_old_seks = null ;
                    Label old_seks = null ;//
            ScrollPane scrollPane_box_nots = null;
                VBox box_nots = null;
                    Label label_nots = null ;
                    Label nots = null ;//
        HBox options = null ;
            Rectangle rec2 = null ;
            Button add_treatment = null ;
            Button display_treatment = null ;
            Button edit_info = null ;
        Button exit = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;
        Label Date = null ;

        java.util.Date timeDate = null;
        SimpleDateFormat simpleDateFormat = null ;


        public ProfilePatient(Stage stage, PatientModule patientModule){

            primary_layout = new StackPane();

            rec1 =  new Rectangle();
            rec1.setFill(Color.rgb(90,132,173));
            rec1.widthProperty().bind(primary_layout.widthProperty());
            rec1.heightProperty().bind(primary_layout.heightProperty());

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            label_nots = new Label(" ملاحظات ");
            label_nots.setFont(new Font("Arial",40));
            label_nots.setUnderline(true);
            label_nots.setTextFill(Color.WHITE);
            label_nots.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            label_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));

            nots = new Label(patientModule.getWarning()) ;
            nots.setFont(new Font("Arial",35));
            nots.setTextFill(Color.WHITE);
            nots.setWrapText(true);
            nots.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));

            box_nots = new VBox(label_nots,nots);
            box_nots.setSpacing(0);
            box_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
            box_nots.setPrefSize(575,20);
            box_nots.setBackground(new Background(new BackgroundFill(Color.rgb(90,132,173),CornerRadii.EMPTY,Insets.EMPTY)));
            box_nots.setStyle("-fx-border-width: 0 0.5 2 0; -fx-border-color: red white white red;");
            VBox.setMargin(label_nots,new Insets(10,150,0,150));
            VBox.setMargin(nots,new Insets(15,75,0,75));

            label_old_seks = new Label(" السوابق المرضية ");
            label_old_seks.setFont(new Font("Arial",40));
            label_old_seks.setUnderline(true);
            label_old_seks.setTextFill(Color.WHITE);
            label_old_seks.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            old_seks = new Label(patientModule.getDescreption()) ;
            old_seks.setFont(new Font("Arial",35));
            old_seks.setTextFill(Color.WHITE);
            old_seks.setWrapText(true);
            old_seks.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            box_old_seks = new VBox(label_old_seks,old_seks);
            box_old_seks.setSpacing(0);
            box_old_seks.setPrefSize(575,20);
            box_old_seks.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            box_old_seks.setStyle("-fx-border-width: 0 0.5 2 0.5; -fx-border-color: red white white white;");
            VBox.setMargin(label_old_seks,new Insets(10,80,0,120));
            VBox.setMargin(old_seks,new Insets(15,75,0,75));

            name = new Label("الاسم        : ");
            name.setFont(new Font("Arial",30));
            name.setTextFill(Color.WHITE);

            label_name = new Label(patientModule.getName());
            label_name.setFont(new Font("Arial",30));
            label_name.setTextFill(Color.WHITE);

            box_name = new HBox(name,label_name);
            box_name.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            num = new Label("الرقم        : ");
            num.setFont(new Font("Arial",30));
            num.setTextFill(Color.WHITE);

            label_num = new Label(patientModule.getId_patient());
            label_num.setFont(new Font("Arial",30));
            label_num.setTextFill(Color.WHITE);

            box_num = new HBox(num,label_num);
            box_num.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            name_of_father = new Label("اسم الاب     : ");
            name_of_father.setFont(new Font("Arial",30));
            name_of_father.setTextFill(Color.WHITE);

            label_name_of_father = new Label(patientModule.getFather_name());
            label_name_of_father.setFont(new Font("Arial",30));
            label_name_of_father.setTextFill(Color.WHITE);

            box_name_of_father = new HBox(name_of_father,label_name_of_father);
            box_name_of_father.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            name_of_mother = new Label("اسم الام     : ");
            name_of_mother.setFont(new Font("Arial",30));
            name_of_mother.setTextFill(Color.WHITE);

            label_name_of_mother = new Label(patientModule.getMother_name());
            label_name_of_mother.setFont(new Font("Arial",30));
            label_name_of_mother.setTextFill(Color.WHITE);

            box_name_of_mother = new HBox(name_of_mother,label_name_of_mother);
            box_name_of_mother.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            age = new Label("العمر       : ");
            age.setFont(new Font("Arial",30));
            age.setTextFill(Color.WHITE);

            /////////////////////////// dont touch this is for the true age as number format not date format \\\\\\\\\\\\\\\\\\\\\\

            String age_string = patientModule.getBirthday().substring(0,4);
            Integer smaller_age = new Integer(patientModule.getBirthday().substring(0,4));
            Date timeDate1 = new Date();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("Y");
            String string_age = simpleDateFormat1.format(timeDate1);
            Integer bigger_age = new Integer(string_age);
            Integer final_age = bigger_age - smaller_age;
            label_age = new Label(final_age.toString());
            label_age.setFont(new Font("Arial",30));
            label_age.setTextFill(Color.WHITE);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            box_age = new HBox(age,label_age);
            box_age.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            phone_number = new Label("رقم الموبايل : ");
            phone_number.setFont(new Font("Arial",30));
            phone_number.setTextFill(Color.WHITE);

            label_phone_number = new Label(patientModule.getMobilephone());
            label_phone_number.setFont(new Font("Arial",30));
            label_phone_number.setTextFill(Color.WHITE);

            box_phone_number = new HBox(phone_number,label_phone_number);
            box_phone_number.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            job = new Label("العمل        : ");
            job.setFont(new Font("Arial",30));
            job.setTextFill(Color.WHITE);

            label_job = new Label(patientModule.getJob());
            label_job.setFont(new Font("Arial",30));
            label_job.setTextFill(Color.WHITE);

            box_job = new HBox(job,label_job);
            box_job.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            info = new VBox(box_name,box_num,box_age,box_name_of_father,box_name_of_mother,box_phone_number,box_job);
            info.setSpacing(7);
            info.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
            info.setPrefSize(575,0);
            info.setAlignment(Pos.CENTER_RIGHT);
            info.setStyle("-fx-border-width: 0 0 2 0.5; -fx-border-color: red white white white;");

            content = new HBox(box_nots,box_old_seks,info);
            content.setSpacing(0);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            options = new HBox();

            rec2 =  new Rectangle();
            rec2.setFill(Color.rgb(30,96,137));
            rec2.setHeight(200);
            rec2.setWidth(850);

            add_treatment= new Button( " اضافة معاينة ",  GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"50")) ;
            add_treatment.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
            add_treatment.setFont(new Font("Arial",30));
            add_treatment.setContentDisplay(ContentDisplay.TOP);
            add_treatment.setTextFill(Color.rgb(90,132,173));

            display_treatment = new Button( " عرض المعاينات " ,  GlyphsDude.createIcon(FontAwesomeIcon.CLIPBOARD,"50")) ;
            display_treatment.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
            display_treatment.setFont(new Font("Arial",30));
            display_treatment.setContentDisplay(ContentDisplay.TOP);
            display_treatment.setTextFill(Color.rgb(90,132,173));
            display_treatment.setOnAction(e->{
                DisplayTreatment displayTreatment = new DisplayTreatment(stage,patientModule);
            });

            edit_info = new Button( " تعديل البيانات " ,  GlyphsDude.createIcon(FontAwesomeIcon.EDIT,"50")) ;
            edit_info.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
            edit_info.setFont(new Font("Arial",30));
            edit_info.setContentDisplay(ContentDisplay.TOP);
            edit_info.setTextFill(Color.rgb(90,132,173));

            options.getChildren().addAll(add_treatment,display_treatment,edit_info);
            options.setSpacing(50);
            options.setPrefSize(750,100);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            exit = new Button(" خروج ");
            exit.setFont(new Font("Arial",25));
            exit.setTextFill(Color.WHITE);
            exit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
            exit.setPrefSize(175,45);

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

            timeDate = new Date();
            simpleDateFormat = new SimpleDateFormat(" d - M - Y ");
            String s = simpleDateFormat.format(timeDate);

            Date = new Label(s);
            Date.setFont(new Font("Arial",35));
            Date.setTextFill(Color.WHITE);

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            primary_layout.getChildren().addAll(rec1,content,rec2,options,exit,Date,dr_name);

            StackPane.setAlignment(content, Pos.TOP_CENTER);
            StackPane.setMargin(content,new Insets(25,10,550,10));

            StackPane.setAlignment(options, Pos.TOP_CENTER);
            StackPane.setMargin(options,new Insets(450,400,0,400));

            StackPane.setAlignment(rec2, Pos.TOP_CENTER);
            StackPane.setMargin(rec2,new Insets(400,385,400,325));

            StackPane.setAlignment(exit,Pos.BOTTOM_CENTER);
            StackPane.setMargin(exit,new Insets(0,100,80,70));

            StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
            StackPane.setMargin(dr_name,new Insets(790,0,0,1300));

            StackPane.setAlignment(Date,Pos.TOP_LEFT);
            StackPane.setMargin(Date,new Insets(790,0,0,15));

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
            stage.setScene(scene);

            add_treatment.setOnAction(e->{
                AddTreatment addTreatment = new AddTreatment(stage,patientModule);
            });

            edit_info.setOnAction(e->{
                AddPatient addPatient = new AddPatient(stage,patientModule);
            });

            exit.setOnAction(e->{
                Inquirers inquirers = new Inquirers(stage);
            });

        }

}*/
