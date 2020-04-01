package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utility.Utility;

public class ComputerTest extends Utility {

//  private WebDriver driver;
    private String baseUrl = "https://demo.nopcommerce.com/";
    private JavascriptExecutor js;

    @Before
    public void openBrowser() {
//      System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//      ChromeOptions options = new ChromeOptions();
//      options.setPageLoadStrategy(PageLoadStrategy.NONE);
//      driver = new ChromeDriver(options);
//      js = (JavascriptExecutor) driver;
        chromeBrowserDriver();

//      driver.manage().window().setPosition(new Point(-2000, 0));//display 2
        setNewPosition();

//      driver.manage().window().maximize();
        maximizeWindow();

//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        implicitlyWaitSeconds(10);

//      driver.get(baseUrl);
        getBaseUrl(baseUrl);
    }

    @Test
    public void UserShouldNavigateToComputerPage() {
//      driver.findElement(By.linkText("Computers")).click();
        clickOnElement(By.linkText("Computers"));

//      WebElement assertTxt = driver.findElement(By.xpath("//div[@class='page-title']/h1 "));
        String expectedTxt = "Computers";
        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        Assert.assertEquals(actualTxt, expectedTxt);
    }

    @Test
    public void addProductToShoppingCart() throws InterruptedException {

//      driver.findElement(By.linkText("Computers")).click();
        clickOnElement(By.linkText("Computers"));

//      Thread.sleep(3000);
        sleepMethod();

        //element for desktop
//      driver.findElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']")).click();
        clickOnElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']"));

//      Thread.sleep(2000);
        sleepMethod();

        //to scrool the page down
//      js.executeScript("window.scrollBy(0, -1800);");
        javaScriptExecuter(0, -1800);

//      Thread.sleep(2000);
        sleepMethod();

        //element for build your own computer
        // driver.findElement(By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]")).click();
        driver.findElement(By.linkText("Build your own computer")).click();

//      Thread.sleep(3000);
        sleepMethod();

        //to scroll the page down
//      js.executeScript("window.scrollBy(0, -1800);");
        javaScriptExecuter(0, -1800);

//      Thread.sleep(2000);
        sleepMethod();

        //element for 400gb hdd hardriver radio button
//      driver.findElement(By.id("product_attribute_3_7")).click();
        clickOnElement(By.id("product_attribute_3_7"));

        //element for add to cart button
//      driver.findElement(By.id("add-to-cart-button-1")).click();
        clickOnElement(By.id("add-to-cart-button-1"));

        //element for message for add to cart
//      WebElement productAddedMsg = driver.findElement(By.xpath("//p[@class='content']"));
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(actualMsg, expectedMsg);
    }


    @After
    public void closeBrowser() throws InterruptedException {
//      Thread.sleep(3000);
        sleepMethod();


//      driver.close();
        closeMethod();
    }


}