package com.github.xingli13.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by xingli13 on 2018/10/19.
 */
public class AwesomeJavaProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	public void process(Page page) {
		// get info
		String url = page.getRequest().getUrl();
//		if (url.contains("awesome-java")) {
//
//		}
	}

	public Site getSite() {
		return site;
	}
}
