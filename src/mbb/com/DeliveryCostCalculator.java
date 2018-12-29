package mbb.com;

import java.util.ArrayList;

public class DeliveryCostCalculator {
    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost = 2.99;            //fixed price default

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct) {          //delivery need costPerDelivery and costPerProduct
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;

    }


    public double getCostPerDelivery() {
        return costPerDelivery;
    }

    public void setCostPerDelivery(double costPerDelivery) {
        this.costPerDelivery = costPerDelivery;
    }

    public double getCostPerProduct() {
        return costPerProduct;
    }

    public void setCostPerProduct(double costPerProduct) {
        this.costPerProduct = costPerProduct;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    public double calculateFor(Cart cart, ArrayList<Category> categoryArrayList) {          //Delivery cost calculate via this method
        double delivery = 0;
        int categoryNumber = 0;
        for (Category cat : categoryArrayList) {
            delivery = delivery + getCostPerProduct() * cart.shoppingCart.get(cat.getTitleCategory());
            categoryNumber++;
        }

        return (getCostPerDelivery() * categoryNumber) + delivery + getFixedCost();
    }


}
