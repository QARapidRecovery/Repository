package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;


public class BootCDTab extends BaseTab {

    public static final String CSS_MORE_DROPDOWN = "#coreNavigationMore";
    public static final String CSS_MORE_BOOT_CD=  "#coreNavigationMoreMenu [href*='BootCD']";
    public static final String CSS_HELP_BOOT_CD =   ".page-header  [data-onclick *= 'Help']";
    public static final String CSS_CREATE_BOOT_CD =  "#createNewBootCD";
    public static final String CSS_DIALOG_WINDOW_QUESTION_MARK = ".ui-icon-help-left";
    public static final String CSS_DIALOG_WINDOW_CLOSE= ".ui-icon-closeright";
    public void openCreateBootCDWindow(){
        driver.findElement(By.cssSelector(BootCDTab.CSS_CREATE_BOOT_CD)).click();
    }
}
