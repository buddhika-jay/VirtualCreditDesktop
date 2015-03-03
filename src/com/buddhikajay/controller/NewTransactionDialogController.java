package com.buddhikajay.controller;

/**
 * Created by Buddhika Jayawardhana on 03/03/2015.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    @FXML
    void okActionFired(ActionEvent event) {

    }

    @FXML
    void cancleActionFired(ActionEvent event) {

    }

}

