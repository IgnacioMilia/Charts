/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Recibe un HashMap(String, Double) y representa sus valores en un gráfico.
 * 
 * @author Ignacio Milia
 */
public class Charts extends Application {
    private static Controller controller;
    private Parent root;
    private Scene scene;
    
    
    public Charts(){
        //launch();
    }
    
    @Override
    public void start(Stage stage) {
        try {
            //muestra la ventana
            root = FXMLLoader.load(getClass().getResource("Charts.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
            
        } catch (IOException ex) {
            Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public static void mostrar(){
    }

    public static void main(String[] args) {
//        controller = new Controller();
//        controller.setData();
        launch(args);
        
    }
    
}
