package mbb.com;

import java.util.ArrayList;

public class Coupon extends DiscountCoupon {

    private Category category;
    private double discountAmount;
    private double categoryAmount;
    private String discountType;


    public Coupon(Category category, double discountAmount, double categoryAmount, String discountType) {
        this.category = category;
        this.discountAmount = discountAmount;
        this.categoryAmount = categoryAmount;
        this.discountType = discountType;
    }

    public Coupon() {
    }

    public ArrayList<Coupon> getCoupons(Cart cart, ArrayList<Category> categories) {                //getting coupons for order amount>=100
        ArrayList<Coupon> coupons = new ArrayList<>();
        for (Category cat : categories) {
            if (cart.totalAmountByCategory.get(cat.getTitleCategory()) >= 100) {
                Coupon coupon = new Coupon(cat, 10.0, cart.totalAmountByCategory.get(cat.getTitleCategory()), "rate");
                coupons.add(coupon);
            }
        }
        return coupons;
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

    public double getCategoryAmount() {
        return categoryAmount;
    }

    public void setCategoryAmount(double categoryAmount) {
        this.categoryAmount = categoryAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @Override
    public double discountCalculate(Coupon coupon, double cartAmount) {             //overriding from DiscountCoupon abstract class and calculating coupon discount after Campaign
        double discountPrice;
        if (coupon.getDiscountType().equalsIgnoreCase("Rate")) {
            discountPrice = (coupon.getDiscountAmount() * cartAmount / 100);
        } else
            discountPrice = 0;
        return discountPrice;

    }
}
