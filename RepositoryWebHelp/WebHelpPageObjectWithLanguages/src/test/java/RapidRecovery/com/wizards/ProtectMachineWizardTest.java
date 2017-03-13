package RapidRecovery.com.wizards;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

import static RapidRecovery.com.PageObject.PageObject.CSS_LOADING;
import static RapidRecovery.com.PageObject.wizards.BaseWizard.CSS_WIZARD_QUESTION_MARK;

public class ProtectMachineWizardTest extends BaseTestWizards {


    public ProtectMachineWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        protectMachineWizard = new ProtectMachineWizard();
        language.printLanguageByKey();
    }

    @org.testng.annotations.Test
    public void welcomeStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_WELCOME));
        protectMachineWizard.closeWizard();
    }

    @org.testng.annotations.Test
    public void connectionStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CONNECTION));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test
    public void protectionStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_WIZARD_PROTECTION),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PROTECTION));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test

    public void volumesStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.setCustomProtection();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_WIZARD)
                ,webHelpPage.getLocalizedText(WebHelpPage.TEXT_PROTECTION_VOLUMES));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test
    public void scheduleStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.setCustomProtection();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PRT_WIZARD_PROTECTION_SCHEDULE),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_PROTECTION_SCHEDULE));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test
    public void repositoryStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_REPOSITORY),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_REPOSITORY));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test
    public void repositoryConfigurationStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.createNewRepository();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CREATE_REPOSITORY),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_REPOSITORY_CONFIGURATION ));
        protectMachineWizard.closeWizard();

    }

    @org.testng.annotations.Test
    public void encryptionStep() {
        protectMachineWizard.launchProtectMachineWizard();
        protectMachineWizard.selectAdvancedProtectMachinesWizard();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.fillConnectionFields();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.proceedToNextStep();
        protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
        protectMachineWizard.checkWebHelpWizard(CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_ADDING_ENCRYPTION_KEY),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_ENCRYPTION));
        protectMachineWizard.closeWizard();


    }


}
