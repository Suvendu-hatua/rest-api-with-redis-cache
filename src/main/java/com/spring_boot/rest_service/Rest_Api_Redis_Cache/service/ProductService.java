package com.spring_boot.rest_service.Rest_Api_Redis_Cache.service;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product getProductById(int id);
    public List<Product> searchProductByName(String name);
    public List<Product> sortProductsByPriceAsc();
    public List<Product> sortProductsByPriceDesc();
    public List<Product> searchProductsByProductionYear(String year);
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public void deleteProductById(int id);
}
