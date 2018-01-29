/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yw283_checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.MenuBar;

/**
 *
 * @author yq.wang
 */
public class Checkerboard_FXMLController implements Initializable {
    Checkerboard checkerboard;
    
    @FXML
    private AnchorPane pane;
    @FXML
    private MenuBar menubar;
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth = 400;
    private double boardHeight = 400;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    public void build() {
        checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        pane.getChildren().setAll(checkerboard.build());
    }
    
    public void refresh() {
        pane.getChildren().clear();
        build();
    }
    
    public void getBoardSize(Scene scene) {
        boardWidth = scene.getWidth();
        boardHeight = scene.getHeight() - menubar.getHeight();   //minus the height of menubar
    }
    
    public void start(Scene scene) {
        getBoardSize(scene);
        build();
        
        //assigns a lamba expression to a variable that is passed as a parameter
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            getBoardSize(scene);
            refresh();
        };

        scene.widthProperty().addListener(lambdaChangeListener);
        scene.heightProperty().addListener(lambdaChangeListener);
    
    }
    
    public void AssignValue() {
        numRows = checkerboard.getNumRows();
        numCols = checkerboard.getNumCols();
        boardWidth = checkerboard.getWidth();
        boardHeight = checkerboard.getHeight();
        lightColor = checkerboard.getLightColor();
        darkColor = checkerboard.getDarkColor();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    //16 x 16
    private void size16(ActionEvent event) {
        AssignValue();
        numRows = numCols = 16;
        refresh();
    }

    @FXML
    //10 x 10
    private void size10(ActionEvent event) {
        AssignValue();
        numRows = numCols = 10;
        refresh();
    }

    @FXML
    //8 x 8
    private void size8(ActionEvent event) {
        AssignValue();
        numRows = numCols = 8;
        refresh();
    }

    @FXML
    //3 x 3
    private void size3(ActionEvent event) {
        AssignValue();
        numRows = numCols = 3;
        refresh();
    }

    @FXML
    //default color
    private void colorDefault(ActionEvent event) {
        AssignValue();
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        refresh();
    }

    @FXML
    //blue color
    private void colorBlue(ActionEvent event) {
        AssignValue();
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        refresh();
    }
}
