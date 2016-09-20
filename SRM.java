/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm;

import java.awt.Toolkit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author harry
 */
public class SRM extends Application {
    
    public static Parent root;
    public static Stage stage;
    public static Scene scene;
    public static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    @Override
    public void start(Stage nstage) throws Exception {
        stage = nstage;
        scene = new Scene(new Button("re"));
        root = FXMLLoader.load(getClass().getResource("mls/fxml/SRM.fxml"));
        scene.setRoot(root);
        stage.setMinWidth(SCREEN_WIDTH*0.6);
        stage.setMinHeight(SCREEN_HEIGHT*0.7);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
