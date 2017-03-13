package RapidRecovery.com.tabs;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.FileSearchTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


/**
 * Created by 1 on 12/8/2016.
 */
public class FileSearchTabTest extends BaseTabTest{


    public FileSearchTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        fileSearchTab = new FileSearchTab();
        fileSearchTab.openTab(BaseTab.Tabs.FileSearchTab);
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void FileSearchResultWebHelp() {
        fileSearchTab.checkWebHelp(FileSearchTab.CSS_SEARCH_RESULT_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_FILE_SEARCH));
    }

}
