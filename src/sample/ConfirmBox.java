package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

/**
 * Created by wojciech.misiak on 4/24/2017.
 */
public class ConfirmBox {
    public static Boolean display(String message) {
        Alert alert = new Alert(CONFIRMATION);
       // alert.setTitle("");
        alert.setHeaderText(message);
        //alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
                    } else {
            return false;
                    }
    }
}
