package RapidRecovery.com.PageObject.wizards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchiveWizard extends BaseWizard {


    public static final String CSS_ARCHIVE_DROPDOWN =  "#archiveMachine .dellap-caret-down";
    public static final String CSS_IMPORT_ARCHIVE_WIZARD  =  ".dellap-import";
    public static final String CSS_ATTACH_ARCHIVE_WINDOW =  " #archiveMachine .dellap-mount";
   public static final String CSS_OPEN_ARCHIVE_WIZARD =  "#archiveMachine";
    public static final String CSS_ARCHIVE_WIZARD_SELECT_ALL_MACHINES = "#machinesGrid_selectAll_triSpan";
    public static final String CSS_ARCHIVE_LOCATION = "#localPath";
    public static final String CSS_IMPORT_ALL_ARCHIVES_CHECKBOX = " #isAllAgents";
    public static final String CSS_ATTACH_ARCHIVE_QUESTION_MARK=  " #ui-dialog-titlebar-hlp1 .ui-icon-help-left";



//Archive Wizard

    public void launchArchiveWizard(){

         waitTillProgress(CSS_OVERLAY);
        driver.findElement(By.cssSelector(CSS_OPEN_ARCHIVE_WIZARD)).click();

    }


    public void fillArchiveLocationField(){
        WebElement archiveLocation = driver.findElement(By.cssSelector(CSS_ARCHIVE_LOCATION));
        archiveLocation.sendKeys(configurations.getInstance().getArchiveLocation());
    }

    public  void selectAllMachines(){
        WebElement archiveWizardSelectAllMachines = driver.findElement(By.cssSelector(CSS_ARCHIVE_WIZARD_SELECT_ALL_MACHINES));
        archiveWizardSelectAllMachines.click();
    }

// Import Archive Wizard

    public void launchImportArchiveWizard(){
        launchWizard(CSS_ARCHIVE_DROPDOWN,CSS_IMPORT_ARCHIVE_WIZARD );
        waitTillProgress(CSS_OVERLAY);
    }

    public void fillImportArchiveLocationField(){
        WebElement archiveLocation = driver.findElement(By.cssSelector(CSS_ARCHIVE_LOCATION));
        archiveLocation.sendKeys(configurations.getInstance().getPathToArchiveForImport());
    }

    public void deselectImportAllMachines(){
        WebElement importAllMachinesInArchive = driver.findElement(By.cssSelector(CSS_IMPORT_ALL_ARCHIVES_CHECKBOX));
        importAllMachinesInArchive.click();
        waitTillProgress(CSS_OVERLAY);
    }









}
