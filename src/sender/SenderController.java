package sender;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.AlertUtil;

public class SenderController {

    private static int countRepeatMessages = 1;
    private static String lastMessage = "";

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    /**
     * <p>
     * Метод отправляет сообщение
     * </p>
     */
    public void sendMsg() {

        String textFieldText = textField.getText();

        if (assertMessage(textFieldText)) {

            textArea.appendText(textFieldText + "\n");
            textField.clear();

        }

        textField.requestFocus();

    }

    /**
     * <p>
     * Метод проверяет отправляемое сообщение на предмет пустоты и количества
     * отправляемых подряд одниковых сообщений в сответствии с константой
     * MAX_REPEAT_MESSAGES
     * </p>
     * 
     * @param message проверяемоее ообщение
     * @return boolean true валидное сообщение false нет
     */
    private boolean assertMessage(final String message) {
        if (message.trim().equals("")) {
            AlertUtil.fireAlert(Constants.EMPTY_MESSAGE_TITLE, Constants.EMPTY_MESSAGE_HEADER);
            return false;
        }
        ;
        if (message.equals(lastMessage)) {

            countRepeatMessages++;

            if (countRepeatMessages > Constants.MAX_REPEAT_MESSAGES) {

                AlertUtil.fireAlert(Constants.TOO_MATCH_MESSAGE_TITLE,
                        String.format(Constants.TOO_MATCH_MESSAGE_HEADER, message, Constants.MAX_REPEAT_MESSAGES));
                return false;
            }

        }

        else {
            lastMessage = message;
            countRepeatMessages = 1;
        }

        return true;

    }
}
