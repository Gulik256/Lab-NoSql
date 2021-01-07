package Impl;

import Dao.MonitorDao;
import Models.Monitor;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MonitorDaoImpl implements MonitorDao {

    JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

    @Override
    public void getAllMonitors() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            List<Document> monitorList = Collection.find().into(new ArrayList<>());
            System.out.println("Monitors: ");
            for (Document monitor : monitorList) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getByName(String Name) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            Document Monitor_getByName = Collection.find(new Document("Name", Name)).first();
            System.out.println("Monitor: " + Monitor_getByName.toJson());
            System.out.println("------------------One monitor found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMonitor(Monitor monitor) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            Document Monitor_createMonitor = new Document("_id", new ObjectId());
            Document Monitor_createTypeMonitor = new Document("_id", new ObjectId());
            Document Monitor_createModelMonitor = new Document("_id", new ObjectId());

            Monitor_createTypeMonitor.append("Name_type", monitor.Type.getName_type())
                    .append("Features", monitor.Type.getFeatures());

            Monitor_createModelMonitor.append("Name_company", monitor.Model.getName_company())
                    .append("Country", monitor.Model.getCountry())
                    .append("Name_model", monitor.Model.getName_model());

            Monitor_createMonitor.append("Name", monitor.getName())
                    .append("Matrix_type", monitor.getMatrix_type())
                    .append("Aspect_ratio", monitor.getAspect_ratio())
                    .append("Diagonal_matrix", monitor.getDiagonal_matrix())
                    .append("Screen_resolution", monitor.getScreen_resolution())
                    .append("Screen_refresh_rate", monitor.getScreen_refresh_rate())
                    .append("Type", Monitor_createTypeMonitor)
                    .append("Model", Monitor_createModelMonitor);

            Collection.insertOne(Monitor_createMonitor);
            System.out.println("------------------One monitor inserted-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMonitor(Monitor monitor) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            Document setData_Type = new Document();
            setData_Type.append("Name_type", monitor.Type.getName_type())
                    .append("Features", monitor.Type.getFeatures());

            Document setData_Model = new Document();
            setData_Model.append("Name_company", monitor.Model.getName_company())
                    .append("Country", monitor.Model.getCountry())
                    .append("Name_model", monitor.Model.getName_model());

            Bson filter = eq("_id", monitor.getId());
            Document setData_Monitor = new Document();
            setData_Monitor.append("Name", monitor.getName())
                    .append("Matrix_type", monitor.getMatrix_type())
                    .append("Aspect_ratio", monitor.getAspect_ratio())
                    .append("Diagonal_matrix", monitor.getDiagonal_matrix())
                    .append("Screen_resolution", monitor.getScreen_resolution())
                    .append("Screen_refresh_rate", monitor.getScreen_refresh_rate())
                    .append("Type", setData_Type)
                    .append("Model", setData_Model);

            Document update = new Document();
            update.append("$set", setData_Monitor);

            Collection.updateOne(filter, update);

            System.out.println("------------------One monitor update-------------------");
            System.out.println(Collection.find(filter).first().toJson(prettyPrint));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMonitor(Monitor monitor) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            Bson filter = eq("_id", monitor.getId());
            DeleteResult result = Collection.deleteOne(filter);
            System.out.println(result);
            System.out.println("------------------One monitor delete-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
