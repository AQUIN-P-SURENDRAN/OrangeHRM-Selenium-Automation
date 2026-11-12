package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class PIMFileuploadTest extends orangebase {
	
	
	@Test
	public void PimfileUploadTest() throws InterruptedException
	{
		//login();
		
		Pimfile.clickPIM();
        System.out.println("PIM opened successfully");
        
        Assert.assertTrue(Pimfile.PIMHeadingDisplayed(),"PIM heading is not displayed");
        System.out.println("PIM page is displayed successfully");
        
        Pimfile.clickConfig();
        
        Pimfile.clickDataImport();
        
        Pimfile.TitledatainportDisplayed();
        System.out.println("Data import opened successfully");
        
        Pimfile.uploadFile(System.getProperty("user.dir") + "/fileupload/importData.csv");
        Thread.sleep(5000);
        
        Assert.assertTrue(Pimfile.isFileSelected(),"CSV file was not selected successfully");
        System.out.println("CSV file selected successfully");
        
        Pimfile.clickUpload();
        System.out.println("Upload button clicked successfully");
        
        Assert.assertTrue(Pimfile.isImportResultDisplayed(), "Import result popup was not displayed");
        System.out.println("Import result popup displayed successfully");

        Pimfile.clickOkalert(); //this an html aleart 
	}

}
