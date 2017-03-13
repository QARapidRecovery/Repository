package framework.pageObject.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VMExportTypeStep extends BaseStep  {

    String exportType;

    public VMExportTypeStep() {
        if(verifyStep(CSS_VM_EXPORT_STEP)==false){
            throw new NullPointerException("Not VM export step");
        }
    }

    public VMExportTypeStep(String exportType) {
        if(verifyStep(CSS_VM_EXPORT_STEP)==false){
            throw new NullPointerException("Not VM export step");
        }
        this.exportType = exportType;
    }

    public MachinesStep selectVMExport(String exportType){

            if (exportType.equalsIgnoreCase("OneTimeExport")){
                selectOneTimeExport();
                return new MachinesStep();
            } else if (exportType.equalsIgnoreCase("VirtualStandby")){
                selectContinuousExport();
                return new MachinesStep();
            }

        return null;
    }

    public void selectOneTimeExport(){
        selectExportType(VMExportType.ONE_TIME_EXPORT);
        WebElement nextButton = driver.findElement(By.cssSelector(CSS_WIZARD_NEXT_BUTTON));
        nextButton.click();
        waitTillProgress(CSS_LOADING);
    }

    public void selectContinuousExport(){
        selectExportType(VMExportType.CONTINUOUS_EXPORT);
        WebElement nextButton = driver.findElement(By.cssSelector(CSS_WIZARD_NEXT_BUTTON));
        nextButton.click();
        waitTillProgress(CSS_LOADING);
    }

    private void selectExportType(VMExportType exportType){
        WebElement checkbox = driver.findElement(By.cssSelector(exportType.exportTypeCss));
        checkbox.click();
    }

         private enum  VMExportType{
        ONE_TIME_EXPORT(CSS_ONE_TIME_EXPORT),
        CONTINUOUS_EXPORT(CSS_CONTINUOUS_EXPORT);

        private String exportTypeCss;

        VMExportType(String exportTypeCss){
            this.exportTypeCss = exportTypeCss;
        }

    }



}
