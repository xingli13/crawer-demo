package com.github.xingli13.func;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xingli13
 */
public class BasicUrls {
	private static Set<String> urlLines = new HashSet<>();
	private static final String GITHUB_BING_URL = "https://www.bing.com/search?q=site%3Agithub.com+";

	public static Set<String> getUrlLines() {
		try {
			if (urlLines.size() == 0) {
				getUrlsFromAwesome("D:/Java/crawler/crawer-demo/awesome-java.md");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlLines;
	}

	public static void getUrlsFromAwesome(String path) throws IOException {
		File file = new File(path);
		int len = 0;
		BufferedReader reader = null;
		reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));
		String tmp = null;
		while ((tmp = reader.readLine()) != null){
			if (tmp.startsWith("-")){
				String url = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(")"));
				if (!url.contains("github.com")) {
//					String name = tmp.substring(tmp.indexOf("[") + 1, tmp.indexOf("]"));
//					url = GITHUB_BING_URL + name.replace(" ", "+");
					continue;
				}
//				urlLines[len++] = url;
				urlLines.add(url);
			}
		}
		reader.close();
	}
}
