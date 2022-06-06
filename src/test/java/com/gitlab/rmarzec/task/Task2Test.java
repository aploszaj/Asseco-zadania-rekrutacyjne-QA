package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.model.Task2Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Task2Test {
    DriverFactory driverFactory = new DriverFactory();
    WebDriver webDriver = driverFactory.initDriver();
    private static Logger log = LoggerFactory.getLogger(Task2Test.class);


    @Test
    public void verifyExistingLanguages() throws Exception {
        //BasicConfigurator.configure();
        Task2Page task2Page = new Task2Page(webDriver);
        List<WebElement> languages = new ArrayList<>();

        try {
            webDriver.get("https://pl.wikipedia.org/wiki/Wiki");
            Assert.assertEquals(webDriver.getCurrentUrl(), "https://pl.wikipedia.org/wiki/Wiki",
                    "The requested page has NOT been loaded");

            for (WebElement language : task2Page.listOfLanguages) {
                String languageString = language.getText();

                if (languageString.equals("English")) {
                    String link = language.getAttribute("href");
                    System.out.println(languageString + ": " + link);
                } else
                    System.out.println(languageString);

                languages.add(language);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

