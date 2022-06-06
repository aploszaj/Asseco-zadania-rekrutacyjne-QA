package com.gitlab.rmarzec.model;

import com.gitlab.rmarzec.consts.Task3Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

public class Task3Page {
    WebDriver webDriver;
    public static final Logger log = Logger.getLogger(Task3Page.class);

    public Task3Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = Task3Consts.GOOGLE_SEARCH_FIELD)
    public WebElement googleSearchField;

    @FindBy(css = Task3Consts.GOOGLE_ACCEPT_COOKIES_BTN)
    public WebElement googleAcceptCookiesBtn;

    @FindBy(css = Task3Consts.FEELING_LUCKY_BTN)
    public WebElement feelingLuckyBtn;

    @FindBy(css = Task3Consts.W3SCHOOL_ACCEPT_COOKIES_BTN)
    public WebElement w3schoolAcceptCookiesBtn;

    @FindBy(css = Task3Consts.TRY_IT_YOURSELF)
    public WebElement tryItYourselfBtn;

    @FindBy(xpath = Task3Consts.EXAMPLE_HEADER)
    public WebElement exampleHeader;

    @FindBy(name = Task3Consts.SELECT_CARS_CHEVRON_BTN)
    public WebElement selectCarsChevronBtn;

    @FindBy(css = Task3Consts.CAR_LIST)
    public List<WebElement> carList;

    public WebDriver switchToFrameByIdOrName(String frameIdOrName) {
        if (!(webDriver instanceof FirefoxDriver)) {
            return webDriver.switchTo().frame(frameIdOrName);
        }
        WebElement frame = null;
        try {
            frame = webDriver.findElement(By.cssSelector("iframe[id='" + frameIdOrName + "']"));
        } catch (NoSuchElementException e) { /* It's ok for the moment */ }

        if (frame == null) {
            try {
                frame = webDriver.findElement(By.cssSelector("iframe[name='" + frameIdOrName + "']"));
            } catch (NoSuchElementException e) {
                log.warn(String.format("CORE > switchToFrameByIdOrName() error: Frame with name or id '%s' not found.", frameIdOrName));
            }
        }
        return webDriver.switchTo().frame(frame);
    }
}
