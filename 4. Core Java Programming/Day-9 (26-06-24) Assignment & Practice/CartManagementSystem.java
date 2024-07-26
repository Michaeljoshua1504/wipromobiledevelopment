import java.util.Scanner;

public class CartManagementSystem {
    private static Warehouse warehouse = new Warehouse();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItemToWarehouse();
                    break;
                case 2:
                    viewWarehouseInventory();
                    break;
                case 3:
                    checkItemQuantity();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nWarehouse Management System");
        System.out.println("1. Add Item to Warehouse");
        System.out.println("2. View Warehouse Inventory");
        System.out.println("3. Check Item Quantity");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItemToWarehouse() {
        System.out.print("Enter Item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Item item = new Item(itemId, price, description, title);
        warehouse.addItem(item, quantity);
        System.out.println("Item added to warehouse successfully.");
    }

    private static void viewWarehouseInventory() {
        warehouse.showInventory();
    }

    private static void checkItemQuantity() {
        System.out.print("Enter Item ID to check quantity: ");
        String itemId = scanner.nextLine();

        Item item = warehouse.findItemById(itemId);
        if (item != null) {
            int quantity = warehouse.getQuantity(item);
            System.out.println("Item: " + item);
            System.out.println("Quantity in warehouse: " + quantity);
        } else {
            System.out.println("Item not found in the warehouse.");
        }
    }
}
