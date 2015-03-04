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
}