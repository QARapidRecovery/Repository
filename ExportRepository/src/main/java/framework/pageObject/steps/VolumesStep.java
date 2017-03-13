package framework.pageObject.steps;

import org.openqa.selenium.By;


public class VolumesStep extends BaseStep {

    public static final String CSS_SELECT_ALL_VOLUMES ="#exportVolumeMappingGrid_selectAll_triSpan";

    public VolumesStep() {
        waitTillProgress(CSS_LOADING);
        if (verifyStep(CSS_VOLUMES_STEP) == false) {
            throw new NullPointerException("Not Volumes step");
        }
    }

    public void selectAllVolumes(){
        driver.findElement(By.cssSelector(CSS_SELECT_ALL_VOLUMES)).click();
        proceedToNextStep();


    }

    public void proceedWarningStepIfPresent(){
        if(isWarningPresent(By.cssSelector(CSS_WARNINGS_STEP)) == true){
            proceedToNextStep();
        }
    }

    private boolean isWarningPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
