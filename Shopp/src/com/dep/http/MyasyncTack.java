package com.dep.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.dep.info.bookinfo;
import com.dep.mystatic.My_image;
import com.dep.sql.MySqlHelp;
import com.example.shopp.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class MyasyncTack extends AsyncTask<String, Integer, ArrayList<bookinfo>> {

	MyData dd;
	Context context;
	public interface MyData{
			public void getData(ArrayList<bookinfo> book);
		}
	public MyasyncTack(Context context,MyData myData) {
		super();
		this.context=context;
		this.dd=myData;
	}

	



	@Override
	protected ArrayList<bookinfo> doInBackground(String... params) {
		// TODO Auto-generated method stub
		ArrayList<bookinfo> list=new ArrayList<bookinfo>();
		try{
		MyPost post=new MyPost();
		List<NameValuePair> parameters=new ArrayList<NameValuePair>();
		
		String myjson=post.mydopost("http://192.168.83.178:8080/bookshopp/down_bookinfo",parameters);
      
		MySqlHelp dbhelper = new MySqlHelp(context, "bookshopp.db", null, 1);
		    SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
       	 String insert="insert into bookinfo(bookname,author,eleprice,entprice,stock,list_time,image_path)"+"values(?,?,?,?,?,?,?)";

	           JSONArray jsa=new JSONArray(myjson);
	           
	           ArrayList<Map<String, Object>> imglist=new ArrayList<Map<String,Object>>();
	           
                  
	           for(int i=0;i<jsa.length();i++){
	        	   JSONObject jo=(JSONObject)jsa.get(i);
	        	   bookinfo  book1=new bookinfo();
	        	   book1.setBookname(jo.getString("bookname"));
	        	   book1.setAuthor(jo.getString("aothor"));
	        	   book1.setEleprice(jo.getString("eleprice"));
	        	   book1.setEntprice(jo.getString("entprice"));
	        	   book1.setImage_path(jo.getString("image_path"));
	        	   book1.setList_time(jo.getString("list_time"));
	        	   book1.setStock(jo.getString("stock"));
	            	 
	        	  MyUrl url=new MyUrl();
	        	  
                  Map<String, Object>map=new HashMap<String, Object>();

                  
                      InputStream in=url.myurl(book1.getImage_path());
                		Bitmap bitmap=BitmapFactory.decodeStream(in);
	        	   
	        	   map.put("bookimg", bitmap );
	        	   map.put("bookname", book1.getBookname());
                   InputStream ins=url.myurl(book1.getImage_path());

	        	      File file=new File("mnt/sdcard/",book1.getBookname()+".jpg");
	        	      FileOutputStream out=new FileOutputStream(file);
	        	     byte[] b=new byte[1024];
	        	     int k;
	        	      while((k=ins.read(b))!=-1){
	        	    	  out.write(b, 0, k);
		        	      out.flush();

	        	      }
	        	      out.close();
	        	      ins.close();
	        	      in.close();
	        	   list.add(book1);
	        	   
	        	   imglist.add(map);
	        	   
	        	   
	        	   
	        	   
	        	   //添加到数据库中
					String []values={book1.getBookname(),book1.getAuthor(),book1.getEleprice(),book1.getEntprice(),book1.getStock(),book1.getList_time(),book1.getImage_path()};
					sqlbase.execSQL(insert, values);
	        	 
	           }
	           
	           My_image img=new My_image();
        	   img.setMyimg(imglist);
	           
	           
		}catch(Exception e){
			e.printStackTrace();
		}  
		
		return list;
		
	}

	@Override
	protected void onPostExecute(ArrayList<bookinfo> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		dd.getData(result);
		
	}

	
}
