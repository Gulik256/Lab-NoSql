package Replication;

import Dao.MonitorDao;
import Impl.MonitorDaoImpl;
import Models.Model;
import Models.Monitor;
import Models.Type;

public class Replication {
    MonitorDao monitorDao = new MonitorDaoImpl();
    public void replication() throws InterruptedException {
//        monitorDao.deleteAllMonitors();
        long startTime = System.nanoTime();
        Model model = new Model("Test","Test", "Test");
        Type type = new Type("Test", "Test");
        for(int i = 0; i < 500; i++){
            insert(new Monitor("Test", "Test", "Test", 21, 1080, 60, type, model));
        }
        long endTime = System.nanoTime();
        System.out.println("Insert: " + (double) (endTime - startTime) / 1000000000);
        startTime = System.nanoTime();
        monitorDao.getAllMonitors();
        endTime = System.nanoTime();
        System.out.println("Select: " + (double) (endTime - startTime) / 1000000000);
    }

    public boolean insert(Monitor monitor) throws InterruptedException {
        int retries = 3;
        while (retries > 0) {
            try {
                if(monitorDao.createMonitor(monitor) != false){
                    return true;
                }
            } catch (Exception e) {
                retries--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return false;
    }

}
