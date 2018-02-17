/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifcationexamples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import taskers.*;

/**
 * FXML Controller class
 *
 * @author dalemusser
 */
public class NotificationsUIController implements Initializable, Notifiable {

    @FXML
    private TextArea textArea;
    
    private Task1 task1;
    private Task2 task2;
    private Task3 task3;
    @FXML
    private Button task1_button;
    @FXML
    private Button task2_button;
    @FXML
    private Button task3_button;

    private int[] flag = {0,0,0};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (task1 != null) task1.end();
                if (task2 != null) task2.end();
                if (task3 != null) task3.end();
            }
        });
    }
    
    @FXML
    public void startTask1(ActionEvent event) {
        if (task1 == null) {
        	System.out.println("start task 1");
            task1 = new Task1(2147483647, 1000000);
            task1.setNotificationTarget(this);
            task1_button.textProperty().setValue("End task 1");
            task1.start();
            flag[0] = 1;
        }
        else if (flag[0] == 1){
        	System.out.println("stop task 1");
        	task1.end();
        	task1 = null;
        	task1_button.textProperty().setValue("Start Task 1");
        	flag[0] = 0;
        }
    }
    
    @Override
    public void notify(String message) {
        if (message.equals("Task1 done.")) {
            task1 = null;
            task1_button.textProperty().setValue("Start task 1");
        }
        textArea.appendText(message + "\n");
    }
    
    @FXML
    public void startTask2(ActionEvent event) {
        System.out.println("start task 2");
        if (task2 == null) {
            task2 = new Task2(2147483647, 1000000);
            task2.setOnNotification((String message) -> {
                textArea.appendText(message + "\n");
                if (message.equals("Task2 done.")){
                	task2_button.textProperty().setValue("Start Task 2");
                }
            });
            task2_button.textProperty().setValue("End task 2");
            task2.start();
            flag[1] = 1;
        }       
        else if (flag[1] == 1){
        	System.out.println("stop task 2");
        	task2.end();
        	task2 = null;
        	task2_button.textProperty().setValue("Start Task 2");
        	flag[1] = 0;
        } 
    }
    
    @FXML
    public void startTask3(ActionEvent event) {
        System.out.println("start task 3");
        if (task3 == null) {
            task3 = new Task3(2147483647, 1000000);
            // this uses a property change listener to get messages
            task3.addPropertyChangeListener((PropertyChangeEvent evt) -> {
                String message = (String)evt.getNewValue();
                textArea.appendText(message + "\n");
                if (message.equals("Task3 done.")){
                	task3_button.textProperty().setValue("Start Task 3");
                }
            });
            task3_button.textProperty().setValue("End task 3");
            task3.start();
            flag[2] = 1;
        }
        else if (flag[2] == 1){
        	System.out.println("stop task 3");
        	task3.end();
        	task3 = null;
        	task3_button.textProperty().setValue("Start Task 3");
        	flag[2] = 0;
        }
    } 
}
