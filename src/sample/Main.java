package sample;

import GUI.pages.MainMenu;
import database.db;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import module.MediceneModule;
import java.sql.SQLException;

public class Main extends Application  {

    public static db db;
    public static MediceneModule[] mediceneModule = null;
    public static Rectangle2D rectangle2D ;

    static {
        try {
            db = new db();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Main() {}

    @Override
    public void start(Stage stage) throws Exception{


        rectangle2D = Screen.getPrimary().getBounds();
        Image image = new Image("/icon/ioio.png");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setTitle("Clinic");


        mediceneModule = db.GetMediceneModuleFromDataBase();
//        stage.setMaximized(true);
//        stage.setMinHeight(800);
//        stage.setMinWidth(1200);
        MainMenu mainMenu = new MainMenu(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
