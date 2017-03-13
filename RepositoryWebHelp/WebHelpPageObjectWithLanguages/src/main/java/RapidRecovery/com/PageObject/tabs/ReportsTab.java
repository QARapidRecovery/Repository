package RapidRecovery.com.PageObject.tabs;

import org.openqa.selenium.By;

/**
 * Created by 1 on 11/21/2016.
 */
public class ReportsTab extends BaseTab {
    public static final String CSS_MORE_DROPDOWN = "#coreNavigationMore";
    public static final String CSS_MORE_REPORTS =  "#coreNavigationMoreMenu [href*='Reports']";
    public static final String CSS_HELP_REPORTS =   ".header-help-link [data-onclick *= 'Help']";
    public static final String CSS_HELP_REPORTS_DROPDOWN =  ".dropdown-toggle .caret";
    public static final String CSS_JOB_SUMMARY_REPORT =  " [href*='CoreJobSummaryReport']";
    public static final String CSS_JOB_REPORT =  " [href*='CoreJobReport']";
    public static final String CSS_FAILURE_REPORT =  " [href*='CoreFailureReport']";

    public static final String CSS_SUMMARY_REPORT =  " [href*='CoreSummaryReport']";
    public static final String CSS_REPOSITORY_REPORT =  " [href*='CoreRepositoryReport']";
    public static final String CSS_SCHEDULED_REPORT =  " [href*='ScheduledReport']";

    public void selectSummaryReport(){
        driver.findElement(By.cssSelector(ReportsTab.CSS_HELP_REPORTS_DROPDOWN)).click();
        driver.findElement(By.cssSelector(ReportsTab.CSS_SUMMARY_REPORT)).click();
    }
    public void selectFailureReport(){
        driver.findElement(By.cssSelector(ReportsTab.CSS_HELP_REPORTS_DROPDOWN)).click();
        driver.findElement(By.cssSelector(ReportsTab.CSS_FAILURE_REPORT)).click();
    }




}
