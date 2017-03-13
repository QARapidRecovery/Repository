package framework.pageObject.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 1 on 1/25/2017.
 */
public class MachinesStep extends BaseStep {

    String exportType;


    public MachinesStep() {
        if(verifyStep(CSS_MACHINES_STEP)==false){
            throw new NullPointerException("Not the machine step");

        }




    }

    public RecoveryPointsStep  selectMachineInGrid(){
            String machineCSS = "#exportProtectedMachinesGrid [data-value='"
                    + configurations.getInstance().getExportedVMHostName() + "']";
                        waitTillProgress(CSS_LOADING);
            WebElement selectMachine = driver.findElement(By.cssSelector(machineCSS));
            selectMachine.click();
            proceedToNextStep();
            return new RecoveryPointsStep();


    }


}
