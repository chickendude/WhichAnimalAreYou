package ch.ralena.whichanimalareyou;

public class Animal {
	private int[] mStats;
	private String mName;

	public Animal(int[] stats, String name) {
		mStats = stats;
		mName = name;
	}

	public int[] getStats() {
		return mStats;
	}

	public String getName() {
		return mName;
	}
}
