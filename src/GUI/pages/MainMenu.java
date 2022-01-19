package GUI.pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMenu {

    public Stage stage = new Stage();
    public Scene scene = null ;

    StackPane primary_layout = null ;
        Rectangle rec1 = null ;
        Button about = null ;
        Label main_menu = null ;
        Button inquire = null ;
        Label Date = null ;
        HBox dr_name = null ;
            Label dr = null ;
            Label name = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;

    public MainMenu(Stage stage){

        about = new Button("الدعم التقني",GlyphsDude.createIcon(FontAwesomeIcon.SUPPORT,"30" ));
        about.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        about.setFont(new Font("Arial",25));
        about.setContentDisplay(ContentDisplay.TOP);
        about.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        main_menu = new Label("القائمة الرئيسية");
        main_menu.setFont(new Font("Arial",60));
        main_menu.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        inquire= new Button( "الاستعلامات",  GlyphsDude.createIcon(FontAwesomeIcon.QUESTION_CIRCLE,"50")) ;
        inquire.setStyle("-fx-border-width: 50 100 50 100 ; -fx-border-color: #1E6089 #1E6089 #1E6089 #1E6089;");
        inquire.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        inquire.setTextFill(Color.rgb(90,132,173));
        inquire.setFont(new Font("Arial",30));
        inquire.setContentDisplay(ContentDisplay.TOP);
        inquire.setDefaultButton(true);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        dr_name = new HBox();

        dr = new Label("");
        dr.setFont( new Font("Arial",70) );
        dr.setTextFill( Color.rgb(30,96,137) );

        name = new Label( "إدارة العيادة" );
        name.setFont( new Font("Arial",70) );
        name.setTextFill(Color.WHITE);

        dr_name = new HBox(dr, name);
        HBox.setHgrow(dr_name,Priority.ALWAYS);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        primary_layout = new StackPane();

        rec1 =  new Rectangle();
        rec1.setFill(Color.rgb(90,132,173));
        rec1.widthProperty().bind(primary_layout.widthProperty());
        rec1.heightProperty().bind(primary_layout.heightProperty());

        primary_layout.getChildren().addAll(rec1,about,main_menu,Date,dr_name,inquire);

        StackPane.setAlignment(about,Pos.TOP_LEFT);
        StackPane.setMargin(about,new Insets(10,0,0,10));

        StackPane.setAlignment(main_menu,Pos.TOP_RIGHT);
        StackPane.setMargin(main_menu,new Insets(10,10,0,0));

        StackPane.setAlignment(inquire,Pos.CENTER);
        StackPane.setMargin(inquire,new Insets(0,0,0,0));

        StackPane.setAlignment(Date,Pos.TOP_LEFT);
        StackPane.setMargin(Date,new Insets(750,0,0,15));

        StackPane.setAlignment(dr_name,Pos.CENTER);
        StackPane.setMargin(dr_name,new Insets(100,0,0,650));


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout,Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);
        stage.show();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        about.setOnAction(e->{

            TeqniqalSupport teqniqalSupport = new TeqniqalSupport(stage);

        });

        inquire.setOnAction(e->{

            Inquirers inquirers = new Inquirers(stage);

        });

    }
}



/*
package GUI.pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMenu {
    public Stage stage = new Stage();
    public Scene scene = null ;

    StackPane primary_layout = null ;
    Rectangle rec1 = null ;
    HBox top = null ;
    Button about = null ;
    Label main_menu = null ;
    HBox dr_name = null ;
    Label dr = null ;
    Label name = null ;
    Rectangle rec2 = null ;
    HBox content = null ;
    Button inquire = null ;
    Label Date = null ;

    java.util.Date timeDate = null;
    SimpleDateFormat simpleDateFormat = null ;

    public MainMenu(Stage stage){

        timeDate = new Date();
        simpleDateFormat = new SimpleDateFormat(" Y - M - d ");
        String s = simpleDateFormat.format(timeDate);

        Date = new Label(s);
        Date.setFont(new Font("Arial",35));
        Date.setTextFill(Color.WHITE);

        inquire= new Button( "الاستعلامات",  GlyphsDude.createIcon(FontAwesomeIcon.QUESTION_CIRCLE,"50")) ;
        inquire.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        inquire.setFont(new Font("Arial",30));
        inquire.setContentDisplay(ContentDisplay.TOP);
        inquire.setTextFill(Color.rgb(90,132,173));
        inquire.setDefaultButton(true);

        rec2 = new Rectangle();
        rec2.setFill(Color.rgb(30,96,137));
        rec2.setWidth(400);
        rec2.setHeight(200);

        dr_name = new HBox();
        dr = new Label("Dr.");
        dr.setFont( new Font("Arial",70) );
        dr.setTextFill( Color.rgb(30,96,137) );
        name = new Label( "Barakat shahien" );
        name.setFont( new Font("Arial",70) );
        name.setTextFill(Color.WHITE);
        dr_name = new HBox(dr, name);
        dr_name.setMaxHeight(70);
        dr_name.setMaxWidth(600);
        HBox.setHgrow(dr_name,Priority.ALWAYS);

        main_menu = new Label("القائمة الرئيسية");
        main_menu.setFont(new Font("Arial",60));
        main_menu.setTextFill(Color.WHITE);

        about = new Button("الدعم التقني",GlyphsDude.createIcon(FontAwesomeIcon.SUPPORT,"30" ));
        about.setFont(new Font("Arial",20));
        about.setContentDisplay(ContentDisplay.TOP);
        about.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY,Insets.EMPTY)));
        about.setTextFill(Color.WHITE);


        primary_layout = new StackPane();

        rec1 =  new Rectangle();
        rec1.setFill(Color.rgb(90,132,173));
        rec1.widthProperty().bind(primary_layout.widthProperty());
        rec1.heightProperty().bind(primary_layout.heightProperty());

        primary_layout.getChildren().addAll(rec1,dr_name,rec2,inquire,Date,about,main_menu);
        primary_layout.setMaxWidth(stage.getWidth());
        primary_layout.setMaxHeight(stage.getHeight());
        StackPane.setAlignment(main_menu, Pos.TOP_RIGHT);
        StackPane.setAlignment(about, Pos.TOP_LEFT);

        StackPane.setAlignment(dr_name,Pos.CENTER);
        StackPane.setMargin(dr_name,new Insets(0,0,500,0));

        StackPane.setAlignment(rec2,Pos.CENTER);
        StackPane.setAlignment(inquire, Pos.CENTER);

        StackPane.setAlignment(Date,Pos.BOTTOM_LEFT);

        scene = new Scene(primary_layout,stage.getWidth(),stage.getHeight());
        stage.setScene(scene);
//        stage.setFullScreenExitHint("");
//        stage.setFullScreen(true);
        stage.show();
        about.setOnAction(e->{
            TeqniqalSupport teqniqalSupport = new TeqniqalSupport(stage);
        });
        inquire.setOnAction(e->{
            Inquirers inquirers = new Inquirers(stage);

        });


    }

}*/
