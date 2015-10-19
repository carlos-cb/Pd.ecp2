package Business.controllers;

import java.util.ArrayList;
import java.util.List;

import Business.models.Daos.DaoFactory;
import Business.models.entities.Theme;
import Business.models.entities.Vote;
import Business.views.VoteTransferObject;

public class BusinessController{

	public void createTheme(String themeName) {
		int id = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
        DaoFactory.getFactory().getThemeDao().create(new Theme(id, themeName));
		
	}

	public List<String> showThemes() {
		return DaoFactory.getFactory().getThemeDao().findAllNames();
	}
	
	public void voteTheme(VoteTransferObject voteTransferObject){
		int id = DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
        Theme t = DaoFactory.getFactory().getThemeDao().findByName(voteTransferObject.getThemeName());
        DaoFactory.getFactory().getVoteDao().create(new Vote(id, voteTransferObject.getVote(), t));
	}
	
	public List<VoteTransferObject> showAverage() {
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<VoteTransferObject> voteTransferObject = new ArrayList<>();
        int total = 0;
        int j = 0;
        int average =0;
        for (int i = 0; i < themes.size(); i++) {
            List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(themes.get(i));
            total += votes.get(i).getVote();
            j++;
            if(j > 0){
            	average = total/j;
            }
            voteTransferObject.add(new VoteTransferObject(themes.get(i).getName(), average));
        }
        return voteTransferObject;
	}
	
	
}