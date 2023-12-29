package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddressFormPage;
import pomPages.CartPage;
import pomPages.HeadphonesPage;
import pomPages.HomePage;
import pomPages.MyAddressPage;
import pomPages.MyProfilePage;
import pomPages.ShopperLoginPage;
import pomPages.SignUpPage;
import pomPages.WelcomePage;

public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	public WebDriver driver;
	public static WebDriver sdriver;
	
	protected WelcomePage welcome;
	protected ShopperLoginPage login;
	protected HomePage home;
	protected SignUpPage signUp;
	protected MyProfilePage myProfile;
	protected MyAddressPage myAddress;
	protected HeadphonesPage headPhone;
	protected CartPage cart;
	protected AddressFormPage address;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
	}
	
	@BeforeMethod
	public void methodConfiguration() {
		driver = webUtil.navigateToApp(property.getData("browser"), 
				property.getData("url"), 
				Long.parseLong(property.getData("time")));
		sdriver = driver;
		
		welcome = new WelcomePage(driver);
		login = new ShopperLoginPage(driver);
		home = new HomePage(driver);
		signUp = new SignUpPage(driver);
		myProfile = new MyProfilePage(driver);
		myAddress = new MyAddressPage(driver);
		headPhone = new HeadphonesPage(driver);
		cart = new CartPage(driver);
		address = new AddressFormPage(driver);		
	}
	
	@AfterMethod
	public void methodTeardown() {
		home.clickProfileButton();
		home.clickLogout();
		webUtil.closeAllBrowsers();
	}
	
	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
	
	//@AfterTest
	//@AfterSuite
}
