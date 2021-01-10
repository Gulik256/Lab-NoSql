package Aggregation;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.push;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.*;

public class Aggregation {

    public void testTimeAggregation(){
        //QUERY 1 NO Aggregation
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");

            long startTime = System.currentTimeMillis();
            List<Document> monitorList = Collection.find(new Document("Screen_refresh_rate", 75)).into(new ArrayList<>());
            long endTime = System.currentTimeMillis();
            System.out.println("Monitors: ");
            for (Document monitor : monitorList) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
            System.out.println("Query1 no aggregation: " + (endTime - startTime) + "ms");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //QUERY 1 Aggregation
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection2 = DB.getCollection("Monitor");

            Bson match = match(eq("Screen_refresh_rate", 75));
            long startTime = System.currentTimeMillis();
            List<Document> monitorList2 = Collection2.aggregate(Arrays.asList(match)).into(new ArrayList<>());
            long endTime = System.currentTimeMillis();
            System.out.println("Monitors: ");
            for (Document monitor : monitorList2) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
            System.out.println("Query1 aggregation: " + (endTime - startTime) + "ms");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //QUERY 2 NO Aggregation
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection3 = DB.getCollection("Monitor");

            long startTime = System.currentTimeMillis();
            List<Document> monitorList = Collection3.find(new Document("Screen_refresh_rate", 75).append("Screen_resolution", 720)).into(new ArrayList<>());
            long endTime = System.currentTimeMillis();
            System.out.println("Monitors: ");
            for (Document monitor : monitorList) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
            System.out.println("Query2 no aggregation: " + (endTime - startTime) + "ms");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //QUERY 2 Aggregation
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection4 = DB.getCollection("Monitor");

            Bson match = match(eq("Screen_refresh_rate", 75));
            Bson match2 = match(eq("Screen_resolution", 720));
            long startTime = System.currentTimeMillis();
            List<Document> monitorList2 = Collection4.aggregate(Arrays.asList(match)).into(new ArrayList<>());
            long endTime = System.currentTimeMillis();
            System.out.println("Monitors: ");
            for (Document monitor : monitorList2) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
            System.out.println("Query2 aggregation: " + (endTime - startTime) + "ms");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

//        //QUERY 3 NO Aggregation
//        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
//            MongoDatabase DB = mongoClient.getDatabase("Monitors");
//            MongoCollection<Document> Collection4 = DB.getCollection("Monitor");
//
//            long startTime = System.currentTimeMillis();
//            List<Document> monitorList = Collection4.find(new Document("Test", 60).append("Screen_resolution", 720)).into(new ArrayList<>());
//            long endTime = System.currentTimeMillis();
//            System.out.println("Monitors: ");
//            for (Document monitor : monitorList) {
//                System.out.println(monitor.toJson());
//            }
//            System.out.println("------------------Monitors found-------------------");
//            System.out.println("Query3 no aggregation: " + (endTime - startTime) + "ms");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        //TODO create query 3 no aggregation

        //QUERY 3 Aggregation
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true")) {
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection5 = DB.getCollection("Monitor");

            Bson match = match(eq("Screen_refresh_rate", 80));
            Bson sort = sort(descending("Diagonal_matrix"));
            Bson group = group("$Diagonal_matrix", sum("count", 1L), push("Diagonal_matrix", "$Diagonal_matrix"));
            Bson project = project(fields(excludeId(), computed("tag", "$_id"), include("count", "Diagonal_matrix")));
            Bson limit = limit(3);
            long startTime = System.currentTimeMillis();
            List<Document> monitorList2 = Collection5.aggregate(Arrays.asList(match, group, project, sort, limit)).into(new ArrayList<>());
            long endTime = System.currentTimeMillis();
            System.out.println("Monitors: ");
            for (Document monitor : monitorList2) {
                System.out.println(monitor.toJson());
            }
            System.out.println("------------------Monitors found-------------------");
            System.out.println("Query3 aggregation: " + (endTime - startTime) + "ms");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
