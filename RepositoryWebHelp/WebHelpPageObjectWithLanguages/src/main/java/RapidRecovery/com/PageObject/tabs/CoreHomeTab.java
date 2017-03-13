package RapidRecovery.com.PageObject.tabs;

import RapidRecovery.com.util.ConfigurationFileLoader;
import org.openqa.selenium.By;

/**
 * Created by 1 on 11/16/2016.
 */
public class CoreHomeTab extends BaseTab {

    // the tabs
    public static final String  CSS_SUMMARY_HELP = ".header-help-link [role=button]";

    // the links
    public static final String CSS_HELP_DROPDOWN = "#helpMenu .dellap-caret-down" ;
    public static final String CSS_HELP_MENU_HELP = ".dropdown-menu .dellap-help";

    public void openHomePage(){
        driver.get(generateURL(ConfigurationFileLoader.getInstance()));
    }
    public void openHelpDropdown(){
        driver.findElement(By.cssSelector(CoreHomeTab.CSS_HELP_DROPDOWN)).click();
    }

}
