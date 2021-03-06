package Dao;

import Models.Monitor;
import org.bson.types.ObjectId;

import java.util.List;

public interface MonitorDao {

    void getAllMonitors();
    void getByName(String Name);
    boolean createMonitor(Monitor monitor);
    void updateMonitor(Monitor monitor);
    void deleteMonitor(Monitor monitor);
    void deleteAllMonitors();

}
