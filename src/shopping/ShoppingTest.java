package shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.time.chrono.ThaiBuddhistChronology;

public class ShoppingTest extends Utility {

    String baseUrl="https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker () throws InterruptedException {
        /*
        		1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Sale”  link and click
		1.3 Verify the text “Sale”
         */
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        doVerifyElements("Sale", By.xpath("//h1[@id='page-title']"), "Sale page not displayed correctly");

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Sort by:')]"));
        doClickOnElement(By.partialLinkText("Name A -"));

        //1.5 Click on “Add to cart” button of the product “Cup of Mojo Bluetooth Speaker”
        //changed to Avengers as Cup of Bluetooth Speaker cannot be found on the page
        doMouseHoverNoClick(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(2000);
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));

        // Verify the@ message “Product has been added to your cart” display in  green bar
        doVerifyElements("Product has been added to your cart", By.xpath("//li[@class='info']"), "Product has been added to your cart is not displayed");

        //1.7 Click on X sign to close the message
        doClickOnElement(By.cssSelector("a[title='Close']"));

        //Click on “Your cart” icon and Click on “View cart” button
        doClickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        doClickOnElement(By.xpath("//span[normalize-space()='View cart']"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        doVerifyElements("Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"), "Shopping cart is not displayed correctly");

        //1.10 Change the Qty = 2
        Thread.sleep(500);
        doFindElementAndClearText(By.xpath("//input[@id='amount16']"));
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='amount16' and @ name='amount']")).sendKeys("2");
        Thread.sleep(1000);

        /*
        1.11 Verify the text “Your shopping cart - 2 items”
        1.12 Verify the Subtotal $39.98
        1.13 Verify the total $46.18
         */
        Thread.sleep(2000);
        doVerifyElements("Your shopping cart - 2 items", By.xpath("//h1[@id='page-title']"), "Shopping cart is not displayed correctly");
        Thread.sleep(500);
        doVerifyElements("$29.98", By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']"), "Subtotal is not displayed correctly");
        Thread.sleep(500);
        doVerifyElements("$36.00", By.xpath("//li[@class='total']//span[@class='surcharge']"), "Total is incorrect");

        //1.14 Click on “Go to checkout” button
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));

        //Verify the text “Log in to your account”
        Thread.sleep(500);
        doVerifyElements("Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"), "Log in to your account message is not displayed correctly");

        //1.16 Enter Email address
        doSendTextToElement(By.cssSelector("#email"), doRandomEmailGenerator());//random email selection

        //1.17 Click on “Continue” Button
        doClickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));

        //1.18 Verify the text “Secure Checkout”
        doVerifyElements("Secure Checkout", By.cssSelector(".title"), "Secure Checkout Message is displayed incorrectly");

        //1.19 Fill all the mandatory fields
        doSendTextToElement(By.id("shippingaddress-firstname"), "Paul");
        doSendTextToElement(By.id("shippingaddress-lastname"), "Smith");
        doSendTextToElement(By.id("shippingaddress-street"), "1000 Abc Street");
        doSendTextToElement(By.id("shippingaddress-custom-state"), "England");
        doClickOnElement(By.id("create_profile"));
        doSendTextToElement(By.id("password"), "secret123");

        //Select the Delivery Method to “Local Shipping”
        doClickOnElement(By.id("method128"));
        Thread.sleep(500);

        //1.23 Select Payment Method “COD”
        doClickOnElement(By.id("pmethod6"));
        Thread.sleep(500);

        //Verify the total $37.03
        doVerifyElements("$37.03", By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"), "Total is displayed incorrectly");
        Thread.sleep(500);

        //Click on “Place Order” Button
        doClickOnElement(By.cssSelector("button[class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(1500);

        //1.26 Verify the text “Thank you for your order”
        doVerifyElements("Thank you for your order", By.cssSelector("#page-title"), "Thank you for your order displayed incorrectly");

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        // 1.2 Mouse hover on the “Bestseller”  link and click
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));

        //1.3 Verify the text “Bestsellers”
        Thread.sleep(500);
        doVerifyElements("Bestsellers", By.xpath("//h1[@id='page-title']"), "Bestsellers is not displayed correctly");

        //	1.4 Mouse hover on “Sort By” and select “Name A-Z”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Sort by:')]"));
        doClickOnElement(By.partialLinkText("Name A -"));

        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        doMouseHoverNoClick(By.cssSelector(" .product.productid-13"));
        Thread.sleep(1000);
        doClickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']/span[1]"));

        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        doVerifyElements("Product has been added to your cart", By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product added - displayed incorrectly");

        //1.7 Click on X sign to close the message
        Thread.sleep(500);
        doClickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(500);
        doClickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(500);
        doClickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(500);
        doVerifyElements("Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"), "1 Product is not add into the cart");

        //1.10 Click on “Empty your cart” link
        Thread.sleep(500);
        doClickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        //String alert = driver.switchTo().alert().getText();
        String alert = doGetTextFromAlert();
        String expectedAlert = "Are you sure you want to clear your cart?";
        Assert.assertEquals("Alert Message is incorrect", expectedAlert, alert);
        Thread.sleep(500);

        //1.12 Click “Ok” on alert
        doAcceptAlert();
        Thread.sleep(2000);

        //1.13 Verify the message “Item(s) deleted from your cart”
        doVerifyElements("Item(s) deleted from your cart", By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"), "item is not deleted");
        Thread.sleep(500);

        //1.14 Verify the text “Your cart is empty”
        doVerifyElements("Your cart is empty", By.xpath("//h1[normalize-space()='Your cart is empty']"), "your cart is not empty");
    }

    public void tearDown(){
        closeBrowser();
    }

}
