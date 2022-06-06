package com.gitlab.rmarzec.consts;

public class Task4Consts {
    public static final String YT_ACCEPT_COOKIES_BTN = "div[class^=\"eom-button\"]>div>ytd-button-renderer:nth-child(2)>a";
    public static final String YT_VIDEOS_2ROWS = "ytd-rich-grid-row.style-scope:nth-child(@row)>";
    public static final String YT_VIDEOS_IN_ROW = "div>ytd-rich-item-renderer:nth-child(@video)";
    public static final String YT_META = ">#content>ytd-rich-grid-media>div>#details>#meta";
    public static final String YT_TITLE = YT_META + ">h3>a";
    public static final String YT_LIVE = YT_META + ">ytd-badge-supported-renderer>div[class*='@live']";
    public static final String YT_CHANNEL = ">#content>ytd-rich-grid-media>div>#details>a";
    public static final String YT_TIME = ">#content>ytd-rich-grid-media>div>ytd-thumbnail>a" +
            ">#overlays>ytd-thumbnail-overlay-time-status-renderer>span";
}
