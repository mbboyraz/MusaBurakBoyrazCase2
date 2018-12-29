package mbb.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart implements CartResponsibility {
    Map<String, Integer> shoppingCart = new HashMap<>();
    double totalAmount = 0;
    double amountTemp = 0;
    double amount = 0;
    Map<String, Double> totalAmountByCategory = new HashMap<>();
    private boolean campaignCheck = false;

    public void addItem(Product product, int quantity) {                    //add item to cart
        amount = 0;
        product.setQuantityProduct(quantity);
        if (shoppingCart.isEmpty()) {                               //shopping cart stored in hashmap and check if shopping cart is empty add first
            shoppingCart.put(product.getTitleCategory(), quantity);         //add quantity via category name
            amount = product.getPriceProduct() * quantity;                  //amount for added product and quantity
            totalAmount = totalAmount + amount;                             //total cart amount wihout discounts and deliver
            totalAmountByCategory.putIfAbsent(product.getTitleCategory(), totalAmount);             //total amounts stored Hashmap and group by categories
        } else if (shoppingCart.containsKey(product.getTitleCategory())) {                      //if shpping cart is not empty
            amount = product.getPriceProduct() * quantity;                                  //amount for added product and quantity
            totalAmount = totalAmount + amount;                                             //totalAmount added amount
            shoppingCart.put(product.getTitleCategory(), shoppingCart.get(product.getTitleCategory()) + quantity);      //if shopping cart is not empty, add to existing quantity
            if (totalAmountByCategory.containsKey(product.getTitleCategory())) {                                                        //if totalAmountByCategory is empty
                totalAmountByCategory.put(product.getTitleCategory(), totalAmountByCategory.get(product.getTitleCategory()) + amount);      //add amount to hashmap group by categories
            } else {
                totalAmountByCategory.put(product.getTitleCategory(), amount);                                                             //else add existing totalAmount to amount
            }
        } else {
            amount = product.getPriceProduct() * quantity;                                                                              //calculate amount via quantity
            totalAmount = totalAmount + amount;
            shoppingCart.put(product.getTitleCategory(), quantity);
            if (totalAmountByCategory.containsKey(product.getTitleCategory())) {
                totalAmountByCategory.put(product.getTitleCategory(), totalAmountByCategory.get(product.getTitleCategory()) + amount);
            } else {
                totalAmountByCategory.put(product.getTitleCategory(), amount);
            }
        }
        print(product);
    }

    private void print(Product product) {                   //print added products according to the format
        System.out.println("Added item");
        System.out.println("Category\t:" + product.getTitleCategory() + "\nProduct\t:" + product.getTitleProduct() + "\nQuantity\t:" + product.getQuantityProduct() + "\nUnit Price\t:" + product.getPriceProduct() + "\nTotal Price\t:" + totalAmount);

    }


    @Override
    public double getTotalAmountAfterDiscount(Cart cart, ArrayList<Category> categoryArrayList) {
        double lastPrice = cart.totalAmount - getCampaignDiscount(cart, categoryArrayList) - getCouponDiscount(cart, categoryArrayList);
        System.out.println("Total Price (without Delivery Cost) : " + lastPrice);
        return lastPrice;
    }

    @Override
    public double getCouponDiscount(Cart cart, ArrayList<Category> categoryArrayList) {
        Coupon coupon = new Coupon();
        ArrayList<Coupon> activeCoupons = coupon.getCoupons(cart, categoryArrayList);
        if (!campaignCheck) {
            getCampaignDiscount(cart, categoryArrayList);
        }
        double totalDiscountCoupon = 0;
        for (Coupon coup : activeCoupons) {

            totalDiscountCoupon = totalDiscountCoupon + coup.discountCalculate(coup, amountTemp);
        }

        System.out.println("Coupons discount price : " + totalDiscountCoupon);
        return totalDiscountCoupon;

    }

    @Override
    public double getCampaignDiscount(Cart cart, ArrayList<Category> categoryArrayList) {
        Campaign campaign = new Campaign();
        ArrayList<Campaign> activeCampains = campaign.getCampains(cart, categoryArrayList);
        double totalDiscount = 0;
        for (Campaign camp : activeCampains) {
            //System.out.println(camp.getCategory().getTitleCategory()+" discount price : "+camp.discountCalculate(camp,cart));
            totalDiscount = totalDiscount + camp.discountCalculate(camp, cart);
        }
        campaignCheck = true;
        amountTemp = cart.totalAmount - totalDiscount;
        System.out.println("Campaign discount price : " + totalDiscount);
        return totalDiscount;
    }

    @Override
    public double getDeliveryCost(Cart cart, ArrayList<Category> categoryArrayList) {
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(1.0, 2.0);
        return deliveryCostCalculator.calculateFor(cart, categoryArrayList);
    }

}
