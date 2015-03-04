package com.buddhikajay.controller;

/**
 * Created by Buddhika Jayawardhana on 03/03/2015.
 */

import com.buddhikajay.model.TableTransaction;
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

    MainApp mainApp;
    Stage stage;
    Scene scene;
    TableTransaction transaction;
    AnchorPane anchorPane;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private Button cancleButton;

    @FXML
    private TextField amountTextField;

    @FXML
    private ComboBox<String> resolvedComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<String> personComboBox;

    @FXML
    public void okActionFired(ActionEvent event) {
        transaction = new TableTransaction();
        transaction.setDate(dateTextField.getText());
        transaction.setAmount(Float.parseFloat(amountTextField.getText()));
    }

    @FXML
    public void cancleActionFired(ActionEvent event) {
        this.stage.close();
    }

    public NewTransactionDialogController(){}

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showNewTransactionDialog(){

        try {
            FXMLLoader loader = new FXMLLoader(NewTransactionDialogController.class.getResource("/com/buddhikajay/view/NewTransactionDialog.fxml"));//("/com/buddhikajay/view/NewTransactionDialog.fxml"));
            anchorPane = (AnchorPane)loader.load();
            scene = new Scene(anchorPane);
            stage = new Stage();
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

