package mbb.com.test;

import org.junit.Assert;
import org.junit.Test;

import mbb.com.Category;
import mbb.com.Product;

public class ProductTest {
    @Test
    public void ProductTest(){
        //Product productExpected = new Product("Circuit",10.0,"Electronic");
        Category category = new Category("Electronic");

        Product product = new Product("Circuit",10.0,category.getTitleCategory());

        Assert.assertEquals("Circuit",product.getTitleProduct());
        Assert.assertEquals(10.0,product.getPriceProduct(),0);
        Assert.assertEquals("Electronic",product.getTitleCategory());

    }
}
