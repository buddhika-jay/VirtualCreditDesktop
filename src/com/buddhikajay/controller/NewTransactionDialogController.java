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
    void okActionFired(ActionEvent event) {

    }

    @FXML
    void cancleActionFired(ActionEvent event) {

    }

    @FXML
    public void initialize(){}
    NewTransactionDialogController(){}

}

