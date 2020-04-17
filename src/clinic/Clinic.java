package clinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Clinic extends Application {

    static private Resizable controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(400);
        stage.setMinWidth(400);
        stage.setResizable(true);
        stage.setOpacity(0.95);
        controller = (Resizable) loader.getController();
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            if (controller != null) {
                controller.resize(oldValue, newValue);

            }
        });
    }
    
    public static void setController(Resizable newController){
        Clinic.controller = newController;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
