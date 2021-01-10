import Dao.MonitorDao;
import Impl.MonitorDaoImpl;
import Models.Model;
import Models.Monitor;
import Models.Type;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //insert model
//        Model model = new Model("Test","Test", "Test");
//        ModelDao modelDao = new ModelDaoImpl();
//        modelDao.createModel(model);

        //insert type
//        Type type = new Type("Test", "Test");
//        TypeDao typeDao = new TypeDaoImpl();
//        typeDao.createType(type);

        //insert monitor
//        Model model = new Model("Test","Test", "Test");
//        Type type = new Type("Test", "Test");
//        Monitor monitor = new Monitor("Test", "Test", "Test", 21, 1080, 60, type, model);
//        MonitorDao monitorDao = new MonitorDaoImpl();
//        monitorDao.createMonitor(monitor);

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

        


    }
}
