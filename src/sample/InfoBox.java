package sample;

import javafx.scene.control.Alert;

/**
 * Created by wojciech.misiak on 4/27/2017.
 */
public class InfoBox {
    static void display(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    static void display(String message, String additionalMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        alert.setContentText(additionalMessage);
        alert.showAndWait();
    }

}
