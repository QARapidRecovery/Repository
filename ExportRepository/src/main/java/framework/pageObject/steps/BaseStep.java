package framework.pageObject.steps;

import framework.pageObject.PageObject;
import framework.pageObject.section.HeaderLeftSection;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by 1 on 1/24/2017.
 */
public class BaseStep extends PageObject {


    public static final String  CSS_MACHINES_STEP= "#exportProtectedMachines.active-step-link ";
    public static final String CSS_RP_STEP = "#recoveryPoints.active-step-link";
    public static final String CSS_ONE_TIME_EXPORT ="#oneTimeExport";
    public static final String CSS_CONTINUOUS_EXPORT ="#continuousExport";
    public static final String CSS_VM_EXPORT_STEP = "#selectExportType.active-step-link";
    public static final String CSS_DESTINATION_STEP =  "#destination.active-step-link";
    public static final String CSS_VMWARE_OPTIONS_STEP =   "#optionsWmWare.active-step-link";
    public static final String CSS_HYPERV_OPTIONS_STEP =   "#optionsHyperV.active-step-link";
    public static final String CSS_ESXi_OPTIONS_STEP =   "#optionsEsx.active-step-link";
    public static final String CSS_VIRTUAL_BOX_OPTIONS_STEP =   "#optionsVirtualBox.active-step-link";
    public static final String CSS_VOLUMES_STEP = "#volumes.active-step-link";
    public static final String CSS_SELECT_RP_IN_GRID = "#exportRecoveryPointsGrid [aria-describedby='exportRecoveryPointsGrid_Contents']";
    public static final String CSS_WARNINGS_STEP =   "#warnings.active-step-link";
    public static final String CSS_NETWORK_ADAPTER_STEP ="#networkAdaptersHyperV.active-step-link";
    public static final String CSS_WIZARD_NEXT_BUTTON = "#btnWizardDefault";
    public static final String CSS_OVERLAY = "div .ui-widget-overlay";
    public static final String CSS_LOADING = "#loadingPanel";
    public static final String CSS_TOP_BLOCK="#applicationHeader"; // HeaderLeftSection



    public BaseStep() {
        waitTillProgress(CSS_OVERLAY);
    }

    public HeaderLeftSection getHeaderLeftSection(){
        waitTillProgress(CSS_OVERLAY);
        WebElement topMenu = driver.findElement(By.cssSelector(CSS_TOP_BLOCK));

        return new HeaderLeftSection(topMenu);
    }

    public  boolean verifyStep(String stepCss){
        try{
            waitTillProgress(CSS_LOADING);
            WebElement stepID = driver.findElement(By.cssSelector(stepCss));
            return stepID.isDisplayed();
        }catch(NoSuchElementException e){
            System.out.println("Wrong Step for " + getClass());
            return false;
        }
    }

    public void proceedToNextStep(){
        waitTillProgress(CSS_OVERLAY);
        waitTillProgress(CSS_LOADING,10,30);
        WebElement nextButton= driver.findElement(By.cssSelector(CSS_WIZARD_NEXT_BUTTON));
        nextButton.click();
    }
    public void checkValidationFillValue(String cssFileld, String text, String cssError){
        try{
            String cssFieldWithValidationError = cssFileld + cssError;
            WebElement fieldValidationError =driver.findElement(By.cssSelector(cssFieldWithValidationError));
            while (fieldValidationError.isDisplayed()){
                fieldValidationError.clear();
                fieldValidationError.sendKeys(text);
                waitTillProgress(CSS_LOADING);
                proceedToNextStep();
            }
        } catch (WebDriverException e){
            System.out.println(e);
        }
    }
}
