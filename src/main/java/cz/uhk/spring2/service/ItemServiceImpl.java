package cz.uhk.spring2.service;

import cz.uhk.spring2.model.Item;
import cz.uhk.spring2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItem(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(long id) {
        Item u = getItem(id);
        if(u != null){
            itemRepository.delete(u);
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
