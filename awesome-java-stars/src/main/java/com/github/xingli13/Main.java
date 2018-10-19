package com.github.xingli13;

import com.github.xingli13.processor.AwesomeJavaProcessor;
import us.codecraft.webmagic.Spider;

/**
 * Created by xingli13 on 2018/10/19.
 */
public class Main {
	public static void main(String[] args){
		Spider.create(new AwesomeJavaProcessor())
				.addUrl("https://github.com/akullpp/awesome-java/blob/master/awesome-java.md")
				.thread(1)
				.run();
	}
	// 获取readme.md开始的所有链接 map<,set<AwesomeItem>> 或者set<AwesomeItem>
	// 组合非github的链接
	// 如果是bing.com的链接就选择第一条
	// 如果是github的就选择stars的值
	// 我希望可以全部进行比较，也可以进行单个类别里面的比较

}
