package mbb.com;

public abstract class DiscountCoupon {
    public abstract double discountCalculate(Coupon coupon, double cartAmount);     //abstract method for coupon discount calculate OCP

}
