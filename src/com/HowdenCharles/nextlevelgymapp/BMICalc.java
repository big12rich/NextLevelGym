package com.HowdenCharles.nextlevelgymapp;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class BMICalc extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmicalc);
		// Show the Up button in the action bar.
		setupActionBar();
	    Button button1 =  (Button)findViewById(R.id.button1);
	    Button button2 =  (Button)findViewById(R.id.button2);

	    //Implement listener for your button so that when you click the 
	    //button, android will listen to it.             

	     button1.setOnClickListener(new View.OnClickListener() {             
	        public void onClick(View v) {                 
	        // Perform action on click	
	        	EditText Theight = (EditText)findViewById(R.id.editText1); 
	        	String hstr = Theight.getText().toString(); 
	        	EditText Tweight = (EditText)findViewById(R.id.editText2); 
	        	String wstr = Tweight.getText().toString(); 
	        	if(hstr!=null && wstr!=null){
	        	bmiCalc(Double.parseDouble(wstr), Double.parseDouble(hstr)); 	
	        	TextView textView=(TextView)findViewById(R.id.textView5);
	        	DecimalFormat df = new DecimalFormat("#.##");
	            textView.setText("Your current BMI is: " + df.format(bmiNum));
	        	}else{
	        		TextView textView=(TextView)findViewById(R.id.textView5);
	        		textView.setText("Please enter a valid height and weight");}
	        }
	        });
	     button2.setOnClickListener(new View.OnClickListener() {             
		        public void onClick(View v) {                 
		        // Perform action on click	 	
		        	TextView textView=(TextView)findViewById(R.id.textView5);
		            textView.setText(""+bmiChart());
		        }
		        });  
	    }
		
		private double bmiNum = 0;
		private double weight = 0;
		private double height = 0;
		   
		   public double bmiCalc(double weightLb, double heightIn)
		   {
		       weight = weightLb;
		       height = heightIn;
		       bmiNum = ((weight*703)/(height*height));
		       return bmiNum;
		       
		   }

		   public String bmiChart(){
		   	String bmiChart = "Underweight: BMI < 18.5 \r"
		   	+ "Normal: 18.5 <= BMI < 25 \r"
		   	+"Overweight: 25 <= BMI <30 \r"
		   	+"Obese: 30 <= BMI";
		   	return bmiChart;
		   }
		   
		

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmicalc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
