package RapidRecovery.com.wizards;


import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.PageObject.wizards.ReplicationWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

public class ReplicationWizardTest extends BaseTestWizards {


    public ReplicationWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        replicationWizard = new ReplicationWizard();
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void targetCoreStep() {
        replicationWizard.launchReplicationWizard();
        replicationWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_REPL_TAB)
                ,webHelpPage.getLocalizedText( WebHelpPage.TEXT_TARGET_CORE));
    }




  @org.testng.annotations.Test
   public void requestStep() {
      replicationWizard.launchReplicationWizard();
      replicationWizard.specifyAExistingTargetCore();
      replicationWizard.proceedToNextStep();
      replicationWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText( WebHelpPage.TEXT_REPL_TAB),
              webHelpPage.getLocalizedText( WebHelpPage.TEXT_REQUEST));

  }

   @org.testng.annotations.Test
    public void protectedMachinesStep() {
       replicationWizard.launchReplicationWizard();
       replicationWizard.specifyAExistingTargetCore();
       replicationWizard.proceedToNextStep();
       replicationWizard.specifyEmailAddress();
       replicationWizard.proceedToNextStep();
       replicationWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText( WebHelpPage.TEXT_REPL_TAB),
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_PROTECTED_MACHINES));

   }


   @org.testng.annotations.Test
    public void seedDriveLocationStep() {
       replicationWizard.launchReplicationWizard();
       replicationWizard.specifyAExistingTargetCore();
       replicationWizard.proceedToNextStep();
       replicationWizard.specifyEmailAddress();
       replicationWizard.proceedToNextStep();
       replicationWizard.selectAllAgents();
       replicationWizard.useASeedDrive();
       replicationWizard.proceedToNextStep();
       replicationWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText( WebHelpPage.TEXT_SEED_DRIVE__REPL_WIZARD),
                       webHelpPage.getLocalizedText( WebHelpPage.TEXT_SEED_DRIVE_LOCATION));

   }

    @org.testng.annotations.Test
    public void seedDriveOptionStep() {
        replicationWizard.launchReplicationWizard();
        replicationWizard.specifyAExistingTargetCore();
        replicationWizard.proceedToNextStep();
        replicationWizard.specifyEmailAddress();
        replicationWizard.proceedToNextStep();
        replicationWizard.selectAllAgents();
        replicationWizard.useASeedDrive();
        replicationWizard.proceedToNextStep();
        replicationWizard.specifySeedDriveLocation();
        replicationWizard.proceedToNextStep();
        replicationWizard. checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_SEED_DRIVE__REPL_WIZARD),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_SEED_DRIVE_OPTIONS));


    }

}

