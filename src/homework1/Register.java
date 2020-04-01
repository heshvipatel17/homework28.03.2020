package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class Register extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        maximizeWindow();
        implicitlyWaitSeconds(10);
        getBaseUrl(baseUrl);
    }

    @Test
    public void registerPage() {

        clickOnElement(By.xpath("//a[@class='ico-register']"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void Register() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-register']"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        Assert.assertEquals(expectedText, actualText);

        sleepMethod();
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), ("Jitu"));
        sendTextToElement(By.xpath("//input[@id='LastName']"), ("Patel"));
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), ("1"));
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), ("January"));
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), ("2000"));
        randomMethod(By.id("Email"));
        sendTextToElement(By.xpath("//input[@name='Company']"),("Prime Testing"));
        sendTextToElement(By.xpath("//input[@name='Password']"),("Abc@123"));
        sendTextToElement(By.xpath("//input[@name='ConfirmPassword']"),("Abc@123"));
        clickOnElement(By.xpath("//input[@name='register-button']"));
        String expectedRegText = "Your registration completed";
        String actualRegPage = getTextFromElement(By.xpath("//div[@class='page-body']//div[text()='Your registration completed']"));
        Assert.assertEquals(actualRegPage, expectedRegText);
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}


