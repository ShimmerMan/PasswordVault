package com.shimmerman.passwordvault.test.model;

import com.shimmerman.passwordvault.model.DataManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataManagerTest {
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createAndShutdownTest() {
        try {
            // Create the database
            boolean isCreated = DataManager.createConnection();
            assertTrue(isCreated, "Could not create successfully");

            // Shutdown the database
            boolean isShutdown = DataManager.shutdown();
            assertTrue(isCreated, "Could not shutdown successfully");
            
        } catch (Exception e) {
            fail("Failed because of thrown exception", e);
        }
    }

}