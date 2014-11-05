package com.snack.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NetworkHelper implements Runnable{
	private final static String url = "http://www.kekenet.com/read/";
	
	public static String content = "";
	
	public static String getContent() {
		List<String> list = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(url).get();

			Elements elements = doc.getElementsByClass("kouyu_photo");

			for(Element element : elements) {
				Elements hrefs = element.select("a[href]");
				int dup = 0;
				for(Element href : hrefs) {
					if(dup == 1) {  //to skip duplicated links
						dup = 0;
						continue;
					}
					dup = 1;
					list.add(href.toString());
					System.out.println(href.attr("href")
							+ href.childNodes().get(0).attr("src")
							+ href.attr("title"));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		NetworkHelper.getContent();
	}
}
