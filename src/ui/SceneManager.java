package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public final class SceneManager {

    public static void loadScene(String resourcePath) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource(resourcePath));
            Main.window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class Scenes {
        public static final String Main = "main.fxml";
        public static final String BeforeFight = "before_fight.fxml";
        public static final String Fight = "fight.fxml";
    }
}
