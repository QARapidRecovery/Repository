package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/browsers/chromedriver.exe";
    private static final String GECKO_DRIVER_PATH = "src/main/resources/browsers/geckodriver.exe";
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal();
    private static final DriverManager INSTANCE = new DriverManager();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver createDriver(String browser) {
        if(CHROME.equalsIgnoreCase(browser)) {
            this.setChromeDriver();
            this.webDriver.set(new ChromeDriver());
        } else {
            if(!FIREFOX.equalsIgnoreCase(browser)) {
                throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", new Object[]{browser}));
            }

            this.setGeckoDriver();
            this.webDriver.set(new FirefoxDriver());
        }

        return (WebDriver)this.webDriver.get();
    }

    public WebDriver getDriver() {
        return (WebDriver)this.webDriver.get();
    }

    private void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    }

    private void setGeckoDriver() {
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
    }
}
