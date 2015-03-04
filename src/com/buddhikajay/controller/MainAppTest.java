package com.buddhikajay.controller;

import com.buddhikajay.model.TableTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainAppTest {

    MainApp mainApp;
    @Before
    public void setUp() throws Exception {
        mainApp = new MainApp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddToDatabase() throws Exception {
        TableTransaction transaction = new TableTransaction(1,"Buddhika", 100, "Lend", "2015", "Yes", "Ananm manam" );
        assertEquals(true, mainApp.addToDatabase(transaction));
    }
}