package com.guru99.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.account.AccountPage;
import com.guru99.base.BaseTestClass;
import com.guru99.home.HomePage;
import com.guru99.tv.TVPage;
import com.guru99.utility.EmailGenerator;

public class TestCase5 extends BaseTestClass {
	
	/*
	 * Go to http://live.guru99.com/. 
	 * click on my account link. 
	 * click on create account link and fill New user information expect email id. 
	 * click register.
	 * verify registration is done. 
	 * go to TV menu. 
	 * Add product in your wish list.
	 * click Share wishlist. 
	 * In next page enter email and a message and click share Wishlist.
	 * check wishlist is shared.
	 */
	
	
	HomePage objhp;
	AccountPage objap;
	TVPage objtp;
	
	String randomString = EmailGenerator.getRandomString(3);
	
	@DataProvider(name = "userDetailsWithEmail")
	public Object[][] userWithEmail() {
		return new Object[][] 
			{ 
			    { "test", "t", "one", randomString +"@test.in", "test123", "test123" } 
			};

	}

	@DataProvider(name = "userDetailsWithoutEmail")
	public Object[][] userWithoutEmail(){
		return new Object[][]
		   {
			  { "test", "t", "two", "test123", "test123" }
		   };
		
	}
	
	@Test(priority = 1, dataProvider = "userDetailsWithEmail")
	public void testCase5_createUserWithEmail(String fName, String mName, String lName, String email, String pswd, String confPswd) throws InterruptedException {
		objhp = new HomePage(driver);
		objhp.clickMyAccountLink();
		Reporter.log("Clicked on My Account link", true);
		objap = new AccountPage(driver);
		objap.clickCreateAccountButton();
		Reporter.log("Clicked on Create an Account button", true);
		objap.registerWithEmailId(fName, mName, lName, email, pswd, confPswd);
		Assert.assertEquals(objap.verifyRegistrationWithEmail(), "Thank you for registering with Main Website Store.");
		Reporter.log("Registration is sucesfull with all the required fields.");
		objhp.clickOnTVmenu();
		Reporter.log("Clicked on the TV menu", true);
		objtp = new TVPage(driver);
		objtp.addLGtoWishList();
		Reporter.log("LG LCD added to wishlist successfully..", true);
		objtp.shareWishList();
		Reporter.log("Clicked on share wishlist button.", true);
		objtp.enterShareEmailAddress(randomString+ "@test.in");
		Reporter.log("Entered the email address to be shared the wishlist.", true);
		objtp.enterShareMessage("blah blah..");
		Reporter.log("Entered the message to be shared the wishlist.", true);
		objtp.shareFinalWishlist();
		Reporter.log("Email, Message entered and the wishlist is shared..", true);
		Assert.assertEquals(objtp.verifyMessageAfterSharingWishlist(), "Your Wishlist has been shared.");
		Reporter.log("Wishlist is shared successfully & the verification is done.", true);
	}
}
