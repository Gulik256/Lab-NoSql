package Dao;

import Models.Model;


public interface ModelDao {

    void getAllModels();
    void getByModel(String Model);
    void createModel(Model model);
    void updateModel(Model model);
    void deleteModel(Model model);

}
