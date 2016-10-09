package ch.ralena.whichanimalareyou;

import java.util.ArrayList;
import java.util.List;

public class Questions {
	private static List<String> questionList;

	public static List<String> getQuestions() {
		questionList = new ArrayList<>();
		questionList.add("I would kill for some food right now");
		questionList.add("I need a LOT of sleep or I feel cranky");
		questionList.add("I can't live without water");
		questionList.add("You won't like me when I'm angry");
		questionList.add("Eating is my life");
		questionList.add("I love cuddling");
		questionList.add("Stay away from my nuts!");
		questionList.add("I need my beauty sleep");

		return questionList;
	}

}
