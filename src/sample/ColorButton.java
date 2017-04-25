package sample;

import javafx.scene.control.Button;

/**
 * Created by wojciech.misiak on 4/25/2017.
 */
public class ColorButton {
    private Button button;
    private Colors color;

    public ColorButton(Button button, Colors color) {
        this.button = button;
        this.color = color;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setColorsAndBorder(Colors color, int border) {
        this.color=color;
        button.setStyle("-fx-background-color:" + color + "; -fx-border-width: " + border+"px;");
    }
}
