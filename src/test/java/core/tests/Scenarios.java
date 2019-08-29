package core.tests;

import org.testng.annotations.Test;

public class Scenarios extends SupportTest {

	@Test(enabled = true, priority = 1, description = "Validating login feature")
	public void TC_01_ValidateSuccessfulLogin() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Login into Application and verify My Profile"));
		loginPage.Login();
		logger.debug(this.getTestEndInfoMessage("Login into Application and verify My Profile "));
	}

	@Test(enabled = true, priority = 2, description = "Validating Edit profile")
	public void TC_02_EditProfileChangePassword() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Edit Profile Change Password"));
		loginPage.Login();
		homePage.changePassword();
		logger.debug(this.getTestEndInfoMessage("Edit Profile Change Password"));
	}

	@Test(enabled = true, priority = 3, description = "Validating select item and add to cart ")
	public void TC_03_AddToCart() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Search and select item and AddToCarT"));
		loginPage.Login();
		homePage.addToCart();
		logger.debug(this.getTestEndInfoMessage("search and select item and AddToCarT"));
	}

	@Test(enabled = true, priority = 4, description = "Checking price filter feature")
	public void TC_04_ApplyPriceFilter() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Apply Filter Price (Low to High)"));
		loginPage.Login();
		homePage.sortByPriceLowToHigh();
		logger.debug(this.getTestEndInfoMessage("Apply Filter Price (Low to High)"));
	}
}
