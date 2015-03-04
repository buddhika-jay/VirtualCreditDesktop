package com.buddhikajay.controller;

import com.buddhikajay.SqliteDatabase;
import com.buddhikajay.library.PersonGeneric;
import com.buddhikajay.model.TableTransaction;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Buddhika Jayawardhana on 01/03/2015.
 */
public class MainApp extends Application{

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<TableTransaction> transactions = FXCollections.observableArrayList();
    private ObservableList<PersonGeneric> persons;
    private SqliteDatabase database;
    private NewTransactionDialogController newTransactionDialogController;
    /*
    Url of the sqlite database
     */
    final String DB_URL = "C://Users//Buddhika//Documents//Programming//IdeaProjects//VirtualCreditDesktop//database//test.sqlite";
    private String GET_ALL_TRANSACTIONS = "SELECT * FROM tran";

    public MainApp(){
        //creates test dataset for transactionOverview controller
        transactions.add(new TableTransaction(1,"Buddhika", 100, "Lend", "2015", "Yes", "Ananm manam" ));//int id, String person, float amount, String type, String date, String resolved, String description
        database = new SqliteDatabase(DB_URL);
        setTransacions();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Virtual Credit");
        try{
            //loads a Border pane.
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/buddhikajay/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        showTransactionOverview();

    }

    /*
    Getters and Setters
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    public void setTransactions(ObservableList<TableTransaction> transactions) {
        this.transactions = transactions;
    }

    public ObservableList<PersonGeneric> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<PersonGeneric> persons) {
        this.persons = persons;
    }
    /*
    loads the table and other componets and sets it on the center of borderpane.
     */
    public void showTransactionOverview(){
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/buddhikajay/view/TransactionOverview.fxml"));
            AnchorPane overviewPage = loader.load();
            rootLayout.setCenter(overviewPage);
            TransactionOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setTransactions(this.transactions);
            controller.setReportTable();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showNewTransactionDialog(){
        this.newTransactionDialogController = new NewTransactionDialogController();
        newTransactionDialogController.setMainApp(this);
        newTransactionDialogController.showNewTransactionDialog();
    }
    /*extracting all the data from the database that the table should display and format them.
        will return an Observable list array of table row data model.
         */
    public void setTransacions(){
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

                    this.transactions.add(tempTableTransaction);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Result set empty");
        }

    }


    public ObservableList<TableTransaction> getTransactions() {
        return transactions;
    }
    Stage getPrimaryStage(){
        return this.primaryStage;
    }
    public static void main(String arga[]){
        Application.launch();
    }
}
