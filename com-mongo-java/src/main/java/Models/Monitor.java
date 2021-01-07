package Models;


import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Monitor {

    private ObjectId id;
    private String Name;
    private String Matrix_type;
    private String Aspect_ratio;
    private int Diagonal_matrix;
    private int Screen_resolution;
    private int Screen_refresh_rate;
    public Type Type;
    public Model Model;

    public Monitor(ObjectId id, String name, String matrix_type,
                   String aspect_ratio, int diagonal_matrix, int screen_resolution,
                   int screen_refresh_rate, Type type, Model model) {
        this.id = id;
        Name = name;
        Matrix_type = matrix_type;
        Aspect_ratio = aspect_ratio;
        Diagonal_matrix = diagonal_matrix;
        Screen_resolution = screen_resolution;
        Screen_refresh_rate = screen_refresh_rate;
        Type = type;
        Model = model;
    }

    public Monitor(String name, String matrix_type, String aspect_ratio,
                   int diagonal_matrix, int screen_resolution, int screen_refresh_rate,
                   Type type, Model model) {
        Name = name;
        Matrix_type = matrix_type;
        Aspect_ratio = aspect_ratio;
        Diagonal_matrix = diagonal_matrix;
        Screen_resolution = screen_resolution;
        Screen_refresh_rate = screen_refresh_rate;
        Type = type;
        Model = model;
    }

    public Monitor(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public Monitor setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Monitor setName(String name) {
        this.Name = name;
        return this;
    }

    public String getMatrix_type() {
        return Matrix_type;
    }

    public Monitor setMatrix_type(String matrix_type) {
        this.Matrix_type = matrix_type;
        return this;
    }

    public String getAspect_ratio() {
        return Aspect_ratio;
    }

    public Monitor setAspect_ratio(String aspect_ratio) {
        this.Aspect_ratio = aspect_ratio;
        return this;
    }

    public int getDiagonal_matrix() {
        return Diagonal_matrix;
    }

    public Monitor setDiagonal_matrix(int diagonal_matrix) {
        this.Diagonal_matrix = diagonal_matrix;
        return this;
    }

    public int getScreen_resolution() {
        return Screen_resolution;
    }

    public Monitor setScreen_resolution(int screen_resolution) {
        this.Screen_resolution = screen_resolution;
        return this;
    }

    public int getScreen_refresh_rate() {
        return Screen_refresh_rate;
    }

    public Monitor setScreen_refresh_rate(int screen_refresh_rate) {
        this.Screen_refresh_rate = screen_refresh_rate;
        return this;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type type) {
        Type = type;
    }

    public Model getModel() {
        return Model;
    }

    public void setModel(Model model) {
        Model = model;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monitor{");
        sb.append("id=").append(id);
        sb.append(", Name='").append(Name).append('\'');
        sb.append(", Matrix_type='").append(Matrix_type).append('\'');
        sb.append(", Aspect_ratio='").append(Aspect_ratio).append('\'');
        sb.append(", Diagonal_matrix=").append(Diagonal_matrix);
        sb.append(", Screen_resolution=").append(Screen_resolution);
        sb.append(", Screen_refresh_rate=").append(Screen_refresh_rate);
        sb.append(", Type=").append(Type);
        sb.append(", Model=").append(Model);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return Diagonal_matrix == monitor.Diagonal_matrix &&
                Screen_resolution == monitor.Screen_resolution &&
                Screen_refresh_rate == monitor.Screen_refresh_rate &&
                id.equals(monitor.id) &&
                Name.equals(monitor.Name) &&
                Matrix_type.equals(monitor.Matrix_type) &&
                Aspect_ratio.equals(monitor.Aspect_ratio) &&
                Type.equals(monitor.Type) &&
                Model.equals(monitor.Model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, Matrix_type, Aspect_ratio, Diagonal_matrix, Screen_resolution, Screen_refresh_rate, Type, Model);
    }
}
