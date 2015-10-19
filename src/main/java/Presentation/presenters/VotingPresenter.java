package Presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import Business.controllers.BusinessController;
import Business.views.VoteTransferObject;
import Presentation.models.Model;

public class VotingPresenter{
	
	public List<String> process() {
        List<VoteTransferObject> themeAverages = new BusinessController().showAverage();
        List<String> averagesList = new ArrayList<>();
        for (int i = 0; i < themeAverages.size(); i++) {
            averagesList.add("[themeName=" + themeAverages.get(i).getThemeName() + 
            		", average=" + themeAverages.get(i).getAverage() + "]");
        }
        return averagesList;

    }
	
	public void voteTheme(Model model) {
        new BusinessController().voteTheme(new VoteTransferObject((String) model.get("themeName"), (int) model.get("vote")));

    }
}