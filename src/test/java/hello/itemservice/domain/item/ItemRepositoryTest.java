package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);

        // when
        Item saveItem = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }


    @Test
    void findAll() {
        // given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> result = itemRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2); // result.size()는 2와 같다는걸 확인하고 싶을때
        assertThat(result).contains(item1, item2); // result 안에 item1, item2가 포함되있음을 확인할때
    }

    @Test
    void update() {
        // given
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        // when
        Item updateParam = new Item("item2", 20000, 40);
        itemRepository.update(itemId, updateParam);

        // then
        Item findId = itemRepository.findById(itemId);
        assertThat(findId.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findId.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findId.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

    @Test
    void clearStore() {
    }
}
