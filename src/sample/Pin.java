package sample;

import javafx.scene.control.Label;

/**
 * Created by wojciech.misiak on 4/25/2017.
 */
public class Pin {
    private Label label;
    private Colors color;

    public Pin(Label label, Colors color) {
        this.label = label;
        this.color = color;
    }

    public Pin() {
        this.label=new Label();
        this.color=Colors.GRAY;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setColorsAndBorder(Colors color, int border){
        this.color=color;
        label.setStyle("-fx-background-color:" + color + "; -fx-border-width: " + border+"px; -fx-border-color: black;");
    }
}
