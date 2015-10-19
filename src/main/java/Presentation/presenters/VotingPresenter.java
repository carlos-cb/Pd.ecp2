package Presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import Business.controllers.BusinessController;
import Business.views.ThemeTransferObject;
import Business.views.VoteTransferObject;
import Presentation.models.Model;

public class VotingPresenter{
	
	public List<String> process() {
        List<ThemeTransferObject> themeTransferObject = new BusinessController().getAverage();
        List<String> averagesList = new ArrayList<>();
        for (int i = 0; i < themeTransferObject.size(); i++) {
            averagesList.add("[themeName=" + themeTransferObject.get(i).getThemeName() + 
            		", average=" + themeTransferObject.get(i).getAverage() + "]");
        }
        return averagesList;

    }
	
	public void voteTheme(Model model) {
        new BusinessController().voteTheme(new VoteTransferObject((String) model.get("themeName"), (int) model.get("vote")));

    }
}