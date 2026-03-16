package cz.uhk.spring2.repository;

import cz.uhk.spring2.model.Item;
import cz.uhk.spring2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
