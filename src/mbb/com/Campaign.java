package mbb.com;

import java.util.ArrayList;

public class Campaign extends DiscountCampaign {

    private Category category;
    private double discountAmount;
    private int categoryQuantity;
    private String discountType;

    public Campaign(Category category, double discountAmount, int categoryQuantity, String discountType) {
        this.category = category;
        this.discountAmount = discountAmount;
        this.categoryQuantity = categoryQuantity;
        this.discountType = discountType;
    }

    public Campaign() {
    }

    public ArrayList<Campaign> getCampains(Cart cart, ArrayList<Category> categories) {                  //getting campaigns for order quantity>=3
        ArrayList<Campaign> campaigns = new ArrayList<>();                                              //getting campaigns for order quantity>=5
        for (Category cat : categories) {                                                               //getting campaigns for order quantity>=5 && amount>=100 (not documented)
            if (cart.shoppingCart.get(cat.getTitleCategory()) >= 3 && cart.shoppingCart.get(cat.getTitleCategory()) < 5) {
                Campaign campaign1 = new Campaign(cat, 20.0, cart.shoppingCart.get(cat.getTitleCategory()), "rate");
                campaigns.add(campaign1);
            } else if (cart.shoppingCart.get(cat.getTitleCategory()) >= 5) {
                Campaign campaign2 = new Campaign(cat, 50.0, cart.shoppingCart.get(cat.getTitleCategory()), "rate");
                campaigns.add(campaign2);
                if (cart.totalAmountByCategory.get(cat.getTitleCategory()) >= 100.0) {
                    Campaign campaign = new Campaign(cat, 5.0, cart.shoppingCart.get(cat.getTitleCategory()), "amount");
                    campaigns.add(campaign);

                }
            }
        }
        return campaigns;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getCategoryQuantity() {
        return categoryQuantity;
    }

    public void setCategoryQuantity(int categoryQuantity) {
        this.categoryQuantity = categoryQuantity;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }


    @Override
    public double discountCalculate(Campaign campaign, Cart cart) {         //overriding DiscountCampaign and calculate discount for active campaigns
        double discountPrice;
        if (campaign.getDiscountType().equalsIgnoreCase("Rate")) {
            discountPrice = (campaign.getDiscountAmount() * cart.totalAmountByCategory.get(campaign.getCategory().getTitleCategory()) / 100);       //calculate for rate
        } else if (campaign.getDiscountType().equalsIgnoreCase("Amount")) {
            discountPrice = campaign.getDiscountAmount() * cart.shoppingCart.get(campaign.getCategory().getTitleCategory());                    //calculate for amount
        } else
            discountPrice = 0;
        return discountPrice;

    }
}
