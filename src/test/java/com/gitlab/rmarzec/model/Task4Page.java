package com.gitlab.rmarzec.model;

import com.gitlab.rmarzec.consts.Task3Consts;
import com.gitlab.rmarzec.consts.Task4Consts;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Task4Page {
    WebDriver webDriver;
    public static final Logger log = Logger.getLogger(Task3Page.class);

    public Task4Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = Task4Consts.YT_ACCEPT_COOKIES_BTN)
    public WebElement ytAcceptCookiesBtn;
}
