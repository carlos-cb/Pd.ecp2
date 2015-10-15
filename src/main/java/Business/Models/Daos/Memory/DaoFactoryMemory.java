package Business.Models.Daos.Memory;

import Business.Models.Daos.DaoFactory;

public class DaoFactoryMemory extends DaoFactory {

    public DaoFactoryMemory() {
    }

    @Override
    public Entity1Dao getEntity1Dao() {
        // TODO Auto-generated method stub
        return new Entity1DaoMemory();
    }

    @Override
    public Entity2Dao getEntity2Dao() {
        return new Entity2DaoMemory();
    }

}
