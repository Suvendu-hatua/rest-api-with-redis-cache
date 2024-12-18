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
        TypedQuery<Product>query=entityManager.createQuery("Select p from Product p where p.productName like :data",Product.class);
        //Setting data
        query.setParameter("data","%"+name+"%");
        return query.getResultList();
    }

    @Override
    public List<Product> sortProductsByPriceAsc() {
        TypedQuery<Product> query=entityManager.createQuery("Select p from Product p order by p.productPrice asc",Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> sortProductsByPriceDesc() {
        TypedQuery<Product> query=entityManager.createQuery("Select p from Product p order by p.productPrice desc",Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> searchProductsByProductionYear(String year) {
        TypedQuery<Product> query=entityManager.createQuery("Select p from Product p where p.productionDate like :data",Product.class);
        //Setting parameter
        query.setParameter("data","%"+year+"%");
        return query.getResultList();
    }

}
