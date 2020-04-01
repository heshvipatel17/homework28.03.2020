package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class Electronics extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
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
    public void hoverElectronicsAndClicktoCamaraAndPhoto() throws InterruptedException {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        sleepMethod();
        clickOnElement(By.xpath("//li[@class='active last']//a[contains(text(),'Camera & photo')]"));
        sleepMethod();
        sleepMethod();

        String expectedTxt = "Camera & photo";
        String accutalTxt = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(accutalTxt, expectedTxt);
        sleepMethod();

    }

    @Test
    public void sortPriceLowToHigh() throws InterruptedException {

        Actions actions = new Actions(driver);
        moveToElement(By.linkText("Electronics"));
        sleepMethod();
        moveToElement(By.linkText("Camera & photo"));
        clickOnElement(By.linkText("Camera & photo"));
        sleepMethod();

        //WebElement Position drop down menu
        selectDropDown(By.id("products-orderby"), (3));
        sleepMethod();
        javaScriptExecuter(0, 500);
        sleepMethod();
        arrayListToShortPrice(By.className("prices"));

    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}
