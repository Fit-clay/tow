package com.example.shopp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.dep.http.MyPost;
import com.dep.mystatic.User_id;
import com.dep.mystatic.User_name;
import com.dep.sql.MySqlHelp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class userinfo extends Activity {

	private EditText edt1, edt2, edt3, edt4, edt5;
	private Button btn1, btn2, btn3;
	private RadioButton radio1,radio2;
	private RadioGroup rgroup;
	private Handler handler;

	private Map<String, String> map;
    private  String one,tow,three,four,five,six;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.userinfo);
		rgroup=(RadioGroup) findViewById(R.id.userinfo_sexgroup);
		radio1=(RadioButton) findViewById(R.id.userinfo_man);
		radio2=(RadioButton) findViewById(R.id.userinfo_weman);
		edt1 = (EditText) findViewById(R.id.userinfo_username);
		edt2 = (EditText) findViewById(R.id.userinfo_password);
		edt3 = (EditText) findViewById(R.id.userinfo_again_password);
		edt4 = (EditText) findViewById(R.id.userinfo_address);
		edt5 = (EditText) findViewById(R.id.userinfo_email);
		
		   MySqlHelp dbhelper = new MySqlHelp(this, "bookshopp.db", null, 1);

		   SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
                 Cursor cur=sqlbase.query("userinfo", new String[]{"username","password","sex","address","email"}, "username="+"'"+User_name.getUserinfo_name()+"'",null, null, null, null);
                  if(cur.getCount()>0){
                	  cur.moveToFirst();
                	  edt1.setText(cur.getString(0));
                	  edt2.setText(cur.getString(1));
                	  edt3.setText(cur.getString(1));
                	  edt4.setText(cur.getString(3));
                	  edt5.setText(cur.getString(4));
                        if(cur.getString(4).equals("男")){
                        	radio1.setChecked(true);
                        }         
                        else {
                        	radio2.setChecked (true);

						}
                  }
		
		
		
	rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				if(checkedId==R.id.userinfo_man){
					four=radio1.getText().toString().trim();
					
				Log.i("         ==========",four);
				}
				else if(checkedId==R.id.userinfo_weman){
					four=radio2.getText().toString().trim();
					Log.i("         ==========",four);


				}
			}
		});
		
	btn1 = (Button) findViewById(R.id.userinfo_break_frist);

	btn1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			finish();
		}
	});
	
	btn3 = (Button) findViewById(R.id.mycar);

btn3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent in = new Intent();
			in.setClass(userinfo.this, shopp_car.class);
			startActivity(in);
		}
	});
	
	
	
	

	btn2 = (Button) findViewById(R.id.save);
	
	 btn2.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
               rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					
					if(checkedId==R.id.man){
						four=radio1.getText().toString().trim();
					}
				else if (checkedId==R.id.weman){
						four=radio2.getText().toString().trim();

					}
				}
			});
			
			
			
			
			handler = new Handler() {

				@Override
				public void handleMessage(Message message) {
					// TODO Auto-generated method stub
					super.handleMessage(message);
					Bundle bundle = message.getData();
					String result = bundle.getString("result");
					Toast.makeText(userinfo.this, result, 1000).show();
					
				}

			};
			
			 one = edt1.getText().toString().trim();
			 tow = edt2.getText().toString().trim();
			 three = edt3.getText().toString().trim();
			 five = edt4.getText().toString().trim();
			 six = edt5.getText().toString().trim();
	


			new Thread() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

				          final String path="http://192.168.83.178:8080/bookshopp/save_userinfo";

				          
				          List<NameValuePair> parameters=new ArrayList<NameValuePair>();
				          parameters.add(new BasicNameValuePair("username", one));
				          parameters.add(new BasicNameValuePair("password", tow));
				          parameters.add(new BasicNameValuePair("sex", four));
				          parameters.add(new BasicNameValuePair("address", five));
				          parameters.add(new BasicNameValuePair("email", six));
				          parameters.add(new BasicNameValuePair("id",""+User_id.getLogin_check()));
				          MyPost mypost=new MyPost();
				          
				          String result=mypost.mydopost(path, parameters);

						
						Message msg=new Message();
                        Bundle bundle=new Bundle();
                        bundle.putString("result",result);
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                     // �жϷ���˷���ֵ������ע��ɹ�����Ϣ���뱾�����ݿ�
                        System.out.println(result);
						if (result.equals("ok")) {
							// 注册成功将信息存储到本地数据库
					        MySqlHelp dbhelper = new MySqlHelp(getApplicationContext(), "bookshopp.db", null, 1);

							SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
							//String insert="insert into userinfo(username,password,sex,address,email)"+"values(?,?,?,?,?)";
							String sql = "update userinfo set username="
							+"'"+one+"',"+"password="+"'"+tow+"',"+"sex="+"'"+four+"',"+"address="+"'"+five+"'"+"email="+"'"+six+"'"+"where username="+"'"+User_name.getUserinfo_name()+"'";
                               System.out.println(sql+"/////////////////////");
							//sqlbase.update("userinfo", parameters, "username=?",new String[]{ User_name.getUserinfo_name()});
							//String []values={one,tow,four,five,six};
							sqlbase.execSQL(sql);
							
							
							
						}
					}

					
				

			}.start();
			
		}
	});

		
	}
	
	
	
	
	
}
