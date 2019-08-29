package core.pages;

import java.util.Map;

import agent.IAgent;
import central.Configuration;

public class HomePage extends FullPage {

	public HomePage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}

	/**
	 * Change Password for Registered account
	 * @throws Exception
	 */
	public void changePassword() throws Exception {
		getControl("myProfile").waitUntilClickable();
		getControl("myProfile").click();
		getControl("changePassWordBtn").click();
		getControl("oldPasswordTextBox").click();
		getControl("oldPasswordTextBox").enterText(testData.get("password"));
		getControl("newPasswordTextBox").enterText(testData.get("password"));
		getControl("saveProfileBtn").click();
		getControl("passwordUpdateMsg").waitUntilVisible();
		sftAssert.assertEquals(getControl("passwordUpdateMsg","isVisible"), true);
		sftAssert.assertAll();
	}

	/**
	 * Add Product to cart
	 * @throws Exception
	 */
	public void addToCart() throws Exception {
		goBack();
		getControl("searchFor").click();
		getControl("searchTxtBox").enterText(testData.get("searchFor"));
		getControl("searchSuggestion").click();
		getControl("selectItem").click();
		waitForElementToBeLoaded(10);
		try {
			getControl("addToCartBtn").click();
		} catch (Exception e) {
			goBack();
			getControl("selectItem").click();
			getControl("addToCartBtn").click();
		}
		getControl("selectSmall").click();
		try {
			if (getControl("getNotifiedTxt", "isVisible")) {
				goBack();
				getControl("selectMedium").click();
			}
		} catch (Exception e) {
		}
		getControl("activeCart").click();
		sftAssert.assertEquals(getControl("verifyContinueToCheckOutBtn", "isVisible"), true);
		sftAssert.assertAll();
	}

	/**
	 * Price sort Filter function
	 * @throws Exception
	 */
	public void sortByPriceLowToHigh() throws Exception {
		goBack();
		getControl("searchFor").click();
		getControl("searchTxtBox").enterText(testData.get("searchFor"));
		getControl("searchSuggestion").click();
		getControl("sortBtn").click();
		getControl("sortPriceLowToHigh").click();
		sftAssert.assertEquals(getControl("selectItem", "isVisible"), true);
		sftAssert.assertAll();

	}
}
