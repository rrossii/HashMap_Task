import codefinity.Task.OnlineStoreDatabaseImpl;
import codefinity.model.Customer;
import codefinity.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OnlineStoreDatabaseImplTest {

    private OnlineStoreDatabaseImpl database = new OnlineStoreDatabaseImpl();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        database = new OnlineStoreDatabaseImpl();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void addProduct() {
        Product product = new Product(1, "Laptop", 999.99, 5);
        database.addProduct(product);

        assertTrue(database.getProducts().containsKey(1));
        assertEquals(product, database.getProducts().get(1));
    }

    @Test
    public void updateProduct() {
        Product product = new Product(1, "Laptop", 999.99, 5);
        database.addProduct(product);

        database.updateProduct(1, 1099.99, 8);

        assertEquals(1099.99, database.getProducts().get(1).getPrice(), 0.001);
        assertEquals(8, database.getProducts().get(1).getQuantity());
    }

    @Test
    public void removeProduct() {
        Product product = new Product(1, "Laptop", 999.99, 5);
        database.addProduct(product);

        database.removeProduct(1);

        assertFalse(database.getProducts().containsKey(1));
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        database.addCustomer(customer);

        assertTrue(database.getCustomers().containsKey(101));
        assertEquals(customer, database.getCustomers().get(101));
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        database.addCustomer(customer);

        database.updateCustomer(101, "456 Oak St");

        assertEquals("456 Oak St", database.getCustomers().get(101).getAddress());
    }

    @Test
    public void removeCustomer() {
        Customer customer = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        database.addCustomer(customer);

        database.removeCustomer(101);

        assertFalse(database.getCustomers().containsKey(101));
    }

    @Test
    public void placeOrder_Successful() {
        Customer customer = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        Product product = new Product(1, "Laptop", 999.99, 5);

        database.addCustomer(customer);
        database.addProduct(product);

        database.placeOrder(101, 1, 3);

        assertEquals(2, database.getProducts().get(1).getQuantity());
        assertEquals("Order placed successfully!", outputStream.toString());
    }

    @Test
    public void placeOrder_Failure_CustomerNotFound() {
        Product product = new Product(1, "Laptop", 999.99, 5);

        database.addProduct(product);

        database.placeOrder(101, 1, 3);

        assertEquals("Failed to place the order. Check the data.\n", outputStream.toString());
    }

    @Test
    public void placeOrder_Failure_ProductNotFound() {
        Customer customer = new Customer(101, "John Doe", "john@example.com", "123 Main St");

        database.addCustomer(customer);

        database.placeOrder(101, 1, 3);

        assertEquals("Failed to place the order. Check the data.\n", outputStream.toString());
    }

    @Test
    public void displayAllProducts() {
        Product laptop = new Product(1, "Laptop", 999.99, 5);
        Product phone = new Product(2, "Smartphone", 499.99, 10);

        database.addProduct(laptop);
        database.addProduct(phone);

        database.displayAllProducts();

        String expectedOutput = "List of products:" +
                "1: Laptop - $999.99" +
                "2: Smartphone - $499.99";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void displayAllCustomers() {
        Customer john = new Customer(101, "John Doe", "john@example.com", "123 Main St");
        Customer jane = new Customer(102, "Jane Smith", "jane@example.com", "456 Oak St");

        database.addCustomer(john);
        database.addCustomer(jane);

        database.displayAllCustomers();

        String expectedOutput = "List of customers:" +
                "101: John Doe - 123 Main St" +
                "102: Jane Smith - 456 Oak St";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void getProducts() {
        assertNotNull(database.getProducts());
        assertTrue(database.getProducts().isEmpty());
    }

    @Test
    public void getCustomers() {
        assertNotNull(database.getCustomers());
        assertTrue(database.getCustomers().isEmpty());
    }

    @Test
    public void toStringTest() {
        assertNotNull(database.toString());
    }
}
