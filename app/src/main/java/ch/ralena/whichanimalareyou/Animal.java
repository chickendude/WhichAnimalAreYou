package ch.ralena.whichanimalareyou;

public class Animal {
	private int[] mStats;
	private String mName;
	private int mResourceId;

	public Animal(String name, int[] stats, int resourceId) {
		mStats = stats;
		mName = name;
		mResourceId = resourceId;
	}

	public int[] getStats() {
		return mStats;
	}

	public String getName() {
		return mName;
	}

	public int getResourceId() {
		return mResourceId;
	}
}
