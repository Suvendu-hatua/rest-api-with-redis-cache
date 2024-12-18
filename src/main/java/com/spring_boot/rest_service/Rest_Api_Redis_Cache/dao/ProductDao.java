package com.spring_boot.rest_service.Rest_Api_Redis_Cache.dao;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao {

    public List<Product> searchProductByName(String name);
    public List<Product> sortProductsByPriceAsc();
    public List<Product> sortProductsByPriceDesc();
    public List<Product> searchProductsByProductionYear(String year);


}
