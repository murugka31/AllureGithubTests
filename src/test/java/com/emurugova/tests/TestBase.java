package com.emurugova.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.emurugova.config.MainConfig;
import com.emurugova.helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase{

    public static MainConfig config = ConfigFactory.create(MainConfig.class);

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo",true);

        Configuration.remote = format("https://%s:%s@%s", config.getRemoteLogin(), config.getRemotePassword(), config.getRemoteUrl());
        Configuration.browserSize = "2100x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    public void attachMethods() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
    }
}
