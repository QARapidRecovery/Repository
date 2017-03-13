package framework.pageObject.section;

import framework.pageObject.PageObject;
import framework.pageObject.steps.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderLeftSection extends PageObject {
    public static final String CSS_RESTORE_MACHINE_MENU = "#restoreMachine .aa-caret-down";
    public static final String CSS_VM_Export = "#restoreMachine #export";
    public static final String CSS_RESTORE_MACHINE = "#restoreMachine [data-onclick*= 'Restoration']";
    public static final String CSS_MOUNT_RP = "#restoreMachine [data-onclick*= 'Mount']";
    private final WebElement headerLeftSection;

    public HeaderLeftSection(WebElement headerLeftSection) {
        this.headerLeftSection = headerLeftSection;
    }

    public BaseStep selectExportWizard(){
        openWizard(TopMenu.VM_EXPORT);
        return new BaseStep();
    }

    public BaseStep selectRestoreWizard(){
        openWizard(TopMenu.RESTORE_MACHINE);
        return new BaseStep();
    }

    public BaseStep selectMountRPWizard(){
        openWizard(TopMenu.MOUNT_RP);
        return new BaseStep();
    }


    private void openWizard(TopMenu menu) {
        //click on parent menu element
        WebElement menuElement = driver.findElement(By.cssSelector(menu.menuCss));
        menuElement.click();
        WebElement subMenuElement = driver.findElement(By.cssSelector(menu.submenuCss));
        subMenuElement.click();
    }



     private enum TopMenu {
        VM_EXPORT(CSS_RESTORE_MACHINE_MENU, CSS_VM_Export),
        RESTORE_MACHINE(CSS_RESTORE_MACHINE_MENU, CSS_RESTORE_MACHINE),
        MOUNT_RP(CSS_RESTORE_MACHINE_MENU, CSS_MOUNT_RP);

        private String menuCss;
        private String submenuCss;

        TopMenu(String menuCss, String submenuCss) {
            this.menuCss = menuCss;
            this.submenuCss = submenuCss;

        }
    }


}
