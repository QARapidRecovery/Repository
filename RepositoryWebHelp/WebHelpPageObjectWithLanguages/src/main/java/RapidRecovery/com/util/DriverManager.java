package RapidRecovery.com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory to instantiate a WebDriver object. It returns an instance of the driver
 */
public class DriverManager {
    private static final String CHROME_DRIVER_PATH = "src/main/resources/browsers/chromedriver.exe";
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private final static DriverManager INSTANCE = new DriverManager();

    private DriverManager() {
    }
    /**
     * Factory method to create a new WebDriver instance given to the browser. It should be created once per test suite
     * @return WebDriver instance
     */

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        webDriver.set(new ChromeDriver());

        return webDriver.get();
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

}
