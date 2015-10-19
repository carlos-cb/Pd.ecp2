package Business.controllers;

import java.util.ArrayList;
import java.util.List;

import Business.models.Daos.DaoFactory;
import Business.models.entities.Theme;
import Business.models.entities.Vote;
import Business.views.ThemeTransferObject;
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
	
	public List<ThemeTransferObject> getAverage() {
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeTransferObject> themeTransferObject = new ArrayList<>();
        for (int i = 0; i < themes.size(); i++) {
            List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(themes.get(i));
            double average = getmedia(votes);
            themeTransferObject.add(new ThemeTransferObject(themes.get(i).getName(), average));
        }
        return themeTransferObject;
	}

    private double getmedia(List<Vote> votes) {
        double total = 0;
        double media = 0;
        for (int i = 0; i < votes.size(); i++) {
        	total += votes.get(i).getVote();
        }
            media = total / votes.size();
        return media;
    }
}