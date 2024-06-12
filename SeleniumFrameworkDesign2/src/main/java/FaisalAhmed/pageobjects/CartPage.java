package FaisalAhmed.pageobjects;

import java.util.List;

import FaisalAhmed.AbstractComponents.AbstractComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".heading button")
	WebElement continueShopping;
	
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean VerifyProductDisplay(String productName)
	{
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();
		return new CheckoutPage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
}


