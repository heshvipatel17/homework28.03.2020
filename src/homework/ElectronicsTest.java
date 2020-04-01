package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class ElectronicsTest extends Utility {
    //    private WebDriver driver;
    String baseUrl = "https://demo.nopcommerce.com/";
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
    public void hoverElectronicsAndClicktoCamaraAndPhoto() throws InterruptedException {

//      WebElement electonics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
//      electonics.click();
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

//      Thread.sleep(3000);
        sleepMethod();

//      WebElement cameraAndPhoto = driver.findElement(By.xpath("//li[@class='active last']//a[contains(text(),'Camera & photo')]"));
//      cameraAndPhoto.click();
        clickOnElement(By.xpath("//li[@class='active last']//a[contains(text(),'Camera & photo')]"));

//      Thread.sleep(3000);
        sleepMethod();

//      WebElement assertText = driver.findElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
//      Thread.sleep(3000);
        sleepMethod();

        String expectedTxt = "Camera & photo";
        String accutalTxt = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(accutalTxt, expectedTxt);

//      Thread.sleep(3000);
        sleepMethod();

    }

    @Test
    public void sortPriceLowToHigh() throws InterruptedException {

//        WebElement electronicsLink = driver.findElement(By.linkText("Electronics"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(electronicsLink).perform();
        moveToElement(By.linkText("Electronics"));
        sleepMethod();

//        WebElement cameraNPhoto = driver.findElement(By.linkText("Camera & photo"));

//      WebElement cameraNPhoto = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        sleepMethod();
//      actions.moveToElement(cameraNPhoto).perform();
//      cameraNPhoto.click();
        moveToElement(By.linkText("Camera & photo"));
        clickOnElement(By.linkText("Camera & photo"));
        sleepMethod();

        //WebElement Position drop down menu
//      WebElement sortByDropDownMenu = driver.findElement(By.id("//select[@id='products-orderby']"));
//      Select select = new Select(sortByDropDownMenu);
        selectDropDown(By.id("products-orderby"), (3));

//      select.selectByIndex(3);

//      Thread.sleep(2000);
        sleepMethod();

//      js.executeScript("window.scrollBy(0,500);");
        javaScriptExecuter(0, 500);

//      Thread.sleep(2000);
        sleepMethod();

//        List<WebElement> elements = driver.findElements(By.className("prices"));
//        // "elements" is a WebElement so sout will print all the Html text from console from the webpage
//        // System.out.println(elements);
//
//        List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(toList());
//        System.out.println("Expected result: " + webSortedPrices);
//
//        List<String> mySortedPrices = new ArrayList<>();
//        for (WebElement element : elements) {
//            String text = element.getText();
//            mySortedPrices.add(text);
//        }
//        System.out.println("Actual result: " + mySortedPrices);
//
//        //mySortedPrices.sort(Comparator.comparingInt(s -> Integer.valueOf(s)));
//        Assert.assertEquals(webSortedPrices, mySortedPrices);
        arrayListToShortPrice(By.className("prices"));

    }

    @After
    public void closeBrowser() {
//      driver.quit();
        quitMethod();
    }
}
