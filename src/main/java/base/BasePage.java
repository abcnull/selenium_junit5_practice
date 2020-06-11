package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/6/10 20:16
 */
public class BasePage {
    public RemoteWebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public JavascriptExecutor je;

    /**
     * 无参构造器
     */
    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver80.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        this.actions = new Actions(driver);
        this.je = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * 有参构造器
     *
     * @param driver 驱动
     */
    public BasePage(RemoteWebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver80.exe");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        this.actions = new Actions(driver);
        this.je = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * 简单点击操作的封装
     *
     * @param locator 被点击元素的定位
     */
    public void clickButton(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /**
     * 输入框输入的封装
     *
     * @param locator 输入框定位
     * @param str 输入的字符串
     */
    public void sendKeys(By locator, CharSequence... str) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(str);
    }
}
