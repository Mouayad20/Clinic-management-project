package GUI.pages;

import GUI.component.PrintRec;
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
import module.MediceneModule;
import module.PatientModule;
import module.VisitModule;
import sample.Main;
import javax.swing.*;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTreatment {

    public Scene scene = null;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
        HBox history = null ;
            Label labelDate = null ;
            TextField dateTF = null ;
        VBox left_box = null ;
            Label medicine_label = null ;
            HBox content = null ;
                Button add_madicine = null ;
                TextField search_medicine = null ;
            ScrollPane scrollPane_medicine = null;
                VBox box_medicine = null ;
                CheckBox[] medicine = null ;
        VBox right_box = null ;
            Label label_description_treatment = null ;
            TextArea description_treatment = null ;
            Label label_addition_doctor = null ;
            TextArea addition_doctor = null ;
        Button submit = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;

    public AddTreatment(Stage stage , PatientModule patientModule){

        primary_layout = new StackPane();

        rec =  new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        labelDate = new Label(" تاريخ الزيارة :");
        labelDate.setFont(new Font("Arial",40));
        labelDate.setTextFill(Color.WHITE);

        dateTF = new TextField();
        dateTF.setFont(new Font("Arial",30));
        dateTF.setPromptText("______يوم-شهر-سنة________");
        dateTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
        dateTF.setStyle("-fx-color: White;");
        dateTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        dateTF.setStyle("-fx-text-fill : White;");

        history = new HBox(dateTF,labelDate);
        history.setSpacing(1);
        history.setPrefSize(700,50);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        medicine_label = new Label(" الأدوية  ");
        medicine_label.setFont(new Font("Arial",40));
        medicine_label.setTextFill(Color.WHITE);

        search_medicine = new TextField();
        search_medicine.setFont(new Font("Arial",30));
        search_medicine.setPromptText("البحث عن دواء");
        search_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        search_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        search_medicine.setStyle("-fx-text-fill : #1E6089;");
        search_medicine.setPrefSize(450,25);

        add_madicine = new Button("اضافة دواء",GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"22"));
        add_madicine.setFont(new Font("Arial",16));
        add_madicine.setContentDisplay(ContentDisplay.TOP);
        add_madicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
        add_madicine.setTextFill(Color.rgb(30,96,137));

        content = new HBox(add_madicine,search_medicine);
        content.setSpacing(50);

        box_medicine = new VBox();
        box_medicine.setSpacing(10);
        for (int i = 0; i <Main.mediceneModule.length ; i++) {
            box_medicine.getChildren().add(Main.mediceneModule[i]);
        }
        search_medicine.textProperty().addListener(e->{
            box_medicine.getChildren().clear();
            for (int i = 0; i < Main.mediceneModule.length; i++) {
                if ( Main.mediceneModule[i].getName().startsWith(search_medicine.getText()))
                    box_medicine.getChildren().add(Main.mediceneModule[i]);
            }
        });

        scrollPane_medicine = new ScrollPane(box_medicine);
        scrollPane_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane_medicine.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_medicine.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        left_box = new VBox(medicine_label,content,scrollPane_medicine);
        left_box.setSpacing(30);
        VBox.setMargin(medicine_label,new Insets(0,0,0,250));
        VBox.setMargin(scrollPane_medicine,new Insets(0,147,0,0));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_description_treatment = new Label(" وصف المعاينة  ");
        label_description_treatment.setFont(new Font("Arial",40));
        label_description_treatment.setTextFill(Color.WHITE);
        label_description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_description_treatment.setAlignment(Pos.TOP_RIGHT);

        description_treatment = new TextArea();
        description_treatment.setFont(new Font("Arial",30));
        description_treatment.setWrapText(true);
        description_treatment.setPrefSize(150,250);
        description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description_treatment.setStyle("-fx-text-fill : #5A84AD;");
        description_treatment.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" );

        label_addition_doctor = new Label(" اضافات الطبيب  ");
        label_addition_doctor.setFont(new Font("Arial",40));
        label_addition_doctor.setTextFill(Color.WHITE);
        label_addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_addition_doctor.setAlignment(Pos.TOP_RIGHT);

        addition_doctor = new TextArea();
        addition_doctor.setFont(new Font("Arial",30));
        addition_doctor.setWrapText(true);
        addition_doctor.setPrefSize(150,250);
        addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        addition_doctor.setStyle("-fx-text-fill : #5A84AD;");
        addition_doctor.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________");

        right_box = new VBox(label_description_treatment,description_treatment,label_addition_doctor,addition_doctor);
        right_box.setSpacing(30);
        VBox.setMargin(label_description_treatment,new Insets(0,0,0,220));
        VBox.setMargin(label_addition_doctor,new Insets(0,0,0,220));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("تسجيل المعاينة");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(175,45);

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

        primary_layout.getChildren().addAll(rec,back,history,right_box,left_box,Date,submit,dr_name);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(history, Pos.TOP_RIGHT);
        StackPane.setMargin(history,new Insets(40,0,0,390));

        StackPane.setAlignment(right_box,Pos.CENTER_RIGHT);
        StackPane.setMargin(right_box,new Insets(150,50,150,800));

        StackPane.setAlignment(left_box,Pos.CENTER_LEFT);
        StackPane.setMargin(left_box,new Insets(150,760,150,50));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,100,80,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(750,0,0,1300));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout, Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////      Buttons Actions        ////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
        });

        add_madicine.setOnAction(e->{

            VBox add_box = new VBox();
            HBox name_medicine = new HBox();
            Label label_add_name_medicine = new Label();
            TextField textField_add_name_medicine = new TextField();
            HBox type_medicine = new HBox();
            Label label_add_type_medicine = new Label();
            TextField textField_add_type_medicine = new TextField();
            Button save = new Button();

            add_box.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY,Insets.EMPTY)));
            add_box.setSpacing(10);

            label_add_name_medicine.setText(" اسم الدواء : ");
            label_add_name_medicine.setFont(new Font("Arial",25));
            label_add_name_medicine.setTextFill(Color.WHITE);
            label_add_name_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_name_medicine.setFont(new Font("Arial",25));
            textField_add_name_medicine.setPromptText("_____________________");
            textField_add_name_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_name_medicine.setStyle("-fx-color: White;");
            textField_add_name_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_name_medicine.setStyle("-fx-text-fill : White;");

            name_medicine.getChildren().addAll(textField_add_name_medicine,label_add_name_medicine);
            name_medicine.setSpacing(5);

            label_add_type_medicine.setText(" نوع الدواء : ");
            label_add_type_medicine.setFont(new Font("Arial",25));
            label_add_type_medicine.setTextFill(Color.WHITE);
            label_add_type_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_type_medicine.setFont(new Font("Arial",25));
            textField_add_type_medicine.setPromptText("_____________________");
            textField_add_type_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_type_medicine.setStyle("-fx-color: White;");
            textField_add_type_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_type_medicine.setStyle("-fx-text-fill : White;");

            type_medicine.getChildren().addAll(textField_add_type_medicine,label_add_type_medicine);
            type_medicine.setSpacing(5);

            save = new Button(" حفظ ");
            save.setFont(new Font("Arial",25));
            save.setTextFill(Color.rgb(30,96,137));
            save.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
            save.setPrefSize(100,45);

            add_box.getChildren().addAll(name_medicine,type_medicine,save);
            VBox.setMargin(name_medicine,new Insets(5,0,0,75));
            VBox.setMargin(type_medicine,new Insets(10,0,0,75));
            VBox.setMargin(save,new Insets(10,0,15,230));

            primary_layout.getChildren().addAll(add_box);

            StackPane.setAlignment(add_box,Pos.TOP_LEFT);
            StackPane.setMargin(add_box,new Insets(300,903,1150,50));

            save.setOnAction(ex->{
                primary_layout.getChildren().remove(add_box);
                MediceneModule mediceneModule = new MediceneModule(textField_add_name_medicine.getText()
                        ,textField_add_type_medicine.getText());
                try {
                    Main.db.AddMedicene(mediceneModule);
                    Main.mediceneModule = Main.db.GetMediceneModuleFromDataBase();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

        });

        submit.setOnAction(e->{
            String medecene = "";
            Integer j = 1;
            for (int i = 0; i <Main.mediceneModule.length ; i++) {
                if (Main.mediceneModule[i].isSelected())
                {
                    medecene = medecene + j.toString() + ". " +Main.mediceneModule[i].getText() + "\n\n\n";
                    j++;
                    Main.mediceneModule[i].setSelected(false);
                }

            }
            VisitModule visitModule = new VisitModule();
            visitModule.setDate(dateTF.getText());
            visitModule.setDescription(description_treatment.getText());
            System.out.println(medecene);
            visitModule.setMedecine(medecene);
            visitModule.setNotes(addition_doctor.getText());
            Integer id = new Integer(patientModule.getId());
            try {
                Main.db.AddVisit(visitModule,id.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            PrintRec printRec = new PrintRec(stage,primary_layout,patientModule,visitModule);
        });
    }

    /**
     * this constructor used for display treatment
     * @param stage
     * @param patientModule
     * @param visitModule
     */
    public AddTreatment(Stage stage , PatientModule patientModule,VisitModule visitModule){

        primary_layout = new StackPane();

        rec =  new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        labelDate = new Label(" تاريخ الزيارة :");
        labelDate.setFont(new Font("Arial",40));
        labelDate.setTextFill(Color.WHITE);

        dateTF = new TextField(visitModule.getDate());
        dateTF.setFont(new Font("Arial",30));
        dateTF.setPromptText("______يوم-شهر-سنة________");
        dateTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
        dateTF.setStyle("-fx-color: White;");
        dateTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        dateTF.setStyle("-fx-text-fill : White;");

        history = new HBox(dateTF,labelDate);
        history.setSpacing(1);
        history.setPrefSize(700,50);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        medicine_label = new Label(" الأدوية  ");
        medicine_label.setFont(new Font("Arial",40));
        medicine_label.setTextFill(Color.WHITE);

        search_medicine = new TextField();
        search_medicine.setFont(new Font("Arial",30));
        search_medicine.setPromptText("البحث عن دواء");
        search_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        search_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        search_medicine.setStyle("-fx-text-fill : #1E6089;");
        search_medicine.setPrefSize(450,25);

        add_madicine = new Button("اضافة دواء",GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"22"));
        add_madicine.setFont(new Font("Arial",16));
        add_madicine.setContentDisplay(ContentDisplay.TOP);
        add_madicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
        add_madicine.setTextFill(Color.rgb(30,96,137));


        content = new HBox(add_madicine,search_medicine);
        content.setSpacing(50);

        box_medicine = new VBox();
        box_medicine.setSpacing(10);
        for (int i = 0; i <Main.mediceneModule.length ; i++) {
            box_medicine.getChildren().add(Main.mediceneModule[i]);
        }
        search_medicine.textProperty().addListener(e->{
            box_medicine.getChildren().clear();
            for (int i = 0; i < Main.mediceneModule.length; i++) {
                if ( Main.mediceneModule[i].getName().startsWith(search_medicine.getText()))
                    box_medicine.getChildren().add(Main.mediceneModule[i]);
            }
        });


        scrollPane_medicine = new ScrollPane(box_medicine);
        scrollPane_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane_medicine.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_medicine.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane_medicine.setPrefSize(200,300);


        left_box = new VBox(medicine_label,content,scrollPane_medicine);
        left_box.setSpacing(30);
        VBox.setMargin(medicine_label,new Insets(0,0,0,350));
        VBox.setMargin(scrollPane_medicine,new Insets(0,147,0,0));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_description_treatment = new Label(" وصف المعاينة  ");
        label_description_treatment.setFont(new Font("Arial",40));
        label_description_treatment.setTextFill(Color.WHITE);
        label_description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_description_treatment.setAlignment(Pos.TOP_RIGHT);

        description_treatment = new TextArea(visitModule.getDescription());
        description_treatment.setFont(new Font("Arial",30));
        description_treatment.setWrapText(true);
        description_treatment.setPrefSize(150,250);
        description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description_treatment.setStyle("-fx-text-fill : #5A84AD;");
        description_treatment.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" );

        label_addition_doctor = new Label(" اضافات الطبيب  ");
        label_addition_doctor.setFont(new Font("Arial",40));
        label_addition_doctor.setTextFill(Color.WHITE);
        label_addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_addition_doctor.setAlignment(Pos.TOP_RIGHT);

        addition_doctor = new TextArea(visitModule.getNotes());
        addition_doctor.setFont(new Font("Arial",30));
        addition_doctor.setWrapText(true);
        addition_doctor.setPrefSize(150,250);
        addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        addition_doctor.setStyle("-fx-text-fill : #5A84AD;");
        addition_doctor.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________");

        right_box = new VBox(label_description_treatment,description_treatment,label_addition_doctor,addition_doctor);
        right_box.setSpacing(30);
        VBox.setMargin(label_description_treatment,new Insets(0,0,0,220));
        VBox.setMargin(label_addition_doctor,new Insets(0,0,0,220));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("إضغط للطباعة");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(175,45);

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

        primary_layout.getChildren().addAll(rec,back,history,right_box,left_box,Date,submit,dr_name);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(20,0,0,10));

        StackPane.setAlignment(history, Pos.TOP_RIGHT);
        StackPane.setMargin(history,new Insets(40,0,0,390));

        StackPane.setAlignment(right_box,Pos.CENTER_RIGHT);
        StackPane.setMargin(right_box,new Insets(150,50,150,800));

        StackPane.setAlignment(left_box,Pos.CENTER_LEFT);
        StackPane.setMargin(left_box,new Insets(150,760,150,50));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(790,0,0,15));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,100,80,0));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(790,0,0,1300));


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout, Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        stage.setScene(scene);

        //////////////////////////////////////////////////////      Buttons Actions        ////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
        });

        add_madicine.setOnAction(e->{

            VBox add_box = new VBox();
            HBox name_medicine = new HBox();
            Label label_add_name_medicine = new Label();
            TextField textField_add_name_medicine = new TextField();
            HBox type_medicine = new HBox();
            Label label_add_type_medicine = new Label();
            TextField textField_add_type_medicine = new TextField();
            Button save = new Button();

            add_box.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY,Insets.EMPTY)));
            add_box.setSpacing(10);

            label_add_name_medicine.setText(" اسم الدواء : ");
            label_add_name_medicine.setFont(new Font("Arial",25));
            label_add_name_medicine.setTextFill(Color.WHITE);
            label_add_name_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_name_medicine.setFont(new Font("Arial",25));
            textField_add_name_medicine.setPromptText("_____________________");
            textField_add_name_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_name_medicine.setStyle("-fx-color: White;");
            textField_add_name_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_name_medicine.setStyle("-fx-text-fill : White;");

            name_medicine.getChildren().addAll(textField_add_name_medicine,label_add_name_medicine);
            name_medicine.setSpacing(5);

            label_add_type_medicine.setText(" نوع الدواء : ");
            label_add_type_medicine.setFont(new Font("Arial",25));
            label_add_type_medicine.setTextFill(Color.WHITE);
            label_add_type_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_type_medicine.setFont(new Font("Arial",25));
            textField_add_type_medicine.setPromptText("_____________________");
            textField_add_type_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_type_medicine.setStyle("-fx-color: White;");
            textField_add_type_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_type_medicine.setStyle("-fx-text-fill : White;");

            type_medicine.getChildren().addAll(textField_add_type_medicine,label_add_type_medicine);
            type_medicine.setSpacing(5);

            save = new Button(" حفظ ");
            save.setFont(new Font("Arial",25));
            save.setTextFill(Color.rgb(30,96,137));
            save.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
            save.setPrefSize(100,45);

            add_box.getChildren().addAll(name_medicine,type_medicine,save);
            VBox.setMargin(name_medicine,new Insets(5,0,0,75));
            VBox.setMargin(type_medicine,new Insets(10,0,0,75));
            VBox.setMargin(save,new Insets(10,0,15,230));

            primary_layout.getChildren().addAll(add_box);

            StackPane.setAlignment(add_box,Pos.TOP_LEFT);
            StackPane.setMargin(add_box,new Insets(300,903,1150,50));

            save.setOnAction(ex->{
                primary_layout.getChildren().remove(add_box);
                MediceneModule mediceneModule = new MediceneModule(textField_add_name_medicine.getText()
                        ,textField_add_type_medicine.getText());
                try {
                    Main.db.AddMedicene(mediceneModule);
                    Main.mediceneModule = Main.db.GetMediceneModuleFromDataBase();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

        });

        submit.setOnAction(e->{
            String medecene = "";
            for (int i = 0; i <Main.mediceneModule.length ; i++) {
                if (Main.mediceneModule[i].isSelected())
                {
                    medecene = medecene + Main.mediceneModule[i].getText() + "\n\n";
                    Main.mediceneModule[i].setSelected(false);
                }

            }
            try {
                stage.hide();
                JTextField q = new JTextField(visitModule.getMedecine());
                q.print();
                stage.show();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
            PrintRec printRec = new PrintRec(stage,primary_layout,patientModule,visitModule);
        });
    }
}




