package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;
import com.orangehrm.utilities.LoginDataProvider;

public class NegativeLoginTest extends orangebase {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = LoginDataProvider.class
    )
    public void invalidLoginTest(String username, String password) {

        li.setvalues(username, password);

        li.loginClick();

        System.out.println("Testing Username: " + username);
        System.out.println("Testing Password: " + password);

        Assert.assertTrue(li.LoginErrorDisplayed(),"Login error message is not displayed");
        System.out.println("Invalid login handled successfully");
    }


    @Test
    public void FieldataRequiredTest() {

        li.setvalues("", "Wrongpassword");

        li.loginClick();

        Assert.assertTrue(
            li.EmptyFieldMessageDisplayed(),
            "Empty data error message is not displayed"
        );

        System.out.println("Empty data message handled successfully");
    }
}
