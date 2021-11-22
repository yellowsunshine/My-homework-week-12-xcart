package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li"));
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {

        //Click on the “Shipping” link
        selectMenu("Shipping");
        //Verify the text “Shipping”
        doVerifyElements("Shipping", By.xpath("//h1[@id='page-title']"), "Shipping is not displayed correctly");
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException{
        //Click on the “New!” link
        selectMenu("New!");
        //Verify the text “New arrivals”
        doVerifyElements("New arrivals", By.xpath("//h1[@id='page-title']"), "New Arrivals is not displayed correctly");
    }

    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully() throws InterruptedException{
        //Click on the “Coming soon” link
        selectMenu("Coming soon");
        //Verify the text “Coming soon
        doVerifyElements("Coming soon", By.xpath("//h1[@id='page-title']"), "Coming soon is not displayed correctly");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException{
        //1 Click on the “Contact us” link
        selectMenu("Contact us");
        //Verify the text “Contact us
        doVerifyElements("Contact us", By.xpath("//h1[@id='page-title']"), "Contact us is not displayed correctly");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
