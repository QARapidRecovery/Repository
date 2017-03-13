package RapidRecovery.com.PageObject.tabs;

import RapidRecovery.com.util.IncomingReplicationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by 1 on 11/16/2016.
 */
public class ReplicationTab extends BaseTab {

    public static final String CSS_REPLICATION_SUMMARY_HELP = ".header-help-link [role=button]";


    public static final String CSS_DIALOG_WINDOW_QUESTION_MARK=  " #ui-dialog-titlebar-hlp1 .ui-icon-help-left";
    public static final String CSS_OUTGOING_REPLICATION_SETTINGS=  ".navbar-right .dellap-settings";
    public static final String CSS_OUTGOING_REPLICATION_SETTINGS_BUTTON = " [aria-describedby = 'outgoingGrid_actions']";
    public static final String CSS_OUTGOING_REPLICATION_SCHEDULE_BUTTON =  ".p-s-important .dropdown-menu >li:nth-child(3)";
    public static final String CSS_INCOMING_REPLICATION_SETTINGS_BUTTON ="[aria-describedby = 'incomingGrid_actions']";
    public static final String CSS_INCOMING_REPLICATION_CONSUME_BUTTON =  "[data-onclick*='ConsumeSeedDriveDialog']";
    public static final String CSS_DIALOG_CLOSE_BUTTON =  ".ui-icon-closeright";

    public void openOutgoingReplicationSettings(){
        driver.findElement(By.cssSelector(ReplicationTab.CSS_OUTGOING_REPLICATION_SETTINGS)).click();
    }
    public void openReplicationScheduleWindow(){
        driver.findElement(By.cssSelector(ReplicationTab.CSS_OUTGOING_REPLICATION_SETTINGS_BUTTON)).click();
        driver.findElement(By.cssSelector(ReplicationTab.CSS_OUTGOING_REPLICATION_SCHEDULE_BUTTON)).click();
    }

public void consumeSeedDriveforIncomingReplication()throws IncomingReplicationException {
    try {
        List<WebElement> incomingReplicationGrid = driver.findElements(By.cssSelector(ReplicationTab.CSS_INCOMING_REPLICATION_SETTINGS_BUTTON));
        incomingReplicationGrid.get(0).click();
        WebElement consumeButton = driver.findElement(By.cssSelector(ReplicationTab.CSS_INCOMING_REPLICATION_CONSUME_BUTTON));
        new Actions(driver).moveToElement(consumeButton).click().perform();
    }catch (IndexOutOfBoundsException e){
        throw new IncomingReplicationException("Incoming replication is not found");
    }
}

}
