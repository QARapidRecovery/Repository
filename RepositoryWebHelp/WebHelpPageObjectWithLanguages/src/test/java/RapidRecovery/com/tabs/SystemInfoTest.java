package RapidRecovery.com.tabs;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

import static RapidRecovery.com.PageObject.tabs.BaseTab.CSS_SUMMARY_HELP;

public class SystemInfoTest extends BaseTabTest {


    public SystemInfoTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        tab = new BaseTab();
        tab.openTab(BaseTab.Tabs.SystemInfoTab);
        language.printLanguageByKey();
    }



    @org.testng.annotations.Test
    public void systemInfoHelp() {
        tab.checkWebHelp(CSS_SUMMARY_HELP,  webHelpPage.getLocalizedText(WebHelpPage.TEXT_SYSTEM_INFO));
    }


}
