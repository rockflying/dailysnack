package com.snack.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
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
			Connection connection = Jsoup.connect(url);
			
			System.out.println(connection);
			
			Document doc = connection.get();

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
				}
			}
		} catch (Exception e) {
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
