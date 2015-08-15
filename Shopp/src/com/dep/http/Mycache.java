package com.dep.http;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.util.LruCache;

public  class Mycache extends LruCache<String, Bitmap>{
	HashMap<String, SoftReference<Bitmap>>mymap;
	public Mycache(int maxSize,HashMap<String, SoftReference<Bitmap>> mymap) {
		super(maxSize);
		this.mymap=mymap;
	}

	@Override
	protected void entryRemoved(boolean evicted, String key, Bitmap oldValue,
			Bitmap newValue) {
		// TODO Auto-generated method stub
		super.entryRemoved(evicted, key, oldValue, newValue);
		mymap.put(key, new SoftReference<Bitmap>(oldValue));
	}

	@Override
	protected int sizeOf(String key, Bitmap value) {
		// TODO Auto-generated method stub
		return super.sizeOf(key, value);
	}


}

