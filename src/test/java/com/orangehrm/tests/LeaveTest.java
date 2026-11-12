package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;

public class LeaveTest extends orangebase{

	@Test
	public void leavetest() {
		
		//login();
		
		Pimleave.clickpimleave();
		
		Pimleave.clickapplayleave();
		Assert.assertTrue(Pimleave.LeaveHeadingDisplayed(),"Leave heading is not displayed");
	    System.out.println("Leave heading is displayed successfully");
		
		Pimleave.selectLeaveType();
		
		Pimleave.enterFromDate("2026-20-11");
		Pimleave.enterToDate("2027-02-12");
		Pimleave.Resonforleave("Due to fever i am applaying for this leave.This need to fail because the date excedes leave balance!");
		
		Pimleave.clickleaveapplaybuttion();
		Assert.assertTrue(Pimleave.isInsufficientLeaveDisplayed(),"Insufficient leave balance message was not displayed");
		System.out.println("Insufficient leave message was displayed successfully");
		
		
	}
	
}
