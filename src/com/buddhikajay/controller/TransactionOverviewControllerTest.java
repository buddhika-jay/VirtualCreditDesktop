package com.buddhikajay.controller;

import com.buddhikajay.SqliteDatabase;
import com.buddhikajay.model.TableTransaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionOverviewControllerTest {
    final String dbUrl = "C://Users//Buddhika//Documents//Programming//IdeaProjects//VirtualCreditDesktop//database//test.sqlite";

    TransactionOverviewController toControl;
    @Before
    public void setup(){
        toControl = new TransactionOverviewController();
    }
    @Test
    public void testGetAllTransactionsFromDatabase() throws Exception {
        SqliteDatabase database = new SqliteDatabase(dbUrl);
        toControl.setDatabase(database);
        toControl.setGET_ALL_TRANSACTIONS("SELECT * FROM tran");
        //TableTransaction tableTransaction =  new TableTransaction(1, "1", 1, "1", "1", "1", "1");//int id, String person, float amount, String type, String date, String resolved, String description
        assertEquals(2, toControl.getAllTransactionsFromDatabase().get(0).getId());
    }
}