package com.shimmerman.passwordvault;

/*
 *  Using the log4j Logger for logging errors, warnings, etc.
 */
import com.shimmerman.passwordvault.model.DataManager;
import com.shimmerman.passwordvault.model.MasterAccount;
import com.shimmerman.passwordvault.model.SecurityQuestion;
import javafx.scene.chart.PieChart;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

public class PasswordVault {

    final static Logger logger = Logger.getLogger(PasswordVault.class);

    public static void main(String[] agrs) {
        System.out.println("Hello world!");
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("username", "FAaaarr");
        System.out.println(Arrays.toString(properties.entrySet().toArray()));


        //MasterAccount masterAccount = new MasterAccount("Carl", "Handsome", null);
        SecurityQuestion securityQuestion = new SecurityQuestion("What is a Carl?", "He is a handsome.", "Carl");
        try {
            DataManager.createConnection();
            //DataManager.add(masterAccount);
            DataManager.add(securityQuestion);

            DataManager.printMasterAccountTable();
            System.out.println("\n\n");
            DataManager.printSecurityQuestionTable();

            DataManager.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
