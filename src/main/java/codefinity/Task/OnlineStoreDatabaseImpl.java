package codefinity.Task;

import codefinity.model.Customer;
import codefinity.model.Product;

import java.util.HashMap;
import java.util.Map;

public class OnlineStoreDatabaseImpl implements OnlineStoreDatabase {

    private Map<Integer, Product> products;
    private Map<Integer, Customer> customers;

    public OnlineStoreDatabaseImpl() {
        this.products = new HashMap<>();
        this.customers = new HashMap<>();
    }


    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(int productId, double newPrice, int newQuantity) {

    }

    @Override
    public void removeProduct(int productId) {

    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(int customerId, String newAddress) {

    }

    @Override
    public void removeCustomer(int customerId) {

    }

    @Override
    public void placeOrder(int customerId, int productId, int quantity) {

    }

    @Override
    public void displayAllProducts() {

    }

    @Override
    public void displayAllCustomers() {

    }
}
