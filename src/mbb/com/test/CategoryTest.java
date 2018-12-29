package mbb.com.test;

import org.junit.Assert;
import org.junit.Test;

import mbb.com.Category;

public class CategoryTest {
    @Test
    public void CategoryTest(){
        Category category = new Category("Electronic");

        Assert.assertEquals("Electronic",category.getTitleCategory());

    }
}
