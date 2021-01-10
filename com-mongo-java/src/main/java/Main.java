import Aggregation.Aggregation;
import Dao.ModelDao;
import Dao.MonitorDao;
import Dao.TypeDao;
import Impl.ModelDaoImpl;
import Impl.MonitorDaoImpl;
import Impl.TypeDaoImpl;
import Models.Model;
import Models.Monitor;
import Models.Type;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //insert model
//        Model model = new Model("Test","Test", "Test");
//        Model model2 = new Model("Test1","Test1", "Test1");
//        Model model3 = new Model("Test2","Test2", "Test2");
//        Model model4 = new Model("Test3","Test3", "Test3");
//
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.createModel(model);
//        modelDao.createModel(model2);
//        modelDao.createModel(model3);
//        modelDao.createModel(model4);

        //insert type
//        Type type = new Type("Test", "Test");
//        Type type1 = new Type("Test2", "Test2");
//        Type type2 = new Type("Test3", "Test3");
//        Type type3 = new Type("Test4", "Test4");
//
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.createType(type);
//        typeDao.createType(type1);
//        typeDao.createType(type2);
//        typeDao.createType(type3);


        //insert monitor
//        Model model11 = new Model("Test1","Test1", "Test1");
//        Type type11 = new Type("Test1", "Test1");
//        Model model12 = new Model("Test2","Test2", "Test2");
//        Type type12 = new Type("Test2", "Test2");
//        Model model13 = new Model("Test3","Test3", "Test3");
//        Type type13 = new Type("Test3", "Test3");
//        Monitor monitor = new Monitor("Test1", "Test1", "Test1", 21, 720, 75, type11, model11);
//        Monitor monitor1 = new Monitor("Test2", "Test2", "Test2", 24, 1080, 80, type12, model12);
//        Monitor monitor2 = new Monitor("Test3", "Test3", "Test3", 26, 1080, 120, type13, model13);
//        MonitorDao monitorDao = new MonitorDaoImpl();
//        monitorDao.createMonitor(monitor);
//        monitorDao.createMonitor(monitor1);
//        monitorDao.createMonitor(monitor2);

        //find by name model
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.getByModel("Test");

        //find by type
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.getByNameType("Custom monitor");

        //find by name monitor
//        MonitorDao monitorDao = new MonitorDaoImpl();
//        monitorDao.getByName("Taya");

        //find all models
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.getAllModels();

        //find all types
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.getAllTypes();

        //find all monitors
//        MonitorDao monitorDao = new MonitorDaoImpl();
//        monitorDao.getAllMonitors();

        //update model
//        ObjectId id = new ObjectId("5ff1f52b7f11f303c4b7ceaa");
//        Model model = new Model(id,"Test1", "Test1", "Tes1");
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.updateModel(model);

        //update type
//        ObjectId id = new ObjectId("5ff71eb0ed8d8b767e7e27f5");
//        Type type = new Type(id,"Test1","Test1");
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.updateType(type);

        //update monitor
//        ObjectId id = new ObjectId("5ff746f8dbce6a593e219758");
//        Model model1 = new Model("Test","Test", "Test");
//        Type type1 = new Type("Test", "Test");
//        Monitor monitor1 = new Monitor(id,"Test1", "Test1", "Test1", 21, 1080, 60, type1, model1);
//        MonitorDao monitorDao1 = new MonitorDaoImpl();
//        monitorDao1.updateMonitor(monitor1);

        //delete model
//        ObjectId id = new ObjectId("5ff1f52b7f11f303c4b7ceaa");
//        Model model = new Model(id);
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.deleteModel(model);

        //delete type
//        ObjectId id = new ObjectId("5ff71eb0ed8d8b767e7e27f5");
//        Type type = new Type(id);
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.deleteType(type);

        //delete monitor
//        ObjectId id2 = new ObjectId("5ff746f8dbce6a593e219758");
//        Monitor monitor2 = new Monitor(id2);
//        MonitorDao monitorDao2 = new MonitorDaoImpl();
//        monitorDao2.deleteMonitor(monitor2);
//        monitorDao2.deleteAllMonitors();


        //MigrationFromMySqlToMongoDB
//        new Migration.migrationFromMySqlToMongo().MigrationTypeFromMySqlToMongo();
//        new Migration.migrationFromMySqlToMongo().MigrationModelFromMySqlToMongo();
//        new Migration.migrationFromMySqlToMongo().MigrationMonitorFromMySqlToMongo();

        //MigrationFromMongoDbToMySql
//        new Migration.migrationFromMongoToSql().MigrationTypeFromMongoToMySql();
//        new Migration.migrationFromMongoToSql().MigrationModelFromMongoToMySql();
//        new Migration.migrationFromMongoToSql().MigrationMonitorFromMongoToMySql();

    //    Replication
//        new Replication.Replication().replication();

        //Aggregation
//        new Aggregation().testTimeAggregation();
        
    }
}
