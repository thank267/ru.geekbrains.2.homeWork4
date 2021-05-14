
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application  {
    
    @Override
    public void start(Stage primaryStage)  throws Exception{
        Parent sender = FXMLLoader.load(getClass().getResource("sender.fxml"));
        primaryStage.setTitle("Sender");
        primaryStage.setScene(new Scene(sender, 300, 275));
        primaryStage.show();

        Parent receiver = FXMLLoader.load(getClass().getResource("receiver.fxml"));
        StackPane secondaryLayout = new StackPane(receiver);
        Stage newWindow = new Stage();
        newWindow.setTitle("Receiver");
        newWindow.setScene(new Scene(secondaryLayout, 300, 275));

        
        newWindow.setX(primaryStage.getX() + 300+300/2);
        newWindow.setY(primaryStage.getY());
        newWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
