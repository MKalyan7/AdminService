package com.agis.AdminService.service;

import com.agis.AdminService.entity.Product;
import com.agis.AdminService.model.ProductRequest;
import com.agis.AdminService.model.ProductResponse;
import com.agis.AdminService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public long createNewProduct(ProductRequest productRequest) {

        log.info(" Creating New Product : {}", productRequest);

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productCode(productRequest.getProductCode())
                .productCountry(productRequest.getCountry())
                .productStatus(Boolean.TRUE).build();

        productRepository.save(product);

        log.info("New Product Created");

        return product.getProductId();
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponses = productList.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
        return productResponses;
    }

    @Override
    public ProductResponse getProductDetail(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        ProductResponse productResponse = modelMapper.map(product,ProductResponse.class);
        return productResponse;
    }
}
