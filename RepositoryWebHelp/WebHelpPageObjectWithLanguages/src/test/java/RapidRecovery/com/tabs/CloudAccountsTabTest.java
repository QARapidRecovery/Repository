package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.CloudAccountsTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

public class CloudAccountsTabTest extends BaseTabTest {

    public CloudAccountsTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod(){
        cloudTab = new CloudAccountsTab();
        cloudTab.openTab(BaseTab.Tabs.CloudsTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void cloudAccountWebHelp() {
        cloudTab.checkWebHelp(CloudAccountsTab.CSS_HELP_CLOUDS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_CLOUD_ACCOUNTS));
    }


}
