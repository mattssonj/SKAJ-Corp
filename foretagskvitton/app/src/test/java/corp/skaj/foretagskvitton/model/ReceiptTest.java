package corp.skaj.foretagskvitton.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class ReceiptTest {

    Receipt receipt;

    @Before
    public void setup() {
        Product product = new Product("Appelsin Juice", 15.90, 25);
        Calendar c = Calendar.getInstance();
        c.set(2017, 04, 10);
        double totalPrice = 15.90;
        receipt = new Receipt(product, c, totalPrice);
    }

    @Test
    public void testGetAmountOfProducts() {
        int amount = receipt.getAmountOfProducts();

        Assert.assertEquals(1, amount);
    }

    @Test
    public void testPrice(){
        double price = receipt.getTotal();

        Assert.assertEquals(15.90, price);
    }

    @Test
    public void testTime() {
        Calendar time = Calendar.getInstance();
        time.set(2017, 04, 10);

        Assert.assertEquals(receipt.getDate(), time);
    }

    @Test
    public void testProductName() {
        String productName = receipt.getListOfProducts().get(0).getName();

        Assert.assertEquals("Appelsin Juice", productName);
    }

    @Test
    public void testTax(){
        double tax = receipt.getListOfProducts().get(0).getTax();

        Assert.assertEquals(25.0, tax);
    }
}