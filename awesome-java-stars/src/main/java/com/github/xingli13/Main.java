package com.github.xingli13;

import com.github.xingli13.downloader.MyHttpClientDownloader;
import com.github.xingli13.func.BasicUrls;
import com.github.xingli13.processor.AwesomeJavaProcessor;
import org.apache.log4j.*;
import us.codecraft.webmagic.Spider;

/**
 * Created by xingli13 on 2018/10/19.
 */
public class Main {
	public static void main(String[] args){
		// logger
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.INFO);
		root.addAppender(new ConsoleAppender(
				new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));


		Spider.create(new AwesomeJavaProcessor())
				.setDownloader(new MyHttpClientDownloader())
				.addUrl((BasicUrls.getUrlLines()).toArray(new String[BasicUrls.getUrlLines().size()]))
				.thread(5)
				.run();
	}
	// 获取readme.md开始的所有链接 map<,set<AwesomeItem>> 或者set<AwesomeItem>
	// 组合非github的链接
	// 如果是bing.com的链接就选择第一条
	// 如果是github的就选择stars的值
	// 我希望可以全部进行比较，也可以进行单个类别里面的比较

}
