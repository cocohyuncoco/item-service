package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
// Data는 위험하다. getter, setter 정도만 쓰는게 좋음
// DTO용으로 쓸땐 괜찮,
@Getter
@Setter
public class Item {

    private long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

