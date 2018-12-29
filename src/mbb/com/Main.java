package mbb.com;

import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {


        ArrayList<Category> categoryArrayList = new ArrayList<>();      //categories stored in Arraylist
        ArrayList<Product> productArrayList = new ArrayList<>();        //products stored in Arraylist

        Category categoryClothes = new Category("Clothes");     //new categories created
        Category categoryFood = new Category("Food");
        Category categoryPhone = new Category("Phone");

        categoryArrayList.add(categoryFood);                //categories added category Array list
        categoryArrayList.add(categoryPhone);
        categoryArrayList.add(categoryClothes);

        Product product1 = new Product("htc one m8",1500.0,categoryPhone.getTitleCategory());           //new products created
        Product product2 = new Product("samsung galaxy j7",1300.0,categoryPhone.getTitleCategory());
        Product product3 = new Product("orange",5.0,categoryFood.getTitleCategory());
        Product product4 = new Product("tshirt",15.0,categoryClothes.getTitleCategory());

        productArrayList.add(product1);         //products added arraylist
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);


       Cart cart = new Cart();                  //cart created
       cart.addItem(product1,1);        //product added cart with quantities

       cart.addItem(product1,1);

       cart.addItem(product2,2);
       cart.addItem(product3,5);
       cart.addItem(product4,5);
       cart.addItem(product1,1);



        double lastPrice = cart.getTotalAmountAfterDiscount(cart,categoryArrayList)+cart.getDeliveryCost(cart,categoryArrayList);   //total price getting and sum with delivery cost


        System.out.println("Delivery Cost : "+cart.getDeliveryCost(cart,categoryArrayList));        //delivery cost printed
        System.out.println("Total (with Delivery) : " + lastPrice);                                 //total last price printed
    }

}
