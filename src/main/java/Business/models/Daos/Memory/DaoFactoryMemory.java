package Business.models.Daos.Memory;

import Business.models.Daos.DaoFactory;
import Business.models.Daos.ThemeDao;
import Business.models.Daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

	private ThemeDao themeDao;

    private VoteDao voteDao;
	
    public DaoFactoryMemory() {
    }

    @Override
    public ThemeDao getThemeDao() {
    	if (themeDao == null) {
            themeDao = new ThemeMemoryDao();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
    	if (voteDao == null) {
            voteDao = new VoteMemoryDao();
        }
        return voteDao;
    }

}
