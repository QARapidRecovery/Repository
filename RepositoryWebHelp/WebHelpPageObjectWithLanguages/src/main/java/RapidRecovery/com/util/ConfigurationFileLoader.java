package RapidRecovery.com.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Orfeika on 11/30/2016.
 */
public class ConfigurationFileLoader {

    private static final String PROPERTIES_FILE = "/config.properties";
    private static final ConfigurationFileLoader INSTANCE = new ConfigurationFileLoader();
    private final  Properties properties;

    private ConfigurationFileLoader() {
        properties = new Properties();
        loadPropertiesFromFile();


    }

    public static ConfigurationFileLoader getInstance() {
        return INSTANCE;
    }


    private void loadPropertiesFromFile() {
        try {
            properties.load(ConfigurationFileLoader.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't get properties from " + PROPERTIES_FILE, e);
        }
    }


        public String getCoreIP(){
            return properties.getProperty("CoreIP").toString();
        }

        public String getCoreUser(){
            return  properties.getProperty("CoreUser").toString();
        }

        public String getCorePassword(){return  properties.getProperty("CorePassword").toString();}

    public String getCorePort(){
        return  properties.getProperty("CorePort").toString();
    }

    public String getArchiveLocation(){
        return  properties.getProperty("archiveLocation").toString();
    }

    public String getHyperVHost(){
        return  properties.getProperty("hyperVHost").toString();
    }

    public String getHyperVLogin(){
        return  properties.getProperty("hyperVLogin").toString();
    }

    public String getHyperVPassword(){
        return  properties.getProperty("hyperVPassword").toString();
    }

    public String getEmail(){
        return  properties.getProperty("email").toString();
    }

    public String getSeedDriveLocation(){
        return  properties.getProperty("seedDriveLocation").toString();
    }


    public String getProtectAgentManual(){
        return  properties.getProperty("protectAgentManual").toString();
    }

    public String getRepositoryName(){
        return  properties.getProperty("repositoryName").toString();
    }
    public String getRepositoryLocation(){
        return  properties.getProperty("repositoryLocation").toString();
    }

    public String getProtectHostname(){
        return  properties.getProperty("hostname").toString();
    }

    public String getProtectLogin(){
        return  properties.getProperty("login").toString();
    }

    public String getProtectPassword(){
        return  properties.getProperty("password").toString();
    }
    public String getPathToArchiveForImport(){
        return  properties.getProperty("pathToArchiveForImport").toString();
    }
    public String getPathToFolderForVMWareExport(){return  properties.getProperty("pathToFolderForVMWareExport").toString();}
    public String getTargetCore(){return properties.getProperty("targetCore").toString();}
    public String getClusterIP() {return properties.getProperty("clusterIP").toString();}
    public String getClusterHostName() {return properties.getProperty("clusterHostName").toString();}
    public String getClusterPassword() {return properties.getProperty("clusterPassword").toString();}
    public String getBmrIP(){return properties.getProperty("BmrIP").toString();}
    public String getBmrKey(){return properties.getProperty("BmrKey").toString();}
    public String getAgentName(){return properties.getProperty("AgentName").toString();}





}
