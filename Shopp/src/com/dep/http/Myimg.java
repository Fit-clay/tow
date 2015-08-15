package com.dep.http;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class Myimg extends AsyncTask<String, Void, Bitmap> {

	ImageView iv;
	String url;
	Mycache mycache;

	public Myimg(ImageView iv,Mycache mycache) {
		super();
		// this.mydata=mydata;
		this.iv = iv;
		this.mycache=mycache;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		url = params[0];
		InputStream in = null;
		Bitmap map = null;
		try {

			URL myurl = new URL(params[0]);
			URLConnection uconn = myurl.openConnection();
			in = uconn.getInputStream();

			map = BitmapFactory.decodeStream(in);

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("图片缓存失败");
		} finally {
			return map;
		}

	}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null&&url==iv.getTag()) {
			iv.setImageBitmap(result);
			mycache.put(url, result);
		}
	}

}
