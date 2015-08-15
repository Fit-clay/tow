package com.example.shopp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.dep.http.MyGet;
import com.dep.http.MyPost;
import com.dep.http.ToGet;
import com.dep.sql.MySqlHelp;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class register extends Activity {

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
		setContentView(R.layout.register);
		rgroup=(RadioGroup) findViewById(R.id.sexgroup);
		radio1=(RadioButton) findViewById(R.id.man);
		radio2=(RadioButton) findViewById(R.id.weman);
		rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				if(checkedId==R.id.man){
					four=radio1.getText().toString().trim();
					
				Log.i("         ==========",four);
				}
				else{
					four=radio2.getText().toString().trim();
					Log.i("         ==========",four);


				}
			}
		});
		
		
		edt1 = (EditText) findViewById(R.id.register_username);
		edt2 = (EditText) findViewById(R.id.register_password);
		edt3 = (EditText) findViewById(R.id.again_password);
		edt4 = (EditText) findViewById(R.id.register_address);
		edt5 = (EditText) findViewById(R.id.register_email);
		btn1 = (Button) findViewById(R.id.register_break_frist);
		btn2 = (Button) findViewById(R.id.again_in);
		btn3 = (Button) findViewById(R.id.register_register);
		
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();

			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				edt1.setText("");
				edt2.setText("");
				edt3.setText("");
				edt4.setText("");
				edt5.setText("");
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                   rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						
						if(checkedId==R.id.man){
							four=radio1.getText().toString().trim();
						}
						else{
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
						Toast.makeText(register.this, result, 1000).show();
						
					}

				};
				
				 one = edt1.getText().toString().trim();
				 tow = edt2.getText().toString().trim();
				 three = edt3.getText().toString().trim();
				 five = edt4.getText().toString().trim();
				 six = edt5.getText().toString().trim();
		

				if (one.equals(null) || "".equals(one)) {
					Toast.makeText(register.this, "用户名不能为空", 1000)
							.show();
					
				} else if (!tow.equals(three)) {
					Toast.makeText(register.this, "密码不一致", 1000)
							.show();
				} else if (five.equals(null)) {
					Toast.makeText(register.this, "地址不能为空", 1000)
							.show();

				} else if (six.equals(null)) {
					Toast.makeText(register.this, "邮箱不能为空", 1000)
							.show();
				} else {

				new Thread() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

					          final String path="http://192.168.83.178:8080/bookshopp/register";

					          
					          List<NameValuePair> parameters=new ArrayList<NameValuePair>();
					          parameters.add(new BasicNameValuePair("username", one));
					          parameters.add(new BasicNameValuePair("password", tow));
					          parameters.add(new BasicNameValuePair("sex", four));
					          parameters.add(new BasicNameValuePair("address", five));
					          parameters.add(new BasicNameValuePair("email", six));
					          MyPost mypost=new MyPost();
					          String result=mypost.mydopost(path, parameters);

							
							Message msg=new Message();
                            Bundle bundle=new Bundle();
                            bundle.putString("result",result);
                            msg.setData(bundle);
                            handler.sendMessage(msg);
                         // �жϷ���˷���ֵ������ע��ɹ�����Ϣ���뱾�����ݿ�
    						if (result.equals("注册成功")) {
    							// 注册成功将信息存储到本地数据库
    					        MySqlHelp dbhelper = new MySqlHelp(getApplicationContext(), "bookshopp.db", null, 1);

    							SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();
    							String insert="insert into userinfo(username,password,sex,address,email)"+"values(?,?,?,?,?)";
    							String []values={one,tow,four,five,six};
    							sqlbase.execSQL(insert, values);
    							
    							Intent in = new Intent();
    							in.setClass(register.this, login.class);
    							startActivity(in);
    							
    						}
						}

						
					

				}.start();
				}
			}
		});

	}

}
