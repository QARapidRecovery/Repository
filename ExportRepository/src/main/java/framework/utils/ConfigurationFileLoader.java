package framework.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by 1 on 1/24/2017.
 */
public class ConfigurationFileLoader {
    private static final String PROPERTIES_FILE = "/config.properties";
    private static final ConfigurationFileLoader INSTANCE = new ConfigurationFileLoader();
    private final Properties properties;

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
    public String getExportedVMHostName(){
        return  properties.getProperty("ExportedVMHostName").toString();
    }
    public String getHyperVHostName(){
        return  properties.getProperty("HyperVHostName").toString();
    }
    public String getHyperVHostLogin(){
        return  properties.getProperty("HyperVHostLogin").toString();
    }
    public String getHyperVHostPassword(){
        return  properties.getProperty("HyperVHostPassword").toString();
    }
    public String getHyperVMachineLocation(){
        return  properties.getProperty("HyperVMachineLocation").toString();
    }
    public String getESXiHostName(){
        return  properties.getProperty("ESXiHostName").toString();
    }
    public String getESXiHostLogin(){
        return  properties.getProperty("ESXiHostLogin").toString();
    }
    public String getESXiHostPassword(){
        return  properties.getProperty("ESXiHostPassword").toString();
    }
    public String getVMWareLocation(){return  properties.getProperty("VMWareLocation").toString();}
    public String getVMWareNetworkLocation(){return  properties.getProperty("VMWareNetworkLocation").toString();}
    public String getVMWareVMWareShareUsername(){return  properties.getProperty("VMWareShareUsername").toString();}
    public String getVMWareVMWareSharePassword(){return  properties.getProperty("VMWareSharePassword").toString();}
    public String getVirtualBoxTargetPath(){
        return  properties.getProperty("VirtualBoxTargetPath").toString();
    }
    public String getAzurePublishSettingsFile(){return  properties.getProperty("AzurePublishSettingsFile").toString();}





}
