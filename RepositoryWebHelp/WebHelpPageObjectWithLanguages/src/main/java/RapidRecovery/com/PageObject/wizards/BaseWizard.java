package RapidRecovery.com.PageObject.wizards;

import RapidRecovery.com.PageObject.PageObject;
import RapidRecovery.com.util.ConfigurationFileLoader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Set;


public class BaseWizard extends PageObject {


    ConfigurationFileLoader configurations;
    public static final String CSS_WIZARD_STEP_HEADER = "#wizardContentContainer h3";
    public static final String CSS_WIZARD_NEXT_BUTTON = "#btnWizardDefault";
    public static final String CSS_WIZARD_CLOSE_BUTTON = ".ui-dialog-icon.ui-icon-closeright";
    public static final String CSS_CLOSE_WARNING= "#dialog .default";
    public static final String CSS_OVERLAY = "div .ui-widget-overlay";
    public static final String  CSS_WIZARD_QUESTION_MARK ="#ui-dialog-titlebar-hlp1 > span";




    public void launchWizard(String cssLaunchWizard){
        WebElement webelement = driver.findElement(By.cssSelector(cssLaunchWizard));
        webelement.click();
    }

    public void launchWizard(String cssWizardDropdown, String cssLaunchWizard){
        WebElement openDropdown = driver.findElement(By.cssSelector(cssWizardDropdown));
        openDropdown.click();
        WebElement launchWizard = driver.findElement(By.cssSelector(cssLaunchWizard));
        launchWizard.click();
    }

    public void checkWebHelpWizard(String cssToHelpLink, String webHelpText, String stepHeaderName  ) {
        waitTillProgress(CSS_LOADING,10,20);
        String winHandleBefore = driver.getWindowHandle();
        WebElement stepHeader = driver.findElement(By.cssSelector(CSS_WIZARD_STEP_HEADER));
        System.out.println(stepHeader.getText() + " step");
        Assert.assertTrue(stepHeaderName.equals(stepHeader.getText()));
        // Perform the click operation that opens new window
        driver.findElement(By.cssSelector(cssToHelpLink)).click();
        // Switch to new window opened
        Set<String> windowHandles = driver.getWindowHandles();
        //Get active windows , while size of windowsHandles list  is equal or lover than 1.
        while (windowHandles.size()<=1){
            windowHandles = driver.getWindowHandles();
        }
        for(String winHandle : windowHandles){
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
        // Perform the actions on new window
        if(checkQuestionMark(webHelpText)== false){
            driver.switchTo().window(winHandleBefore);
            throw new AssertionError (" Text in link does not match with expected text" + "\n (" + webHelpText +")");
        }
/// Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
    }


    public void proceedToNextStep(){
        waitTillProgress(CSS_OVERLAY);
        waitTillProgress(CSS_LOADING,10,30);
        WebElement nextButton= driver.findElement(By.cssSelector(CSS_WIZARD_NEXT_BUTTON));
        nextButton.click();
    }

    public void closeWizard(){
        try {
            WebElement closeButton= driver.findElement(By.cssSelector(CSS_WIZARD_CLOSE_BUTTON));
            WebElement closeWarning= driver.findElement(By.cssSelector(CSS_CLOSE_WARNING));
            closeButton.click();
            closeWarning.click();
        }catch (ElementNotVisibleException| NoSuchElementException e){

        }
    }


}
