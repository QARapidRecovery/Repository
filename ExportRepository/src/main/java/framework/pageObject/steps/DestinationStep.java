package framework.pageObject.steps;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class DestinationStep extends BaseStep{
    public static final String CSS_ESXI_HOSTNAME = "#esxHostName";
    public static final String CSS_ESXI_USERNAME = "#esxUserName";
    public static final String CSS_ESXI_PASSWORD = "#esxPassword";

    public static final String CSS_HYPERV_HOSTNAME = "#hyperVhostName";
    public static final String CSS_HYPERV_PASSWORD = "#hyperVpassword";
    public static final String CSS_HYPERV_USERNAME = "#hyperVuserName";

    public static final String CSS_DESTINATION_DROPDOWN = "#dropdown-wrapper-recoverToVirtualMachine .aa-caret-down";
    public static final String CSS_DESTINATION_VMWARE =    "li[data-value*='2']";
    public static final String CSS_DESTINATION_ESXI =    "li[data-value*='1']";
    public static final String CSS_DESTINATION_HYPER_V =    "li[data-value*='3']";
    public static final String CSS_DESTINATION_VIRTUALBOX =    "li[data-value*='5']";
    public static final String CSS_DESTINATION_AZURE =    " li[data-value*='6']";

    public static final String CSS_TITLE_VMWARE =  "[data-original-title*= 'VMware Workstation']";
    public static final String CSS_TITLE_ESXI= "[data-original-title*= 'vCenter/ESXi']";
    public static final String CSS_TITLE_HYPER_V ="[data-original-title = 'Hyper-V']";
    public static final String CSS_TITLE_VIRTUALBOX  = "[data-original-title*= 'VirtualBox']";
    public static final String CSS_TITLE_AZURE  ="[data-original-title*= 'Azure']";
    public static final String CSS_ESXI_VALIDATION_ERROR = ".has-error";

    public static final String CSS_HYPERV_REMOTE_HOST = "#useRemoteMachine";

    public DestinationStep() {
          if(verifyStep(CSS_DESTINATION_STEP)==false){
throw new NullPointerException("Not the destination Step");
          }
    }

    public enum  Destination{
        ESXI(CSS_DESTINATION_ESXI, CSS_TITLE_ESXI),
        VMWARE_WORKSTATION(CSS_DESTINATION_VMWARE,CSS_TITLE_VMWARE),
        HYPER_V(CSS_DESTINATION_HYPER_V,CSS_TITLE_HYPER_V),
        VIRTUAL_BOX(CSS_DESTINATION_VIRTUALBOX,CSS_TITLE_VIRTUALBOX),
        AZURE(CSS_DESTINATION_AZURE,CSS_TITLE_AZURE);
        private String destinationCss;
        private String cssTitle;

        Destination(String destinationCss, String cssTitle){
            this.destinationCss = destinationCss;
            this.cssTitle = cssTitle;
        }

        public  String getDestinationCss(){
            return destinationCss;
        }
        public  String getTitleCss(){
            return cssTitle;
        }

    }

    public VirtualMachineOptionsStep selectDestination(Destination destination) {
        driver.findElement(By.cssSelector(CSS_DESTINATION_DROPDOWN)).click();
        driver.findElement(By.cssSelector(destination.getDestinationCss())).click();
        waitTillProgress(CSS_LOADING);
        try {
            WebElement verifySelection = driver.findElement(By.cssSelector(destination.getTitleCss()  /*+"[data-tooltip-hover ='true']"*/));
            if(destination.equals(destination.ESXI)){
                fillESXiExportFields();
                proceedToNextStep();
            }else if(destination.equals(destination.VMWARE_WORKSTATION)){
                proceedToNextStep();
            }else if(destination.equals(destination.VIRTUAL_BOX)){
                proceedToNextStep();
            }else if(destination.equals(destination.HYPER_V)){
                fillHyperVExportFields();
                proceedToNextStep();

            }

        } catch (ElementNotFoundException | NoSuchElementException e) {
            System.out.println(e);
            selectDestination(destination);
        }
            return new VirtualMachineOptionsStep();

    }

    private void fillESXiExportFields(){
        WebElement hostnameField=  driver.findElement(By.cssSelector(CSS_ESXI_HOSTNAME));
        String hostname = configurations.getInstance().getESXiHostName();
        hostnameField.sendKeys(hostname);
        WebElement usernameField= driver.findElement(By.cssSelector(CSS_ESXI_USERNAME));
        String username = configurations.getInstance().getESXiHostLogin();
        usernameField.sendKeys(username);
        WebElement passwordField= driver.findElement(By.cssSelector(CSS_ESXI_PASSWORD));
        String password =configurations.getInstance().getESXiHostPassword();
        passwordField.sendKeys(password);
        proceedToNextStep();
        checkValidationFillValue(CSS_ESXI_HOSTNAME,hostname, CSS_ESXI_VALIDATION_ERROR  );
        checkValidationFillValue(CSS_ESXI_USERNAME,username,CSS_ESXI_VALIDATION_ERROR  );
        checkValidationFillValue(CSS_ESXI_PASSWORD,password,CSS_ESXI_VALIDATION_ERROR );
    }

    private void fillHyperVExportFields(){
        WebElement remoteHost=  driver.findElement(By.cssSelector(CSS_HYPERV_REMOTE_HOST));
        remoteHost.click();
        WebElement hostnameField=  driver.findElement(By.cssSelector(CSS_HYPERV_HOSTNAME));
        String hostname = configurations.getInstance().getHyperVHostName();
        hostnameField.sendKeys(hostname);
        WebElement usernameField= driver.findElement(By.cssSelector(CSS_HYPERV_USERNAME));
        String username = configurations.getInstance().getHyperVHostLogin();
        usernameField.sendKeys(username);
        WebElement passwordField= driver.findElement(By.cssSelector(CSS_HYPERV_PASSWORD));
        String password =configurations.getInstance().getHyperVHostPassword();
        passwordField.sendKeys(password);
        proceedToNextStep();
        checkValidationFillValue(CSS_HYPERV_HOSTNAME,hostname, CSS_ESXI_VALIDATION_ERROR  );
        checkValidationFillValue(CSS_HYPERV_USERNAME,username,CSS_ESXI_VALIDATION_ERROR  );
        checkValidationFillValue(CSS_HYPERV_PASSWORD,password,CSS_ESXI_VALIDATION_ERROR );
    }

}
