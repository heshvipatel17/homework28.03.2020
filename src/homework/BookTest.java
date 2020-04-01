package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class BookTest extends Utility {
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
    public void userShouldNavigatetoBooksPage() throws InterruptedException {
//      driver.findElement(By.linkText("Books")).click();
        clickOnElement(By.linkText("Books"));

//      WebElement assertTxt = driver.findElement(By.xpath("//div[@class='page-title']/h1 "));
        String expectedTxt = "Books";
        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        Assert.assertEquals(actualTxt, expectedTxt);
//      Thread.sleep(3000);
        sleepMethod();

    }

    @Test
    public void booksShortByAscendingOrder() throws InterruptedException {
//      driver.findElement(By.linkText("Books")).click();
        clickOnElement(By.linkText("Books"));
//      driver.findElement(By.linkText("Position")).click();
//      Thread.sleep(3000);
        sleepMethod();

//        List<WebElement> allResults = driver.findElements(By.xpath("//div[@class='product-grid']//h2/a"));
//        //Store results in  actualList arraylist
//        ArrayList<String> actualList = new ArrayList<>(allResults.size());
//        for (int i = 0; i < 3; i++) {
//            actualList.add(allResults.get(i).getText());
//        }
//        System.out.println("The actualList before sorting: " + actualList);
//        Collections.sort(actualList);
        getActullyList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();

        //WebElement Position dropdown box
//        WebElement positionDropDown = driver.findElement(By.cssSelector("select#products-orderby"));
//        Select select = new Select(positionDropDown);
        selectDropDown(By.cssSelector("select#products-orderby"),(1));
//        select.selectByIndex(1);
//        Thread.sleep(2000);
        sleepMethod();

        //Scroll down page
//      js.executeScript("window.scrollBy(0, 500);");
        javaScriptExecuter(0,500);

//      Thread.sleep(2000);
        sleepMethod();

        //WebElement list of names of books after sorting them in AtoZ order using dropdown menu
//        List<WebElement> allResults1 = driver.findElements(By.xpath("//div[@class='product-grid']//h2/a"));
//        //Store results in  expectedList arraylist
//        ArrayList<String> expectedList = new ArrayList<>(allResults1.size());
//        for (int j = 0; j < 3; j++) {
//            expectedList.add(allResults1.get(j).getText());
//        }
//        System.out.println("The expectedList before sorting: " + expectedList);
//        Collections.sort(expectedList);
        getExpectedList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();
         String expectedList= "Fahrenheit 451 by Ray Bradbury";
         String actualList=getTextFromElement(By.xpath("//div[@class='product-grid']//h2/a"));
   //    getActullyList(By.xpath("//div[@class='product-grid']//h2/a"));
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void productAddToWishList() throws InterruptedException {
//      driver.findElement(By.linkText("Books")).click();
        clickOnElement(By.linkText("Books"));

//      Thread.sleep(3000);
        sleepMethod();

        WebElement dropDown = driver.findElement(By.id("products-orderby"));

//      Thread.sleep(3000);
        sleepMethod();

        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");

//      Thread.sleep(3000);
        sleepMethod();

//      driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]")).click();
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));

//      Thread.sleep(3000);
        sleepMethod();

//      WebElement assertText = driver.findElement(By.xpath("//div[@style='display: block;']//p"));
        String expertText = "The product has been added to your wishlist";
        String actualText = getTextFromElement(By.xpath("//div[@style='display: block;']//p"));
        Assert.assertEquals(expertText, actualText);

//      Thread.sleep(3000);
        sleepMethod();

    }
    @After
    public void closeBrowser(){
//     driver.quit();
       quitMethod();
    }
}
