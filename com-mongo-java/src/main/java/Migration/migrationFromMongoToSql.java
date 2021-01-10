package Migration;

import Models.Type;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class migrationFromMongoToSql {

    public void MigrationTypeFromMongoToMySql(){
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Type");
            List<Document> typeList = Collection.find().into(new ArrayList<>());
            for (Document type : typeList) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Type (Name_type, Features) VALUES (?, ?)");
                    ps.setString(1, type.getString("Name_type"));
                    ps.setString(2,type.getString("Features"));
                    ps.executeUpdate();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MigrationModelFromMongoToMySql(){
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Model");
            List<Document> modelList = Collection.find().into(new ArrayList<>());
            for (Document model : modelList) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Model (Name_company, Country, Name_model) VALUES (?, ?, ?)");
                    ps.setString(1, model.getString("Name_company"));
                    ps.setString(2,model.getString("Country"));
                    ps.setString(3,model.getString("Name_model"));
                    ps.executeUpdate();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MigrationMonitorFromMongoToMySql(){
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
            MongoDatabase DB = mongoClient.getDatabase("Monitors");
            MongoCollection<Document> Collection = DB.getCollection("Monitor");
            List<Document> monitorList = Collection.find().into(new ArrayList<>());
            for (Document monitor : monitorList) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Monitor (Name, Matrix_type, Aspect_ratio, Diagonal_matrix, Screen_resolution, Screen_refresh_rate, id_type, id_model) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM Type WHERE Type.Name_type " + " = ?");
                    ps1.setString(1, monitor.getString("Name_type"));
                    ResultSet rs1 = ps1.executeQuery();
                    PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM Model WHERE Model.Name_model " + " = ?");
                    ps2.setString(1, monitor.getString("Name_model"));
                    ResultSet rs2 = ps2.executeQuery();
                    ps.setString(1, monitor.getString("Name"));
                    ps.setString(2, monitor.getString("Matrix_type"));
                    ps.setString(3, monitor.getString("Aspect_ratio"));
                    ps.setInt(4, monitor.getInteger("Diagonal_matrix"));
                    ps.setInt(5, monitor.getInteger("Screen_resolution"));
                    ps.setInt(6, monitor.getInteger("Screen_refresh_rate"));
                    ps.setInt(7, rs1.getInt("id")); //TODO строка 77 даёт null
                    ps.setInt(8, rs2.getInt("id")); //TODO строка 80 даёт null
                    ps.executeUpdate();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
