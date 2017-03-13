package framework.pageObject.steps;

import org.openqa.selenium.By;

/**
 * Created by 1 on 2/22/2017.
 */
public class WarningStep extends BaseStep {

    public boolean isWarningPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
