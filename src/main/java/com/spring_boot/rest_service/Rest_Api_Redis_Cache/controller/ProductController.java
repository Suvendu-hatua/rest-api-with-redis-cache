package com.spring_boot.rest_service.Rest_Api_Redis_Cache.controller;

import com.spring_boot.rest_service.Rest_Api_Redis_Cache.entity.Product;
import com.spring_boot.rest_service.Rest_Api_Redis_Cache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        try{
            Product product=productService.getProductById(id);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try{
            product=productService.addProduct(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestBody Product product){
        try{
            product=productService.updateProduct(id,product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id){
        try{
            productService.deleteProductById(id);
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //Search Product by name.
    @GetMapping("/searchByName")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam("name") String name){
        try{
            return ResponseEntity.ok(productService.searchProductByName(name));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    //sort products by price asc or desc
    @GetMapping("/sort/{type}")
    public ResponseEntity<List<Product>> sortProductsByPrice(@PathVariable String type){
        try{
            if(type.equals("asc")){
                return ResponseEntity.ok(productService.sortProductsByPriceAsc());
            }else{
                return ResponseEntity.ok(productService.sortProductsByPriceDesc());
            }
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    //Search products by production year
    @GetMapping("/searchByYear")
    public ResponseEntity<List<Product>> searchProductsByProductionYear(@RequestParam("year")String year){
        try{
            return ResponseEntity.ok(productService.searchProductsByProductionYear(year));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
