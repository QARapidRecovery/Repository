package RapidRecovery.com.tabs;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.CoreLogsTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

public class CoreLogsTest extends BaseTabTest {

    public CoreLogsTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod(){
        coreLogsTab = new CoreLogsTab();
        coreLogsTab.openTab(BaseTab.Tabs.CoreLogs);
        language.printLanguageByKey();
    }
      @org.testng.annotations.Test
    public void coreLogsWebHelp() {
          coreLogsTab.checkWebHelp(CoreLogsTab.CSS_HELP_CORE_LOGS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_DOWNLOAD_CORE_LOGS));
    }
}
