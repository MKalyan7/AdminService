package com.agis.AdminService.controller;

import com.agis.AdminService.model.ProductRequest;
import com.agis.AdminService.model.ProductResponse;
import com.agis.AdminService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/createNewProduct")
    public long createNewProduct(@RequestBody ProductRequest productRequest) {
       return productService.createNewProduct(productRequest);
    }
    @GetMapping("/getProducts")
    private List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    private ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
        ProductResponse productResponse = productService.getProductDetail(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }


}
