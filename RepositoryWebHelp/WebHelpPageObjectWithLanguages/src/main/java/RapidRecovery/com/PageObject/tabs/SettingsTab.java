package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;

/**
 * Created by 1 on 11/16/2016.
 */
public class SettingsTab extends BaseTab {

    public static final String CSS_UPDATE_HELP_SETTINGS = "#updatesCoreSettings .header-help-link>a ";
    public static final String CSS_NIGHTLY_JOB_HELP_SETTINGS ="#nightlyJobsCoreSettings .header-help-link>a";
    public static final String CSS_REPLAY_ENGINE_HELP_SETTINGS ="#replayEngineCoreSettings .header-help-link>a";
    public static final String CSS_SMTP_HELP_SETTINGS = "#smtpCoreSettings .header-help-link>a";
    public static final String CSS_REPORT_HELP_SETTINGS = "#reportCoreSettings .header-help-link>a";
    public static final String CSS_ATTACHABILITY_HELP_SETTINGS = "#attachabilitySettings .header-help-link>a";
    public static final String CSS_JOBS_HELP_SETTINGS = "#jobsSettings .header-help-link>a";
    public static final String CSS_LICENSE_HELP_SETTINGS =   "#licenseSettings .header-help-link>a";
    public static final String CSS_GENERAL_HELP_SETTINGS = "#generalCoreSettings .header-help-link>a";
    public static final String CSS_BACK_UP_CONFIGURATION_SETTINGS = "[data-onclick*='Backup']";
    public static final String CSS_RESTORE_CONFIGURATION_SETTINGS = "[data-onclick*='Restore']" ;
    public static final String CSS_DIALOG_WINDOW_QUESTION_MARK =  " #ui-dialog-titlebar-hlp1 .ui-icon-help-left";


    public void openBackUpConfigurationSettings(){
        driver.findElement(By.cssSelector(SettingsTab.CSS_BACK_UP_CONFIGURATION_SETTINGS)).click();
    }
    public void openRestoreConfigurationSettings(){
        driver.findElement(By.cssSelector(SettingsTab.CSS_BACK_UP_CONFIGURATION_SETTINGS)).click();
    }

}
