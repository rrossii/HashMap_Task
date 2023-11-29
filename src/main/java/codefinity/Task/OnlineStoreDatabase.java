package codefinity.Task;

import codefinity.model.Customer;
import codefinity.model.Product;

public interface OnlineStoreDatabase {
    void addProduct(Product product);

    void updateProduct(int productId, double newPrice, int newQuantity);

    void removeProduct(int productId);

    void addCustomer(Customer customer);

    void updateCustomer(int customerId, String newAddress);

    void removeCustomer(int customerId);

    void placeOrder(int customerId, int productId, int quantity);

    void displayAllProducts();

    void displayAllCustomers();
}
