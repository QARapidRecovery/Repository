package framework.pageObject.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 1 on 1/30/2017.
 */
public class RecoveryPointsStep  extends BaseStep{

    public RecoveryPointsStep() {
        if(verifyStep(CSS_RP_STEP)==false){
            throw new NullPointerException("Not a rp step");

        }
    }

    public DestinationStep  selectRP(){
        waitTillProgress(CSS_LOADING,30,30);
        WebElement selectRP = driver.findElement(By.cssSelector(CSS_SELECT_RP_IN_GRID));
        selectRP.click();
        proceedToNextStep();
        waitTillProgress(CSS_LOADING,30,30);
        return new DestinationStep ();


    }





}
