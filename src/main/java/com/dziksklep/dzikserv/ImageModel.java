package com.dziksklep.dzikserv;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoId;
    private String photoName;

    @ManyToOne
    @JsonBackReference
    private Product product;

    public ImageModel() {
    }

    public ImageModel(Long photoId, String photoName, Product product) {
        this.photoId = photoId;
        this.photoName = photoName;
        this.product = product;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}