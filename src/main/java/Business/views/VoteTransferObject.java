package Business.views;

public class VoteTransferObject {
	
	private String themeName;

    private int average;

    public VoteTransferObject(String themeName, int average) {
        this.themeName = themeName;
        this.average = average;
    }

    public String getThemeName() {
        return themeName;
    }

    public int getVote() {
        return average;
    }

	public int getAverage() {
		return average;
	}
}