import framework.pageObject.steps.BaseStep;
import framework.pageObject.steps.VMExportTypeStep;
import framework.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String URL = "https://administrator:123asdQ@10.35.180.155:8006/apprecovery/admin";

    WebDriver driver;
    WebDriverWait wait;
    VMExportTypeStep vmExportTypeStep;
    BaseStep baseStep;

    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getInstance().createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,20);
        baseStep = new BaseStep();
    }

    @BeforeMethod
    public void beforeBaseMethod() {
        driver.get(URL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
