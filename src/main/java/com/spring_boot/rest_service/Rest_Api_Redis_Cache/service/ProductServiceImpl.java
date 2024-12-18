package com.spring_boot.rest_service.Rest_Api_Redis_Cache.service;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.dao.ProductRepository;
import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> result =productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new RuntimeException("Not found product with productId:"+id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.searchProductByName(name);
    }

    @Override
    public List<Product> sortProductsByPriceAsc() {
        return productRepository.sortProductsByPriceAsc();
    }

    @Override
    public List<Product> sortProductsByPriceDesc() {
        return productRepository.sortProductsByPriceDesc();
    }

    @Override
    public List<Product> searchProductsByProductionYear(String year) {
        return productRepository.searchProductsByProductionYear(year);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(int id, Product product) {
        Product prod=getProductById(id);
        if(prod!=null){
            prod.setProductName(product.getProductName());
            prod.setProductionDate(product.getProductionDate());
            prod.setProductDesc(product.getProductDesc());
            prod.setProductPrice(product.getProductPrice());
            prod.setProductCount(product.getProductCount());
            return productRepository.save(prod);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteProductById(int id) {
        Product product=getProductById(id);
        productRepository.delete(product);
    }
}
