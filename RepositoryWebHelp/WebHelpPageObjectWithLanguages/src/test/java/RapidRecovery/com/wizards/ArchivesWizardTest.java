package RapidRecovery.com.wizards;
import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ArchiveWizard;
import RapidRecovery.com.PageObject.wizards.BaseWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


public class ArchivesWizardTest extends BaseTestWizards {


    public ArchivesWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        archiveWizard = new ArchiveWizard();
        language.printLanguageByKey();

    }

    @org.testng.annotations.Test
    public void archiveTypeStep() {
        archiveWizard.launchArchiveWizard();
        archiveWizard.checkWebHelpWizard(BaseWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_ARCHIVE_TYPE));

    }

    @org.testng.annotations.Test
    public void archiveLocationStep() {
        archiveWizard.launchArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.checkWebHelpWizard(BaseWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_LOCATION));
    }

    @org.testng.annotations.Test
    public void archiveMachinesStep() {
        archiveWizard.launchArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.fillArchiveLocationField();
        archiveWizard.proceedToNextStep();
        archiveWizard.waitTillProgress(PageObject.CSS_LOADING,10,20);
        archiveWizard.checkWebHelpWizard(BaseWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_MACHINES));
    }
    @org.testng.annotations.Test
    public void archiveOptionsStep() {
        archiveWizard.launchArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.fillArchiveLocationField();
        archiveWizard.proceedToNextStep();
        archiveWizard.selectAllMachines();
        archiveWizard.proceedToNextStep();
        archiveWizard.waitTillProgress(BaseWizard.CSS_LOADING,10,20);
        archiveWizard.checkWebHelpWizard(BaseWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_OPTIONS));
    }

    @org.testng.annotations.Test
    public void dateRangeStep() {
        archiveWizard.launchArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.fillArchiveLocationField();
        archiveWizard.proceedToNextStep();
        archiveWizard.selectAllMachines();
        archiveWizard.proceedToNextStep();
        archiveWizard.waitTillProgress(BaseWizard.CSS_LOADING,10,20);
        archiveWizard.proceedToNextStep();
        archiveWizard.waitTillProgress(BaseWizard.CSS_LOADING,10,20);
        archiveWizard.checkWebHelpWizard(BaseWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_DATE_RANGE));
    }
}
