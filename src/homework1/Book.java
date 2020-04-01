package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class Book extends Utility {
//  private WebDriver driver;
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
    public void userShouldNavigatetoBooksPage() throws InterruptedException {
        clickOnElement(By.linkText("Books"));
        String expectedTxt = "Books";
        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        Assert.assertEquals(actualTxt, expectedTxt);
        sleepMethod();
    }
    @Test
    public void booksShortByAscendingOrder() throws InterruptedException {
        clickOnElement(By.linkText("Books"));
        sleepMethod();
        getActullyList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();
        selectDropDown(By.cssSelector("select#products-orderby"),(1));
        sleepMethod();
        //Scroll down page
        javaScriptExecuter(0,500);
        sleepMethod();
        getExpectedList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();

        String expectedList= "Fahrenheit 451 by Ray Bradbury";
        String actualList=getTextFromElement(By.xpath("//div[@class='product-grid']//h2/a"));
        Assert.assertEquals(expectedList, actualList);
    }
    @Test
    public void productAddToWishList() throws InterruptedException {
        clickOnElement(By.linkText("Books"));
        sleepMethod();
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        sleepMethod();
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");
        sleepMethod();
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        sleepMethod();
        String expertText = "The product has been added to your wishlist";
        String actualText = getTextFromElement(By.xpath("//div[@style='display: block;']//p"));
        Assert.assertEquals(expertText, actualText);
        sleepMethod();
    }
    @After
    public void closeBrowser(){
       quitMethod();
    }
}
