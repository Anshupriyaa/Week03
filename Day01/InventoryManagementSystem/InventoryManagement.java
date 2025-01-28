public class InventoryManagement {
    static class Node {
        String itemName;
        String itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, String itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Node head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, String itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, String itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, String itemId, int quantity, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(itemName, itemId, quantity, price);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove an item based on Item ID
    public void removeById(String itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        if (head.itemId.equals(itemId)) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && !temp.itemId.equals(itemId)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found!");
            return;
        }

        prev.next = temp.next;
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(String itemId, int newQuantity) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId.equals(itemId)) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    // Search for an item based on Item ID
    public void searchById(String itemId) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId.equals(itemId)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    // Search for an item based on Item Name
    public void searchByName(String itemName) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Node temp = head;

        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total inventory value: $" + totalValue);
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String criterion, boolean ascending) {
        head = mergeSort(head, criterion, ascending);
    }

    private Node mergeSort(Node head, String criterion, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head, criterion, ascending);
        Node right = mergeSort(nextOfMiddle, criterion, ascending);

        return merge(left, right, criterion, ascending);
    }

    private Node merge(Node left, Node right, String criterion, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;

        boolean condition;
        if (criterion.equalsIgnoreCase("name")) {
            condition = ascending ? left.itemName.compareToIgnoreCase(right.itemName) <= 0
                                  : left.itemName.compareToIgnoreCase(right.itemName) > 0;
        } else if (criterion.equalsIgnoreCase("price")) {
            condition = ascending ? left.price <= right.price : left.price > right.price;
        } else {
            throw new IllegalArgumentException("Invalid sort criterion!");
        }

        if (condition) {
            result = left;
            result.next = merge(left.next, right, criterion, ascending);
        } else {
            result = right;
            result.next = merge(left, right.next, criterion, ascending);
        }

        return result;
    }

    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Display a single item
    private void displayItem(Node item) {
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Item ID: " + item.itemId);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: $" + item.price);
        System.out.println();
    }

    // Display all items
    public void displayInventory() {
        Node temp = head;

        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtBeginning("Item A", "ID1", 10, 5.5);
        inventory.addAtEnd("Item B", "ID2", 20, 15.0);
        inventory.addAtPosition("Item C", "ID3", 5, 7.5, 2);
        inventory.addAtEnd("Item D", "ID4", 12, 10.0);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        inventory.removeById("ID003");
        System.out.println("After removing Item C:");
        inventory.displayInventory();

        inventory.updateQuantity("ID002", 25);
        System.out.println("After updating quantity of Item B:");
        inventory.displayInventory();

        inventory.searchById("ID001");
        inventory.searchByName("Item D");

        inventory.calculateTotalValue();

        inventory.sortInventory("name", true);
        System.out.println("After sorting by name (ascending):");
        inventory.displayInventory();

        inventory.sortInventory("price", false);
        System.out.println("After sorting by price (descending):");
        inventory.displayInventory();
    }
}
