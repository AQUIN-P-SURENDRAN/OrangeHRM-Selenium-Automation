package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class DeleteEmployeeTest extends orangebase {

	@Test
	public void DeleteEmploye()
	{
		String empname="Bjiorn";
		//login();
		
		dashboard.clickPIM();
    	System.out.println("PIM opened successfully for name search");
    	
    	pim.openEmplist();
    	pim.searchByEmpNamedelete(empname);
    	Assert.assertTrue(pim.isDeleteRecordFound(),"Employee deletion success message was not displayed");
    	
    	pim.clickDeleteButton();
    	pim.confirmDelete();
    	System.out.println("Employee deleted successfully");
	}
}
