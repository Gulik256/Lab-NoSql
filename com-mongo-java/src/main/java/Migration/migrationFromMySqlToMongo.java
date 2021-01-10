package Migration;

import Models.Model;
import Models.Monitor;
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

public class migrationFromMySqlToMongo {

    public void MigrationTypeFromMySqlToMongo(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Type");
                ResultSet rs = ps.executeQuery();
                List<Document> lec = new ArrayList<>();
                while (rs.next()){
                    Type type = new Type(
                            rs.getString("Name_type"),
                            rs.getString("Features")
                    );
                    Document type_lec = new Document("_id", new ObjectId());
                    type_lec.append("Name_type", type.getName_type())
                            .append("Features", type.getFeatures());
                    lec.add(type_lec);
                }
                rs.close();

                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
                MongoDatabase DB = mongoClient.getDatabase("Monitors");
                MongoCollection<Document> Collection = DB.getCollection("Type");

                Collection.insertMany(lec);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MigrationModelFromMySqlToMongo(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Model");
                ResultSet rs = ps.executeQuery();
                List<Document> lec = new ArrayList<>();
                while (rs.next()){
                    Model model = new Model(
                            rs.getString("Name_company"),
                            rs.getString("Country"),
                            rs.getString("Name_model")
                    );
                    Document model_lec = new Document("_id", new ObjectId());
                    model_lec.append("Name_company", model.getName_company())
                             .append("Country", model.getCountry())
                             .append("Name_model", model.getName_model());
                    lec.add(model_lec);
                }
                rs.close();

                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
                MongoDatabase DB = mongoClient.getDatabase("Monitors");
                MongoCollection<Document> Collection = DB.getCollection("Model");

                Collection.insertMany(lec);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MigrationMonitorFromMySqlToMongo(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monitors_nosql?serverTimezone=UTC","root","Rocstar256157");
            try{
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Monitor, Model, Type WHERE Monitor.id_type = Type.id AND Monitor.id_model = Model.id");
                ResultSet rs = ps.executeQuery();
                List<Document> lec = new ArrayList<>();
                while (rs.next()){
                    Type type = new Type(
                            rs.getString("Name_type"),
                            rs.getString("Features")
                    );
                    Model model = new Model(
                            rs.getString("Name_company"),
                            rs.getString("Country"),
                            rs.getString("Name_model")
                    );
                    Monitor monitor = new Monitor(
                            rs.getString("Name"),
                            rs.getString("Matrix_type"),
                            rs.getString("Aspect_ratio"),
                            rs.getInt("Diagonal_matrix"),
                            rs.getInt("Screen_resolution"),
                            rs.getInt("Screen_refresh_rate"),
                            type,
                            model
                    );

                    Document setData_Type = new Document("_id", new ObjectId());
                    setData_Type.append("Name_type", monitor.Type.getName_type())
                            .append("Features", monitor.Type.getFeatures());

                    Document setData_Model = new Document("_id", new ObjectId());
                    setData_Model.append("Name_company", monitor.Model.getName_company())
                            .append("Country", monitor.Model.getCountry())
                            .append("Name_model", monitor.Model.getName_model());

                    Document monitor_lec = new Document("_id", new ObjectId());
                    monitor_lec.append("Name", monitor.getName())
                    .append("Matrix_type", monitor.getMatrix_type())
                    .append("Aspect_ratio", monitor.getAspect_ratio())
                    .append("Diagonal_matrix", monitor.getDiagonal_matrix())
                    .append("Screen_resolution", monitor.getScreen_resolution())
                    .append("Screen_refresh_rate", monitor.getScreen_refresh_rate())
                    .append("Type", setData_Type)
                    .append("Model", setData_Model);

                    lec.add(monitor_lec);
                }
                rs.close();

                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27011,localhost:27012,localhost:27013/?replicaSet=myapp&retryWrites=true");
                MongoDatabase DB = mongoClient.getDatabase("Monitors");
                MongoCollection<Document> Collection = DB.getCollection("Monitor");

                Collection.insertMany(lec);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