/*
package GUI.pages;

import GUI.component.PrintRec;
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
import module.MediceneModule;
import module.PatientModule;
import module.VisitModule;
import org.w3c.dom.ls.LSOutput;
import sample.Main;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddTreatment {

    public Scene scene = null;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Button back = null ;
        HBox history = null ;
            Label labelDate = null ;
            TextField dateTF = null ;
        VBox left_box = null ;
            Label medicine_label = null ;
            HBox content = null ;
                Button add_madicine = null ;
                TextField search_medicine = null ;
            ScrollPane scrollPane_medicine = null;
                VBox box_medicine = null ;
                    CheckBox[] medicine = null ;
        VBox right_box = null ;
            Label label_description_treatment = null ;
            TextArea description_treatment = null ;
            Label label_addition_doctor = null ;
            TextArea addition_doctor = null ;
        Button submit = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label DRname = null ;
        Label Date = null ;

        java.util.Date timeDate = null;
        SimpleDateFormat simpleDateFormat = null ;

    public AddTreatment(Stage stage , PatientModule patientModule){

        primary_layout = new StackPane();

        rec =  new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        labelDate = new Label(" تاريخ الزيارة :");
        labelDate.setFont(new Font("Arial",40));
        labelDate.setTextFill(Color.WHITE);

        dateTF = new TextField();
        dateTF.setFont(new Font("Arial",30));
        dateTF.setPromptText("______يوم-شهر-سنة________");
        dateTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
        dateTF.setStyle("-fx-color: White;");
        dateTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        dateTF.setStyle("-fx-text-fill : White;");

        history = new HBox(dateTF,labelDate);
        history.setSpacing(1);
        history.setPrefSize(700,50);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        medicine_label = new Label(" الأدوية  ");
        medicine_label.setFont(new Font("Arial",40));
        medicine_label.setTextFill(Color.WHITE);

        search_medicine = new TextField();
        search_medicine.setFont(new Font("Arial",30));
        search_medicine.setPromptText("البحث عن دواء");
        search_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        search_medicine.setStyle("-fx-color: White;");
        search_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        search_medicine.setStyle("-fx-text-fill : White;");
        search_medicine.setPrefSize(450,25);

        add_madicine = new Button("اضافة دواء",GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"22"));
        add_madicine.setFont(new Font("Arial",16));
        add_madicine.setContentDisplay(ContentDisplay.TOP);
        add_madicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
        add_madicine.setTextFill(Color.rgb(30,96,137));

        content = new HBox(add_madicine,search_medicine);
        content.setSpacing(50);

        box_medicine = new VBox();
        box_medicine.setSpacing(10);
        for (int i = 0; i <Main.mediceneModule.length ; i++) {
            box_medicine.getChildren().add(Main.mediceneModule[i]);
        }
        search_medicine.textProperty().addListener(e->{
            box_medicine.getChildren().clear();
            for (int i = 0; i < Main.mediceneModule.length; i++) {
                if ( Main.mediceneModule[i].getName().startsWith(search_medicine.getText()))
                    box_medicine.getChildren().add(Main.mediceneModule[i]);
                }
            });

        scrollPane_medicine = new ScrollPane(box_medicine);
        scrollPane_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane_medicine.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_medicine.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        left_box = new VBox(medicine_label,content,scrollPane_medicine);
        left_box.setSpacing(30);
        VBox.setMargin(medicine_label,new Insets(0,0,0,250));
        VBox.setMargin(scrollPane_medicine,new Insets(0,147,0,0));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_description_treatment = new Label(" وصف المعاينة  ");
        label_description_treatment.setFont(new Font("Arial",40));
        label_description_treatment.setTextFill(Color.WHITE);
        label_description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_description_treatment.setAlignment(Pos.TOP_RIGHT);

        description_treatment = new TextArea();
        description_treatment.setFont(new Font("Arial",30));
        description_treatment.setWrapText(true);
        description_treatment.setPrefSize(150,250);
        description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description_treatment.setStyle("-fx-text-fill : #5A84AD;");
        description_treatment.setPromptText("__________________________________________________________________" +
                                            "__________________________________________________________________" +
                                            "__________________________________________________________________" +
                                            "__________________________________________________________________" +
                                            "__________________________________________________________________" +
                                            "__________________________________________________________________" +
                                            "__________________________________________________________________" );

        label_addition_doctor = new Label(" اضافات الطبيب  ");
        label_addition_doctor.setFont(new Font("Arial",40));
        label_addition_doctor.setTextFill(Color.WHITE);
        label_addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_addition_doctor.setAlignment(Pos.TOP_RIGHT);

        addition_doctor = new TextArea();
        addition_doctor.setFont(new Font("Arial",30));
        addition_doctor.setWrapText(true);
        addition_doctor.setPrefSize(150,250);
        addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        addition_doctor.setStyle("-fx-text-fill : #5A84AD;");
        addition_doctor.setPromptText("__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________" +
                                      "__________________________________________________________________");

        right_box = new VBox(label_description_treatment,description_treatment,label_addition_doctor,addition_doctor);
        right_box.setSpacing(30);
        VBox.setMargin(label_description_treatment,new Insets(0,0,0,220));
        VBox.setMargin(label_addition_doctor,new Insets(0,0,0,220));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("تسجيل المعاينة");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(175,45);

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

        primary_layout.getChildren().addAll(rec,back,history,right_box,left_box,Date,submit,dr_name);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(20,0,0,10));

        StackPane.setAlignment(history, Pos.TOP_RIGHT);
        StackPane.setMargin(history,new Insets(40,0,0,390));

        StackPane.setAlignment(right_box,Pos.CENTER_RIGHT);
        StackPane.setMargin(right_box,new Insets(150,50,150,800));

        StackPane.setAlignment(left_box,Pos.CENTER_LEFT);
        StackPane.setMargin(left_box,new Insets(150,760,150,50));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(790,0,0,15));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,100,80,0));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(790,0,0,1300));


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,stage.getWidth(),stage.getWidth());
        stage.setScene(scene);

        //////////////////////////////////////////////////////      Buttons Actions        ////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
        });

        add_madicine.setOnAction(e->{

            VBox add_box = new VBox();
                HBox name_medicine = new HBox();
                    Label label_add_name_medicine = new Label();
                    TextField textField_add_name_medicine = new TextField();
                HBox type_medicine = new HBox();
                    Label label_add_type_medicine = new Label();
                    TextField textField_add_type_medicine = new TextField();
                Button save = new Button();

            add_box.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY,Insets.EMPTY)));
            add_box.setSpacing(10);

            label_add_name_medicine.setText(" اسم الدواء : ");
            label_add_name_medicine.setFont(new Font("Arial",25));
            label_add_name_medicine.setTextFill(Color.WHITE);
            label_add_name_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_name_medicine.setFont(new Font("Arial",25));
            textField_add_name_medicine.setPromptText("_____________________");
            textField_add_name_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_name_medicine.setStyle("-fx-color: White;");
            textField_add_name_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_name_medicine.setStyle("-fx-text-fill : White;");

            name_medicine.getChildren().addAll(textField_add_name_medicine,label_add_name_medicine);
            name_medicine.setSpacing(5);

            label_add_type_medicine.setText(" نوع الدواء : ");
            label_add_type_medicine.setFont(new Font("Arial",25));
            label_add_type_medicine.setTextFill(Color.WHITE);
            label_add_type_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_type_medicine.setFont(new Font("Arial",25));
            textField_add_type_medicine.setPromptText("_____________________");
            textField_add_type_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_type_medicine.setStyle("-fx-color: White;");
            textField_add_type_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_type_medicine.setStyle("-fx-text-fill : White;");

            type_medicine.getChildren().addAll(textField_add_type_medicine,label_add_type_medicine);
            type_medicine.setSpacing(5);

            save = new Button(" حفظ ");
            save.setFont(new Font("Arial",25));
            save.setTextFill(Color.rgb(30,96,137));
            save.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
            save.setPrefSize(100,45);

            add_box.getChildren().addAll(name_medicine,type_medicine,save);
            VBox.setMargin(name_medicine,new Insets(5,0,0,75));
            VBox.setMargin(type_medicine,new Insets(10,0,0,75));
            VBox.setMargin(save,new Insets(10,0,15,230));

            primary_layout.getChildren().addAll(add_box);

            StackPane.setAlignment(add_box,Pos.TOP_LEFT);
            StackPane.setMargin(add_box,new Insets(300,903,1150,50));

            save.setOnAction(ex->{
                primary_layout.getChildren().remove(add_box);
                MediceneModule mediceneModule = new MediceneModule(textField_add_name_medicine.getText()
                        ,textField_add_type_medicine.getText());
                try {
                    Main.db.AddMedicene(mediceneModule);
                    Main.mediceneModule = Main.db.GetMediceneModuleFromDataBase();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

        });

        submit.setOnAction(e->{
            String medecene = "";
            Integer j = 1;
            for (int i = 0; i <Main.mediceneModule.length ; i++) {
                if (Main.mediceneModule[i].isSelected())
                {
                    medecene = medecene + j.toString() + ". " +Main.mediceneModule[i].getText() + "\n\n\n";
                    j++;
                    Main.mediceneModule[i].setSelected(false);
                }

            }
            VisitModule visitModule = new VisitModule();
            visitModule.setDate(dateTF.getText());
            visitModule.setDescription(description_treatment.getText());
            System.out.println(medecene);
            visitModule.setMedecine(medecene);
            visitModule.setNotes(addition_doctor.getText());
            Integer id = new Integer(patientModule.getId());
            try {
                Main.db.AddVisit(visitModule,id.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            PrintRec printRec = new PrintRec(stage,primary_layout,patientModule,visitModule);
        });
        }

    */
