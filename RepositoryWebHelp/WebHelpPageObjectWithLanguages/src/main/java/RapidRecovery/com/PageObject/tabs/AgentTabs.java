package RapidRecovery.com.PageObject.tabs;

import RapidRecovery.com.util.ConfigurationFileLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AgentTabs extends BaseTab{

    public static final String  CSS_AGENT_HELP = ".navbar-main.page-header .header-help-link";
    public static final String  CSS_AGENT_SUMMARY_HELP = ".block-header .header-help-link";
    public static final String  CSS_AGENT_EVENTS_HELP = ".block-header .header-help-link";
    public static final String  CSS_AGENT_REPORT_HELP = ".block-subheader .header-help-link";
    public static final String  CSS_AGENT_RETENTION_POLICY_HELP = ".block-header .header-help-link";
    public static final String  CSS_AGENT_NOTIFICATIONS_HELP = ".block-header .header-help-link";
    public static final String  CSS_AGENT_LOGS_HELP = ".block-header .header-help-link";
    public static final String  CSS_AGENT_SUMMARY_TAB = ".navbar-main.page-header [href*='ProtectedMachines']";
    public static final String  CSS_AGENT_RP_TAB = ".navbar-main.page-header [href*='RecoveryPoints']";
    public static final String  CSS_AGENT_EVENTS_TAB = ".navbar-main.page-header [href*='Events']";
    public static final String  CSS_AGENT_SETTINGS_TAB = ".navbar-main.page-header [href*='Settings']";
    public static final String  CSS_AGENT_GENERAL_SETTINGS =  "#generalSettings .header-help-link";
    public static final String  CSS_AGENT_NIGHTLY_JOB_SETTINGS =  "#nightlyJobsSettings .header-help-link";
    public static final String  CSS_AGENT_LICENSING_SETTINGS ="#licenseSettings .header-help-link";
    public static final String  CSS_AGENT_REPORTS_DRPDWN = ".page-header > ul > li:nth-child(5)";
    public static final String CSS_AGENT_JOB_REPORT =  ".dropdown-menu [href*='JobReport']";
    public static final String CSS_AGENT_FAILURE_REPORT =  ".dropdown-menu  [href*='FailureReport']";
    public static final String  CSS_AGENT_MORE_DRPDWN = ".page-header > ul > li:last-child";
    public static final String CSS_AGENT_SYSTEM_INFO =  ".navbar-main.page-header .dropdown-menu [href*='SystemInfo']";
    public static final String CSS_AGENT_MOUNTS =  " .navbar-main.page-header .dropdown-menu  [href*='Mounts'] i ";
    public static final String CSS_AGENT_RETENTION_POLICY =  ".navbar-main.page-header .dropdown-menu [href*='RetentionPolicy']";
    public static final String CSS_AGENT_NOTIFICATIONS =  " .navbar-main.page-header .dropdown-menu [href*='EventsConfiguration']";
    public static final String CSS_AGENT_LOGS =  ".dropdown-menu [href*='ViewLog']";
    public static final String CSS_AGENT_LOCAL_MOUNTS_HELP =  ".blockInnerContainer .header-help-link";
    public static final String CSS_AGENT_REMOTE_MOUNTS_HELP =  ".mt10 .header-help-link";


    public void selectTheAgent(){
        driver.get(generateURL(ConfigurationFileLoader.getInstance()));
        String agentXPath = "// a[contains(., '"+configurations.getInstance().getAgentName()+"')]";

        try {
            WebElement agent = driver.findElement(By.xpath(agentXPath));
            agent.click();
        }catch (StaleElementReferenceException e){
            WebElement agent = driver.findElement(By.xpath(agentXPath));
            agent.click();
        }
    }
    public void openAgentTab(String cssTab){
        driver.findElement(By.cssSelector(cssTab)).click();
    }

    public void  openAgentTab(String cssDropdown, String cssTab){

        driver.findElement(By.cssSelector(cssDropdown)).click();
        WebElement jobReport=  driver.findElement(By.cssSelector(cssTab));
        new Actions(driver).moveToElement(jobReport).click().perform();
        waitTillProgress(CSS_LOADING);
    }

}
