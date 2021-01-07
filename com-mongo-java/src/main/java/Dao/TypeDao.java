package Dao;

import Models.Type;
import org.bson.types.ObjectId;

import java.util.List;

public interface TypeDao {

    void getAllTypes();
    void getByNameType(String Type);
    void createType(Type type);
    void updateType(Type type);
    void deleteType(Type type);
}
