package com.snack.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import android.util.Log;

public class NetworkHelper implements Runnable{
//	private final static String urls = "http://www.kekenet.com/read/";
	private final static String urls = "https://raw.githubusercontent.com/rockflying/dailysnack/master/README.md";
	
	public static String content = "";
	
	public static String getContent() {
		try {
			URL url = new URL(urls);
			URLConnection myConn = url.openConnection();
//			myConn.connect();
			InputStream in = myConn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			
			ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
			int data = 0;
			while((data = bis.read())!=-1) {
				baf.append((byte)data);
			}
			
			content = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
			
			Log.i("I", "--------------------"+ content);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
