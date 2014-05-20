package com.example.healthkart;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	EditText username;
	EditText password;
	Button login;
	 public static SharedPreferences mSharedPreferences;
	 SharedPreferences.Editor e;
	
	 @Override
     public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             this.requestWindowFeature(Window.FEATURE_NO_TITLE);
             setContentView(R.layout.login);
             
             mSharedPreferences= getSharedPreferences("kart", 0);
     	     e = mSharedPreferences.edit();
             username=(EditText)findViewById(R.id.login);
             password=(EditText)findViewById(R.id.password);
             login=(Button)findViewById(R.id.logiinbutton);
             
             if(mSharedPreferences.getString("login", "").equals("yes"))
             {
            	 Intent a=new Intent(getApplicationContext(), Survey.class);
            	 startActivity(a);
            	 finish(); 
             }
             
             login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					 if(username.getText().toString().trim().length()!=0 && 
		            		 password.getText().toString().trim().length()!=0)
		             {
		            	 if(username.getText().toString().equals("healthkart") && password.getText().toString().equals("123"))
		            	 {
		            	 e.putString("login", "yes");
		            	 e.commit();
		            		 
		            	 Intent a=new Intent(getApplicationContext(), Survey.class);
		            	 startActivity(a);
		            	 finish();
		            	 }
		            	 else
		            	 {
		            		 Toast.makeText(getApplicationContext(), "Username/Password is wrong", Toast.LENGTH_SHORT).show(); 
		            	 }
		             }
		             else if(username.getText().toString().trim().length()==0 )
		             {
		            	 Toast.makeText(getApplicationContext(), "Please enter your username", Toast.LENGTH_SHORT).show();
		             }
		             else if(password.getText().toString().trim().length()==0 )
		             {
		            	 Toast.makeText(getApplicationContext(), "Please enter your password", Toast.LENGTH_SHORT).show();
		             }
		             else
		             {
		            	 Toast.makeText(getApplicationContext(), "Nice try, Please fill the blanks", Toast.LENGTH_SHORT).show();
		             }
					
				}
			});
             
            
             
             
             
             
	 }

}
