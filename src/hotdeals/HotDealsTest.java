package hotdeals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //Mouse hover on hot deals link, then sale link and click
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //Verify the text "Sale"
        doVerifyElements("Sale", By.xpath("//h1[@id='page-title']"), "Sale message is not displayed");
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(500);
        //1.5 Verify that the product arrange alphabetically
        doSortDataFromElements(By.partialLinkText("Name A"));
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //Mouse hover on the “Sale”  link and click
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        //Verify the text “Sale”
        String expectedMessage1 = "Sale";
        String actualMessage1 = doGetTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User has not navigated to Sale Page + ", expectedMessage1, actualMessage1);
        // 2.4 Mouse hover on “Sort By” and select “Price Low-High”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Recommended')]"));
        // 2.5 Verify that the product’s price arrange Low to High
        doSortDataFromElements(By.partialLinkText("Price Low - Hi"));
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals”link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //3.2 Mouse hover on the “Sale”link and click
        Thread.sleep(500);
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        //3.3 Verify the text “Sale”
        String expectedMessage1 = "Sale";
        String actualMessage1 = doGetTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User has not navigated to Sale Page + ", expectedMessage1, actualMessage1);
        //3.4 Mouse hover on “Sort By”and select “Rates”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Recommended')]"));
        //3.5 Verification according to rates
        doSortDataFromElements(By.partialLinkText("Rates"));


    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        //4.1 Mouse hover on the “Hot deals”link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //4.2 Mouse hover on the “Bestsellers”link and click
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //4.3 Verify the text “Bestsellers”
        String expectedMessage2 = "Bestsellers";
        String actualMessage2 = doGetTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not on BestSellers Page + ", expectedMessage2, actualMessage2);
        //4.4 Mouse hover on “Sort By” and select “Name Z -A”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        doSortDataFromElements(By.partialLinkText("Name Z -"));
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //5.1 Mouse hover on the “Hot deals” link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        Thread.sleep(500);
        //5.2 Mouse hover on the “Bestsellers” link and click
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //5.3 Verify the text “Bestsellers”
        String expectedMessage3 = "Bestsellers";
        String actualMessage3 = doGetTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not on BestSellers Page + ", expectedMessage3, actualMessage3);
        //5.4 Mouse hover on “Sort By” and select “Price High -Low”
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        doSortDataFromElements(By.partialLinkText("Price High - L"));

    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        //6.1 Mouse hover on the “Hot deals” link
        doMouseHoverNoClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //6.2 Mouse hover on the “Bestsellers” link and click
        Thread.sleep(500);
        doMouseHoverNoClick(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        doClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        // 6.3 Verify the text “Bestsellers”
        Thread.sleep(500);
        String expectedMessage4 = "Bestsellers";
        String actualMessage4 = doGetTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not on BestSellers Page + ", expectedMessage4, actualMessage4);
        //6.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(500);
        doMouseHoverNoClick(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        doSortDataFromElements(By.partialLinkText("Rates"));
    }

    public void tearDown(){
        closeBrowser();
    }
}



