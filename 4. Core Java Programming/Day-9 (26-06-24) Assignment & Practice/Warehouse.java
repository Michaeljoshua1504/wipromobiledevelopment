import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Item, Integer> inventory;

    public Warehouse() {
        this.inventory = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void showInventory() {
        for (Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }

    public int getQuantity(Item item) {
        return inventory.getOrDefault(item, 0);
    }

    public Item findItemById(String itemId) {
        for (Item item : inventory.keySet()) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}
