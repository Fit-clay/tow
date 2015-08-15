package com.example.shopp;

import java.util.ArrayList;
import java.util.List;

import com.dep.info.bookinfo_car;
import com.dep.mystatic.My_image;
import com.dep.sql.MySqlHelp;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class shopp_car extends Activity {

	private Button car_pay, car_break, car_delete;
	private ListView list;

	List<bookinfo_car> booklist = new ArrayList<bookinfo_car>();
	List<String> selsct = new ArrayList<String>();
	BaseAdapter adapter ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopp_car);

		
		list = (ListView) findViewById(R.id.shopp_list);

		
		bookinfo_car book1 = new bookinfo_car("asfd", "asd", "asd", "af", "asfd", "asd",
				"elepriasdce");
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		booklist.add(book1);
		
//        MySqlHelp dbhelper = new MySqlHelp(this, "bookshopp.db", null, 1);
//
// 	   SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
//          Cursor cur=sqlbase.query("bookinfo", new String[]{"bookname" ,"author ","eleprice","entprice ","image_path"}, null, null, null, null, null);
//         if(cur.getCount()>0){                        
//         	cur.moveToFirst();
//         	one=cur.getString(0);
//         	tow=cur.getString(1);
//         	three=cur.getString(2);
//         	four=cur.getString(3);
//         	five=number+"";
//         	book_name.setText(one);
//         	author.setText(cur.getString(1));
//         	price.setText(cur.getString(3));
//         	eleprice.setText(cur.getString(2));
//         	stock.setText(cur.getString(4));
//         }
//			Bitmap mybBitmap=(Bitmap)My_image.getMyimg().get(number).get("bookimg");
//
//		
		
		
		
		
		
		adapter= new BaseAdapter() {

			LayoutInflater infater = LayoutInflater.from(shopp_car.this);
			ViewHolder holder;
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				if (convertView == null) {

					holder = new ViewHolder();

					convertView = infater
							.inflate(R.layout.shopp_car_list, null);

					holder.box = (CheckBox) convertView
							.findViewById(R.id.check1);
					holder.bookname = (TextView) convertView
							.findViewById(R.id.shoop_car_name);
					holder.bookauthor = (TextView) convertView
							.findViewById(R.id.shoop_car_auther);
					holder.bookimg = (ImageView) convertView
							.findViewById(R.id.shopp_car_img);
					holder.entnum = (TextView) convertView
							.findViewById(R.id.shoop_car_entbook);
					holder.elenum = (TextView) convertView
							.findViewById(R.id.shoop_car_elebook);
					holder.entprice = (TextView) convertView
							.findViewById(R.id.shoop_car_entprice);
					holder.eleprice = (TextView) convertView
							.findViewById(R.id.shoop_car_eleprice);

					bookinfo_car book1 = booklist.get(position);

					holder.bookname.setText(book1.getBookname());
					holder.bookauthor.setText(book1.getAuthor());

					holder.bookimg.setImageBitmap(null);

					holder.entnum.setText(book1.getEntbook());
					holder.elenum.setText(book1.getElebook());
					holder.entprice.setText(book1.getEntprice());
					holder.eleprice.setText(book1.getEleprice());

					convertView.setTag(holder);

				} else {

					holder = (ViewHolder) convertView.getTag();

					bookinfo_car book1 = booklist.get(position);

					holder.bookname.setText(book1.getBookname());
					holder.bookauthor.setText(book1.getAuthor());

					holder.bookimg.setImageBitmap(null);

					holder.entnum.setText(book1.getEntbook());
					holder.elenum.setText(book1.getElebook());
					holder.entprice.setText(book1.getEntprice());
					holder.eleprice.setText(book1.getEleprice());
				}
				if(selsct.contains(position))
				
				{
					holder.box.setChecked(true);
				} 
									else {
					holder.box.setChecked(false);
				}
				
				return convertView;

			}

			class ViewHolder {
				CheckBox box;
				TextView bookname;
				TextView bookauthor;
				ImageView bookimg;
				TextView entnum;
				TextView elenum;
				TextView entprice;
				TextView eleprice;
			}

			int io=0;
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
//				io++;
//				System.out.println(io+"");
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return booklist.size();
			}
		};

		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				CheckBox cb=(CheckBox)view.findViewById(R.id.check1);
                   if(!cb.isChecked()){

                	   cb.setChecked(true);
                	   String str=position+"";
                	   selsct.add(str);
                   }	
                   else {
                	 
                	   cb.setChecked(false);
                	   String str=position+"";
                	   selsct.remove(str);
				}
			}
		});
		
		
		
		
	
		car_delete = (Button) findViewById(R.id.shopp_car_delete);
				car_delete.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
                       for(int i=0;i<selsct.size();i++){
                    	   
                     	System.out.println(selsct.get(i)+"");
                        int k=Integer.valueOf(selsct.get(i));
						booklist.remove(k);
						
                     	System.out.println(booklist.size());

                       }
						adapter.notifyDataSetChanged();
                          selsct.clear();

					}
				});
		car_pay = (Button) findViewById(R.id.shopp_car_pay);

		car_break = (Button) findViewById(R.id.shopp_car_break);
		car_break.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				finish();
			}
		});
	}
}
