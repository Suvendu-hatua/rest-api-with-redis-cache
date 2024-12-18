package com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "product_desc")
    private String productDesc;

    @Column(name = "price",nullable = false)
    private Double productPrice;

    @Column(name = "count",nullable = false)
    private int productCount;

    @Column(name = "production_date")
    private Date productionDate;

    //Constructors

    public Product() {
    }

    public Product(String productName, String productDesc, Double productPrice, int productCount, Date productionDate) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.productionDate = productionDate;
    }
    //Setter and getter


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", productionDate=" + productionDate +
                '}';
    }
}
