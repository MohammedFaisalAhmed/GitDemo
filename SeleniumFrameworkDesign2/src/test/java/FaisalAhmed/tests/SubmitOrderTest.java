package FaisalAhmed.tests;


import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Faisal.TestComponents.BaseTest;
import FaisalAhmed.pageobjects.CartPage;
import FaisalAhmed.pageobjects.CheckoutPage;
import FaisalAhmed.pageobjects.ConfirmationPage;
import FaisalAhmed.pageobjects.LandingPage;
import FaisalAhmed.pageobjects.OrderPage;
import FaisalAhmed.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;




public class SubmitOrderTest extends BaseTest{
	
	//String productName = "ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"Purchase"} )

		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
		
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();
	
        Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage  = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
 
	}
		
		//@Test(dependsOnMethods = {"submitOrder"})
		@Test
		
		public void orderHistoryTest(String productName)
		{
			ProductCatalogue productCatalogue = landingPage.loginApplication("Faisal1@gmail.com","Gmail123456@");
			OrderPage orderPage = productCatalogue.goToOrderPage();
			
			Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
			
	
			
		}
		
		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			/*
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "Faisal@gmail.com");
			map.put("password", "Gmail12345@");
			map.put("productName", "ZARA COAT 3");
			
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email", "Faisal1@gmail.com");
			map1.put("password", "Gmail123456@");
			map1.put("productName", "ADIDAS ORIGINAL");
			*/
			
			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\fais\\data\\PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
			
			
			
		}
		}
		
		

		




