package com.example.shopp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.dep.http.MyGet;
import com.dep.http.ToGet;
import com.dep.mystatic.Mylogin_check;
import com.dep.mystatic.User_id;
import com.dep.mystatic.User_name;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {

	private EditText edt1,edt2;
	private TextView forget;

	
	private Button btn1,btn2;
	private Map<String,String> map;
	private Handler handler ;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.login); 
		  btn1=(Button) findViewById(R.id.login_login);
	      btn2=(Button) findViewById(R.id.login_register);
	       edt1=(EditText) findViewById(R.id.login_username);
	       edt2=(EditText) findViewById(R.id.login_password);
	       
	       forget=(TextView) findViewById(R.id.forget);
	        
	        forget.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent in=new Intent();
					in.setClass(login.this,forget_passwd.class);
					startActivity(in);
		
				}
			});;
	       
          btn1.setOnClickListener(new OnClickListener() {
        	     //锟斤拷陆锟缴癸拷锟斤拷锟斤拷转锟斤拷锟斤拷页
		         //锟斤拷陆锟缴癸拷锟斤拷        锟斤拷锟矫伙拷锟斤拷锟斤拷锟捷碉拷锟斤拷页锟斤拷     锟斤拷 锟介看锟斤拷锟斤拷锟斤拷息锟酵癸拷锟斤车锟斤拷锟斤拷锟斤拷锟睫改和憋拷锟斤拷
			@Override
			public void onClick(View v) {
				
				
				//锟斤拷取锟竭程达拷锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟叫讹拷锟角凤拷锟铰斤拷晒锟�
				handler= new Handler(){
				    @Override
				    public void handleMessage(Message msg) {
				        super.handleMessage(msg);
				        Bundle data = msg.getData();
				        String val = data.getString("myget");
				        Toast.makeText(login.this, val, 1000).show();
				       if(val.equals("登陆成功")){
				    	   Mylogin_check.setLogin_check(true);
				    		finish();
				       }
				       else{
					        Toast.makeText(login.this, val, 1000).show();

				       }
				    
				    }
				};
				
				
				
				// TODO Auto-generated method stub
		          new Thread(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						  String username=edt1.getText().toString().trim();
					      String password=edt2.getText().toString().trim();
				          final String path="http://192.168.83.178:8080/bookshopp/login";
				          map=new HashMap<String, String>();	
				          map.put("username", username);
				          map.put("password", password);
				      
				          
                                 ToGet tomyget=new ToGet();
                                 String url=tomyget.toget(path, map);
          
								System.out.println(url);
								
								 MyGet get=new MyGet();
									String myget,test="";
									myget = get.myget(url);
									test=myget.substring(myget.indexOf(".")+1, myget.length());
									int index=Integer.valueOf(test);
								
									
									User_id.setId(index);
									User_name.setUserinfo_name(username);
									
									myget=myget.substring(0,myget.indexOf("."));
									
									
									//System.out.println(index);

                                   // System.out.println(myget);
                                    
                                    //锟斤拷锟饺碉拷锟斤拷锟斤拷锟捷达拷锟捷筹拷锟竭筹拷
                                    Message msg=new Message();
                                    Bundle bundle=new Bundle();
                                    bundle.putString("myget",myget);
                                    msg.setData(bundle);
                                    handler.sendMessage(msg);
							
					  
					        /*
					         * doPost时使锟斤拷
					         List<NameValuePair> parameters =new ArrayList<NameValuePair>();
					         
					         parameters.add(new BasicNameValuePair("username", username));
					         parameters.add(new BasicNameValuePair("password", password));
					      */
							//Toast.makeText(login.this, myget,1000).show();
							
//							Handler handler = null ;
//							Message message = new Message();
//							message.obj = myget;
//							handler.sendMessage(message);
					          
					}
		        	 
		        	 
		         }.start();
		        
		         

			}
		});
          
          
          btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent in=new Intent();
				in.setClass(login.this,register.class);
				startActivity(in);
				
			}
		});
          
          
          
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}
}
