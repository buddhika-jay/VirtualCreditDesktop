package com.buddhikajay.controller;

import com.buddhikajay.SqliteDatabase;
import com.buddhikajay.model.TableTransaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        resolvedColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("resolved"));
        personColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("person"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Float>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, Integer>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("description"));
    }

    public void setMainApp(MainApp mainApp, SqliteDatabase database){
        this.mainApp = mainApp;
        this.database = database;
        //reportTable.setItems(mainApp.getTransactions());
        this.setReportTable(this.getAllTransactionsFromDatabase());
    }

    public SqliteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SqliteDatabase database) {
        this.database = database;
    }

    public String getGET_ALL_TRANSACTIONS() {
        return GET_ALL_TRANSACTIONS;
    }

    public void setGET_ALL_TRANSACTIONS(String GET_ALL_TRANSACTIONS) {
        this.GET_ALL_TRANSACTIONS = GET_ALL_TRANSACTIONS;
    }

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
        else System.out.println("Database Returned null");

        return tableTransactions;
    }

    public void setReportTable(ObservableList<TableTransaction> transactions){
        reportTable.setItems(transactions);
    }


}
