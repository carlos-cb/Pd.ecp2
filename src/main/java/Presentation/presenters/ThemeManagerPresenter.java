package Presentation.presenters;

import java.util.List;

import Business.controllers.BusinessController;
import Presentation.models.Model;

public class ThemeManagerPresenter{
	
	public List<String> process() {
		List<String> themes = new BusinessController().showThemes();
        return themes;
	}

	public void createTheme(Model model) {
		new BusinessController().createTheme((String) model.get("themeName"));
		
	}
}