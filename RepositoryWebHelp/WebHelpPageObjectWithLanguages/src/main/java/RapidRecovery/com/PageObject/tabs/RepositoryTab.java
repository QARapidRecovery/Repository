package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;

/**
 * Created by 1 on 11/18/2016.
 */
public class RepositoryTab extends BaseTab {
    public static final String  CSS_REPOSITORY_HELP = ".header-help-link [role=button]";
    public static final String  CSS_DVM_REPOSITORY = "#dvmRepositoriesPlaceholder .header-help-link";
    public static final String  CSS_ADD_NEW_REPOSITORY ="#newMainRepository";
    //add new Repository window
    public static final String CSS_NEW_REPO_HELP_QUESTION_MARK=".ui-dialog-titlebar-help";
    // add new Repository-> add storage location
    public static final String  CSS_ADD_STORAGE_LOCATION = " [aria-labelledby = 'ui-id-3'] .dellap-plus";

    public static final String CSS_ADD_STORAGE_LOCATION_QUESTION_MARK= "#ui-dialog-titlebar-hlp2";

    public static final String CSS_CLOSE_DIALOG_ADD_NEW_REPO = "[aria-labelledby = 'ui-id-3']  .ui-icon-closeright";
    public static final String CSS_CLOSE_DIALOG_OPEN_EXISTING_DVM =  ".ui-icon-closeright";

    public static final String CSS_CLOSE_DIALOG_ADD_STORAGE_LOCATION = "[aria-labelledby = 'ui-id-4']  .ui-icon-closeright";
    public static final String CSS_OPEN_EXISTING_DVM = "#openMainRepository";
    public static final String CSS_OPEN_EXISTING_DVM_QUESTION_MARK =  "#ui-dialog-titlebar-hlp1";

    public void openExistingDVMRepo(){
        driver.findElement(By.cssSelector(RepositoryTab.CSS_OPEN_EXISTING_DVM)).click();
    }
    public void openAddNewRepositoryWindow(){
        driver.findElement(By.cssSelector(RepositoryTab.CSS_ADD_NEW_REPOSITORY)).click();
    }
    public void openAddStorageLocationWindow(){
        driver.findElement(By.cssSelector(RepositoryTab.CSS_ADD_STORAGE_LOCATION)).click();
    }
}
