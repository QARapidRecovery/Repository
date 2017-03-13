package RapidRecovery.com.wizards;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.RestoreWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static RapidRecovery.com.PageObject.PageObject.CSS_LOADING;

public class RestoreWizardTest extends BaseTestWizards {

    public RestoreWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        restoreWizard = new RestoreWizard();
        language.printLanguageByKey();
    }



    @org.testng.annotations.Test
    public void machinesStep() {
        restoreWizard.launchRestoreWizard();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK, 
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD)
                , webHelpPage.getLocalizedText( WebHelpPage.TEXT_MACHINES));
    }

    @org.testng.annotations.Test
    public void recoveryPointsStep() {
        restoreWizard.launchRestoreWizard();
        restoreWizard.selectMachineInGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RECOVERY_POINTS));

    }

      @org.testng.annotations.Test
    public void destinationStep() {
          restoreWizard.launchRestoreWizard();
          restoreWizard.selectMachineInGrid();
          restoreWizard.proceedToNextStep();
          restoreWizard.selectRPinGrid();
          restoreWizard.proceedToNextStep();
          restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                  webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
                  webHelpPage.getLocalizedText( WebHelpPage.TEXT_DESTINATION));

      }

    @org.testng.annotations.Test
    public void diskMappingStep() {
        restoreWizard.launchRestoreWizard();
        restoreWizard.selectMachineInGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRPinGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.recoverToTargetMachine();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_DISK_MAPPING));


    }

   @org.testng.annotations.Test
    public void volumeMappingStep() {
       restoreWizard.launchRestoreWizard();
       restoreWizard.selectMachineInGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.selectRPinGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.proceedToNextStep();
       restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_VOLUME_MAPPING));



   }

//
   @org.testng.annotations.Test
  public void dismountDatabaseStep() {
       restoreWizard.launchRestoreWizard();
       restoreWizard.selectMachineInGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.selectRPinGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.proceedToNextStep();
       restoreWizard.proceedToNextStep();
       restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
               webHelpPage.getLocalizedText( WebHelpPage.TEXT_DISMOUNT_DB));

   }


  @org.testng.annotations.Test
    public void warningStep() {
      restoreWizard.launchRestoreWizard();
      restoreWizard.selectMachineInGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.selectRPinGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.proceedToNextStep();
      restoreWizard.proceedToNextStep();
      restoreWizard.proceedToNextStep();
      restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
              webHelpPage.getLocalizedText( WebHelpPage.TEXT_WARNING));

  }

    @org.testng.annotations.Test
    public void summaryStep() {
        restoreWizard.launchRestoreWizard();
        restoreWizard.selectMachineInGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRPinGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.proceedToNextStep();
        restoreWizard.proceedToNextStep();
        restoreWizard.proceedToNextStep();
        restoreWizard.proceedToNextStep();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_RESTORE_WIZARD),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_SUMMARY));

    }

  @org.testng.annotations.Test
    public void bootCDStep() {
      restoreWizard.launchRestoreWizard();
      restoreWizard.selectMachineInGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.selectRPinGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.selectCreateBootCD();
      restoreWizard.proceedToNextStep();
      restoreWizard. checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_RESTORE_WIZARD),
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_BOOT_CD));

  }

   @org.testng.annotations.Test
    public void driveInjectionStep() {
       restoreWizard.launchRestoreWizard();
       restoreWizard.selectMachineInGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.selectRPinGrid();
       restoreWizard.proceedToNextStep();
       restoreWizard.selectCreateBootCD();
       restoreWizard.proceedToNextStep();
       restoreWizard.fillBootCDOutputPath();
       restoreWizard.proceedToNextStep();
       restoreWizard.waitTillProgress(CSS_LOADING,20,30);
       restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_RESTORE_WIZARD),
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_DRIVE_INJECTION));
   }


    @org.testng.annotations.Test
   public void isoImageStep() {
        restoreWizard.launchRestoreWizard();
        restoreWizard.selectMachineInGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectRPinGrid();
        restoreWizard.proceedToNextStep();
        restoreWizard.selectCreateBootCD();
        restoreWizard.proceedToNextStep();
        restoreWizard.fillBootCDOutputPath();
        restoreWizard.proceedToNextStep();
        restoreWizard.proceedToNextStep();
        restoreWizard.waitTillProgress(CSS_LOADING);
        restoreWizard.cancelBootCD();
        restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_RESTORE_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_ISO_IMAGE));
    }


  @org.testng.annotations.Test
    public void connectionStep() {
      restoreWizard.launchRestoreWizard();
      restoreWizard.selectMachineInGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.selectRPinGrid();
      restoreWizard.proceedToNextStep();
      restoreWizard.selectCreateBootCD();
      restoreWizard.proceedToNextStep();
      restoreWizard.fillBootCDOutputPath();
      restoreWizard.proceedToNextStep();
      restoreWizard.proceedToNextStep();
      restoreWizard.waitTillProgress(CSS_LOADING);
      restoreWizard.cancelBootCD();
      restoreWizard.proceedToNextStep();
      restoreWizard.checkWebHelpWizard(RestoreWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_RESTORE_WIZARD),
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_CONNECTION));

  }
    @AfterMethod
    public void afterMethod() {
        restoreWizard.closeWizard();
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
    }
}
