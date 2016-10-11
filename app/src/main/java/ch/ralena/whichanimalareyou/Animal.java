package ch.ralena.whichanimalareyou;

public class Animal {
	private int[] mStats;
	private String mName;
	private int mResourceId;
	private int mCaptionResourceId;

	public Animal(String name, int[] stats, int resourceId, int captionResourceId) {
		mStats = stats;
		mName = name;
		mResourceId = resourceId;
		mCaptionResourceId = captionResourceId;
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

	public int getCaptionResourceId() {
		return mCaptionResourceId;
	}
}
