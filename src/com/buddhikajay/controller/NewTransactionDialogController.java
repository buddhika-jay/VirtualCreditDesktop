package com.buddhikajay.controller;

/**
 * Created by Buddhika Jayawardhana on 03/03/2015.
 */



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewTransactionDialogController {
    private MainApp mainApp;
    @FXML
    private TextField idTextField;

    @FXML
    private Button addButton;

    @FXML
    void addEventFired(ActionEvent event) {

    }

    NewTransactionDialogController(MainApp mainApp){
        this.mainApp = mainApp;
    }

    public void showNewTransactionDialog(){
        try {
            FXMLLoader loader = new FXMLLoader(NewTransactionDialogController.class.getResource("/com/buddhikajay/view/NewTransactionDialogController.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

