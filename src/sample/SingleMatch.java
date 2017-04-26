package sample;


import javafx.scene.control.Label;

/**
 * Created by wojciech.misiak on 4/26/2017.
 */
public class SingleMatch {
    private Label label;
    private Colors color;
    private MatchesColors match;

    public SingleMatch(Label label, Colors color) {
        this.label = label;
        this.color = color;
    }

    public SingleMatch(Label label, Colors color, MatchesColors match) {
        this.label = label;
        this.color = color;
        this.match = match;
    }


    public SingleMatch() {
        this.color = Colors.GRAY;
        this.label = new Label();
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

//    public MatchesColors getMatch() {
//        return match;
//    }
//
//    public void setMatch(MatchesColors match) {
//        this.match = match;
//    }

    public void setColorsAndBorder(Colors color, int border) {
        this.color = color;
        label.setStyle("-fx-background-color:" + color + "; -fx-border-width: " + border + "px; -fx-border-color: black;");
    }
}
