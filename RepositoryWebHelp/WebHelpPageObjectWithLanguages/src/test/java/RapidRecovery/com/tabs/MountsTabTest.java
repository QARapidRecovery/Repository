package RapidRecovery.com.tabs;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.MountsTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

public class MountsTabTest extends BaseTabTest {


    public MountsTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod(){
        mountsTab = new MountsTab();
        mountsTab.openTab(BaseTab.Tabs.MountsTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void localMountWebHelp() {
        mountsTab.checkWebHelp(MountsTab.CSS_lOCAL_MOUNTS, webHelpPage.getLocalizedText(WebHelpPage.TEXT_DISMOUNTING_RP));
    }
    @org.testng.annotations.Test
    public void remoteMountWebHelp() {
        mountsTab.checkWebHelp(MountsTab.CSS_REMOTE_MOUNTS,webHelpPage.getLocalizedText(WebHelpPage.TEXT_DISMOUNTING_RP));
    }

}
