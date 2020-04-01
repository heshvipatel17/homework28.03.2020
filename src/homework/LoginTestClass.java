package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTestClass extends Utility {

     String baseUrl = "https://demo.nopcommerce.com/";

    //  private WebDriver driver;

    @Before
    public void openBrowser() {

//      System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//      driver = new ChromeDriver();
        chromeBrowserDriver();

//      driver.manage().window().maximize();
        maximizeWindow();

//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        implicitlyWaitSeconds(10);

//      driver.get(baseUrl);
        getBaseUrl(baseUrl);

    }

    @Test

    public void loginBtn() {
//      WebElement clickLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
//      clickLogin.click();
        clickOnElement(By.xpath("//a[@class='ico-login']"));

//      WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void login() throws InterruptedException {

//      WebElement clickLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
//      clickLogin.click();
        clickOnElement(By.xpath("//a[@class='ico-login']"));

//      WebElement welcomeText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text()='Welcome, Please Sign In!']"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedText, actualText);

//      Thread.sleep(2000);
        sleepMethod();

//      WebElement enterEmail = driver.findElement(By.xpath("//input[@id='Email']"));
//      enterEmail.sendKeys("heshvipatel17@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Email']"), ("heshvipatel17@gmail.com"));

//      WebElement enterPassword = driver.findElement(By.xpath("//input[@name='Password']"));
//      enterPassword.sendKeys("Abc@123");
        sendTextToElement(By.xpath("//input[@name='Password']"), ("Abc@123"));

//      WebElement clickLoginbtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
//      clickLoginbtn.click();
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

//      Thread.sleep(3000);
        sleepMethod();

//      WebElement loginSuccessfully = driver.findElement(By.xpath("//div[@class='topic-block-title']//h2[text()='Welcome to our store']"));
//      Thread.sleep(3000);
        sleepMethod();
        String expectedLoginPage = "Welcome to our store";
        String actualLoginPage = getTextFromElement(By.xpath("//div[@class='topic-block-title']//h2[text()='Welcome to our store']"));
        Assert.assertEquals(actualLoginPage, expectedLoginPage);

//      Thread.sleep(3000);
        sleepMethod();
    }

    @After
    public void closeBrowser() {
//      driver.quit();
        quitMethod();
    }
}


