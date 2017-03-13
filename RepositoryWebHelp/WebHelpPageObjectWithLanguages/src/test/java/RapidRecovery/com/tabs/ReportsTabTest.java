package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.ReportsTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


public class ReportsTabTest extends BaseTabTest {


    public ReportsTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        reportsTab = new ReportsTab();
        reportsTab.openTab(BaseTab.Tabs.ReportsTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void jobReportWebHelp() {
        reportsTab.checkWebHelp(ReportsTab.CSS_HELP_REPORTS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_JOB_REPORT));
    }

    @org.testng.annotations.Test
    public void summaryReportWebHelp() {
        reportsTab.selectSummaryReport();
        reportsTab.checkWebHelp(ReportsTab.CSS_HELP_REPORTS,webHelpPage.getLocalizedText(WebHelpPage.TEXT_SUMMARY_REPORT));
    }

    @org.testng.annotations.Test
    public void failureReportWebHelp() {
        reportsTab.selectFailureReport();
        reportsTab.checkWebHelp(ReportsTab.CSS_HELP_REPORTS,webHelpPage.getLocalizedText(WebHelpPage.TEXT_FAILURE_REPORT));
    }


}
