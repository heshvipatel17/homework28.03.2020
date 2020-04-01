package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utility.Utility;

public class Computer extends Utility {

    private String baseUrl = "https://demo.nopcommerce.com/";
    private JavascriptExecutor js;

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        setNewPosition();
        maximizeWindow();
        implicitlyWaitSeconds(10);
        getBaseUrl(baseUrl);
    }

    @Test
    public void UserShouldNavigateToComputerPage() {
        clickOnElement(By.linkText("Computers"));
        String expectedTxt = "Computers";
        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        Assert.assertEquals(actualTxt, expectedTxt);
    }

    @Test
    public void addProductToShoppingCart() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        sleepMethod();
        clickOnElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']"));
        sleepMethod();
        javaScriptExecuter(0, -1800);
        sleepMethod();

        //element for build your own computer
        driver.findElement(By.linkText("Build your own computer")).click();
        sleepMethod();

        //to scroll the page down
        javaScriptExecuter(0, -1800);
        sleepMethod();

        //element for 400gb hdd harddriver radio button
        clickOnElement(By.id("product_attribute_3_7"));

        //element for add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));

        //element for message for add to cart
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(actualMsg, expectedMsg);
    }


    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        closeMethod();
    }
}