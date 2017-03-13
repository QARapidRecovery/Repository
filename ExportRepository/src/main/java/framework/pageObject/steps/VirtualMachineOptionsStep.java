package framework.pageObject.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class VirtualMachineOptionsStep extends BaseStep {

    public static final String CSS_RESOURCE_POOL_DRPDWN_ESXi = "#dropdown-wrapper-esxResourcePoolTree .dropdown-multiselect-button";
    public static final String CSS_TREE_SERVER_ESXi = ".ui-tree-server";
    public static final String CSS_TREE_DATACENTER_ESXi =".jstree-node [data-value= 'ha-datacenter'] a";
    public static final String CSS_TREE_COMPUTER_ESXi =".jstree-node [data-value= 'ha-compute-res'] a";
    public static final String CSS_TREE_RESOURCE_POOL_ESXi =".jstree-node [data-value= 'ha-root-pool'] a";
    public static final String CSS_RESOURCE_POOL_ESXi = "#esxResourcePoolTree";
    public static final String CSS_VM_CONFIGURATION_LOCATION_ESXi = "#dropdown-wrapper-esxDatastoresSelect";
    public static final String CSS_VM_MACHINE_LOCATION_VMWARE = "#wmWarelocation";
    public static final String CSS_USER_NAME_VMWARE = "#wmWareUsername";
    public static final String CSS_PASSWORD_VMWARE = "#wmWarePassword";
    public static final String CSS_VALIDATION_ERROR = ".input-validation-error";
    public static final String CSS_TARGET_PATH_VBOX = "#vBoxTargetPath";
    public static final String CSS_TARGET_PATH_HYPERV="#hyperVlocation";
    public static final String CSS_SPECIFIC_RAM_CHKBOX_HYPERV="#specificMemory";
    public static final String CSS_SPECIFIC_RAM_FIELD_HYPERV="#specificRam";


    public VirtualMachineOptionsStep() {
    }

    public VirtualMachineOptionsStep(DestinationStep.Destination destination) {
        if(destination ==DestinationStep.Destination.ESXI && verifyStep(CSS_ESXi_OPTIONS_STEP)==false){
            throw new NullPointerException("Not Virtual Machine Options step");
        } else if (destination ==DestinationStep.Destination.ESXI && verifyStep(CSS_VMWARE_OPTIONS_STEP)==false){
            throw new NullPointerException("Not Virtual Machine Options step");
        }else if (destination ==DestinationStep.Destination.HYPER_V && verifyStep(CSS_HYPERV_OPTIONS_STEP)==false){
            throw new NullPointerException("Not Virtual Machine Options step");
        }
    }
    public VolumesStep fillVMOptionsFields(DestinationStep.Destination destination){
        if(destination == DestinationStep.Destination.ESXI){
            fillVMOptionsESXI();
            return new VolumesStep();

        } else if(destination == DestinationStep.Destination.AZURE){

        }else if(destination == DestinationStep.Destination.HYPER_V){
            fillVMOptionsHyperV();
            return new NetworkAdapterStep().skipStep();

        }  else if(destination == DestinationStep.Destination.VIRTUAL_BOX){
            fillVMOptionsVirtualBox();
            return new VolumesStep();
        }else if(destination == DestinationStep.Destination.VMWARE_WORKSTATION){
            fillVMOptionsVMWareLocal();
            return new VolumesStep();

        }

            return null;
    }

    public VolumesStep fillVMOptionsFields(DestinationStep.Destination destination, String key){
        if(destination == DestinationStep.Destination.ESXI){

        } else if(destination == DestinationStep.Destination.AZURE){

        }else if(destination == DestinationStep.Destination.HYPER_V){
            fillVMOptionsHyperV(key);
            return new NetworkAdapterStep().skipStep();

        }  else if(destination == DestinationStep.Destination.VIRTUAL_BOX){
            fillVMOptionsVirtualBox();
            return new VolumesStep();
        }else if(destination == DestinationStep.Destination.VMWARE_WORKSTATION){
            if (key.toUpperCase().equals("LOCAL")){
                fillVMOptionsVMWareLocal();
            } else if(key.toUpperCase().equals("NETWORK")){
                fillVMOptionsVMWareNetwork();
            }
            return new VolumesStep();

        }

        return null;
    }

    private void fillVMOptionsVMWareLocal(){
        waitTillProgress(CSS_LOADING,30,30);
        String vmwareLocation = configurations.getInstance().getVMWareLocation();
        driver.findElement(By.cssSelector(CSS_VM_MACHINE_LOCATION_VMWARE)).sendKeys(vmwareLocation);
        proceedToNextStep();
        checkValidationFillValue(CSS_VM_MACHINE_LOCATION_VMWARE,vmwareLocation, CSS_VALIDATION_ERROR);


    }

    private void fillVMOptionsVMWareNetwork(){
        driver.findElement(By.cssSelector(CSS_VM_MACHINE_LOCATION_VMWARE))
                .sendKeys(configurations.getInstance().getVMWareNetworkLocation());
        driver.findElement(By.cssSelector(CSS_USER_NAME_VMWARE))
                .sendKeys(configurations.getInstance().getVMWareVMWareShareUsername());
        driver.findElement(By.cssSelector(CSS_PASSWORD_VMWARE))
                .sendKeys(configurations.getInstance().getVMWareVMWareSharePassword());
        proceedToNextStep();
    }


    private void fillVMOptionsESXI() {
        driver.findElement(By.cssSelector(CSS_RESOURCE_POOL_DRPDWN_ESXi)).click();
        driver.findElement(By.cssSelector(CSS_TREE_SERVER_ESXi)).click();
        while (verifyStep(CSS_ESXi_OPTIONS_STEP) == true) {
            try {
                driver.findElement(By.cssSelector(CSS_TREE_DATACENTER_ESXi)).click();
                driver.findElement(By.cssSelector(CSS_TREE_COMPUTER_ESXi)).click();
                driver.findElement(By.cssSelector(CSS_TREE_RESOURCE_POOL_ESXi)).click();
                proceedToNextStep();
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                System.out.println(e);
            }
        }
    }

    private void fillVMOptionsVirtualBox(){
        String targetPath = configurations.getInstance().getVirtualBoxTargetPath();
        driver.findElement(By.cssSelector(CSS_TARGET_PATH_VBOX)).sendKeys(targetPath);
        proceedToNextStep();
        checkValidationFillValue(CSS_TARGET_PATH_VBOX,targetPath,CSS_VALIDATION_ERROR);

    }

    private void fillVMOptionsHyperV(String ramValue){
        String targetPath = configurations.getInstance().getHyperVMachineLocation();
        driver.findElement(By.cssSelector(CSS_TARGET_PATH_HYPERV)).sendKeys(targetPath);
        driver.findElement(By.cssSelector(CSS_SPECIFIC_RAM_CHKBOX_HYPERV)).click();
        WebElement ramField = driver.findElement(By.cssSelector(CSS_SPECIFIC_RAM_FIELD_HYPERV));
        ramField.clear();
        ramField.sendKeys(ramValue);
        proceedToNextStep();
        checkValidationFillValue(CSS_TARGET_PATH_HYPERV,targetPath,CSS_VALIDATION_ERROR);



    }

    private void fillVMOptionsHyperV(){
        String targetPath = configurations.getInstance().getHyperVMachineLocation();
        driver.findElement(By.cssSelector(CSS_TARGET_PATH_HYPERV)).sendKeys(targetPath);
        proceedToNextStep();
        checkValidationFillValue(CSS_TARGET_PATH_HYPERV,targetPath, CSS_VALIDATION_ERROR);

        proceedToNextStep();
    }




}
