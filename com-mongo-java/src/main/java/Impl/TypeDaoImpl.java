package Impl;

import Dao.TypeDao;
import Models.Type;
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

public class TypeDaoImpl implements TypeDao {

    JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

    @Override
    public void getAllTypes() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");

            List<Document> typeList = Collection.find().into(new ArrayList<>());
            System.out.println("Types: ");
            for (Document type : typeList) {
                System.out.println(type.toJson());
            }
            System.out.println("------------------Types found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getByNameType(String Type) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");

            Document Type_getByType = Collection.find(new Document("Name_type", Type)).first();
            System.out.println("Type: " + Type_getByType.toJson());
            System.out.println("------------------One type found-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createType(Type type) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");

            Document Type_createType = new Document("_id", new ObjectId());
            Type_createType.append("Name_type", type.getName_type())
                    .append("Features", type.getFeatures());

            Collection.insertOne(Type_createType);
            System.out.println("------------------One type inserted-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateType(Type type) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");

            Bson filter = eq("_id", type.getId());
            Document setData = new Document();
            setData.append("Name_type", type.getName_type())
                    .append("Features", type.getFeatures());
            Document update = new Document();
            update.append("$set", setData);

            Collection.updateOne(filter, update);

            System.out.println("------------------One type update-------------------");
            System.out.println(Collection.find(filter).first().toJson(prettyPrint));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteType(Type type) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");

            Bson filter = eq("_id", type.getId());
            DeleteResult result = Collection.deleteOne(filter);
            System.out.println(result);
            System.out.println("------------------One type delete-------------------");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
