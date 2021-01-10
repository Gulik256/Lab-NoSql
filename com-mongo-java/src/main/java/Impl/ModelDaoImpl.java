package Impl;

import Dao.ModelDao;
import Models.Model;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class ModelDaoImpl implements ModelDao {

    JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

    @Override
    public void getAllModels() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");

            List<Document> modelList = Collection.find().into(new ArrayList<>());
            System.out.println("Models: ");
            for (Document model : modelList) {
                System.out.println(model.toJson());
            }
            System.out.println("------------------Models found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getByModel(String Model) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");

            Document Model_getByModel = Collection.find(new Document("Name_model", Model)).first();
            System.out.println("Model: " + Model_getByModel.toJson());
            System.out.println("------------------One model found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createModel(Model model) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");

            Document Model_createModel = new Document("_id", new ObjectId());
            Model_createModel.append("Name_company", model.getName_company())
                    .append("Country", model.getCountry())
                    .append("Name_model", model.getName_model());

            Collection.insertOne(Model_createModel);
            System.out.println("------------------One model inserted-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateModel(Model model) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");

            Bson filter = eq("_id", model.getId());
            Document setData = new Document();
            setData.append("Name_company", model.getName_company())
                    .append("Country", model.getCountry())
                    .append("Name_model", model.getName_model());
            Document update = new Document();
            update.append("$set", setData);

            Collection.updateOne(filter, update);

            System.out.println("------------------One model update-------------------");
            System.out.println(Collection.find(filter).first().toJson(prettyPrint));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteModel(Model model) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");

            Bson filter = eq("_id", model.getId());
            DeleteResult result = Collection.deleteOne(filter);
            System.out.println(result);
            System.out.println("------------------One model delete-------------------");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
