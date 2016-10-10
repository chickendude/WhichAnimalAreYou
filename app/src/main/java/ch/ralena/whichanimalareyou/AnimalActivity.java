package ch.ralena.whichanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal);
		Intent intent = getIntent();
		int[] selections = intent.getIntArrayExtra("selections");
		Toast.makeText(this, selections[0]+"", Toast.LENGTH_SHORT).show();
	}
}
