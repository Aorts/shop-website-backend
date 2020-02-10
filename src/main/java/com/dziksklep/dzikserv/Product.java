package com.dziksklep.dzikserv;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productCategory;

    @OneToMany(mappedBy = "product", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ImageModel> image;

    private double productPrice;
    private String productDiscount;

    public Product() {
    }

    public Product(Long productId, String productName, String productCategory, List<ImageModel> image, double productPrice, String productDiscount) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.image = image;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<ImageModel> getImage() {
        return image;
    }

    public void setImage(List<ImageModel> image) {
        this.image = image;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }
}
