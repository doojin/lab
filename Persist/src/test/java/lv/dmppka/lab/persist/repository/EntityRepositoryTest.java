package lv.dmppka.lab.persist.repository;

import lv.dmppka.lab.persist.model.Entity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mongo-test-context.xml"})
public class EntityRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    private EntityRepository entityRepository;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(Entity.class);
        entityRepository = new EntityRepository(mongoTemplate);
    }

    @Test
    public void save_findAll() {
        Entity entity1 = createEntity("key1", 1);
        entityRepository.save(entity1);

        Entity entity2 = createEntity("key1", 2);
        entityRepository.save(entity2);

        List<Entity> allEntities = entityRepository.findAll();
        assertThat(allEntities.size(), equalTo(2));
        assertThat(allEntities.get(0).get("key1"), equalTo(1));
        assertThat(allEntities.get(1).get("key1"), equalTo(2));
    }

    private Entity createEntity(String key, Object value) {
        Entity entity = new Entity();
        entity.add(key, value);
        return entity;
    }
}