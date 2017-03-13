package RapidRecovery.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class WebHelpPage {

    private Properties myProperties;

     public WebHelpPage(String language) {
        final String propertiesFileName = "/languages/" + language + "_localization.properties";
        myProperties = new Properties();
        try {
            InputStream inputStream= WebHelpPage.class.getResourceAsStream(propertiesFileName);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            myProperties.load(reader);
          ;


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't get properties from " + propertiesFileName, e);
        }
    }

    public String getLocalizedText(String propertyName) {

        return myProperties.getProperty(propertyName);
    }

    public static String getLocalizedText(String propertyName, String language) {
        final String propertiesFileName = "/" + language + "_localization.properties";
        Properties properties = new Properties();
        try {
            properties.load(WebHelpPage.class.getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't get properties from " + propertiesFileName, e);
        }
        return properties.getProperty(propertyName);
    }


    public static final String CSS_WEBHELP_HEADER = "h1";

    // Summary Tab->Dashboard view ->

    public static final String TEXT_SUMMARY_TAB = "SummaryInfo";
    // Summary tab ->Help->?
    public static final String TEXT_INTRODUCTION = "HelpHelp";
    //Replication tab -> ?

    public static final String TEXT_REPL_TAB = "UnderstandingReplication";

    //Replication tab -> Outgoing replication -> Settings->?

    public static final String TEXT_OUT_REPL_SETTINGS = "ManagingSettingsForOutgoingReplication";

    public static final String TEXT_OUT_REPL_SCHEDULE = "SchedulingReplication";


    //Incoming replication-> Settings->Consume

    public static final String TEXT_CONSUME_SEED_DRIVE = "ConsumingTheSeedDrive";
    // Settings tab -> ?
    public static final String TEXT_SETTINGS = "ManagingCoreSettings";

    // Settings tab -> General
    public static final String TEXT_SETTINGS_GENERAL = "ConfiguringCoreGeneralSettings";

    // Settings tab -> UPDATES
    public static final String TEXT_SETTINGS_UPDATES = "ConfiguringUpdateSettings";

    // Settings tab ->NIGHTLY JOBS
    public static final String TEXT_SETTINGS_NIGHTLY_JOBS = "ConfiguringNightlyJobs";

    // Settings tab ->REPLAY ENGINE
    public static final String TEXT_SETTINGS_REPLAY_ENGINE = "ReplayEngineSettings";

    // Settings tab ->SMTP
    public static final String TEXT_SETTINGS_SMTP = "ConfiguringAnEmailServer";

    // Settings tab ->REPORTS
    public static final String TEXT_SETTINGS_REPORTS = "ManagingReportSettings";

    // Settings tab ->ATTACHABILILTY
    public static final String TEXT_SETTINGS_ATTACHABILILTY = "ManagingCoreSQLAttachability";

    // Settings tab ->JOBS
    public static final String TEXT_SETTINGS_JOBS = "CoreJobSettings";

    // Settings tab ->LICENSES
    public static final String TEXT_SETTINGS_LICENSES= "ManagingLicenses";

    //Settings tab -> Back Up -> ?

    public static final String TEXT_SETTINGS_BACK_UP= "BackupRestoreCoreSettings";

    //Settings tab -> Restore -> ?
    public static final String TEXT_SETTINGS_RESTORE = "BackupRestoreCoreSettings";

    //protect machine wizard -> ?
    public static final String TEXT_PRT_WIZARD =  "ProtectingMachine";

    // protect machine wizard -> protection  step

    public static final String TEXT_PRT_CLUSTER =   "ProtectingCluster";

    public static final String TEXT_PRT_WIZARD_PROTECTION  = "UnderstandingProtectionSchedule";

    // protect machine wizard -> protection schedule step


    public static final String TEXT_PRT_WIZARD_PROTECTION_SCHEDULE  ="CreatingCustomProtectionSchedule";

    //
    public static final String TEXT_DEPLOY_AGENT_SOFTWARE_WIZARD  ="DeployAgentSoftware";


    // Repository tab summary

    public static final String TEXT_REPOSITORY_SUMMARY  = "UnderstandingRepositories";

    // Repository tab->DVN Repositories

    public static final String TEXT_REPOSITORY_DVM  = "ManagingDVMRepository";

    // Protect machine wizard -> repository step


    public static final String TEXT_CREATE_REPOSITORY = "CreatingDVMRepository" ;

    public static final String  TEXT_OPEN_EXISTING_REPOSITORY = "OpeningAnExistingRepository";


    // Protect machine wizard -> encryption step

    public static final String TEXT_ADDING_ENCRYPTION_KEY = "AddEncryption";

    // Protect multiple machines wizard -> welcome, connection, machines,
    public static final String  TEXT_PRT_MLT_WIZARD =  "ProtectMultipleMachine";

    //Restore Wizard -all

    public static final String  TEXT_RESTORE_WIZARD =  "RestoringDataFromRP";


    public static final String TEXT_MOUNT_RP =  "MountingRP";

    public static final String TEXT_VIRTUAL_EXPORT_WIZARD = "ManaginExports";


    public static final String TEXT_SEED_DRIVE__REPL_WIZARD =   "DeterminingSeedingNeeds";

    public static final String TEXT_IMPORT_ARCHIVE = "ImportArchive";

    public static final String TEXT_ATTACH_ARCHIVE = "AttachingAnArchive";

    public static final String TEXT_CREATE_ARCHIVE = "CreatingAnArchive";

    public static final String TEXT_SCHEDULED_ARCHIVE = "PauseResumeScheduledArchive";

    public static final String TEXT_CHECK_ARCHIVE =  "CheckAnArchive";

    public static final String TEXT_EVENTS = "ViewingEventsUsingTasks";


    public static final String TEXT_SYSTEM_INFO  =  "UnderstandingSystemInfo";

    public static final String TEXT_DISMOUNTING_RP  =  "DismountingRP";
    public static final String TEXT_CREATING_BOOT_CD  = "CreatingBootCD";
    public static final String TEXT_ENCRYPTION_KEY  = "EncryptionKeys";
    public static final String TEXT_CLOUD_ACCOUNTS  = "Cloud storage accounts";

    public static final String TEXT_SUMMARY_REPORT  =  "UnderstandingTheSummaryReport";

    public static final String TEXT_FILE_SEARCH = "FindingAndRestoringFile";


//Agent
    public static final String TEXT_DOWNLOAD_CORE_LOGS ="DownloadingViewingLogFile";
    public static final String TEXT_CONFIGURE_EMAIL_TEMPLATE = "ConfiguringAnEmailNotificationTemplate";
    public static final String TEXT_CORE_RETENTION_POLICY ="ConfiguringCoreDefaultRetentionPolicySettings";
    public static final String TEXT_AGENT_RECOVERY_POINTS =  "SummaryInformationProtectedMachines";
    public static final String TEXT_AGENT_SETTINGS =  "ConfiguringMachineSettings";
    public static final String TEXT_AGENT_SETTINGS_GENERAL = "ModifyingProtectedMachineSettings";
    public static final String TEXT_AGENT_SETTINGS_NIGHTLY_JOBS = "CustomizingNightlyJobsForPM";
    public  static final String TEXT_JOB_REPORT = "UnderstandingTheJobReport";
    public static final String TEXT_AGENT_LICENSE_DETAILS ="ViewingLicenseInformation";
    public  static final String TEXT_FAILURE_REPORT = "UnderstandingTheFailureReport";
    public  static final String TEXT_RETENTION_POLICY = "ManagingRetentionPolicies";
    public  static final String TEXT_NOTIFICATIONS = "ConfiguringNotificationGroups";
    public  static final String TEXT_AGENT_LOGS = "ViewingMachineLogs";



//Wizards steps names

    public static final String TEXT_CONNECTION =  "Connection";
    public static final String TEXT_MACHINES = "Machines";
    public static final String TEXT_ADJUSTMENTS = "Adjustments";
    public static final String TEXT_WELCOME = "Welcome";
    public static final String TEXT_PROTECTION = "Protection";
    public static final String TEXT_PROTECTION_VOLUMES = "ProtectionVolumes";
    public static final String  TEXT_PROTECTION_SCHEDULE = "ProtectionSchedule";
    public static final String  TEXT_REPOSITORY =  "Repository";
    public static final String  TEXT_REPOSITORY_CONFIGURATION ="RepositoryConfiguration";
    public static final String  TEXT_ENCRYPTION ="Encryption";
    // Protect Multiple Machines Wizard
    public static final String TEXT_SELECT_MACHINES = "SelectMachines";
    //Restore Wizard
    public static final String TEXT_SUMMARY = "Summary";
    public static final String TEXT_RECOVERY_POINTS = "RecoveryPoints";
    public static final String TEXT_DESTINATION =  "Destination";
    public static final String TEXT_VOLUME_MAPPING ="VolumeMapping";
    public static final String TEXT_DISK_MAPPING ="DiskMapping";
    public static final String TEXT_DISMOUNT_DB ="DismountDatabases";
    public static final String TEXT_WARNING ="Warnings";
    public static final String TEXT_BOOT_CD ="BootCD";
    public static final String TEXT_DRIVE_INJECTION ="DriverInjection";
    public static final String TEXT_ISO_IMAGE ="ISOImage";
    //VM Export Wizard
    public static final String TEXT_VM_EXPORT_TYPE ="SelectVMExportType";
    public static final String TEXT_VM_OPTIONS ="VirtualMachineOptions";
    public static final String TEXT_VOLUMES ="Volumes";
    public static final String TEXT_MOUNT_OPTIONS = "MountOptions";
//Replication Wizard

    public static final String TEXT_TARGET_CORE = "TargetCore";
    public static final String TEXT_REQUEST ="Request";
    public static final String TEXT_PROTECTED_MACHINES="ProtectedMachines";
    public static final String  TEXT_SEED_DRIVE_LOCATION = "SeedDriveLocation";
    public static final String  TEXT_SEED_DRIVE_OPTIONS = "SeedDriveOptions";

    public static final String TEXT_LOCATION = "Location";
    public static final String TEXT_ARCHIVE_TYPE = "ArchiveType";
    public static final String TEXT_OPTIONS = "Options";
    public static final String TEXT_DATE_RANGE = "DateRange";
    public static final String TEXT_IMPORT_TYPE = "ImportType";
    public static final String TEXT_ARCHIVE_INFORMATION = "ArchiveInformation";

}
