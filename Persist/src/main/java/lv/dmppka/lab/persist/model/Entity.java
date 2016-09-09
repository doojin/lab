package lv.dmppka.lab.persist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "entities")
public class Entity {

    @Id
    private String id;
    private Map<String, Object> data = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void add(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }
}
