/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yw283_checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yq.wang
 */
public class Yw283_Checkerboard extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkerboard_FXML.fxml"));
        Parent root = loader.load();
        Checkerboard_FXMLController controller = loader.getController();

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        controller.start(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
