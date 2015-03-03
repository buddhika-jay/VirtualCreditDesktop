package com.buddhikajay.controller;

/**
 * Created by Buddhika Jayawardhana on 03/03/2015.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewTransactionDialogController{

    @FXML
    private TextField idTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private ComboBox<?> typeComboBox;

    @FXML
    private Button cancleButton;

    @FXML
    private TextField amountTextField;

    @FXML
    private ComboBox<?> resolvedComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<?> personComboBox;

    MainApp mainApp;

    public NewTransactionDialogController(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void okActionFired(ActionEvent event) {

    }

    @FXML
    void cancleActionFired(ActionEvent event) {

    }

    public void showNewTransactionDialog(){

        try {
            FXMLLoader loader = new FXMLLoader(NewTransactionDialogController.class.getResource("/com/buddhikajay/view/TransactionOverview.fxml"));
            AnchorPane anchorPane = (AnchorPane)loader.load();
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setTitle("Add New Transaction");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainApp.getPrimaryStage());
            stage.setScene(scene);
            stage.showAndWait();

            //set the controller
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

