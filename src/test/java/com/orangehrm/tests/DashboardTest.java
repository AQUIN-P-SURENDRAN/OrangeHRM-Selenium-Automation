package com.orangehrm.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class DashboardTest extends orangebase {

    @Test(priority = 4)
    public void dashboardtitleverify()
    {
    	
        //login();

        Assert.assertTrue(dashboard.DashboardDisplayed(),"Dashboard heading is not displayed");
        System.out.println("Dashboard is displayed successfully");
    }
    
    @Test(priority = 5)
    public void menuitemvisible()
    {
    	//PIM 
        Assert.assertTrue(dashboard.Pimdisplayed(),"PIM menu is not displayed");
        System.out.println("PIM menu is displayed successfully");
        
        //Myinfo
        Assert.assertTrue(dashboard.Myinfodisplayed(),"My_info menu is not displayed");
        System.out.println("My_info menu is displayed successfully");
        
        //Leave
        Assert.assertTrue(dashboard.Leaveisplayed(),"Leave menu is not displayed");
        System.out.println("Leave menu is displayed successfully");
        
        //Time
        Assert.assertTrue(dashboard.Timeisplayed(),"Time menu is not displayed");
        System.out.println("Time menu is displayed successfully");
        
        //profile
        Assert.assertTrue(dashboard.Profileisplayed(),"Profile menu is not displayed");
        System.out.println("Profile menu is displayed successfully");
        
        //search
        Assert.assertTrue(dashboard.Searchisplayed(),"Search menu is not displayed");
        System.out.println("Search menu is displayed successfully");
        
        //menu items count
        Assert.assertEquals(dashboard.getMenuCount(), 12, "Menu count is incorrect");
        System.out.println("Total menu count is: " + dashboard.getMenuCount());
        
        
    }
    
    @Test(priority = 6)
    public void profileverification()
    {
    	Assert.assertTrue(dashboard.ProfilePictureDisplayed(),"Profile picture is not displayed");
    	System.out.println("Profile picture is displayed successfully");

    	Assert.assertTrue(dashboard.UsernameDisplayed(),"Username is not displayed");
    	System.out.println("Username is displayed successfully");
    	
    	dashboard.clickProfileMenu(); // Open Profile dropdown
    	  
    	Assert.assertEquals(dashboard.profileMenuCount(), 4, "Profile Menu count is incorrect");
        System.out.println("Total Profile menu count is: " + dashboard.profileMenuCount());
         
        List<String> expectedMenus = Arrays.asList(
        	    "About",
        	    "Support",
        	    "Change Password",
        	    "Logout"
        	);

        	Assert.assertEquals(
        	    dashboard.getProfileMenuTexts(),
        	    expectedMenus,
        	    "Profile menu text is incorrect"
        	);
        	System.out.println("Profile menu text verified successfully");
        
        logout();
    }
    
}
