package mbb.com.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


import mbb.com.Cart;
import mbb.com.Category;
import mbb.com.Product;


public class CouponTest {
@Test
    public void CouponTest(){
        Category category = new Category("Glasses");
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        Cart cart = new Cart();
        Product product = new Product("Sun Glass",250.0,"Glasses");
        cart.addItem(product,5);

        Assert.assertEquals(60.0,cart.getCouponDiscount(cart,categories),0);
    }
}
