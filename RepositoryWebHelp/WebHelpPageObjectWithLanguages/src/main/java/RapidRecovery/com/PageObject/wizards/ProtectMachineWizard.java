package RapidRecovery.com.PageObject.wizards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ProtectMachineWizard extends BaseWizard {
    //FIELDS
    public static final String CSS_CONNECTION_HOSTNAME = "#hostName";
    public static final String CSS_CONNECTION_USERNAME = "#userName";
    public static final String CSS_CONNECTION_PASSWORD =  "#password";
    public static final String CSS_REPOSITORY_NAME = "#newRepoName";
    public static final String CSS_REPOSITORY_LOCATION = "#newRepoLocation";
    public static final String CSS_REPOSITORY_METADATA = "#newRepoMetadataLocation";
    //Protect multiple Wizard-> Select Machine step -> field
    public static final String  CSS_SELECT_MACHINES_MANUALLY  = "#machinesListManual";
    //header names
    public static final String TEXT_REPOSITORY_CONFIGURATION ="Repository Configuration";
    //Buttons , Dropdowns
    public static final String CSS_WIZARD_ADVANCED_R_BUTTON = "#advancedWizard";
    public static final String CSS_WIZARD_CUSTOM_PROT_BUTTON = "#customProtection";
    public static final String CSS_WIZARD_CREATE_REPO_BUTTON = "#createRepository";
    public static final String CSS_PRT_MLTPM_WIZARD_CONNECTION_DRPDWN = ".dropdown-multiselect-button";
    public static final String CSS_PRT_MLTPM_WIZARD_CON_DRPDWN_MANUALLY = "#dropdown-menu-sourceType > ul > li:nth-child(5)"; //"#dropdown-menu-sourceType [data-original-title = Manually] ";
    public static final String CSS_PROTECT_MACHINE = "#protectMachine";
    public static final String CSS_PROTECT_MACHINE_DRDWN = "#protectEntity  .dellap-caret-down";
    public static final String CSS_PRT_MLTPM_MACHINES = ".dellap-bulk-protect";
    public static final String CSS_PRT_CLUSTER = ".dellap-cluster-protect";
    public static final String CSS_DIALOG_WINDOW_QUESTION_MARK = "[aria-labelledby='ui-id-3'] .ui-icon-help-left";
    public static final String CSS_CLUSTER_HOST = "[aria-labelledby='ui-id-3']  #clusterHostName";
    public static final String CSS_CLUSTER_USER_NAME = "[aria-labelledby='ui-id-3']  #clusterUserName";
    public static final String CSS_CLUSTER_PASSWORD = "[aria-labelledby='ui-id-3']   #clusterPassword ";

    //Deploy Wizard
    public static final String CSS_DEPLOY_AGENT_SOFTWARE =  ".dellap-bulk-deploy";
    public static final String CSS_SOURCE_DRPDWN = "#dropdown-wrapper-sourceType";
    public static final String CSS_SOURCE_MANUALLY ="#dropdown-menu-sourceType > ul > li:last-child";
    public static final String CSS_SOURCE_HYPER_V ="#dropdown-menu-sourceType > ul > li:nth-child(4)";
    public static final String CSS_HYPER_V_HOSTNAME ="#hvServerHostName";
    public static final String CSS_HYPER_V_USERNAME = "#hvServerUserName";
    public static final String CSS_HYPER_V_PASSWORD = "#hvServerPassword";
    public static final String CSS_CONNECT_CLUSTER_BUTTON =  "#connectClusterButton";
    //lOADING
    public static final String CSS_OVERLAY =" div .ui-widget-overlay";
    public static final String CSS_LOADING = "#loadingPanel";

    public void launchProtectMachineWizard(){
        waitTillProgress(CSS_OVERLAY);
        WebElement protectMachineWizard = driver.findElement(By.cssSelector(CSS_PROTECT_MACHINE));
        protectMachineWizard.click();
    }

    public void selectAdvancedProtectMachinesWizard(){
        WebElement advancedWizard = driver.findElement(By.cssSelector(CSS_WIZARD_ADVANCED_R_BUTTON));
        advancedWizard.click();
    }

    public void fillConnectionFields(){
        WebElement hostname = driver.findElement(By.cssSelector(CSS_CONNECTION_HOSTNAME));
        WebElement username = driver.findElement(By.cssSelector(CSS_CONNECTION_USERNAME));
        WebElement password = driver.findElement(By.cssSelector(CSS_CONNECTION_PASSWORD));
        hostname.sendKeys(configurations.getInstance().getProtectHostname());
        username.sendKeys(configurations.getInstance().getProtectLogin());
        password.sendKeys(configurations.getInstance().getProtectPassword());
    }

   public void setCustomProtection(){
       WebElement customProtection = driver.findElement(By.cssSelector(CSS_WIZARD_CUSTOM_PROT_BUTTON));

       customProtection.click();
   }

   public void createNewRepository(){
       WebElement createRepository = driver.findElement(By.cssSelector(CSS_WIZARD_CREATE_REPO_BUTTON));
       createRepository.click();
       WebElement repositoryLocation = driver.findElement(By.cssSelector(CSS_REPOSITORY_LOCATION));
       repositoryLocation.sendKeys(configurations.getInstance().getRepositoryLocation());
       WebElement repositoryName = driver.findElement(By.cssSelector(CSS_REPOSITORY_NAME));
       new Actions(driver).moveToElement(repositoryName).click().perform();
       repositoryName.sendKeys(configurations.getInstance().getRepositoryName());
       for (int i =0 ; i<6 ; i++){
           repositoryName.sendKeys(configurations.getInstance().getRepositoryName());
           if(!(repositoryName.getText().toString().isEmpty()==true)){
            break;
           }
       }
   }
// Protect Multiple Machines Wizard
   public void launchProtectMultipleMachinesWizard(){
       WebElement protectWizardDropdown = driver.findElement(By.cssSelector(CSS_PROTECT_MACHINE_DRDWN));
       WebElement launchprotectMultipleMachinesWizard = driver.findElement(By.cssSelector(CSS_PRT_MLTPM_MACHINES));
       protectWizardDropdown.click();
       launchprotectMultipleMachinesWizard.click();
       waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
   }


public void selectConnectionManually(){
    driver.findElement(By.cssSelector(CSS_PRT_MLTPM_WIZARD_CONNECTION_DRPDWN)).click();
    driver.findElement(By.cssSelector(CSS_SOURCE_MANUALLY)).click();
}

public void enterMachinesInformation(){
    driver.findElement(By.cssSelector(ProtectMachineWizard.CSS_SELECT_MACHINES_MANUALLY)).
            sendKeys(configurations.getInstance().getProtectAgentManual());
}

//Deploy Agent Software Wizard

    public void launchDeployMachineWizard(){
        WebElement protectWizardDropdown = driver.findElement(By.cssSelector(CSS_PROTECT_MACHINE_DRDWN));
        protectWizardDropdown.click();
        WebElement deployAgentDropdown = driver.findElement(By.cssSelector(CSS_DEPLOY_AGENT_SOFTWARE));
        deployAgentDropdown.click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }
    public void selectConnectionHyperV(){
        driver.findElement(By.cssSelector(ProtectMachineWizard.CSS_SOURCE_DRPDWN)).click();
        driver.findElement(By.cssSelector(ProtectMachineWizard.CSS_SOURCE_HYPER_V)).click();
        WebElement hvHostName = driver.findElement(By.cssSelector(CSS_HYPER_V_HOSTNAME));
        WebElement hvUserName = driver.findElement(By.cssSelector(CSS_HYPER_V_USERNAME));
        WebElement hvPassword = driver.findElement(By.cssSelector(CSS_HYPER_V_PASSWORD));
        hvHostName.sendKeys(configurations.getInstance().getHyperVHost());
        hvUserName.sendKeys(configurations.getInstance().getHyperVLogin());
        hvPassword.sendKeys(configurations.getInstance().getHyperVPassword());
        if(hvPassword.getAttribute("value").isEmpty()== true){
            System.out.println("Text-" + hvPassword.getAttribute("value"));
            hvPassword.clear();
            hvPassword.sendKeys(configurations.getInstance().getHyperVPassword());
        }
    }

    //ProtectCluster
    public void launchProtectClusterWindow(){
        WebElement protectWizardDropdown = driver.findElement(By.cssSelector(CSS_PROTECT_MACHINE_DRDWN));
        protectWizardDropdown.click();
        WebElement launchProtectCluster = driver.findElement(By.cssSelector(CSS_PRT_CLUSTER));
        launchProtectCluster.click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }

    public void fillClusterFields(){
        WebElement clusterPassword = driver.findElement(By.cssSelector(CSS_CLUSTER_PASSWORD));
        WebElement clusterHost = driver.findElement(By.cssSelector(CSS_CLUSTER_HOST));
        WebElement clusterUserName = driver.findElement(By.cssSelector(CSS_CLUSTER_USER_NAME));
        clusterPassword.sendKeys(configurations.getInstance().getClusterPassword());
        clusterHost.clear();
        clusterHost.sendKeys(configurations.getInstance().getClusterIP());
        clusterUserName.clear();
        clusterUserName.sendKeys(configurations.getInstance().getClusterHostName());
    }

    public void connectToCluster(){
        WebElement connectClusterButton = driver.findElement(By.cssSelector(CSS_CONNECT_CLUSTER_BUTTON));

        connectClusterButton.click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY,10,20);
        waitTillProgress(ProtectMachineWizard.CSS_LOADING,10,40);
    }








}
