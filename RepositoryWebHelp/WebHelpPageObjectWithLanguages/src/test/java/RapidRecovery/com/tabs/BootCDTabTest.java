package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.BootCDTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

public class BootCDTabTest extends BaseTabTest {

    public BootCDTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod(){
        bootCDTab = new BootCDTab();
        bootCDTab.openTab(BaseTab.Tabs.BootCDTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void bootCDHelp() {
        bootCDTab.checkWebHelp(BootCDTab.CSS_HELP_BOOT_CD, webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATING_BOOT_CD));
    }

    @org.testng.annotations.Test
    public void addNewBootCDHelp() {
        bootCDTab.openCreateBootCDWindow();
        bootCDTab.checkWebHelp(BootCDTab.CSS_DIALOG_WINDOW_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATING_BOOT_CD));
        bootCDTab.closeDialogWindow();
    }


}
