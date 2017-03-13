package RapidRecovery.com.wizards;
import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.wizards.ProtectMachineWizard;
import RapidRecovery.com.WebHelpPage;
import org.testng.annotations.BeforeMethod;

import static RapidRecovery.com.PageObject.PageObject.CSS_LOADING;

public class DeployAgentSoftwareWizardTest extends BaseTestWizards {


    public DeployAgentSoftwareWizardTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod() {
        protectMachineWizard = new ProtectMachineWizard();
        language.printLanguageByKey();
    }
    
    @org.testng.annotations.Test
    public void connectionStep() {
        protectMachineWizard.launchDeployMachineWizard();
        protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_DEPLOY_AGENT_SOFTWARE_WIZARD),
                webHelpPage.getLocalizedText(WebHelpPage.TEXT_CONNECTION));
    }

  @org.testng.annotations.Test
  public void machinesStep() {
      protectMachineWizard.launchDeployMachineWizard();
      protectMachineWizard.selectConnectionManually();
      protectMachineWizard.proceedToNextStep();
      protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_DEPLOY_AGENT_SOFTWARE_WIZARD),
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_MACHINES));

  }


  @org.testng.annotations.Test
   public void adjustmentStep() {
      protectMachineWizard.launchDeployMachineWizard();
      protectMachineWizard.selectConnectionHyperV();
      protectMachineWizard.proceedToNextStep();
      protectMachineWizard.proceedToNextStep();
      protectMachineWizard.waitTillProgress(CSS_LOADING,10,20);
      protectMachineWizard.checkWebHelpWizard(ProtectMachineWizard.CSS_WIZARD_QUESTION_MARK,
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_DEPLOY_AGENT_SOFTWARE_WIZARD),
              webHelpPage.getLocalizedText(WebHelpPage.TEXT_ADJUSTMENTS));

  }





}
