package com.emurugova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface MainConfig extends Config{

        @Config.Key("remoteUrl")
        String getRemoteUrl();

        @Config.Key("remoteLogin")
        String getRemoteLogin();

        @Config.Key("remotePassword")
        String getRemotePassword();
    }
