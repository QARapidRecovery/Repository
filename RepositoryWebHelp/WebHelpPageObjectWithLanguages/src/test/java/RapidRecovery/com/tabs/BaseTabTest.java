package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.*;
import RapidRecovery.com.WebHelpPage;
import RapidRecovery.com.util.ConfigurationFileLoader;
import RapidRecovery.com.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTabTest {
    WebHelpPage webHelpPage;
    WebDriver driver;
    ConfigurationFileLoader configurations;
    ArchivesTab archivesTab;
    CloudAccountsTab cloudTab;
    BootCDTab bootCDTab;
    CoreHomeTab coreHomeTab;
    BaseTab tab;
    CoreLogsTab coreLogsTab;
    EncryptionKeyTab encryptionKeyTab;
    MountsTab mountsTab;
    NotificationsTab notificationsTab;
    ReplicationTab replicationTab;
    ReportsTab reportsTab;
    RepositoryTab repositoryTab;
    RetentionPolicyTab retentionPolicyTabTab;
    SettingsTab settingsTab;
    AgentTabs agentTabs;
    FileSearchTab fileSearchTab;
    protected LocalizedLanguages language;
    PageObject pageObject;


    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getInstance().createDriver();
        configurations = ConfigurationFileLoader.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageObject  = new PageObject();
        driver.get(pageObject.generateURL(configurations));
        pageObject.changeLanguage(language);
        webHelpPage = new WebHelpPage(language.getLanguageKey());
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


