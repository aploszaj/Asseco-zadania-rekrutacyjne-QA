package com.gitlab.rmarzec.model;

import com.gitlab.rmarzec.consts.Task2Consts;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Task2Page {
    WebDriver webDriver;
    public static final Logger log = Logger.getLogger(Task2Page.class);


    public Task2Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = Task2Consts.LANGUAGE_LIST)
    public List<WebElement> listOfLanguages;


}
