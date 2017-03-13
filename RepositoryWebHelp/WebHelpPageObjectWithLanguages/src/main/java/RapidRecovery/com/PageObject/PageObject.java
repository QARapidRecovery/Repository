package RapidRecovery.com.PageObject;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.WebHelpPage;
import RapidRecovery.com.util.ConfigurationFileLoader;
import RapidRecovery.com.util.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class PageObject {


    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait;
    public static final String CSS_OVERLAY = "div .ui-widget-overlay";
    public static final String CSS_LOADING = "#loadingPanel";

    public PageObject() {
        driver.get(generateURL(ConfigurationFileLoader.getInstance()));
    }

    public String generateURL(ConfigurationFileLoader configurations) {

        String coreIP = configurations.getInstance().getCoreIP();
        String login = configurations.getInstance().getCoreUser();
        String password = configurations.getInstance().getCorePassword();
        String port = configurations.getInstance().getCorePort();

        String myURL = "https://" + login + ":" + password + "@" + coreIP + ":" + port + "/apprecovery/admin";
        return myURL;
    }

    public String generateURL(ConfigurationFileLoader configurations, String tabEnd) {
        String coreIP = configurations.getInstance().getCoreIP();
        String login = configurations.getInstance().getCoreUser();
        String password = configurations.getInstance().getCorePassword();
        String port = configurations.getInstance().getCorePort();

        String myURL = "https://" + login + ":" + password + "@" + coreIP + ":" + port + "/apprecovery/admin/" + tabEnd;
        return myURL;
    }

    protected boolean checkQuestionMark(String headerName) {
        WebElement header = driver.findElement(By.cssSelector(WebHelpPage.CSS_WEBHELP_HEADER));
        Charset.forName("UTF-8").encode(headerName);
        System.out.println("Web-help: " + header.getText());
        if (header.getText().equals(headerName)) {
            driver.close();
            return true;
        }
        driver.close();
        return false;
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

    public void checkWebHelp(String cssToHelpLink, String webHelpText) {
        waitTillProgress(ProtectMachineWizard.CSS_LOADING);
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.cssSelector(cssToHelpLink)).click();
        // Switch to new window opened
        Set<String> windowHandles = driver.getWindowHandles();
        //Get active windows , while size of windowsHandles list  is equal or lover than 1.
        while (windowHandles.size() <= 1) {
            windowHandles = driver.getWindowHandles();
        }
        for (String winHandle : windowHandles) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
        // Perform the actions on new window
        if (checkQuestionMark(webHelpText) == false) {
            driver.switchTo().window(winHandleBefore);
            throw new AssertionError(" Text in link does not match with expected text" + "\n (" + webHelpText + ")");
        }
/// Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
    }

    private  void changeLang(LocalizedLanguages languages) {
        try {
            driver.navigate().refresh();
            waitTillProgress(CSS_OVERLAY, 10, 30);

            driver.findElement(By.cssSelector("a[href*='/apprecovery/admin/Core/Settings']")).click();
            driver.findElement(By.cssSelector(".editable-container[data-url*='SetCurrentCulture'] ")).click();
            driver.findElement(By.cssSelector("#dropdown-wrapper-langComboBox .dellap-caret-down")).click();
            driver.findElement(By.cssSelector("#dropdown-menu-langComboBox > ul >" + languages.getLanguageCss() + "> label")).click();
            driver.findElement(By.cssSelector(".editable-container[data-url*='SetCurrentCulture'] [type = 'submit']")).click();
            driver.navigate().refresh();
        } catch (WebDriverException e) {
            System.out.println(e);

        }
    }
    private boolean  verifyLanguage(LocalizedLanguages languages){
        String  languageName;
        String currentLanguageName;
        for (int i = 0;i<2;i++){
            driver.navigate().refresh();
             languageName =languages.getLanguageName();
             currentLanguageName = driver.findElement(By.xpath
                    ("//*[@id='generalCoreSettings' ] //div[contains(@data-url,'SetCurrentCulture')]")).getText();
            System.out.println("Current Language: "+ currentLanguageName);
            System.out.println("Language that should be: "+ languageName);
            if(languageName.toLowerCase().equals(currentLanguageName.toLowerCase()) ==true){
                return true;
            }
        }
        return false;
    }




    public  void changeLanguage(LocalizedLanguages languages) {
        changeLang(languages);
        while (verifyLanguage(languages)== false){
            driver.findElement(By.cssSelector(".editable-container[data-url*='SetCurrentCulture'] ")).click();
            driver.findElement(By.cssSelector("#dropdown-wrapper-langComboBox .dellap-caret-down")).click();
            driver.findElement(By.cssSelector("#dropdown-menu-langComboBox > ul >" + languages.getLanguageCss() + "> label")).click();
            driver.findElement(By.cssSelector(".editable-container[data-url*='SetCurrentCulture'] [type = 'submit']")).click();


        }
    }


}
