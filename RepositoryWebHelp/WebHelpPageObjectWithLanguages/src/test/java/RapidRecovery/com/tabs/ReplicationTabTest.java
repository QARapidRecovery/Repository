package RapidRecovery.com.tabs;

import RapidRecovery.com.PageObject.enums.LocalizedLanguages;
import RapidRecovery.com.PageObject.tabs.BaseTab;
import RapidRecovery.com.PageObject.tabs.ReplicationTab;
import RapidRecovery.com.WebHelpPage;
import RapidRecovery.com.util.IncomingReplicationException;
import org.testng.annotations.BeforeMethod;

public class ReplicationTabTest extends BaseTabTest {


    public ReplicationTabTest(LocalizedLanguages language) {
        this.language = language;
    }

    @BeforeMethod
    public void beforeMethod()
    {    replicationTab = new ReplicationTab();
        replicationTab.openTab(BaseTab.Tabs.ReplicationTab);
        language.printLanguageByKey();

    }

    @org.testng.annotations.Test
    public void replicationSummaryWebHelp() {
        replicationTab.checkWebHelp(ReplicationTab.CSS_REPLICATION_SUMMARY_HELP, webHelpPage.getLocalizedText(WebHelpPage.TEXT_REPL_TAB));
    }

    @org.testng.annotations.Test
    public void outgoingReplicationSettings() {
        replicationTab.openOutgoingReplicationSettings();
        replicationTab.checkWebHelp(ReplicationTab.CSS_DIALOG_WINDOW_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_OUT_REPL_SETTINGS));
        replicationTab.closeDialogWindow();

    }

    @org.testng.annotations.Test
    public void outgoingReplicationSchedule() {
        replicationTab.openReplicationScheduleWindow();
        replicationTab.checkWebHelp(ReplicationTab.CSS_DIALOG_WINDOW_QUESTION_MARK, webHelpPage.getLocalizedText(WebHelpPage.TEXT_OUT_REPL_SCHEDULE));
        replicationTab.closeDialogWindow();

    }

    @org.testng.annotations.Test
    public void incomingReplicationConsume() throws IncomingReplicationException {
        replicationTab.consumeSeedDriveforIncomingReplication();
        replicationTab.checkWebHelp(ReplicationTab.CSS_DIALOG_WINDOW_QUESTION_MARK,webHelpPage.getLocalizedText(WebHelpPage.TEXT_CONSUME_SEED_DRIVE));
        replicationTab.closeDialogWindow();
    }


}
