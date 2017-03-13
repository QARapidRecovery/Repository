package RapidRecovery.com.PageObject.wizards;


import org.openqa.selenium.By;

public class ReplicationWizard extends BaseWizard {

    public static final String CSS_REPLICATION_WIZARD= "#replicateMachine";
    public static final String CSS_TARGET_HOSTNAME="#srtdHostName";
    public static final String CSS_EMAIL_ADDRESS_FIELD="#EmailAddress";
    public static final String CSS_SELECT_ALL_AGENTS_CHECK_BOX="#agentGrid_selectAll_triSpan";
    public static final String CSS_SELECT_SEED_DRIVE_CHECK_BOX= "#UseSeedDrive";
    public static final String CSS_SELECT_SEED_DRIVE_LOCATION_FIELD= "#localPath";

    public void launchReplicationWizard(){
        driver.findElement(By.cssSelector(ReplicationWizard.CSS_REPLICATION_WIZARD)).click();
        waitTillProgress(ProtectMachineWizard.CSS_OVERLAY);
    }

    public void specifyAExistingTargetCore(){
        driver.findElement(By.cssSelector(CSS_TARGET_HOSTNAME))
                .sendKeys(configurations.getInstance().getTargetCore().toString());
    }
    public void specifyEmailAddress(){
        driver.findElement(By.cssSelector(CSS_EMAIL_ADDRESS_FIELD))
                .sendKeys(configurations.getInstance().getEmail().toString());
    }

    public void selectAllAgents(){
        driver.findElement(By.cssSelector(ReplicationWizard.CSS_SELECT_ALL_AGENTS_CHECK_BOX)).click();
    }
    public void useASeedDrive(){
        driver.findElement(By.cssSelector(ReplicationWizard.CSS_SELECT_SEED_DRIVE_CHECK_BOX)).click();
    }
    public void specifySeedDriveLocation(){
        driver.findElement(By.cssSelector(CSS_SELECT_SEED_DRIVE_LOCATION_FIELD)).
              sendKeys(configurations.getInstance().getSeedDriveLocation());

    }



}
