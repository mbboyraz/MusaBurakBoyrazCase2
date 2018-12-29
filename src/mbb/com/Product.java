package mbb.com;

public class Product extends Category {
    private String titleProduct;
    private double priceProduct;
    private int quantityProduct;


    public Product(String titleProduct, double priceProduct, String titleCategory) {        //product constructor  title price and category
        super(titleCategory);                                                               //super calls category
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
