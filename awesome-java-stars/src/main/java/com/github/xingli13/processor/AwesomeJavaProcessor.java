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
			System.out.println(url);
		} else {
			// TODO: 2018/10/22 to entity
//			String star = page.getHtml().xpath("//ul[@class='pagehead-actions']/li[1]//a[@class='social-count js-social-count']/text()").toString();
			String star = page.getHtml().xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/ul/li[2]/a[2]/text()").toString();
			String fork = page.getHtml().xpath("//ul[@class='pagehead-actions']/li[2]//a[@class='social-count']/text()").toString();

			System.out.println("url: " + url + " stars: " + star + " fork: " + fork);
		}
	}

	@Override
	public Site getSite() {
		return site;
	}
}
