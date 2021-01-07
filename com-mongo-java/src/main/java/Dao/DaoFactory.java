package Dao;

import Impl.ModelDaoImpl;
import Impl.MonitorDaoImpl;
import Impl.TypeDaoImpl;

public class DaoFactory implements IDaoFactory{

    @Override
    public MonitorDao GetMonitorDao() {
        return new MonitorDaoImpl();
    }

    @Override
    public ModelDao GetModelDao() {
        return new ModelDaoImpl();
    }

    @Override
    public TypeDao GetTypeDao() {
        return new TypeDaoImpl();
    }
}
