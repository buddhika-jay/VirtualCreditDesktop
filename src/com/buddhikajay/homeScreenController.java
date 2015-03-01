package com.buddhikajay;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Created by Buddhika Jayawardhana on 27/02/2015.
 */
public class homeScreenController extends Application{

    @FXML
    public Button deleteButton;
    @FXML
    public Button addNewButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button editButton;
    @FXML
    public TableView reportTable;
    @FXML
    public TableColumn personColumn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        primaryStage.setTitle("Virtual Credit");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

    }

}

