package com.spring_boot.rest_service.Rest_Api_Redis_Cache.dao;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer>,ProductDao {
}
