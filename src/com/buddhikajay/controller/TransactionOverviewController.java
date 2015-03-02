package com.buddhikajay.controller;

import com.buddhikajay.model.TableTransaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.SplittableRandom;

/**
 * Created by Buddhika Jayawardhana on 01/03/2015.
 */
public class TransactionOverviewController {
    private MainApp mainApp;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;
    @FXML
    private Button addNewButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<TableTransaction> reportTable;

    @FXML
    private TableColumn<TableTransaction, String> resolvedColumn;

    @FXML
    private TableColumn<TableTransaction, String> personColumn;

    @FXML
    private TableColumn<TableTransaction, Float> amountColumn;

    @FXML
    private TableColumn<TableTransaction, String> dateColumn;

    @FXML
    private TableColumn<TableTransaction, String> typeColumn;

    @FXML
    private TableColumn<TableTransaction, Integer> idColumn;

    @FXML
    private TableColumn<TableTransaction, String> descriptionColumn;

    @FXML
    public void initialize(){
        resolvedColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("resolved"));
        personColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("person"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Float>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Integer>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("description"));
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        reportTable.setItems(mainApp.getTransactions());
    }

}
