package module;

import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Main;

public class MediceneModule extends CheckBox {
    String name;
    String suffix;
    int id;
    public MediceneModule(String name , String suffix){
        super(name.trim()+"                        "+suffix.trim());
        this.name = name;
        this.suffix = suffix;
        set_style();
    }
    void set_style()
    {
        setTextFill(Color.rgb(30,96,137) );
        setFont(new Font("Arial", 25));
        setPrefSize(700, 30);
    }
    public String getName() {
        return name;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getId_custom() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setId(int id) {
        this.id = id;
    }
}
