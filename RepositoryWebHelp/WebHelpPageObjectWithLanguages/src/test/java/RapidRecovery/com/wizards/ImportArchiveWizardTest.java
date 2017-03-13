package RapidRecovery.com.wizards;


import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ArchiveWizard;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

import static RapidRecovery.com.PageObject.wizards.ArchiveWizard.*;


public class ImportArchiveWizardTest extends BaseTestWizards {


    public ImportArchiveWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        archiveWizard = new ArchiveWizard();
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void importTypeStep() {
        archiveWizard.launchImportArchiveWizard();
        archiveWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_TYPE));

    }


    @org.testng.annotations.Test
    public void locationStep() {
        archiveWizard.launchImportArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_ARCHIVE), webHelpPage.getLocalizedText(WebHelpPage.TEXT_LOCATION));
    }


    @org.testng.annotations.Test
    public void archiveInfoStep() {
        archiveWizard.launchImportArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.fillImportArchiveLocationField();
        archiveWizard.proceedToNextStep();
        archiveWizard.waitTillProgress(CSS_LOADING,10,20);
        archiveWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_ARCHIVE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_ARCHIVE_INFORMATION));
    }



    @org.testng.annotations.Test
    public void machinesStep() {
        archiveWizard.launchImportArchiveWizard();
        archiveWizard.proceedToNextStep();
        archiveWizard.fillImportArchiveLocationField();
        archiveWizard.proceedToNextStep();
        archiveWizard.deselectImportAllMachines();
        archiveWizard.proceedToNextStep();
        archiveWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_IMPORT_ARCHIVE)
                , webHelpPage.getLocalizedText(WebHelpPage.TEXT_MACHINES));

    }



}
