package RapidRecovery.com.PageObject.wizards;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigInteger;
import java.security.SecureRandom;


/**
 * Created by 1 on 11/14/2016.
 */
public class RestoreWizard extends  BaseWizard{
    public static final String CSS_RESTORE_WIZARD_HEADER = "#restoreMachine";
    public static final String CSS_ELEMENT_MACHINES_GRID = "#restorationProtectedMachinesGrid .text-with-icons-container";
    public static final String CSS_ELEMENT_RPS_GRID =  "#gview_restorationRecoveryPointsGrid [aria-describedby='restorationRecoveryPointsGrid_Contents']";
    public static final String CSS_WIZARD_QUESTION_MARK = "#ui-dialog-titlebar-hlp1 > span";
    public static final String CSS_R_BUTTON_BOOT_CD = "#recoverUsingBootCD";
    public static final String CSS_CANCEL_BOOT_CD =  ".icon-link>span";
    public static final String CSS_ISO_PATH =  "#outputIsoFile";
    public static final String CSS_BMR_IP =  "#ipAddress";
    public static final String CSS_BMR_KEY =  "#authenticationKey";
    public static final String CSS_RECOVER_USING_BOOT_CD_CHECKBOX= "#recoverUsingBootCD";
    public static final String CSS_HAVE_BOOT_CD_CHECKBOX =  "#alredyHaveBootCD";

    // Mount Wizard
    public static final String CSS_RESTORE_MACHINE_DRDWN = "#restoreMachine .dellap-caret-down";
    public static final String CSS_MOUNT_RP = "#restoreMachine .dellap-mount";
    public static final String CSS_ELEMENT_MACHINES_GRID_MOUNT = "#machineGrid [aria-describedby = 'machineGrid_DisplayName']";
    public static final String CSS_ELEMENT_RPS_GRID_MOUNT =  "#recoveryPointGrid [aria-describedby='recoveryPointGrid_Contents']";


    //Virtual Machine Export Wizard
    public static final String CSS_VM_Export = "#restoreMachine .dellap-export";
    public static final String CSS_ELEMENT_MACHINES_GRID_EXPORT = "#exportProtectedMachinesGrid .text-with-icons-container";
    public static final String CSS_ELEMENT_RPS_GRID_EXPORT =  "#exportRecoveryPointsGrid [aria-describedby='exportRecoveryPointsGrid_Contents']";
    public static final String CSS_EXPORT_WIZARD_DESTNATION_DRPDWN = "#dropdown-wrapper-recoverToVirtualMachine .dellap-caret-down";
    public static final String CSS_EXPORT_WIZARD_DESTINATION_VMWARE= "#dropdown-menu-recoverToVirtualMachine > ul > li:nth-child(2) > label"; // #dropdown-menu-recoverToVirtualMachine  [data-original-title = 'VMWare']
    public static final String CSS_EXPORT_WIZARD_VM_LOCATION_FIELD = "#wmWarelocation";
    @FindBy(css=CSS_EXPORT_WIZARD_VM_LOCATION_FIELD)
    WebElement vmLocation;
    public static final String CSS_EXPORT_WIZARD_VOLUMES_SELECT_ALL = "#jqgh_exportVolumeMappingGrid_cb";

    public void launchRestoreWizard(){
        WebElement restoreWizard = driver.findElement(By.cssSelector(CSS_RESTORE_WIZARD_HEADER));
        restoreWizard.click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }

    public void selectMachineInGrid(){
        driver.findElement(By.cssSelector(RestoreWizard.CSS_ELEMENT_MACHINES_GRID)).click();
    }
    public void selectRPinGrid(){
              driver.findElement(By.cssSelector(RestoreWizard.CSS_ELEMENT_RPS_GRID)).click();

    }
    public void selectCreateBootCD(){
        driver.findElement(By.cssSelector(RestoreWizard.CSS_R_BUTTON_BOOT_CD)).click();

    }
    public void fillBootCDOutputPath() {
        driver.findElement(By.cssSelector(CSS_ISO_PATH)).clear();
         SecureRandom random = new SecureRandom();
        String bootCDName =new BigInteger(20, random).toString(32);
        String path = "C:\\ProgramData\\AppRecovery\\BootCDs\\"+bootCDName+".iso";
        driver.findElement(By.cssSelector(CSS_ISO_PATH)).sendKeys(path);
    }
    public void cancelBootCD(){

        try {
            driver.findElement(By.cssSelector(CSS_CANCEL_BOOT_CD)).click();
        }catch ( ElementNotVisibleException e){

        }
    }

    public void recoverToTargetMachine(){
        driver.findElement(By.cssSelector(CSS_RECOVER_USING_BOOT_CD_CHECKBOX)).click();
        driver.findElement(By.cssSelector(CSS_HAVE_BOOT_CD_CHECKBOX)).click();
        driver.findElement(By.cssSelector(CSS_BMR_IP)).sendKeys(configurations.getInstance().getBmrIP());
        driver.findElement(By.cssSelector(CSS_BMR_KEY)).sendKeys(configurations.getInstance().getBmrKey());
    }
    public void launchVMExportWizard(){
        WebElement restoreDropdown= driver.findElement(By.cssSelector(CSS_RESTORE_MACHINE_DRDWN));
        restoreDropdown.click();
        WebElement vmExportWizard= driver.findElement(By.cssSelector(CSS_VM_Export));
        vmExportWizard.click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }

    public void selectMachineToVmExport(){
        driver.findElement(By.cssSelector(CSS_ELEMENT_MACHINES_GRID_EXPORT)).click();
    }
    public void selectRpToExport(){
        driver.findElement(By.cssSelector(CSS_ELEMENT_RPS_GRID_EXPORT)).click();

    }
    public void selectExportTypeVMWare(){
        try {
            driver.findElement(By.cssSelector(CSS_EXPORT_WIZARD_DESTNATION_DRPDWN)).click();
            driver.findElement(By.cssSelector(CSS_EXPORT_WIZARD_DESTINATION_VMWARE)).click();
        }catch (NoSuchElementException e){
            driver.findElement(By.cssSelector(CSS_EXPORT_WIZARD_DESTNATION_DRPDWN)).click();
            driver.findElement(By.cssSelector(CSS_EXPORT_WIZARD_DESTINATION_VMWARE)).click();
        }
    }

    public void fillVMOptionsFields(){
        WebElement vmLocation= driver.findElement(By.cssSelector(CSS_EXPORT_WIZARD_VM_LOCATION_FIELD));
        vmLocation.sendKeys(configurations.getInstance().getPathToFolderForVMWareExport());}

    //Mount Wizard
        public void launchMountWizard(){
            WebElement restoreDropdown= driver.findElement(By.cssSelector(CSS_RESTORE_MACHINE_DRDWN));
            restoreDropdown.click();
            WebElement mountWizard= driver.findElement(By.cssSelector(CSS_MOUNT_RP));
            mountWizard.click();
            waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }

    public void selectMachinesToMount(){
        driver.findElement(By.cssSelector(RestoreWizard.CSS_ELEMENT_MACHINES_GRID_MOUNT)).click();
    }

    public void selectRPToMount(){
        driver.findElement(By.cssSelector(RestoreWizard.CSS_ELEMENT_RPS_GRID_MOUNT)).click();
    }

}
