package Business.views;

public class VoteTransferObject {
	
	private String themeName;

    private int vote;

    public VoteTransferObject(String themeName, int vote) {
        this.themeName = themeName;
        this.vote = vote;
    }

    public String getThemeName() {
        return themeName;
    }

    public int getVote() {
        return vote;
    }
}