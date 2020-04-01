package utility;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class Utility {
    public WebDriver driver;
    public JavascriptExecutor jse;
    public JavascriptExecutor js;


    public void chromeBrowserDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
    }

    public void randomMethod(By by) {
        WebElement emailField;
        Random email = new Random();
        char c = (char) (email.nextInt(26) + 'a');
        emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(c + "heshvipatel17+8@gmail.com");
    }

    public void implicitlyWaitSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void setNewPosition() {
        driver.manage().window().setPosition(new Point(-2000, 0));//display 2

    }

    public void maximizeWindow() {
        driver.manage().window().maximize();

    }

    public void getBaseUrl(String string) {
        driver.get(string);

    }

    public void javaScriptExecuter(int x, int y) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500);");
    }

    public void selectDropDown(By by, int a) {
//        WebElement productDropDown = driver.findElement(by);
        WebElement sortByDropDownMenu = driver.findElement(by);
        Select select = new Select(sortByDropDownMenu);
        select.selectByIndex(a);

    }

    // this method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // this method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void moveToElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();

    }

    public void arrayListToShortPrice(By by) {
        List<WebElement> elements = driver.findElements(By.className("prices"));
        // "elements" is a WebElement so sout will print all the Html text from console from the webpage
        // System.out.println(elements);

        List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(toList());
        System.out.println("Expected result: " + webSortedPrices);

        List<String> mySortedPrices = new ArrayList<>();
        for (WebElement element : elements) {
            String text = element.getText();
            mySortedPrices.add(text);
        }
        System.out.println("Actual result: " + mySortedPrices);

        //mySortedPrices.sort(Comparator.comparingInt(s -> Integer.valueOf(s)));
        Assert.assertEquals(webSortedPrices, mySortedPrices);
    }

    public void getActullyList(By by) {
        List<WebElement> allResults = driver.findElements(By.xpath("//div[@class='product-grid']//h2/a"));
        //Store results in  actualList arraylist
        ArrayList<String> actualList = new ArrayList<>(allResults.size());
        for (int i = 0; i < 3; i++) {
            actualList.add(allResults.get(i).getText());
        }
        System.out.println("The actualList before sorting: " + actualList);
        Collections.sort(actualList);
    }

    public void getExpectedList(By by) {
        List<WebElement> allResults1 = driver.findElements(By.xpath("//div[@class='product-grid']//h2/a"));
        //Store results in  expectedList arraylist
        ArrayList<String> expectedList = new ArrayList<>(allResults1.size());
        for (int j = 0; j < 3; j++) {
            expectedList.add(allResults1.get(j).getText());
        }
        System.out.println("The expectedList before sorting: " + expectedList);
        Collections.sort(expectedList);

    }

    // this method is select by visible text
    public void selectByvisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public void selectByIndex(By by, int a) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(a);
    }

    public void sleepMethod() throws InterruptedException {
        Thread.sleep(3000);

    }

    public void quitMethod() {
        driver.quit();
    }

    public void closeMethod() {
        driver.close();
    }
}
/*
    Actions action = new Actions(driver);

    public void alertAccept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    public void alertDismiss(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }
    public void alertGetText(){
        Alert alert = driver.switchTo().alert();
        alert.getText();

    }
    public void alertSendText(String string){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(string);

    }

*/
