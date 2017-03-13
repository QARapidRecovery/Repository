package RapidRecovery.com.wizards;

import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ArchiveWizard;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.PageObject.wizards.ReplicationWizard;
import RapidRecovery.com.PageObject.wizards.RestoreWizard;
import RapidRecovery.com.WebHelpPage;
import RapidRecovery.com.util.ConfigurationFileLoader;
import RapidRecovery.com.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTestWizards {
    WebDriver driver;
    ConfigurationFileLoader configurations;
    PageObject pageObject;
    ArchiveWizard archiveWizard;
    ProtectMachineWizard protectMachineWizard;
    RestoreWizard restoreWizard;
    ReplicationWizard replicationWizard;
    WebHelpPage webHelpPage;
    protected LocalizedLanguages language;
    WebDriverWait wait;





    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getInstance().createDriver();
        configurations = ConfigurationFileLoader.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageObject = new PageObject();
        wait= new WebDriverWait(driver,20,10);
        driver.get(pageObject.generateURL(configurations));
        webHelpPage = new WebHelpPage(language.getLanguageKey());
        pageObject.changeLanguage(language);
        }


    @AfterMethod
    public void afterMethod() {
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
