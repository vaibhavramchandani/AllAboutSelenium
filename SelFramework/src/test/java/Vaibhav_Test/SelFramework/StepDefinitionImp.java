package Vaibhav_Test.SelFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseTest {

	public LandingPage landingpage;
	public ProductCatlogue productcat;
	public OrderConfirmation orderConfirm;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingpage = launchApplication();
		//code
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void login_with_username_and_password(String username,String password)
	{
		productcat = firstpage.loginApplication(username,password);

	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productname) {
		List<WebElement> products = productcat.getList();
		productcat.addProductToCart(productname);
	}
	

    @When("^Checkout(.+) and submit the order$")
    public void i_checkout_and_submit(String productname) throws InterruptedException
    {
    	CartPage cart = productcat.goToCartPage();
		CheckoutPage checkout = cart.checkCartList(productname);
		String country = "ind";
		checkout.selectcountry(country);
		orderConfirm = checkout.goToOrderConfirmation();
    }
	
    @Then("(string) message is displayed on ConfirmationPage")
    public void message_dispayed_confirmation(String string)
    {
    	String message = orderConfirm.getmessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
    }
    
	
}
