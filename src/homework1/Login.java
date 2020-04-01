package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class Login extends Utility {

     String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {

        chromeBrowserDriver();
        maximizeWindow();
        implicitlyWaitSeconds(10);
        getBaseUrl(baseUrl);
    }

    @Test

    public void loginBtn() {

        clickOnElement(By.xpath("//a[@class='ico-login']"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void login() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-login']"));

        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText, actualText);
        sleepMethod();

        sendTextToElement(By.xpath("//input[@id='Email']"), ("heshvipatel17@gmail.com"));
        sleepMethod();
        sendTextToElement(By.xpath("//input[@name='Password']"), ("Abc@123"));
        sleepMethod();
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
        sleepMethod();

        String expectedLoginPage = "Welcome to our store";
        String actualLoginPage = getTextFromElement(By.xpath("//div[@class='topic-block-title']//h2[text()='Welcome to our store']"));
        Assert.assertEquals(actualLoginPage, expectedLoginPage);

        sleepMethod();
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}


