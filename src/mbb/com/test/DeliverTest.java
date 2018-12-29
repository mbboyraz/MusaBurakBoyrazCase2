package mbb.com.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import mbb.com.Cart;
import mbb.com.Category;
import mbb.com.DeliveryCostCalculator;
import mbb.com.Product;

public class DeliverTest {
    @Test
    public void DeliverTest() {
        Category category = new Category("Glasses");
        Category categoryElectronic = new Category("Electronic");
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        categories.add(categoryElectronic);
        Cart cart = new Cart();
        Product productElectronic = new Product("Circuit",50.0,categoryElectronic.getTitleCategory());
        Product product = new Product("Sun Glass", 250.0, "Glasses");
        cart.addItem(product, 5);
        cart.addItem(productElectronic,10);

        Assert.assertEquals(34.99,cart.getDeliveryCost(cart,categories),0);

        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(5.0, 4.0);
        Assert.assertEquals(72.99,deliveryCostCalculator.calculateFor(cart,categories),0);




    }
}
