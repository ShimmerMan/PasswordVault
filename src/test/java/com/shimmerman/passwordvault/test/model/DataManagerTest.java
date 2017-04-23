package com.shimmerman.passwordvault.test.model;

import com.shimmerman.passwordvault.model.DataManager;
import org.junit.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class DataManagerTest {


    @Test
    public void createAndShutdownTest() {
        try {
            // Create the database
            boolean isCreated = DataManager.createConnection();
            assertTrue("Could not create successfully", isCreated);

            // Shutdown the database
            boolean isShutdown = DataManager.shutdown();
            assertTrue("Could not shutdown successfully", isCreated);

        } catch (Exception e) {
            fail("Failed because of thrown exception");
            e.printStackTrace();
        }
    }

}