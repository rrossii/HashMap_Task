package codefinity;

import codefinity.Task.OnlineStoreDatabase;
import codefinity.Task.OnlineStoreDatabaseImpl;
import codefinity.model.Customer;
import codefinity.model.Product;

public class Main {
    public static void main(String[] args) {
        OnlineStoreDatabase database = new OnlineStoreDatabaseImpl();

        Product laptop = new Product(1, "Laptop", 899.99, 10);
        Product phone = new Product(2, "Smartphone", 499.99, 20);

        database.addProduct(laptop);
        database.addProduct(phone);

        Customer customer1 = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        Customer customer2 = new Customer(102, "Jane Smith", "jane@example.com", "456 Oak St");

        database.addCustomer(customer1);
        database.addCustomer(customer2);

        database.displayAllProducts();
        database.displayAllCustomers();

        database.placeOrder(101, 1, 2);
        database.placeOrder(102, 2, 5);

        database.displayAllProducts();
    }
}