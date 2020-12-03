import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AppleTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
            public void driverInitiate(){
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--window-size=1600,900");
            driver = new ChromeDriver(option);
            }

    @Test
    public void addItemsToBasketTest() throws InterruptedException {

        driver.get("https://www.apple.com/ru/");
        WebElement searchPic = driver.findElement(By.xpath("//*[@id=\"ac-gn-link-search\"]"));
        searchPic.click();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-input\"]"));
        searchInput.click();
        searchInput.sendKeys("iPhone 12 Pro Max");
        searchInput.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"exploreCurated\"]/div[1]/div[2]/ul/li[2]/a")));
        WebElement targetOption = driver.findElement(By.xpath("//*[@id=\"exploreCurated\"]/div[1]/div[2]/ul/li[2]/a"));
        targetOption.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"Item16_7inch_label\"]/span")));
        WebElement targetModel = driver.findElement(By.xpath("//*[@id=\"Item16_7inch_label\"]/span"));
        targetModel.click();
        Thread.sleep(750);
        WebElement targetColor = driver.findElement(By.xpath("//*[@id=\"Item2pacificblue_label\"]/span[2]"));
        targetColor.click();
        Thread.sleep(750);
        WebElement targetMemory = driver.findElement(By.xpath("//*[@id=\"Item3256gb_label\"]/span[1]"));
        targetMemory.click();
        Thread.sleep(750);
        WebElement clickNoCare = driver.findElement(By.xpath("//*[@id=\"applecareplus_59_noapplecare\"]"));
        clickNoCare.click();
        Thread.sleep(750);
        WebElement addToBasketButton = driver.findElement(By.xpath("//*[@id=\"primary\"]/summary-builder/div[2]/div[1]/div/div[1]/div[2]/div/div/form/div/span"));
        addToBasketButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/form/button")));
        WebElement goToBasketButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/form/button"));
        goToBasketButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"cart-items\"]")));
        List<WebElement> itemsInBasket = driver.findElements(By.xpath("//*[@id=\"cart-items\"]"));
        Assert.assertTrue(itemsInBasket.size()>0);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }
}