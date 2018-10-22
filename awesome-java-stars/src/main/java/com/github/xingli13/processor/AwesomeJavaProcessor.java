package com.github.xingli13.processor;

import com.github.xingli13.entity.GithubRepo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xingli13 on 2018/10/19.
 */
@Slf4j
@ToString
public class AwesomeJavaProcessor implements PageProcessor {

	private final static String BING = "bing";
	private Site site = Site.me()
			.setTimeOut(10000)
			.setRetryTimes(3)
			.setSleepTime(1000);

	@Override
	public void process(Page page) {
//		String url = page.getRequest().getUrl();
		String url = page.getUrl().toString();
		// get info
		if (url.contains(BING)) {
			page.setSkip(true);
			String firstUrl = page.getHtml().xpath("//*[@id='b_results']/li[1]/h2/a/@href").toString();
			System.out.println(firstUrl);
		} else {
			GithubRepo repo = new GithubRepo();
			repo.setName(page.getHtml().xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/h1/strong/a/text()").toString());
			repo.setAuthor(page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
			repo.setStar(page.getHtml().xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/ul/li[2]/a[2]/text()").toString());
			repo.setFork(page.getHtml().xpath("//ul[@class='pagehead-actions']/li[2]//a[@class='social-count']/text()").toString());
			repo.setUrl(url);
			page.putField("repo", repo);
		}
	}

	@Override
	public Site getSite() {
		return site;
	}
}
