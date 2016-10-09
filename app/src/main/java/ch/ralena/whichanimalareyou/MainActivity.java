package ch.ralena.whichanimalareyou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

// all images but monkey, dolphin, elephant, panda, and tiger taken
// from publicdomainpictures.net

		/*
		butterfly:
			1	5	1	1	1	1	1	5
		dolphin:
			4	1	5	3	3	3	1	1
		elephant
			1	3	3	3	4	1	1	2
		flamingo
			3	3	2	2	2	1	1	3
		jellyfish
			1	1	5	4	1	1	1	1
		lion
			5	3	3	5	3	3	1	3
		monkey
			1	3	2	2	3	2	1	3
		redpanda
			1	4	2	2	5	1	1	4
		squirrel
			1	2	2	1	4	1	5	2
		teddybear
			1	5	1	1	1	5	1	5
		tiger
			5	3	3	5	3	2	1	2*/
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

			// first add the text and spinner views to our horizontal layout
			// then add that to our vertical layout
			questionHolder.addView(questionTextView);
			questionHolder.addView(answerSpinner);
			questionHolder.setPadding(0,5,0,5);
			questionLayout.addView(questionHolder);
		}
	}
}
