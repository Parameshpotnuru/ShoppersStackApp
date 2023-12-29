package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
// This test verifies if user is able to add address
public class AddAddressTest extends BaseClass {

	@Test
	public void addAddressTest() throws InterruptedException {
		Map<String, String> map = excel.getData("Sheet1", "Add Address");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"), map.get("Password"));
		Thread.sleep(2000);
		home.clickProfileButton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(2000);
		myProfile.clickMyAddresses();
		myAddress.clickAddAddress();
		address.addAddressDetails(webUtil, map);
		Thread.sleep(2000);
		Assert.assertEquals(myAddress.getSuccessMessage(),"successfully added");
		Thread.sleep(5000);
	}
}
