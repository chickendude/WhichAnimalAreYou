package ch.ralena.whichanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AnimalActivity extends AppCompatActivity {
	public final static String TAG = AnimalActivity.class.getSimpleName();

	private List<Animal> animalList;
	private ImageView animalImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal);
		// pull the image view to load our animal there
		animalImageView = (ImageView) findViewById(R.id.animalImageView);
		// create the list of animals with their stat values
		animalList = new ArrayList<>();
		animalList.add(new Animal("butterfly",new int[]{1,5,1,1,1,1,1,5},R.drawable.butterfly));
		animalList.add(new Animal("dolphin",new int[]{4,1,5,3,3,3,1,1},R.drawable.dolphin));
		animalList.add(new Animal("elephant",new int[]{1,3,3,3,4,1,1,2},R.drawable.elephant));
		animalList.add(new Animal("flamingo",new int[]{3,3,2,2,2,1,1,3},R.drawable.flamingo));
		animalList.add(new Animal("jellyfish",new int[]{1,1,5,4,1,1,1,1},R.drawable.jellyfish));
		animalList.add(new Animal("lion",new int[]{5,3,3,5,3,3,1,3},R.drawable.lion));
		animalList.add(new Animal("monkey",new int[]{1,3,2,2,3,2,1,3},R.drawable.monkey));
		animalList.add(new Animal("red panda",new int[]{1,4,2,2,5,1,1,4},R.drawable.redpanda));
		animalList.add(new Animal("squirrel",new int[]{1,2,2,1,4,1,5,2},R.drawable.squirrel));
		animalList.add(new Animal("teddy bear",new int[]{1,5,1,1,1,5,1,5},R.drawable.teddybear));
		animalList.add(new Animal("tiger",new int[]{5,3,3,5,3,2,1,2},R.drawable.tiger));

		// pull the responses from last time
		Intent intent = getIntent();
		int[] selections = intent.getIntArrayExtra("selections");

		// check if any of the values changed
		boolean changed = false;
		int counter = 0;
		do {
			changed = selections[counter++] != 2;
		} while (!changed && counter < selections.length);
		// if no values changed, say the user is a dung beetle
		if (!changed) {
			animalImageView.setImageDrawable(getResources().getDrawable(R.drawable.dungbeetle));
			Toast.makeText(this, "You are a dung beetle. Did you even take the quiz?", Toast.LENGTH_LONG).show();
		} else {
			Animal yourAnimal = animalList.get(0);
			int topScore = 100;
			for (Animal animal : animalList) {
				int curScore = 0;
				int[] stats = animal.getStats();
				for (int i = 0; i < selections.length; i++) {
					curScore += (Math.abs(stats[i] - selections[i]));
				}
				if (curScore < topScore) {
					topScore = curScore;
					yourAnimal = animal;
				}
			}
			animalImageView.setImageDrawable(getResources().getDrawable(yourAnimal.getResourceId()));
			Toast.makeText(this, "You are a " + yourAnimal.getName(), Toast.LENGTH_SHORT).show();
		}
	}
}