/**
     * this constructor used for display treatment
     * @param stage
     * @param patientModule
     * @param visitModule
     *//*

        public AddTreatment(Stage stage , PatientModule patientModule,VisitModule visitModule){

        primary_layout = new StackPane();

        rec =  new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        labelDate = new Label(" تاريخ الزيارة :");
        labelDate.setFont(new Font("Arial",40));
        labelDate.setTextFill(Color.WHITE);

        dateTF = new TextField(visitModule.getDate());
        dateTF.setFont(new Font("Arial",30));
        dateTF.setPromptText("______يوم-شهر-سنة________");
        dateTF.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
        dateTF.setStyle("-fx-color: White;");
        dateTF.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        dateTF.setStyle("-fx-text-fill : White;");

        history = new HBox(dateTF,labelDate);
        history.setSpacing(1);
        history.setPrefSize(700,50);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        medicine_label = new Label(" الأدوية  ");
        medicine_label.setFont(new Font("Arial",40));
        medicine_label.setTextFill(Color.WHITE);

        search_medicine = new TextField();
        search_medicine.setFont(new Font("Arial",30));
        search_medicine.setPromptText("البحث عن دواء");
        search_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        search_medicine.setStyle("-fx-color: White;");
        search_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        search_medicine.setStyle("-fx-text-fill : White;");
        search_medicine.setPrefSize(450,25);

        add_madicine = new Button("اضافة دواء",GlyphsDude.createIcon(FontAwesomeIcon.PLUS,"22"));
        add_madicine.setFont(new Font("Arial",16));
        add_madicine.setContentDisplay(ContentDisplay.TOP);
        add_madicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY,Insets.EMPTY)));
        add_madicine.setTextFill(Color.rgb(30,96,137));


        content = new HBox(add_madicine,search_medicine);
        content.setSpacing(50);

        box_medicine = new VBox();
        box_medicine.setSpacing(10);
        for (int i = 0; i <Main.mediceneModule.length ; i++) {
            box_medicine.getChildren().add(Main.mediceneModule[i]);
        }
        search_medicine.textProperty().addListener(e->{
            box_medicine.getChildren().clear();
            for (int i = 0; i < Main.mediceneModule.length; i++) {
                if ( Main.mediceneModule[i].getName().startsWith(search_medicine.getText()))
                    box_medicine.getChildren().add(Main.mediceneModule[i]);
            }
        });


        scrollPane_medicine = new ScrollPane(box_medicine);
        scrollPane_medicine.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane_medicine.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane_medicine.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane_medicine.setPrefSize(200,300);


        left_box = new VBox(medicine_label,content,scrollPane_medicine);
        left_box.setSpacing(30);
        VBox.setMargin(medicine_label,new Insets(0,0,0,350));
        VBox.setMargin(scrollPane_medicine,new Insets(0,147,0,0));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        label_description_treatment = new Label(" وصف المعاينة  ");
        label_description_treatment.setFont(new Font("Arial",40));
        label_description_treatment.setTextFill(Color.WHITE);
        label_description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_description_treatment.setAlignment(Pos.TOP_RIGHT);

        description_treatment = new TextArea(visitModule.getDescription());
        description_treatment.setFont(new Font("Arial",30));
        description_treatment.setWrapText(true);
        description_treatment.setPrefSize(150,250);
        description_treatment.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        description_treatment.setStyle("-fx-text-fill : #5A84AD;");
        description_treatment.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" );

        label_addition_doctor = new Label(" اضافات الطبيب  ");
        label_addition_doctor.setFont(new Font("Arial",40));
        label_addition_doctor.setTextFill(Color.WHITE);
        label_addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        label_addition_doctor.setAlignment(Pos.TOP_RIGHT);

        addition_doctor = new TextArea(visitModule.getNotes());
        addition_doctor.setFont(new Font("Arial",30));
        addition_doctor.setWrapText(true);
        addition_doctor.setPrefSize(150,250);
        addition_doctor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        addition_doctor.setStyle("-fx-text-fill : #5A84AD;");
        addition_doctor.setPromptText("__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________" +
                "__________________________________________________________________");

        right_box = new VBox(label_description_treatment,description_treatment,label_addition_doctor,addition_doctor);
        right_box.setSpacing(30);
        VBox.setMargin(label_description_treatment,new Insets(0,0,0,220));
        VBox.setMargin(label_addition_doctor,new Insets(0,0,0,220));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        submit = new Button("إضغط للطباعة");
        submit.setFont(new Font("Arial",25));
        submit.setTextFill(Color.WHITE);
        submit.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY, Insets.EMPTY)));
        submit.setPrefSize(175,45);

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

        primary_layout.getChildren().addAll(rec,back,history,right_box,left_box,Date,submit,dr_name);

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(20,0,0,10));

        StackPane.setAlignment(history, Pos.TOP_RIGHT);
        StackPane.setMargin(history,new Insets(40,0,0,390));

        StackPane.setAlignment(right_box,Pos.CENTER_RIGHT);
        StackPane.setMargin(right_box,new Insets(150,50,150,800));

        StackPane.setAlignment(left_box,Pos.CENTER_LEFT);
        StackPane.setMargin(left_box,new Insets(150,760,150,50));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(790,0,0,15));

        StackPane.setAlignment(submit,Pos.BOTTOM_CENTER);
        StackPane.setMargin(submit,new Insets(0,100,80,0));

        StackPane.setAlignment(dr_name,Pos.TOP_LEFT);
        StackPane.setMargin(dr_name,new Insets(790,0,0,1300));


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
        stage.setScene(scene);

        //////////////////////////////////////////////////////      Buttons Actions        ////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{
            ProfilePatient profilePatient = new ProfilePatient(stage,patientModule);
        });

        add_madicine.setOnAction(e->{

            VBox add_box = new VBox();
            HBox name_medicine = new HBox();
            Label label_add_name_medicine = new Label();
            TextField textField_add_name_medicine = new TextField();
            HBox type_medicine = new HBox();
            Label label_add_type_medicine = new Label();
            TextField textField_add_type_medicine = new TextField();
            Button save = new Button();

            add_box.setBackground(new Background(new BackgroundFill(Color.rgb(30,96,137),CornerRadii.EMPTY,Insets.EMPTY)));
            add_box.setSpacing(10);

            label_add_name_medicine.setText(" اسم الدواء : ");
            label_add_name_medicine.setFont(new Font("Arial",25));
            label_add_name_medicine.setTextFill(Color.WHITE);
            label_add_name_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_name_medicine.setFont(new Font("Arial",25));
            textField_add_name_medicine.setPromptText("_____________________");
            textField_add_name_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_name_medicine.setStyle("-fx-color: White;");
            textField_add_name_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_name_medicine.setStyle("-fx-text-fill : White;");

            name_medicine.getChildren().addAll(textField_add_name_medicine,label_add_name_medicine);
            name_medicine.setSpacing(5);

            label_add_type_medicine.setText(" نوع الدواء : ");
            label_add_type_medicine.setFont(new Font("Arial",25));
            label_add_type_medicine.setTextFill(Color.WHITE);
            label_add_type_medicine.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

            textField_add_type_medicine.setFont(new Font("Arial",25));
            textField_add_type_medicine.setPromptText("_____________________");
            textField_add_type_medicine.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
            textField_add_type_medicine.setStyle("-fx-color: White;");
            textField_add_type_medicine.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            textField_add_type_medicine.setStyle("-fx-text-fill : White;");

            type_medicine.getChildren().addAll(textField_add_type_medicine,label_add_type_medicine);
            type_medicine.setSpacing(5);

            save = new Button(" حفظ ");
            save.setFont(new Font("Arial",25));
            save.setTextFill(Color.rgb(30,96,137));
            save.setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200),CornerRadii.EMPTY, Insets.EMPTY)));
            save.setPrefSize(100,45);

            add_box.getChildren().addAll(name_medicine,type_medicine,save);
            VBox.setMargin(name_medicine,new Insets(5,0,0,75));
            VBox.setMargin(type_medicine,new Insets(10,0,0,75));
            VBox.setMargin(save,new Insets(10,0,15,230));

            primary_layout.getChildren().addAll(add_box);

            StackPane.setAlignment(add_box,Pos.TOP_LEFT);
            StackPane.setMargin(add_box,new Insets(300,903,1150,50));

            save.setOnAction(ex->{
                primary_layout.getChildren().remove(add_box);
                MediceneModule mediceneModule = new MediceneModule(textField_add_name_medicine.getText()
                        ,textField_add_type_medicine.getText());
                try {
                    Main.db.AddMedicene(mediceneModule);
                    Main.mediceneModule = Main.db.GetMediceneModuleFromDataBase();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            });

        });

        submit.setOnAction(e->{
            String medecene = "";
            for (int i = 0; i <Main.mediceneModule.length ; i++) {
                if (Main.mediceneModule[i].isSelected())
                {
                    medecene = medecene + Main.mediceneModule[i].getText() + "\n\n";
                    Main.mediceneModule[i].setSelected(false);
                }

            }
            try {
                stage.hide();
                JTextField q = new JTextField(visitModule.getMedecine());
                q.print();
                stage.show();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
            PrintRec printRec = new PrintRec(stage,primary_layout,patientModule,visitModule);
        });
    }
}*/
