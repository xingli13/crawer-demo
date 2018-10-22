package com.github.xingli13.processor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by xingli13 on 2018/10/19.
 */
@Slf4j
public class AwesomeJavaProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	@Override
	public void process(Page page) {
//		String url = page.getRequest().getUrl();
		String url = page.getUrl().toString();
		// get info
		if (url.contains("bing")) {
			log.info(url);
		} else {
			log.info("url: "+url + " stars: "+page.getHtml().xpath(""));
		}
//		if (url.contains("awesome-java")) {
//
//		}
	}

	@Override
	public Site getSite() {
		return site;
	}
}
