package com.example.shopp;

import com.dep.mystatic.My_image;
import com.dep.mystatic.Mylogin_check;
import com.dep.sql.MySqlHelp;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class particcular extends Activity {

	
	private TextView book_name,author,price,eleprice,stock;
	private TextView book_intro;
	private Button electron,shopp_car,break_frist;
	private ImageView image;
	 Cursor cur;
	 int number;
	 String one,tow,three,four,five,six,sevlen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	        setContentView(R.layout.particular);
	        book_name=(TextView) findViewById(R.id.book_name);
		       author=(TextView)findViewById(R.id.author);   
		       price=(TextView)findViewById(R.id.price);
		       eleprice=(TextView) findViewById(R.id.eleprice);
		       stock=(TextView)findViewById(R.id.stock);

		       electron=(Button) findViewById(R.id.electron);
		       shopp_car=(Button)findViewById(R.id.shopp_car);
	           break_frist=(Button)findViewById(R.id.break_frist);

	           book_intro=(TextView) findViewById(R.id.book_intro);
	           image=(ImageView) findViewById(R.id.book_image);
	           
	             Intent in = getIntent();
		          number=in.getIntExtra("bookname",0);

		           MySqlHelp dbhelper = new MySqlHelp(this, "bookshopp.db", null, 1);

		    	   SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
                     cur=sqlbase.query("bookinfo", new String[]{"bookname" ,"author ","eleprice","entprice ","stock ","list_time","image_path"}, "bookname='"+My_image.getMyimg().get(number).get("bookname")+"'", null, null, null, null);
		            if(cur.getCount()>0){                       
		            	cur.moveToFirst();
		            	one=cur.getString(0);
		            	tow=cur.getString(1);
		            	three=cur.getString(2);
		            	four=cur.getString(3);
		            	
		            	five=number+"";
		            	
		            	book_name.setText(one);
		            	author.setText(cur.getString(1));
		            	price.setText(cur.getString(3));
		            	eleprice.setText(cur.getString(2));
		            	stock.setText(cur.getString(4));
		            }
					Bitmap mybBitmap=(Bitmap)My_image.getMyimg().get(number).get("bookimg");

		            image.setImageBitmap(mybBitmap);
		            
		            
	           break_frist.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
	           electron.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent in = new Intent();
					
					Bundle bundle=new Bundle();
			
					bundle.putString("bookname",book_name.getText().toString().trim());

					bundle.putString("entprice",price.getText().toString().trim());
					bundle.putString("eleprice",eleprice.getText().toString().trim());
                   in.putExtras(bundle);
					in.setClass(particcular.this, electron.class);
					startActivity(in);
					
					
				}
			});
	           shopp_car.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					//�����ݻ��浽���أ�����ת�����ﳵ����
					if(Mylogin_check.getLogin_check()){
						   MySqlHelp dbhelper = new MySqlHelp(getApplicationContext(), "bookshopp.db", null, 1);

							SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
							String insert="insert into shopp_car(bookname,author,eleprice,entprice,image_path)"+"values(?,?,?,?,?)";
							
							String []values={one,tow,three,four,five};
							sqlbase.execSQL(insert, values);
							Toast.makeText(particcular.this, "添加成功", Toast.LENGTH_LONG).show();

	
					}
					else {
						Toast.makeText(particcular.this, "请登录", Toast.LENGTH_LONG).show();
					}
					
				}
			});
	           
	           
	}
}
	

