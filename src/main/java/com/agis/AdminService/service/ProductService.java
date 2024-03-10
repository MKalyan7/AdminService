package com.agis.AdminService.service;

import com.agis.AdminService.model.ProductRequest;
import com.agis.AdminService.model.ProductResponse;

import java.util.List;

public interface ProductService {
    long createNewProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();

    ProductResponse getProductDetail(long productId);
}
