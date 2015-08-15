package com.example.shopp;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class electron extends Activity {
    private TextView t1,t2,t3,t4;
    private EditText edt1,edt2;
    
    private Button pay,break_pre;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.electron);
	    t1=(TextView) findViewById(R.id.ele_price);
	    t2=(TextView) findViewById(R.id.ent_price);
	    t3=(TextView) findViewById(R.id.amount);
	    t4=(TextView)findViewById(R.id.book_name);
	    edt1=(EditText) findViewById(R.id.ele_num);
	    edt2=(EditText) findViewById(R.id.ent_num);
	    
	    
	    pay=(Button)findViewById(R.id.pay);
	    break_pre=(Button)findViewById(R.id.break_pre);
	    
	    Intent in_price = getIntent();
	    
	    t4.setText(in_price.getStringExtra("bookname"));
	    t1.setText(in_price.getStringExtra("eleprice"));
	    t2.setText(in_price.getStringExtra("entprice"));

	    edt2.addTextChangedListener(new TextWatcher() {
			
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
				
				
				Integer amount=Integer.valueOf(t1.getText().toString().trim())*Integer.valueOf(edt1.getText().toString().trim())+Integer.valueOf(t2.getText().toString().trim())*Integer.valueOf(edt2.getText().toString().trim());
				t3.setText("总计"+amount+"元");
				
			}
		});
	    
	    
	    break_pre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	    
	    
	    
	}
}
