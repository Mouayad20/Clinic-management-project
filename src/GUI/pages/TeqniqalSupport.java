package GUI.pages;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import sample.Main;

public class TeqniqalSupport {
    public Scene scene = null;

    StackPane primary_layout = null ;
        Rectangle rec = null ;
        Label teqniqal = null ;
        Button back = null ;
        VBox layout = null ;
            VBox v1 = null ;
                Label name1 = null;
                Label ename1 = null;
                Label mob1 = null;
                Label gmail1 = null;
            VBox v2 = null ;
                Label name2 = null;
                Label ename2 = null;
                Label mob2 = null;
                Label gmail2 = null;

    public TeqniqalSupport(Stage stage) {

        primary_layout = new StackPane();

        rec =  new Rectangle();
        rec.setFill(Color.rgb(90,132,173));
        rec.widthProperty().bind(primary_layout.widthProperty());
        rec.heightProperty().bind(primary_layout.heightProperty());

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        teqniqal = new Label("للدعم التقني يرجى التواصل");
        teqniqal.setFont(new Font("arial",60));
        teqniqal.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back = new Button("الرجوع ", GlyphsDude.createIcon(FontAwesomeIcon.BACKWARD,"30"));
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY)));
        back.setFont(new Font("Arial",25));
        back.setContentDisplay(ContentDisplay.TOP);
        back.setTextFill(Color.WHITE);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name1 = new Label("mahmood shamieh", GlyphsDude.createIcon(FontAwesomeIcon.USER,"30"));
        name1.setFont(new Font("arial",30));
        name1.setTextFill( Color.WHITE );
        name1.setContentDisplay(ContentDisplay.RIGHT);
        name1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        ename1 = new Label("محمود شاميه", GlyphsDude.createIcon(FontAwesomeIcon.USER,"30"));
        ename1.setFont(new Font("arial",30));
        ename1.setTextFill( Color.WHITE );
        ename1.setContentDisplay(ContentDisplay.RIGHT);
        ename1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        mob1 = new Label("0945861450",GlyphsDude.createIcon(FontAwesomeIcon.WHATSAPP,"30"));
        mob1.setFont(new Font("arial",30));
        mob1.setTextFill( Color.WHITE );
        mob1.setContentDisplay(ContentDisplay.RIGHT);
        mob1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        gmail1 = new Label("mahmoodshamiehh2000@gmail.com",GlyphsDude.createIcon(FontAwesomeIcon.GOOGLE,"30"));
        gmail1.setFont(new Font("arial",30));
        gmail1.setTextFill(Color.WHITE);
        gmail1.setContentDisplay(ContentDisplay.RIGHT);
        gmail1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        v1 = new VBox(name1,ename1,mob1,gmail1);
        VBox.setMargin(name1,new Insets(0,0,0,250));
        VBox.setMargin(ename1,new Insets(0,0,0,250));
        VBox.setMargin(mob1,new Insets(0,0,0,250));
        VBox.setMargin(gmail1,new Insets(0,0,0,250));
        v1.setSpacing(20);
        //v1.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));
        v1.setPrefSize(500,300);
        v1.setStyle("-fx-border-width: 0 0 10 0; -fx-border-color: red white white red;");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        name2 = new Label("mouayad kadora", GlyphsDude.createIcon(FontAwesomeIcon.USER,"30"));
        name2.setFont(new Font("arial",30));
        name2.setTextFill( Color.WHITE );
        name2.setContentDisplay(ContentDisplay.RIGHT);
        name2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        ename2 = new Label("مؤيد قدورة", GlyphsDude.createIcon(FontAwesomeIcon.USER,"30"));
        ename2.setFont(new Font("arial",30));
        ename2.setTextFill(Color.WHITE);
        ename2.setContentDisplay(ContentDisplay.RIGHT);
        ename2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        mob2 = new Label("0958739946", GlyphsDude.createIcon(FontAwesomeIcon.WHATSAPP,"30"));
        mob2.setFont(new Font("arial",30));
        mob2.setTextFill( Color.WHITE );
        mob2.setContentDisplay(ContentDisplay.RIGHT);
        mob2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        gmail2 = new Label("moukad18@gmail.com", GlyphsDude.createIcon(FontAwesomeIcon.GOOGLE,"30"));
        gmail2.setFont(new Font("arial",30));
        gmail2.setTextFill( Color.WHITE );
        gmail2.setContentDisplay(ContentDisplay.RIGHT);
        gmail2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        v2 = new VBox(name2,ename2,mob2,gmail2);
        v2.setSpacing(20);
        //v2.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY,Insets.EMPTY)));



        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        primary_layout.getChildren().addAll( rec , teqniqal , back , v1 , v2 );

        StackPane.setAlignment(teqniqal, Pos.TOP_CENTER);
        StackPane.setMargin(teqniqal,new Insets(50,0,0,0));

        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back,new Insets(10,0,0,10));

        StackPane.setAlignment(v1, Pos.CENTER);
        StackPane.setMargin(v1,new Insets(300,350,550,375));

        StackPane.setAlignment(v2, Pos.CENTER);
        StackPane.setMargin(v2,new Insets(400,200,100,625));

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        scene = new Scene(primary_layout, Main.rectangle2D.getWidth(),Main.rectangle2D.getHeight()-20);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        back.setOnAction(e->{

            MainMenu mainMenu = new MainMenu(stage);

        });
        
    }
}
