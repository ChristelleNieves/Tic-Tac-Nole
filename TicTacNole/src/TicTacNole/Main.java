// Name: Christelle Nieves
// Program Name: Tic Tac Nole
// Description: A simple Tic Tac Toe game built with JavaFX.

package TicTacNole;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.EventListener;

public class Main extends Application implements EventListener {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Nole");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
