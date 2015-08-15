package com.example.shopp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.params.CoreConnectionPNames;

import com.dep.http.MyUrl;
import com.dep.http.MyasyncTack;
import com.dep.http.MyasyncTack.MyData;
import com.dep.http.Mycache;
import com.dep.http.Myimg;
import com.dep.info.bookinfo;
import com.dep.mystatic.My_image;
import com.dep.mystatic.Mylogin_check;
import com.dep.mystatic.User_name;
import com.dep.sql.MySqlHelp;
import android.R.anim;
import android.R.integer;
import android.R.layout;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	private AutoCompleteTextView autocom;
	private Button btn1,btn2,btn3,btn4;
	private GridView gridView;

	BaseAdapter adapter;
	  ArrayList<Map<String, String>>map=new ArrayList<Map<String,String>>();
	  ArrayList<Map<String, Object>>towbit=new ArrayList<Map<String,Object>>();

	  MyData da;
	  HashMap<String, SoftReference<Bitmap>>mymap=new HashMap<String, SoftReference<Bitmap>>();
	  Mycache mycache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.main_login);
        btn2=(Button) findViewById(R.id.main_register);
        btn3=(Button) findViewById(R.id.main_search);
        btn4=(Button)findViewById(R.id.userinfo);
       
        mycache=new Mycache((int)Runtime.getRuntime().maxMemory()/8,mymap);

        
        autocom=(AutoCompleteTextView) findViewById(R.id.search);
        autocom.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			    
		         MySqlHelp dbhelper = new MySqlHelp(MainActivity.this, "bookshopp.db", null, 1);

		  	   SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();

		        Cursor cursor=sqlbase.rawQuery("select bookname from bookinfo where bookname like ?", new String[]{"%"+autocom.getText().toString().trim()+"%"});
		      ArrayList< String> alist=new ArrayList<String>();
		     if(cursor.getCount()>0){
		      cursor.moveToFirst();
		      for(int nu=cursor.getCount();nu>0;nu--){
		      if(cursor.getCount()>0){
		        	String instr=cursor.getString(0);
		    	  alist.add(instr);
		        		cursor.moveToNext();
		        	}
		      }
		     }
		        if(alist!=null){
		        	ArrayAdapter adapter2=new ArrayAdapter(MainActivity.this, layout.simple_spinner_dropdown_item,alist);

		        autocom.setAdapter(adapter2);
	        	adapter2.notifyDataSetChanged();

		       }
			}
		});
        
      

       gridView=(GridView) findViewById(R.id.gridview);
       adapter =new BaseAdapter() {
       	
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				
				gridview gvw;
				if(convertView==null){
					gvw=new gridview();
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.showlist, null);
				
				gvw.tv=(TextView) convertView.findViewById(R.id.listtext);
				gvw.iv=(ImageView) convertView.findViewById(R.id.listimg);
				convertView.setTag(gvw);
				}
				else {
					gvw=(gridview) convertView.getTag();
				}
				
//				towbit=My_image.getMyimg();
//				if(towbit!=null)
//				{
//					System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
//					gvw.tv.setText(towbit.get(position).get("bookname").toString());
//					Bitmap icon=(Bitmap)towbit.get(position).get("bookimg");
//					gvw.iv.setImageBitmap(icon);
//
//				}
//				else {
					System.out.println("bbbbbbbbbbbbbbbb");

					gvw.tv.setText(map.get(position).get("bookname").toString());
					gvw.iv.setImageResource(R.drawable.ic_launcher);
					Bitmap icon=getBitmap(map.get(position).get("img_path").toString());
					gvw.iv.setTag(map.get(position).get("img_path").toString());
					
					if(icon!=null){
						gvw.iv.setImageBitmap(icon);
					}
					else {
						new Myimg(gvw.iv,mycache).execute(map.get(position).get("img_path").toString());

					}
//				}
				
				return convertView;
			}
			
			class gridview{
				TextView tv;
				ImageView iv;
			}
			
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return map.size();
			}
		};
		adapter.notifyDataSetChanged();
		System.out.println("AAAAAffffffffAAAAAAAAA");

    	gridView.setAdapter(adapter);

       
       
       
       
       

        gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.putExtra("bookname",position);  
				in.setClass(MainActivity.this, particcular.class);
				startActivity(in);
			}
		});
        
        
        //下拉加载
        gridView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				
				
			}
		});
        
    
        
        
        
        //�������ػ������ݿ�
      
 
        
        
        
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent in=new Intent();
				in.setClass(MainActivity.this,login.class);
				startActivity(in);
				
				
			}
		});
        
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setClass(MainActivity.this,register.class);
				startActivity(in);
				
				
			}
		});
        
         

        btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.putExtra("search",autocom.getText().toString().trim());  
				in.setClass(MainActivity.this, search.class);
				startActivity(in);
			}
		});
        
  btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent();
				in.setClass(MainActivity.this, userinfo.class);
				startActivity(in);
				
			}
		});
        
        
    }

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		 if(Mylogin_check.getLogin_check()){
	        	btn4.setVisibility(View.VISIBLE);
	        }
	}

	public Bitmap getBitmap(String url){
		
		Bitmap bit=mycache.get(url);
		if(bit==null){
			SoftReference<Bitmap> sof=mymap.get(url);
			if(sof!=null){
				bit=sof.get();
				return bit;
			}
		}
			else {
				return bit;
			}
		return null;
		}
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
           menu.add(0,Menu.FIRST,1,"刷新");        
           menu.add(0,Menu.FIRST+1,2,"退出");        
        
        return super.onCreateOptionsMenu(menu);
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()==1){
			  new MyasyncTack(MainActivity.this, da=new MyData() {
				
				@Override
				public void getData(ArrayList<bookinfo> book) {
					// TODO Auto-generated method stub
					
					for(int i=0;i<book.size();i++){
						Map<String, String> mm=new HashMap<String, String>();
						mm.put("bookname", book.get(i).getBookname());
						mm.put("img_path", book.get(i).getImage_path());
						map.add(mm);
						System.out.println("图片加载成功");
						adapter.notifyDataSetChanged();
					}
					
				}
			}).execute();
		    
		  	 Log.i("ssssssssssssss",map.toString());
		}
		
		if(item.getItemId()==2){
			finish();
		}
		
		return super.onOptionsItemSelected(item);
		
		
		
	}
    
    
    
    
}
