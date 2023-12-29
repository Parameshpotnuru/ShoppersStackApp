package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class AddressFormPage {

	// Declaration
	@FindBy(id = "Name")
	private WebElement nameTF;
	@FindBy(id = "House/Office Info")
	private WebElement houseInfoTF;
	@FindBy(id = "Street Info")
	private WebElement streetInfoTF;
	@FindBy(id = "Landmark")
	private WebElement landmarkTF;
	@FindBy(id = "Country")
	private WebElement countryDropdown;
	@FindBy(id = "State")
	private WebElement stateDropdown;
	@FindBy(id = "City")
	private WebElement cityDropdown;
	@FindBy(id = "Pincode")
	private WebElement pincodeTF;
	@FindBy(id = "Phone Number")
	private WebElement phoneNumberTF;
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressButton;

	// Initialization
	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void addAddressDetails(WebDriverUtility web, Map<String, String> details) {
		nameTF.sendKeys(details.get("Name"));
		houseInfoTF.sendKeys(details.get("House/Office Info."));
		streetInfoTF.sendKeys(details.get("Street Info"));
		landmarkTF.sendKeys(details.get("LandMark"));

		web.selectFromDropdown(details.get("Country"), countryDropdown);
		web.selectFromDropdown(details.get("State"), stateDropdown);
		web.selectFromDropdown(details.get("City"), cityDropdown);

		pincodeTF.sendKeys(details.get("Pincode"));
		phoneNumberTF.sendKeys(details.get("Phone Number"));
		addAddressButton.click();
	}
}
