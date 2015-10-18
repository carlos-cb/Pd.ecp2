package Business.models.Daos;

import java.util.List;

import Business.models.entities.Theme;
import Business.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

	public List<Vote> findByTheme(Theme theme);

}