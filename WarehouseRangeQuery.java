import java.util.TreeSet;

public class WarehouseRangeQuery {

    public static void main(String[] args) {

        // Inventory quantities stored in warehouse
        TreeSet<Integer> inventory = new TreeSet<>();

        inventory.add(120);
        inventory.add(250);
        inventory.add(310);
        inventory.add(450);
        inventory.add(520);

        System.out.println("===== SmartLogix Warehouse Inventory =====");

        System.out.println("\nAll Inventory Quantities:");
        for(Integer qty : inventory) {
            System.out.println(qty);
        }

        System.out.println("\nProducts with Quantity between 200 and 500:");

        for(Integer qty : inventory.subSet(200, true, 500, true)) {
            System.out.println(qty);
        }
    }
}