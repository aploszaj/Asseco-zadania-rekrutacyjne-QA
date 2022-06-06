package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.consts.Task4Consts;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.model.Task4Page;
import com.gitlab.rmarzec.model.YTTile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Task4Test {

    @Test
    public void Task4Test() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 3000);
        Task4Page task4Page = new Task4Page(webDriver);
        try {
            webDriver.get("https://www.youtube.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector(Task4Consts.YT_ACCEPT_COOKIES_BTN)));
            task4Page.ytAcceptCookiesBtn.click();
            int rowNum = 3;
            int videoNum = 5;
            //Lista kafelkow
            List<YTTile> ytTileList = new ArrayList<YTTile>();
            for (int i = 1; i < rowNum; i++) {
                String cssRow = Task4Consts.YT_VIDEOS_2ROWS.replace("@row", String.valueOf(i));
                for (int j = 1; j < videoNum; j++) {
                    String cssVideo = cssRow + Task4Consts.YT_VIDEOS_IN_ROW.replace("@video", String.valueOf(j));
                    YTTile ytTile = new YTTile();
                    WebElement title = webDriver.findElement(By.cssSelector(cssVideo + Task4Consts.YT_TITLE));
                    ytTile.setTitle(title.getAttribute("title"));
                    WebElement channel = webDriver.findElement(By.cssSelector(cssVideo + Task4Consts.YT_CHANNEL));
                    ytTile.setChannel(channel.getAttribute("title"));
                    String liveCss = cssVideo + Task4Consts.YT_LIVE.replace("@live", "live");
                    WebElement liveElement = null;
                    try {
                        liveElement = webDriver.findElement(By.cssSelector(liveCss));
                    } catch (Exception e) {
                    }
                    if (liveElement != null) {
                        ytTile.setLength("live");
                    } else {
                        WebElement time = webDriver.findElement(By.cssSelector(cssVideo + Task4Consts.YT_TIME));
                        ytTile.setLength(time.getText());
                    }
                    ytTileList.add(ytTile);
                }
            }
            for (YTTile tile : ytTileList) {
                if (!tile.getLength().equals("live")) {
                    System.out.println(tile.getTitle() + " " + tile.getLength());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
