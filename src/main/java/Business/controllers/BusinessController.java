package Business.controllers;

import java.util.ArrayList;
import java.util.List;

import Business.models.Daos.DaoFactory;
import Business.models.entities.Theme;
import Business.models.entities.Vote;
import Business.views.ThemeAverageTransferObject;
import Business.views.VoteTransferObject;

public class BusinessController{

	private static int idTheme = 0;
	
	public void createTheme(String themeName) {
        DaoFactory.getFactory().getThemeDao().create(new Theme(idTheme, themeName));
        idTheme++;
		
	}

	public List<String> showThemes() {
		return DaoFactory.getFactory().getThemeDao().findAllNames();
	}
	
	private static int idVote = 0;
	
	public void voteTheme(VoteTransferObject voteTransferObject){
		Theme t = DaoFactory.getFactory().getThemeDao().findByName(voteTransferObject.getThemeName());
        DaoFactory.getFactory().getVoteDao().create(new Vote(idVote, voteTransferObject.getVote(), t));
		idVote++;
	}
	
	public List<ThemeAverageTransferObject> getAverage() {
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeAverageTransferObject> themeAverageTransferObject = new ArrayList<>();
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
            themeAverageTransferObject.add(new ThemeAverageTransferObject(themes.get(i).getName(), average));
        }
        return themeAverageTransferObject;
	}
	
	
}