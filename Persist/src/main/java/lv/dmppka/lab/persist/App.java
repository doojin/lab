package lv.dmppka.lab.persist;

import lv.dmppka.lab.persist.model.Entity;
import lv.dmppka.lab.persist.repository.EntityRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        EntityRepository repository = context.getBean(EntityRepository.class);

        Entity entity = new Entity();
        entity.add("key1", "value");
        entity.add("key2", 5);

        repository.save(entity);

        repository.findAll().stream().forEach(App::printEntity);
    }

    private static void printEntity(Entity entity) {
        System.out.println(String.format("%s %s %s", entity.getId(), entity.get("key1"), entity.get("key2")));
    }
}
