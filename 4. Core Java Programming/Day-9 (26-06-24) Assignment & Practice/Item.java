public class Item {
    private String itemId;
    private double price;
    private String description;
    private String title;

    public Item(String itemId, double price, String description, String title) {
        this.itemId = itemId;
        this.price = price;
        this.description = description;
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
