package mbb.com.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import mbb.com.Campaign;
import mbb.com.Cart;
import mbb.com.Category;
import mbb.com.Product;

public class CampaignTest {
    @Test
    public void CampaignTest() {
        Category category = new Category("Glasses");
        Campaign campaign= new Campaign(category,50.0,2,"Rate");
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        Cart cart = new Cart();
        Product product = new Product("Sun Glass",250.0,"Glasses");
        cart.addItem(product,5);
        campaign.discountCalculate(campaign,cart);

        Assert.assertEquals(650.0,cart.getCampaignDiscount(cart,categories),0);
    }
}
