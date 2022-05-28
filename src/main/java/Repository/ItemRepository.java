package Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Documents.GroceryItem, String> {

    @Query("{name:'?0'}")
    Documents.GroceryItem findItemByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Documents.GroceryItem> findAll(String category);

    public long count();

}
