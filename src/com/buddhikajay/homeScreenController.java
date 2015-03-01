package com.buddhikajay;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Created by Buddhika Jayawardhana on 27/02/2015.
 * JavaFx
 */
public class homeScreenController extends Application{
    public TableView reportTable;
    public TableColumn idColumn;
    public TableColumn typeColumn;
    public TableColumn amountColumn;
    public TableColumn personColumn;
    public TableColumn dateColumn;
    public TableColumn descriptionColumn;
    public TableColumn resolvedColumn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        primaryStage.setTitle("Virtual Credit");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

        //idColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("id"));
        /*
        typeColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction,String>("type"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("amount"));
        personColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("person"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("description"));
        resolvedColumn.setCellValueFactory(new PropertyValueFactory<TableTransaction, String>("resolved"));
       */
    }
    public static void main(String args[]){
        Application.launch();
    }
}

