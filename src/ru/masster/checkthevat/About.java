package ru.masster.checkthevat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class About extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
	}
	
	@Override
	public void onBackPressed() {

		// Завершаем наше activity
		this.finish();
		// Intent отвечает за переходы между activity,
		// здесь мы возвращаемся обратно в наше главное окно
		Intent intent = new Intent(this, CheckTheVAT.class);
		startActivity(intent);
	}
}
