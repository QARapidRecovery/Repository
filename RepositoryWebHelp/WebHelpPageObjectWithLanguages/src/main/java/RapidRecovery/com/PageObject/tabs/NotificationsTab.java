package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;

/**
 * Created by 1 on 11/23/2016.
 */
public class NotificationsTab extends BaseTab {
    public static final String  CSS_ADD_NOTIFICATION_GROUP = "#addNotificationGroup";
    public static final String  CSS_DIALOG_WINDOW_QUESTION_MARK = ".ui-dialog-titlebar-help";
    public static final String  CSS_DIALOG_WINDOW_CLOSE = ".ui-icon-closeright";
    public static final String CSS_MORE_DROPDOWN = "#coreNavigationMore";
    public static final String CSS_MORE_NOTIFICATIONS = "#coreNavigationNotifications";
    public static final String CSS_NOTIFICATIONS_SETTINGS ="#gview_eventsNotificationGroupsGrid [data-toggle = 'dropdown']";
    public static final String CSS_NOTIFICATIONS_SETTINGS_EDIT = ".dropdown-menu [data-onclick*= 'ShowEditDialog']";
    public static final String CSS_EDIT_EMAIL_SETTINGS= "#emailSettingsToolbar [data-onclick*='EmailNotificationConfigurationEdit']";

    public void openAddNotificationGroupWindow(){
        driver.findElement(By.cssSelector(NotificationsTab.CSS_ADD_NOTIFICATION_GROUP)).click();

    }

    public void openEditNotificationGropWindow(){
        driver.findElement(By.cssSelector(NotificationsTab.CSS_NOTIFICATIONS_SETTINGS)).click();
        driver.findElement(By.cssSelector(NotificationsTab.CSS_NOTIFICATIONS_SETTINGS_EDIT)).click();
    }
    public void openEditEmailNotificationsConfigWindow(){
        driver.findElement(By.cssSelector(NotificationsTab.CSS_EDIT_EMAIL_SETTINGS)).click();
    }


}
