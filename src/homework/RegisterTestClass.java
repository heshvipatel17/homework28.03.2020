package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class RegisterTestClass extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
//    private WebDriver driver;

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
    public void registerPage() {

//      WebElement clickToRegLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
//      clickToRegLink.click();
        clickOnElement(By.xpath("//a[@class='ico-register']"));

//      WebElement welcomeText = driver.findElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void Register() throws InterruptedException {

//      WebElement clickToRegLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
//      clickToRegLink.click();
        clickOnElement(By.xpath("//a[@class='ico-register']"));

//      WebElement welcomeText = driver.findElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='title']//strong[text()='Your Personal Details']"));
        Assert.assertEquals(expectedText, actualText);

//      Thread.sleep(2000);
        sleepMethod();

//      WebElement clickOnMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
//      clickOnMale.click();
        clickOnElement(By.xpath("//input[@id='gender-male']"));

//      WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
//      enterFirstName.sendKeys("Jitu");
        sendTextToElement(By.xpath("//input[@id='FirstName']"), ("Jitu"));

//      WebElement enterLastName = driver.findElement(By.xpath("//input[@id='LastName']"));
//      enterLastName.sendKeys("Patel");
        sendTextToElement(By.xpath("//input[@id='LastName']"), ("Patel"));

//      WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
//      day.sendKeys("1");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), ("1"));

//      WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
//      month.sendKeys("January");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), ("January"));

//      WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
//      year.sendKeys("2000");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), ("2000"));

//      WebElement emailField;
//      Random email = new Random();
//      char c = (char) (email.nextInt(26) + 'a');
//      emailField = driver.findElement(By.id("Email"));
//      emailField.sendKeys(c + "heshvipatel17+8@gmail.com");
        randomMethod(By.id("Email"));


//      WebElement enterEmail = driver.findElement(By.xpath("//input[@name='Email']"));
//      enterEmail.sendKeys("heshvipatel17+8@gmail.com");

//      WebElement enterComName = driver.findElement(By.xpath("//input[@name='Company']"));
//      enterComName.sendKeys("Prime Testing");
        sendTextToElement(By.xpath("//input[@name='Company']"),("Prime Testing"));

//      WebElement enterPassword = driver.findElement(By.xpath("//input[@name='Password']"));
//      enterPassword.sendKeys("Abc@123");
        sendTextToElement(By.xpath("//input[@name='Password']"),("Abc@123"));

//      WebElement enterConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
//      enterConfirmPassword.sendKeys("Abc@123");
        sendTextToElement(By.xpath("//input[@name='ConfirmPassword']"),("Abc@123"));

//      WebElement clickRegiterBtn = driver.findElement(By.xpath("//input[@name='register-button']"));
//      clickRegiterBtn.click();
        clickOnElement(By.xpath("//input[@name='register-button']"));

//      WebElement actualRegSuccessfully = driver.findElement(By.xpath("//div[@class='page-body']//div[text()='Your registration completed']"));

        String expectedRegText = "Your registration completed";
        String actualRegPage = getTextFromElement(By.xpath("//div[@class='page-body']//div[text()='Your registration completed']"));
        Assert.assertEquals(actualRegPage, expectedRegText);


    }

    @After
    public void closeBrowser() {
//      driver.quit();
        quitMethod();
    }
}


