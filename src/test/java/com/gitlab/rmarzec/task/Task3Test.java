package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.consts.Task3Consts;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.model.Task3Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task3Test {

    @Test
    public void Task3Test() throws Exception {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        Task3Page task3Page = new Task3Page(webDriver);
        try {
            webDriver.get("https://www.google.com/");
            Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.google.com/",
                    "The requested page has NOT been loaded");
            webDriver.findElement(By.cssSelector(Task3Consts.GOOGLE_ACCEPT_COOKIES_BTN)).click();

            Assert.assertTrue(task3Page.googleSearchField.isDisplayed(),
                    "Google search field is NOT displayed");
            task3Page.googleSearchField.sendKeys("HTML select tag - W3Schools");

            Assert.assertTrue(task3Page.feelingLuckyBtn.isDisplayed(),
                    "I'm feeling lucky button is NOT displayed");
            task3Page.feelingLuckyBtn.submit();
            if (!webDriver.getCurrentUrl().equals("https://www.w3schools.com/tags/tag_select.asp")) {
                System.out.println(webDriver.getCurrentUrl());
                webDriver.get("https://www.w3schools.com/tags/tag_select.asp");
            }

            task3Page.w3schoolAcceptCookiesBtn.click();

            Assert.assertTrue(task3Page.feelingLuckyBtn.isDisplayed(),
                    "Try It Yourself button is NOT displayed");
            task3Page.tryItYourselfBtn.click();

            //TODO: find a solution - switch context to iframe
//            Assert.assertEquals(task3Page.exampleHeader.getText(), "The select element",
//                    "The header text is NOt correct");
////
//            task3Page.switchToFrameByIdOrName("iframeResult");
//
//            webDriver.findElements(By.tagName("iframe")).size();
//            webDriver.switchTo().frame(0);
//
//
//            WebElement frame1Heading = webDriver.findElement(By.cssSelector("body>h1:nth-child(1)"));
//            String frame1Text = frame1Heading.getText();
//            System.out.println(frame1Text);
//
//
//            WebElement frame1 = webDriver.findElement(By.id("iframeResult"));
//
//            webDriver.switchTo().frame(0);
//            WebElement frame = webDriver.findElement(By.id("cars"));
            Assert.assertTrue(task3Page.selectCarsChevronBtn.isDisplayed(),
                    "Select car chevron button is NOT displayed");
            task3Page.selectCarsChevronBtn.click();


            List<WebElement> cars = task3Page.carList;
            for (WebElement car : task3Page.carList) {
//                if (car == Task3Consts.CAR_LIST.replace("@target", "opel")) {
//                    WebElement opel = webDriver.findElement(By.cssSelector(Task3Consts.CAR_LIST.
//                            replace("@target", "opel")));
//                    System.out.println(opel.getText() + opel.getCssValue("Opel"));
//                }
            }

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
