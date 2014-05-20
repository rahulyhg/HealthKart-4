package com.example.healthkart;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Survey extends Activity {

	TextView question, suggestion,steps;
	private RadioGroup radioGroup;
	private EditText text;
	Button next,back,logout;
	private RadioButton radioButtonone;
	private RadioButton radioButtontwo;
	private RadioButton radioButtonthree;
	private RadioButton selectedbutton; 
	int flag=1;
	SeekBar seek;
	String gender,age,objective,lt,veg,el,pr="900";
	
	 @Override
     public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
            
             setContentView(R.layout.survey);
             text=(EditText)findViewById(R.id.text);
             back=(Button)findViewById(R.id.back);
             next=(Button)findViewById(R.id.next);
             logout=(Button)findViewById(R.id.logout);
             seek=(SeekBar) findViewById(R.id.seekBar);
             
             question=(TextView) findViewById(R.id.question);
             steps=(TextView) findViewById(R.id.steps);
             suggestion=(TextView) findViewById(R.id.suggestion);
             radioGroup = (RadioGroup) findViewById(R.id.radioSex);
             radioButtonone = (RadioButton) findViewById(R.id.one);
             radioButtontwo = (RadioButton) findViewById(R.id.two);
             radioButtonthree = (RadioButton) findViewById(R.id.three);
             suggestion.setVisibility(View.INVISIBLE);
             
             if(flag==1)
             {
            	 back.setVisibility(View.INVISIBLE);
            	 gender();
            	 steps.setText("Step(6/1)");
            	 
             }
             else
             {
            	 selection();
             }
             
             seek.getThumb().mutate().setAlpha(0);
             back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					System.out.println(flag);
					if(flag>2)
 					{  
						System.out.println(flag);
						flag=flag-2;
 					    selection();
 						back.setVisibility(View.VISIBLE);
 						next.setVisibility(View.VISIBLE);
 						suggestion.setVisibility(View.INVISIBLE);
 						seek.setVisibility(View.VISIBLE);
 						steps.setVisibility(View.VISIBLE);
 						
 					}
 					else if(flag==1 || flag==0)
 					{
 						back.setVisibility(View.INVISIBLE);
 					}
 					else
 					{
 						back.setVisibility(View.INVISIBLE);
 					}
					
				}
			});
             
             logout.setOnClickListener(new OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					
 					SharedPreferences sharedPref= getApplicationContext().getSharedPreferences("kart",0);			 
 					 SharedPreferences.Editor editor = sharedPref.edit();
 					 editor.clear();  
 					 editor.commit();
 					
 					Intent a=new Intent(getApplicationContext(), LoginActivity.class);
 					startActivity(a);
 					finish();
 					
 				}
 			});
             
             
             next.setOnClickListener(new OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					
 					
 					if(flag>1)
 					{   
 						if(flag==3)
 						{
 							
 							if(text.getText().toString().trim().length()!=0)
 							{
 							if(Integer.parseInt(text.getText().toString())>=10)
 							{
 								age=text.getText().toString();
 								selection();
 							}
 							else
 							{
 								 Toast.makeText(getApplicationContext(), "You are young enough to take protein!", Toast.LENGTH_SHORT).show(); 
 							}
 							}
 							else if(text.getText().toString().trim().length()==0)
 							{
 								Toast.makeText(getApplicationContext(), "Please enter your age", Toast.LENGTH_SHORT).show(); 
 							}
 							
 						}
 						else if(flag==7)
 						{
 							int selectedId = radioGroup.getCheckedRadioButtonId();
 						   	selectedbutton = (RadioButton) findViewById(selectedId);
 						   	 el=selectedbutton.getText().toString();
 						   	  System.out.println(el);
 						   	
 						   	  selection();
 						}
 						else if(flag==2)
 						{
 							int selectedId = radioGroup.getCheckedRadioButtonId();
 						   	selectedbutton = (RadioButton) findViewById(selectedId);
 						   	 gender=selectedbutton.getText().toString();
 						    selection();
 						   ;
 						}
 						else if(flag==4)
 						{
 							int selectedId = radioGroup.getCheckedRadioButtonId();
 						   	selectedbutton = (RadioButton) findViewById(selectedId);
 						   	 objective=selectedbutton.getText().toString();
 						    selection();
 						  
 						}
 						else if(flag==5)
 						{
 							int selectedId = radioGroup.getCheckedRadioButtonId();
 						   	selectedbutton = (RadioButton) findViewById(selectedId);
 						   	 lt=selectedbutton.getText().toString();
 						    selection();
 						  
 						}
 						else if(flag==6)
 						{
 							 int selectedId = radioGroup.getCheckedRadioButtonId();
 						   	selectedbutton = (RadioButton) findViewById(selectedId);
 						   	 veg=selectedbutton.getText().toString();
 						    selection();
 						 
 						}
 						else if(flag==8)
 						{
 							seek.setVisibility(View.INVISIBLE);
 					    	 pr=text.getText().toString();
 					    	if(pr.equals(""))
 					    	{
 					    		pr="0";
 					    	}
 					    	 suggestion();
 						}
 						else
 						{
 						
 					    selection();
 						}
 						
 						
 						back.setVisibility(View.VISIBLE);
 					}
 					else
 					{
 						back.setVisibility(View.INVISIBLE);
 					}
 					
 				}
 			});
             
             
             
	 }
	 
	public void gender()
	{
		question.setText("Tell Us Your Gender");
		radioButtonone.setText("Male");
	   	radioButtontwo.setText("Female");
   	   radioButtonthree.setVisibility(View.INVISIBLE);
   	radioButtonone.setVisibility(View.VISIBLE);
   	radioButtontwo.setVisibility(View.VISIBLE);
   	 text.setVisibility(View.INVISIBLE);
   	 flag=2;
   
   	 
   	 
	}
	
	public void age()
	{
		question.setText("Tell Us Your Age");
   	   radioButtonone.setVisibility(View.INVISIBLE);
   	radioButtontwo.setVisibility(View.INVISIBLE);
   	radioButtonthree.setVisibility(View.INVISIBLE);
   	    text.setVisibility(View.VISIBLE);
   	 flag=3;
   	 
	}
	 
	public void objective()
	{
		question.setText("Tell Us Your Objectives");
		  radioButtonone.setVisibility(View.VISIBLE);
		   	radioButtontwo.setVisibility(View.VISIBLE);
		   	radioButtonthree.setVisibility(View.VISIBLE);
   	   text.setVisibility(View.INVISIBLE);
   	   radioButtonone.setText("Muscle Building");
   	radioButtontwo.setText("Mass Gain");
   	radioButtonthree.setText("Fat Loss");
    flag=4;
    
    
   	   
	}
	public void tolerant()
	{
	question.setText("Are you lactose intolerant");
    radioButtonthree.setVisibility(View.INVISIBLE);
   	radioButtonone.setVisibility(View.VISIBLE);
   	radioButtontwo.setVisibility(View.VISIBLE);
   	radioButtonone.setText("YES");
   	radioButtontwo.setText("NO");
    flag=5;
    
    
	}
	 
	public void vegprnonveg()
	{
		question.setText("Are you Veg/Non-Veg");
		 radioButtonthree.setVisibility(View.INVISIBLE);
		   	radioButtonone.setVisibility(View.VISIBLE);
		   	radioButtontwo.setVisibility(View.VISIBLE);
		   	radioButtonone.setText("Veg");
		   	radioButtontwo.setText("Non-Veg");
		    flag=6;
		   
	}
	
	public void experiencelevel()
	{
		question.setText("Experience Level");
		 radioButtonone.setVisibility(View.VISIBLE);
		   	radioButtontwo.setVisibility(View.VISIBLE);
		   	radioButtonthree.setVisibility(View.VISIBLE);
	   text.setVisibility(View.INVISIBLE);
	   radioButtonone.setText("Beginner");
	radioButtontwo.setText("Intermediate");
	radioButtonthree.setText("Pro");
	 flag=7;
	 
	}
	
	
	public void protein()
	{
		question.setText("Your Protein Intake(Calories)");
		radioButtonone.setVisibility(View.INVISIBLE);
	   	radioButtontwo.setVisibility(View.INVISIBLE);
	   	radioButtonthree.setVisibility(View.INVISIBLE);
	   	text.setText("");
	   	 text.setVisibility(View.VISIBLE);
	   	    
	   	    flag=8;
	   	    
	   	
   	   
	}
	
	
	public void selection()
	{
		if(flag==1)
		{
			gender();
			seek.setProgress(0);
			steps.setText("Steps(6/1)");
		}
		else if(flag==2)
		{
			age();
			seek.setProgress(16);
			 steps.setText("Steps(6/2)");
		}
		else if(flag==3)
		{
			objective();
			seek.setProgress(32);
			steps.setText("Steps(6/3)");
		}
		else if(flag==4)
		{
			tolerant();
			seek.setProgress(64);
			steps.setText("Steps(6/4)");
		}
		else if(flag==5)
		{
			vegprnonveg();
			seek.setProgress(80);
			steps.setText("Steps(6/5)");
		}
		else if(flag==6)
		{
			experiencelevel();
			seek.setProgress(100);
			steps.setText("You are just one step away!");
		}
		
		else if(el!=null)
		{
			System.out.println(el);
			if(el.equals("Intermediate") || el.equals("Pro"))
			{
				seek.setVisibility(View.INVISIBLE);
				steps.setVisibility(View.INVISIBLE);
				protein();
			}
			else
			{
				suggestion();
			}
		}
		else
		{
			
			suggestion();
		}
		
			
	}
	
	
	public void suggestion()
	{
		suggestion.setVisibility(View.VISIBLE);
		next.setVisibility(View.INVISIBLE);
		text.setVisibility(View.INVISIBLE);
		question.setVisibility(View.VISIBLE);
		radioButtonone.setVisibility(View.INVISIBLE);
	   	radioButtontwo.setVisibility(View.INVISIBLE);
	   	radioButtonthree.setVisibility(View.INVISIBLE);
	   	seek.setVisibility(View.INVISIBLE);
	   	steps.setVisibility(View.INVISIBLE);
		
		if(gender.equals("Male"))
		{
			if(age!=null)
			{
				int i=Integer.parseInt(age);
				if(i>=10 && i<=25)
				{
					if(objective.equals("Muscle Building"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MuscleBlaze Whey");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Protein X");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MBT");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Blaze Hurricane");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power 225");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power x");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power ");
									}
								}
							}
						}
					}
					else if(objective.equals("Mass Gain"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Veg");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Power");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Power");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat veg");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat veg");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat");
									}
								}
							}
						}
					}
					else if(objective.equals("Fat Loss"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss veg");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat 253");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat zero");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss Chicken");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat cerials");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Zero");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss Veg");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss ");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat cashew");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat loss power");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss");
									}
								}
							}
						}
					}
				}
				else if(i>25)
				{
					if(objective.equals("Muscle Building"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Whey 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MuscleBlaze Protein Whey 25");
									}
								}
							}
							else
							{
								question.setText("We would suggest you to take:");
								suggestion.setText("Chicken Whey 25");
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Veg Whey 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Chicken Whey 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25");
									}
								}
							}
						}
					}
					else if(objective.equals("Mass Gain"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat  25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat  25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat  25");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat chicken 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat cashew 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat almond 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat almond 25");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat chicken 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25");
									}
								}
							}
						}
					}
					else if(objective.equals("Fat Loss"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss chic 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss chic 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss chic 25");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss strong 25");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25");
									}
								}
							}
						}
					}
				}
			}
		}
		else if(gender.equals("Female"))
		{
			if(age!=null)
			{
				int i=Integer.parseInt(age);
				if(i>=10 && i<=25)
				{
					if(objective.equals("Muscle Building"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MuscleBlaze Whey Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Protein X Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MBT Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power Female");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Blaze Hurricane Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power 225 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power x Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Blaze Power Female");
									}
								}
							}
						}
					}
					else if(objective.equals("Mass Gain"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Veg Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Power Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Power Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat veg Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat veg Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Female");
									}
								}
							}
						}
					}
					else if(objective.equals("Fat Loss"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss veg Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat 253 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat zero Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss Chicken Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat cerials Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Zero Female");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss Veg Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat cashew Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat loss power Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss Female");
									}
								}
							}
						}
					}
				}
				else if(i>25)
				{
					if(objective.equals("Muscle Building"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MuscleBlaze Whey 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Whey 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MuscleBlaze Protein Whey 25 Female");
									}
								}
							}
							else
							{
								question.setText("We would suggest you to take:");
								suggestion.setText("Chicken Whey 25 Female");
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Veg Whey 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("Chicken Whey 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("Veg Whey 25 Female");
									}
								}
							}
						}
					}
					else if(objective.equals("Mass Gain"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat 25 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat chicken 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25 Female");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat cashew 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat almond 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat almond 25 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat chicken 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat chicken 25 Female");
									}
								}
							}
						}
					}
					else if(objective.equals("Fat Loss"))
					{
						if(lt.equals("YES"))
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss chic 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss chic 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss chic 25 Female");
									}
								}
							}
						}
						else
						{
							if(veg.equals("Veg"))
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}
								}
							}
							else
							{
								if(el.equals("Beginner"))
								{
									question.setText("We would suggest you to take:");
									suggestion.setText("MB Fat Loss strong 25 Female");
								}
								else if(el.equals("Intermediate") || el.equals("Pro") )
								{
									int j=Integer.parseInt(pr);
									if(j>=0 && j<225)
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}else
									{
										question.setText("We would suggest you to take:");
										suggestion.setText("MB Fat Loss 25 Female");
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
}
