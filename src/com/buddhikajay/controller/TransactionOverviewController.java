package com.buddhikajay.controller;

import com.buddhikajay.SqliteDatabase;
import com.buddhikajay.model.TableTransaction;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.SplittableRandom;

/**
 * Created by Buddhika Jayawardhana on 01/03/2015.
 */
public class TransactionOverviewController {
    private MainApp mainApp;

    private SqliteDatabase database;

    private String GET_ALL_TRANSACTIONS = "SELECT * FROM tran";

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
        //observable table columns
        resolvedColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("resolved"));
        personColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("person"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Float>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Integer>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("description"));

        reportTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//dont know what
        reportTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TableTransaction>() {
            @Override
            public void changed(ObservableValue<? extends TableTransaction> observable, TableTransaction oldValue, TableTransaction newValue) {
                /*
                Do something with new selected value
                 */
            }
        });
    }

    public void setMainApp(MainApp mainApp, SqliteDatabase database){
        this.mainApp = mainApp;
        this.database = database;
        //reportTable.setItems(mainApp.getTransactions());
        this.setReportTable(this.getAllTransactionsFromDatabase());//extracting data from the database and displaying them on the table
    }

    public SqliteDatabase getDatabase() {
        return database;
    }//retun the database

    public void setDatabase(SqliteDatabase database) {
        this.database = database;
    }

    /*returning the String query for extracting all the data that the table should display

     */
    public String getGET_ALL_TRANSACTIONS() {
        return GET_ALL_TRANSACTIONS;
    }

    public void setGET_ALL_TRANSACTIONS(String GET_ALL_TRANSACTIONS) {//set the query to extract all the data that the table should display
        this.GET_ALL_TRANSACTIONS = GET_ALL_TRANSACTIONS;
    }
    /*extracting all the data from the database that the table should display and format them.
    will return an Observable list array of table row data model.
     */
    public ObservableList<TableTransaction> getAllTransactionsFromDatabase(){
        ObservableList<TableTransaction> tableTransactions = FXCollections.observableArrayList();
        TableTransaction tempTableTransaction = new TableTransaction();
        ResultSet resultSet = null;
        try {
            database.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = database.getData(GET_ALL_TRANSACTIONS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultSet!=null){
            try {
                while (resultSet.next()){
                    tempTableTransaction.setId(Integer.parseInt(resultSet.getString("id")));
                    tempTableTransaction.setDate(resultSet.getString("date"));
                    tempTableTransaction.setAmount(Float.parseFloat(resultSet.getString("amount")));
                    tempTableTransaction.setPerson(resultSet.getString("person"));
                    tempTableTransaction.setType(resultSet.getString("type"));
                    tempTableTransaction.setResolved(resultSet.getString("resolved"));
                    tempTableTransaction.setDescription(resultSet.getString("description"));

                    tableTransactions.add(tempTableTransaction);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Result set empty");
        }

        return tableTransactions;
    }

    public void setReportTable(ObservableList<TableTransaction> transactions){
        reportTable.setItems(transactions);
    }

    /*
    Method to activate when delete button is pressed
     */
    @FXML
    public void deleteActionFired(ActionEvent actionEvent) {
        /*
        To delete
         */
        int selectedTransactionIndex = reportTable.getSelectionModel().getSelectedIndex();
        if(selectedTransactionIndex>-1){//if user selected row
            /*
            delete corresponding transaction from the list
             */
            reportTable.getItems().remove(selectedTransactionIndex);
        }
        else {//if user has not selected a row
            /*
            Show a warning dialog
             */
        }
    }
}
