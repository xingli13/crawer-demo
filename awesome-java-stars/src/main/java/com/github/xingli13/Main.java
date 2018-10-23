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


		Spider.create(new AwesomeJavaProcessor())
				.setDownloader(new MyHttpClientDownloader())
				.addPipeline(new SqlPipeline())
				.addUrl((BasicUrls.getUrlLines()).toArray(new String[BasicUrls.getUrlLines().size()]))
				.thread(1)
				.run();
	}
}
