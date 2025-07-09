package biz.promanage.utils;


import biz.promanage.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.DEV));
        switch (EnvType.valueOf(env)) {
        case DEV:
            properties = FileReader.propertyLoader("src/test/resources/dev_config.properties");
            break;
        case PROD:
            properties = FileReader.propertyLoader("src/test/resources/prod_config.properties");
            break;
        default:
            throw new IllegalStateException("Invalid env type: " + env);	
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the dev_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the dev_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the dev_config.properties file");
    }
}
