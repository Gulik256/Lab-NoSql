package Dao;

interface IDaoFactory {

    MonitorDao GetMonitorDao();
    ModelDao GetModelDao();
    TypeDao GetTypeDao();
}
