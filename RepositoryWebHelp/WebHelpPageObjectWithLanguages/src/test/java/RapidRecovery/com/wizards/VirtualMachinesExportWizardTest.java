package RapidRecovery.com.wizards;



import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.RestoreWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;


public class VirtualMachinesExportWizardTest extends BaseTestWizards {


    public VirtualMachinesExportWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        restoreWizard = new RestoreWizard();
        language.printLanguageByKey();
    }



   @org.testng.annotations.Test
   public void vmExportTypeStep(){
       restoreWizard.launchVMExportWizard();
       restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_VM_EXPORT_TYPE));

   }

//
   @org.testng.annotations.Test
    public void machinesStep(){
       restoreWizard.launchVMExportWizard();
        restoreWizard.proceedToNextStep();
       restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_MACHINES));

   }


    @org.testng.annotations.Test
   public void recoveryPointsStep(){
        restoreWizard.launchVMExportWizard();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectMachineToVmExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_RECOVERY_POINTS));
    }


    @org.testng.annotations.Test
    public void destinationStep(){
        restoreWizard.launchVMExportWizard();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectMachineToVmExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRpToExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.waitTillProgress(PageObject.CSS_LOADING,10,20);
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_DESTINATION));

    }


    @org.testng.annotations.Test
   public void vmOptionStep(){
        restoreWizard.launchVMExportWizard();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectMachineToVmExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRpToExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectExportTypeVMWare();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VM_OPTIONS));


    }

    @org.testng.annotations.Test
    public void volumesStep(){
        restoreWizard.launchVMExportWizard();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectMachineToVmExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRpToExport();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectExportTypeVMWare();
        restoreWizard.proceedToNextStep();
        restoreWizard.fillVMOptionsFields();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VIRTUAL_EXPORT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_VOLUMES));
    }









}
