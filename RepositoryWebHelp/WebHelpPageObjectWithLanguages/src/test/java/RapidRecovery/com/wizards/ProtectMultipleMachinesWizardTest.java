package RapidRecovery.com.wizards;


import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.WebHelpPage;

import org.testng.annotations.BeforeMethod;


public class ProtectMultipleMachinesWizardTest extends BaseTestWizards {


    public ProtectMultipleMachinesWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        protectMachineWizard = new ProtectMachineWizard();
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void welcomeStep() {
        protectMachineWizard.launchProtectMultipleMachinesWizard();
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_MLT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_WELCOME));


    }

    @org.testng.annotations.Test
    public void connectionStep() {
        protectMachineWizard.launchProtectMultipleMachinesWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_MLT_WIZARD)
                ,webHelpPage.getLocalizedText(WebHelpPage.TEXT_CONNECTION));

    }

 @org.testng.annotations.Test
   public void selectMachineStep() {
     protectMachineWizard.launchProtectMultipleMachinesWizard();
     protectMachineWizard.selectAdvancedProtectMachinesWizard();
     protectMachineWizard.proceedToNextStep();
     protectMachineWizard.selectConnectionManually();
     protectMachineWizard.proceedToNextStep();
     protectMachineWizard. checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
             webHelpPage.getLocalizedText( WebHelpPage.TEXT_PRT_MLT_WIZARD),webHelpPage.getLocalizedText(  WebHelpPage.TEXT_SELECT_MACHINES ));

 }
    @org.testng.annotations.Test
    public void protectionStep() {
        protectMachineWizard.launchProtectMultipleMachinesWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.selectConnectionManually();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.enterMachinesInformation();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_PRT_WIZARD_PROTECTION),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_PROTECTION));
    }

   @org.testng.annotations.Test
    public void protectionScheduleStep() {
       protectMachineWizard.launchProtectMultipleMachinesWizard();
       protectMachineWizard.selectAdvancedProtectMachinesWizard();
       protectMachineWizard.proceedToNextStep();
       protectMachineWizard.selectConnectionManually();
       protectMachineWizard.proceedToNextStep();
       protectMachineWizard.enterMachinesInformation();
       protectMachineWizard.proceedToNextStep();
       protectMachineWizard.setCustomProtection();
       protectMachineWizard.proceedToNextStep();
       protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText( WebHelpPage.TEXT_PRT_WIZARD_PROTECTION_SCHEDULE),
               webHelpPage.getLocalizedText(WebHelpPage.TEXT_PROTECTION_SCHEDULE));

   }

      @org.testng.annotations.Test
 public void repositoryStep() {
          protectMachineWizard.launchProtectMultipleMachinesWizard();
          protectMachineWizard.selectAdvancedProtectMachinesWizard();
          protectMachineWizard.proceedToNextStep();
          protectMachineWizard.selectConnectionManually();
          protectMachineWizard.proceedToNextStep();
          protectMachineWizard.enterMachinesInformation();
          protectMachineWizard.proceedToNextStep();
          protectMachineWizard.proceedToNextStep();
          protectMachineWizard. checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                 webHelpPage.getLocalizedText( WebHelpPage.TEXT_CREATE_REPOSITORY),
                  webHelpPage.getLocalizedText(WebHelpPage.TEXT_REPOSITORY));


      }

    @org.testng.annotations.Test
public void repositoryConfigurationStep() {
        protectMachineWizard.launchProtectMultipleMachinesWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.selectConnectionManually();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.enterMachinesInformation();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.createNewRepository();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(PageObject.CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_CREATE_REPOSITORY),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_REPOSITORY_CONFIGURATION));
    }

    @org.testng.annotations.Test
   public void encryptionStep() {
        protectMachineWizard.launchProtectMultipleMachinesWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.selectConnectionManually();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.enterMachinesInformation();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
               webHelpPage.getLocalizedText( WebHelpPage.TEXT_ADDING_ENCRYPTION_KEY),
                webHelpPage.getLocalizedText( WebHelpPage.TEXT_ENCRYPTION));

    }

}
