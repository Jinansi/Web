/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Inventory;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Gunjan
 */
public class Product {

    //data members
    private int productId;
    private String name;
    private String modelNo;
    private String brand;
    private float price;
    private static int counter = 0;
    private ImageIcon image = null;
    private double easydeliverycommission = 0.2;

    //constructor
    public Product(String name) {
        this.name = name;
        this.productId = counter++;
    }

    //getters and setters
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public ImageIcon getImage() {
        return image;
   }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getEasydeliverycommission() {
        return easydeliverycommission;
    }

    public void setEasydeliverycommission(double easydeliverycommission) {
        this.easydeliverycommission = easydeliverycommission;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
