package ch.ralena.whichanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

// all images but monkey, dolphin, elephant, panda, and tiger taken
// from publicdomainpictures.net
// dung beetle from http://snappygoat.com/
//TODO: add Animal class with array of int score values
public class MainActivity extends AppCompatActivity {

	private LinearLayout questionLayout;
	private Button submitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		questionLayout = (LinearLayout) findViewById(R.id.questionLayout);
		submitButton = (Button) findViewById(R.id.submitButton);

		List<String> questionList = Questions.getQuestions();

		// populate our linearlayout with our questions
		int id = 0;	// spinner id
		for (String question : questionList) {
			// make a horizontal linear layout for the question and spinner
			LinearLayout questionHolder = new LinearLayout(this);
			// give each item a weight, which needs a layoutparams object
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 3);
			LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(lp);
			lp2.weight = 2;

			// create a textview for our question and center align it
			TextView questionTextView = new TextView(this);
			questionTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
			questionTextView.setLayoutParams(lp);
			questionTextView.setPadding(0,0,10,50);
			questionTextView.setText(question);
			questionTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

			// create our spinner of choices which needs an arrayadapter
			Spinner answerSpinner = new Spinner(this);
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.answer_array, android.R.layout.simple_spinner_dropdown_item);
			answerSpinner.setAdapter(adapter);
			answerSpinner.setLayoutParams(lp2);
			answerSpinner.setId(id++);
			answerSpinner.setSelection(2);
			answerSpinner.setFocusable(true);

			// first add the text and spinner views to our horizontal layout
			// then add that to our vertical layout
			questionHolder.addView(questionTextView);
			questionHolder.addView(answerSpinner);
			questionHolder.setPadding(0,5,0,5);
			questionLayout.addView(questionHolder);
		}

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
				android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
		EditText caption = new EditText(this);
		caption.setLayoutParams(lp);
		questionLayout.addView(caption);

		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int numChildren = questionLayout.getChildCount()-1;
				int[] selections = new int[numChildren];
				for (int i = 0; i < numChildren; i++) {
					LinearLayout layout = (LinearLayout) questionLayout.getChildAt(i);
					Spinner spinner = (Spinner) layout.getChildAt(1);
					selections[i] = (int) spinner.getSelectedItemId();
				}
				Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
				intent.putExtra("selections",selections);
				startActivity(intent);
			}
		});
	}
}
