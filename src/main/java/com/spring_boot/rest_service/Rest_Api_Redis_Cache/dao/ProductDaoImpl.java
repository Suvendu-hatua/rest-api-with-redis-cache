package com.spring_boot.rest_service.Rest_Api_Redis_Cache.dao;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    private EntityManager entityManager;

    @Autowired
    public ProductDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> sortProductsByPriceAsc() {
        return List.of();
    }

    @Override
    public List<Product> sortProductsByPriceDesc() {
        return List.of();
    }

    @Override
    public List<Product> searchProductsByProductionYear(String year) {
        return List.of();
    }

}
