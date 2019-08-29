package core.pages;

import java.util.Map;

import agent.IAgent;
import central.Configuration;

public class LoginPage extends FullPage {

	public LoginPage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}

	/**
	 * Verify Login function with emailid
	 * @throws Exception
	 */
	public void Login() throws Exception {
		try {
			getControl("skipPopUpBtn").click();
		} catch (Exception e) {
			logger.info("Skip Pop Up not appeared");
		}
		getControl("hamburgerMenu").click();
		getControl("loginRegisterBtn").click();
		getControl("usernameTxt").enterText(testData.get("username"));
		getControl("NextBtn").click();
		getControl("passwordTxt").enterText(testData.get("password"));
		getControl("loginBtn").click();
		sftAssert.assertEquals(getControl("myProfile", "isVisible"), true);
		sftAssert.assertAll();
	}

}
