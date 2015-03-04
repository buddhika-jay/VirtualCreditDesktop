package com.buddhikajay.controller;
import com.buddhikajay.model.TableTransaction;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
/**
 * VirtualCreditDesktop Created by Buddhika Jayawardhana on  01/03/2015.
 */
public class TransactionOverviewController {
    private MainApp mainApp;

    private ObservableList<TableTransaction> transactions = FXCollections.observableArrayList();


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

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    public ObservableList<TableTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ObservableList<TableTransaction> transactions) {
        this.transactions = transactions;
    }


    public void setReportTable(){
        reportTable.setItems(this.transactions);
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

    public void addNewEventFired(ActionEvent actionEvent) {
        mainApp.showNewTransactionDialog();
    }

    public void editEventFired(ActionEvent actionEvent) {

    }
}
