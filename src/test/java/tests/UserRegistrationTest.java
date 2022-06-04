package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	
	@Test
	public void UserCanRegisterSuccessfully () {
		
		homeObject = new HomePage (driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Nada", "Hussein", "nada11@123.com", "102030");	
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

}
