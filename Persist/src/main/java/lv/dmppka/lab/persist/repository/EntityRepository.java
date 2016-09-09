package lv.dmppka.lab.persist.repository;

import lv.dmppka.lab.persist.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EntityRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Entity entity) {
        mongoTemplate.save(entity);
    }

    public List<Entity> findAll() {
        return mongoTemplate.findAll(Entity.class);
    }
}
