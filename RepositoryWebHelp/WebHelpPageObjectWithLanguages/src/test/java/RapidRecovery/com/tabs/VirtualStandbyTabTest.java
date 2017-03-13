package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

import static RapidRecovery.com.PageObject.tabs.BaseTab.Tabs.VirtualStandbyTab;

public class VirtualStandbyTabTest extends BaseTabTest {

    public VirtualStandbyTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        tab = new BaseTab();
        tab.openTab(VirtualStandbyTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void coreSummaryWebHelp() {
        tab.checkWebHelp(BaseTab.CSS_SUMMARY_HELP,  webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD));
    }
}
