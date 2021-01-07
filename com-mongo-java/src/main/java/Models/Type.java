package Models;

import org.bson.types.ObjectId;

import java.util.Objects;

public class Type {

    private ObjectId id;
    private String Name_type;
    private String Features;

    public Type(ObjectId id, String name_type, String features) {
        this.id = id;
        Name_type = name_type;
        Features = features;
    }

    public Type(String name_type, String features) {
        Name_type = name_type;
        Features = features;
    }

    public Type(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public Type setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName_type() {
        return Name_type;
    }

    public Type setName_type(String name_type) {
        this.Name_type = name_type;
        return this;
    }

    public String getFeatures() {
        return Features;
    }

    public Type setFeatures(String features) {
        this.Features = features;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Type{");
        sb.append("id=").append(id);
        sb.append(", Name_type='").append(Name_type).append('\'');
        sb.append(", Features='").append(Features).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id.equals(type.id) &&
                Name_type.equals(type.Name_type) &&
                Features.equals(type.Features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name_type, Features);
    }
}
