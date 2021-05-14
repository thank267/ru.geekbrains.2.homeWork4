package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {

    
    /** <p>Метод вызывает диалоговое окно alert</p>
     * 
     * @param title заголовок алерта
     * @param header содержание алерта
     */
    public static void fireAlert(final String title, final String header) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();

    }

}
