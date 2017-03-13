package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.CoreHomeTab;
import RapidRecovery.com.PageObject.tabs.SettingsTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


public class SettingsTabTest extends BaseTabTest {

    public SettingsTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        settingsTab = new SettingsTab();
        settingsTab.openTab(BaseTab.Tabs.SettingsTab);
        language.printLanguageByKey();
    }
  
    @org.testng.annotations.Test
    public void coreSummaryWebHelp() {
        settingsTab.checkWebHelp(CoreHomeTab.CSS_SUMMARY_HELP, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS));
    }
    @org.testng.annotations.Test

    public void testHelpGeneral() {
        settingsTab.checkWebHelp(SettingsTab.CSS_GENERAL_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_GENERAL));

    }
    @org.testng.annotations.Test

    public void testHelpUpdates() {
        settingsTab.checkWebHelp(SettingsTab.CSS_UPDATE_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_UPDATES));

    }

    @org.testng.annotations.Test

    public void testHelpNightlyJobs() {
        settingsTab.checkWebHelp(SettingsTab.CSS_NIGHTLY_JOB_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_NIGHTLY_JOBS));

    }
    @org.testng.annotations.Test

    public void testReplayEngine() {
        settingsTab.checkWebHelp(SettingsTab.CSS_REPLAY_ENGINE_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_REPLAY_ENGINE));

    }
    @org.testng.annotations.Test

    public void testSMTP() {
        settingsTab.checkWebHelp(SettingsTab.CSS_SMTP_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_SMTP));

    }

    @org.testng.annotations.Test
    public void testReports() {
        settingsTab.checkWebHelp(SettingsTab.CSS_REPORT_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_REPORTS));

    }

    @org.testng.annotations.Test

    public void testAttachability() {
        settingsTab.checkWebHelp(SettingsTab.CSS_ATTACHABILITY_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_ATTACHABILILTY));
    }

    @org.testng.annotations.Test

    public void testJobs() {
        settingsTab.checkWebHelp(SettingsTab.CSS_JOBS_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_JOBS));

    }
    @org.testng.annotations.Test

    public void testLicense() {
        settingsTab.checkWebHelp(SettingsTab.CSS_LICENSE_HELP_SETTINGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_LICENSES));

    }
    @org.testng.annotations.Test

    public void testBackUp() {
        settingsTab.openBackUpConfigurationSettings();
        settingsTab.checkWebHelp(SettingsTab.CSS_DIALOG_WINDOW_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_BACK_UP));
        settingsTab.closeDialogWindow();


    }

    @org.testng.annotations.Test

    public void testRestore() {
        settingsTab.openRestoreConfigurationSettings();
        settingsTab.checkWebHelp(SettingsTab.CSS_DIALOG_WINDOW_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_SETTINGS_RESTORE));
        settingsTab.closeDialogWindow();

    }
}
