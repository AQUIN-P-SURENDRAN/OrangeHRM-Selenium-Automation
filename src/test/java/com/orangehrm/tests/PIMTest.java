package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class PIMTest extends orangebase {

    @Test
    public void openPIMTest()
    {
    	// Store employee details once
        String empid = "3245";
        
    	
        // Login
        login();

        // Open PIM
        dashboard.clickPIM();
        System.out.println("PIM opened successfully");
        
        //PIM verification
        Assert.assertTrue(pim.PIMHeadingDisplayed(),"PIM heading is not displayed");
        System.out.println("PIM page is displayed successfully");
        
        //Open addnewemploye 
        pim.addnewemploye();
        System.out.println("Clicked to employed details opened successfull");
        Assert.assertTrue(pim.addnewemployetitleverfy(),"Add employe page is not displayed");
        System.out.println("Addemploy page is displayed successfully");
        
        //adding employe details
        pim.uploadempimage(System.getProperty("user.dir") + "/fileupload/EMPimage.jpg");
       
        pim.enterEmployeeName("Bjiorn", "D", "Poti",empid);
        pim.clickSave();
        
        //after adding employe verifitiong the personal detils page after successfuly adding the employe
      	Assert.assertEquals(pim.PersonalDetailverification(), "Personal Details");
      	System.out.println("Employe added successfull");
        
      	//search employe by id
      	pim.openEmplist();
      	pim.searchByEmployeeID(empid);
      	Assert.assertTrue(pim.employeeIDRecordDisplayed(empid),"Employee ID " + empid + " was not found");
      	
    }
    
    @Test
    public void searchEmpByName()
    {
    	
    	String empname="Nasha";
    	
    	dashboard.clickPIM();
    	System.out.println("PIM opened successfully for name search");
    	
    	pim.openEmplist();
    	pim.searchByEmployeeName(empname);
    	Assert.assertTrue(pim.employeedRecordName(empname),"Employee Name in records" + empname + " was not found");
    	Assert.fail("Testing failure screenshot capture");
   
    }
  
}

