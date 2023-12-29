package org.example.processor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class HolidayProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);


    @Override
    public void process(Page page) {
        String text = page.getHtml().xpath("body/text()").get();
        JSONObject jsonObject = JSONObject.parseObject(text);
        String holidayStr = jsonObject.getString("holiday");
        page.putField("data", holidayStr);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
