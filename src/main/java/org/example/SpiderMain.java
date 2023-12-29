package org.example;

import org.example.processor.HolidayProcessor;
import us.codecraft.webmagic.Spider;
import org.example.pipeline.ConsolePipeline;

public class SpiderMain {
    public static void main(String[] args) {
        String url = "https://timor.tech/api/holiday/year/2024/";
        Spider.create(new HolidayProcessor()).addUrl(url).addPipeline(new ConsolePipeline()).run();

    }
}
