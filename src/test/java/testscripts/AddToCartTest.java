package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {

	@Test
	public void addToCartTest() throws InterruptedException {
		Map<String, String> map = excel.getData("Sheet1", "Add to cart");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"), map.get("Password"));
		Thread.sleep(2000);
		home.mouseHoverToElectronic(webUtil);
		Thread.sleep(3000);
		home.clickHeadPhonesLink();
		headPhone.clickAddToCart();
		Thread.sleep(3000);
		Assert.assertEquals(headPhone.getAddToCartText(), "ADDED");
		String itemName = headPhone.getItemName();
		headPhone.clickCartIcon();
		Assert.assertFalse(cart.getCartItem().equalsIgnoreCase(itemName));
	}
}
