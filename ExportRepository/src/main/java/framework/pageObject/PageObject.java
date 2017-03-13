package framework.pageObject;

import framework.utils.ConfigurationFileLoader;
import framework.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObject {
    protected ConfigurationFileLoader configurations;
    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait;

    public String generateURL(ConfigurationFileLoader configurations) {

        String coreIP = configurations.getInstance().getCoreIP();
        String login = configurations.getInstance().getCoreUser();
        String password = configurations.getInstance().getCorePassword();
        String port = configurations.getInstance().getCorePort();

        String myURL = "https://" + login + ":" + password + "@" + coreIP + ":" + port + "/apprecovery/admin";
        return myURL;
    }

    public void waitTillProgress(String cssElementToLoad, int attemptNumber, long timeOut) {
        for (int i = 0; i < attemptNumber; i++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (driver.findElement(By.cssSelector(cssElementToLoad)).isDisplayed() == true) {
                    (new WebDriverWait(driver, timeOut))
                            .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssElementToLoad)));
                    break;
                }
            } catch (NoSuchElementException | TimeoutException e) {

            }
        }
    }

    public void waitTillProgress(String cssElementToLoad) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            if (driver.findElement(By.cssSelector(cssElementToLoad)).isDisplayed() == true) {
                (new WebDriverWait(driver, 15))
                        .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssElementToLoad)));

            }
        } catch (NoSuchElementException e) {

        }
    }
}
