package com.github.xingli13;

import com.github.xingli13.downloader.MyHttpClientDownloader;
import com.github.xingli13.func.BasicUrls;
import com.github.xingli13.pipeline.SqlPipeline;
import com.github.xingli13.processor.AwesomeJavaProcessor;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
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
//		https://github.com/arquillian/
//		https://github.com/LWJGL/
// TODO: 2018/10/23 不能保证bing查找结果一定对
		// TODO: 2018/10/23 有一些archive了 但是找不到
		// TODO: 2018/10/23 名字搜索结果不对
		// TODO: 2018/10/23 有些没有处理
		// TODO: 2018/10/23 有些东西根本不想要
// TODO: 2018/10/23 少于100 star的手动做一下
		Spider.create(new AwesomeJavaProcessor())
				.setDownloader(new MyHttpClientDownloader())
				.addPipeline(new SqlPipeline())
				.addUrl((BasicUrls.getUrlLines()).toArray(new String[BasicUrls.getUrlLines().size()]))
				.thread(5)
				.run();
	}
}
