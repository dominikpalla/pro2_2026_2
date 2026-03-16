package cz.uhk.spring2.service;

import cz.uhk.spring2.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    void saveItem(Item item);
    Item getItem(long id);
    void deleteItem(long id);
    List<Item> getAllItems();
}
