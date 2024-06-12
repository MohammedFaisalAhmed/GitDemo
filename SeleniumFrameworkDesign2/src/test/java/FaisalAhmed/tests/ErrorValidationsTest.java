package FaisalAhmed.tests;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Faisal.TestComponents.BaseTest;
import FaisalAhmed.pageobjects.CartPage;
import FaisalAhmed.pageobjects.ProductCatalogue;




public class ErrorValidationsTest extends BaseTest{

	
		@Test(groups= {"ErrorHandling"})
		public void loginErrorValidations() throws IOException, InterruptedException
		{
		
			
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("Faisal1@gmail.com","Gmail123456@");
		Assert.assertEquals("Incorrect email or password", landingPage.getErrorMessage());
	

	}
		@Test
		public void productErrorValidations() throws IOException, InterruptedException
		{
		
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("Faisal1@gmail.com","Gmail123456@");
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
	
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);

        


	}
}



