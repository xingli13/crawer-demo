package com.github.xingli13.func;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xingli13
 */
public class BasicUrls {
	private static Set<String> urlLines = new HashSet<>();
	private static final String GITHUB_BING_URL = "https://www.bing.com/search?q=site%3Agithub.com+";

	public static Set<String> getUrlLines() {
		return urlLines;
	}

	public static void getUrlsFromAwesome(String path) throws IOException {
		File file = new File(path);
		int lines =0,len1,len2;
		BufferedReader reader = null;
		reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));
		String tmp = null;
		while ((tmp = reader.readLine()) != null){
			if (tmp.startsWith("-")){
				lines ++;
				String url = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(")"));
				if (!url.contains("github.com")) {
//					String name =
//					url = GITHUB_BING_URL +
				}
				urlLines.add(url);
			}
		}
		System.out.println(lines);
		reader.close();
	}
}
