package Models;

import org.bson.types.ObjectId;

import java.util.Objects;


public class Model {

    private ObjectId id;
    private String Name_company;
    private String Country;
    private String Name_model;

    public Model(ObjectId id, String name_company, String country, String name_model) {
        this.id = id;
        Name_company = name_company;
        Country = country;
        Name_model = name_model;
    }

    public Model(String name_company, String country, String name_model) {
        Name_company = name_company;
        Country = country;
        Name_model = name_model;
    }

    public Model(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public Model setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName_company() {
        return Name_company;
    }

    public Model setName_company(String name_company) {
        this.Name_company = name_company;
        return this;
    }

    public String getCountry() {
        return Country;
    }

    public Model setCountry(String country) {
        this.Country = country;
        return this;
    }

    public String getName_model() {
        return Name_model;
    }

    public Model setName_model(String name_model) {
        this.Name_model = name_model;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Model{");
        sb.append("id=").append(id);
        sb.append(", Name_company='").append(Name_company).append('\'');
        sb.append(", Country='").append(Country).append('\'');
        sb.append(", Name_model='").append(Name_model).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id.equals(model.id) &&
                Name_company.equals(model.Name_company) &&
                Country.equals(model.Country) &&
                Name_model.equals(model.Name_model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name_company, Country, Name_model);
    }
}
