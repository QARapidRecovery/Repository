package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.ArchivesTab;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


public class ArchivesTabTest extends BaseTabTest {


    public ArchivesTabTest(LocalizedLanguages language) {
        this.language = language;
    }


    @BeforeMethod
    public void beforeMethod() {
        webHelpPage = new WebHelpPage(language.getLanguageKey());
        archivesTab = new ArchivesTab();
        archivesTab.openTab(BaseTab.Tabs.ArchiveTab);
        language.printLanguageByKey();

    }


    @org.testng.annotations.Test
    public void archivesWebHelp() {
        archivesTab.checkWebHelp(ArchivesTab.CSS_HELP_ARCHIVES, webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE));
    }

    @org.testng.annotations.Test
    public void scheduledArchiveWebHelp() {
        archivesTab.checkWebHelp(ArchivesTab.CSS_HELP_SCHEDULED_ARCHIVES,webHelpPage.getLocalizedText(WebHelpPage.TEXT_SCHEDULED_ARCHIVE));
    }

  @org.testng.annotations.Test
    public void addAttachedArchiveWebHelp() {
      archivesTab.openAttachArchiveWindow();
      archivesTab.checkWebHelp(ArchivesTab.CSS_DIALOG_WINDOW_QUESTION_MARK,webHelpPage.
              getLocalizedText(WebHelpPage.TEXT_ATTACH_ARCHIVE));
      archivesTab.closeDialogWindow();

  }

   @org.testng.annotations.Test
   public void checkArchiveWebHelp() {
       archivesTab.openCheckArchiveWindow();
       archivesTab.checkWebHelp(ArchivesTab.CSS_DIALOG_WINDOW_QUESTION_MARK,webHelpPage.getLocalizedText(WebHelpPage.TEXT_CHECK_ARCHIVE));
       archivesTab.closeDialogWindow();

   }
    @org.testng.annotations.Test
    public void scheduledArchiveImportWebHelp() {
        archivesTab.checkWebHelp(ArchivesTab.CSS_HELP_SCHEDULED_ARCHIVES_IMPORT,webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_ARCHIVE));
    }
    @org.testng.annotations.Test
    public void attachedArchiveWebHelp() {
        archivesTab.checkWebHelp(ArchivesTab.CSS_HELP_ATTACHED_ARCHIVES,webHelpPage.getLocalizedText(WebHelpPage.TEXT_ATTACH_ARCHIVE));

    }
}
