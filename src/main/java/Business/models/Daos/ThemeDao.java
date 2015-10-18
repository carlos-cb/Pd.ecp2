package Business.models.Daos;

import java.util.List;

import Business.models.entities.Theme;

public interface ThemeDao extends GenericDao<Theme, Integer> {

	Theme findByName(String themeName);

	List<String> findAllNames();

}