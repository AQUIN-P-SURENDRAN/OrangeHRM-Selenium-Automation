package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class LogoutTest extends orangebase {

    @Test
    public void logoutTest()
    {

        // Open Profile menu
        dashboard.clickProfileMenu();


        // Verify Logout option
        Assert.assertTrue(
            dashboard.LogoutDisplayed(),
            "Logout option is not displayed"
        );

        System.out.println("Logout option is displayed successfully");


        // Click Logout
        dashboard.ClickLogout();
        System.out.println("Logout clicked successfully");
        
        //verifying login page is displayed after successfull logout
        Assert.assertTrue(li.LoginPageDisplayed(),"Login page is not displayed after logout");
        System.out.println("Login page displayed successfully after logout");
    }
}