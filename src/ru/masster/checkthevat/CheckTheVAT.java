package ru.masster.checkthevat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckTheVAT extends Activity {

	TextView tvSVat;
	TextView tvBezVat;
	TextView tvIzSum;
	EditText edVAT;
	EditText edSum;
	double vat;
	double sum;
	double itog;
	DecimalFormat df = new DecimalFormat();
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tvSVat=(TextView)findViewById(R.id.tvSVat);
		tvBezVat=(TextView)findViewById(R.id.tvBezVat);
		tvIzSum=(TextView)findViewById(R.id.tvIzSum);
		
		edVAT=(EditText)findViewById(R.id.edVAT);
		edSum=(EditText)findViewById(R.id.edSum);
		
		df.setGroupingSize(3);
				
	}

	public void OnCheck(View v) 
	{
		
		edVAT.requestFocus();
		
		if (edVAT.getText().toString().length()>0)
		{
			vat = Double.parseDouble(edVAT.getText().toString());
		}
		else
			vat = 0;
		
		if (vat>30)
		{
			Toast toast = Toast.makeText(this,"Слишком большой налог!",500);
			toast.show();
			vat = 20;
			edVAT.setText("20");
		}
		
		if (edSum.getText().toString().length()>0)
		{
			sum = Double.parseDouble(edSum.getText().toString());
		}
		else
			sum = 0;
		
		//edSum.setText(df.format(sum));		
		
		itog = sum*(100+vat)/100;		
		BigDecimal decimal = new BigDecimal(itog);
	    decimal = decimal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	    itog = decimal.doubleValue();	    
		tvSVat.setText(df.format(itog));
		
		itog = (sum*100)/(100+vat);		
		decimal = new BigDecimal(itog);
	    decimal = decimal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	    itog = decimal.doubleValue();
		tvBezVat.setText(df.format(itog));
		
		itog = (sum*vat)/(100+vat);		
		decimal = new BigDecimal(itog);
	    decimal = decimal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	    itog = decimal.doubleValue();
		tvIzSum.setText(df.format(itog));
		
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);		
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	} 
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.menu_settings:
	        	Toast.makeText(this,"Разработал программист Андрей Антоненко. (с) 2012",2000).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
