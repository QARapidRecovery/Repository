package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;

/**
 * Created by 1 on 11/21/2016.
 */
public class EncryptionKeyTab extends BaseTab {
    public static final String CSS_MORE_DROPDOWN = "#coreNavigationMore";
    public static final String CSS_MORE_ENCRYPION_KEY=  "#coreNavigationMoreMenu [href*='Encryption']";
    public static final String CSS_HELP_ENCRYPION_KEY=   ".page-header  [data-onclick *= 'Help']";
    public static final String CSS_CREATE_ENCRYPION_KEY =  "#addNewEncryptionKey";
    public static final String CSS_DIALOG_WINDOW_QUESTION_MARK = ".ui-icon-help-left";
    public static final String CSS_DIALOG_WINDOW_CLOSE= ".ui-icon-closeright";
    public void openAddEncryptionKeyWindow(){
        driver.findElement(By.cssSelector(EncryptionKeyTab.CSS_CREATE_ENCRYPION_KEY)).click();
    }
}
