package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utility.Utility;

public class BookH extends Utility {

    private String baseUrl = "https://demo.nopcommerce.com/";
    private JavascriptExecutor js;

    @Before
    public void openBrowser() {
        chromeBrowserDriver();

        js = (JavascriptExecutor) driver;
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getBaseUrl(baseUrl);
    }

    @Test
    public void userNavigateToBookPageSuccessfully() throws InterruptedException {
        //MouseHover on Books
        moveToElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));
        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        String expectedTxt = "Books";
        Assert.assertEquals(actualTxt, expectedTxt);
        Thread.sleep(3000);

    }

    @Test
    public void booksArrangedInAscendingOrderAtoZ() throws InterruptedException {
        //WebElement Books Link
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));
        sleepMethod();
        getActullyList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();
        //WebElement Position dropdown box
        selectDropDown(By.cssSelector("select#products-orderby"), (1));
        sleepMethod();

        //Scroll down page
        javaScriptExecuter(0, 500);
        sleepMethod();

        getExpectedList(By.xpath("//div[@class='product-grid']//h2/a"));
        sleepMethod();
    }

    @Test
    public void bookAddedToWishlistSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));
        sleepMethod();
        selectDropDown(By.cssSelector("select#products-orderby"), (1));
        sleepMethod();
        javaScriptExecuter(0, 500);
        sleepMethod();

        //WebElement for wishlist button
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        String expectedTxt = "The product has been added to your wishlist";
        String actualTxt = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedTxt, actualTxt);
        sleepMethod();
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}
