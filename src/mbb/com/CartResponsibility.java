package mbb.com;

import java.util.ArrayList;

public interface CartResponsibility {
    double getTotalAmountAfterDiscount(Cart cart, ArrayList<Category> categoryArrayList);

    double getCouponDiscount(Cart cart, ArrayList<Category> categoryArrayList);

    double getCampaignDiscount(Cart cart, ArrayList<Category> categoryArrayList);

    double getDeliveryCost(Cart cart, ArrayList<Category> categoryArrayList);
}
