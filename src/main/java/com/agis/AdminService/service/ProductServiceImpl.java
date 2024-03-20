package com.agis.AdminService.service;

import com.agis.AdminService.entity.AuditDetails;
import com.agis.AdminService.entity.Country;
import com.agis.AdminService.entity.Product;
import com.agis.AdminService.entity.State;
import com.agis.AdminService.model.*;
import com.agis.AdminService.repository.CountryRepository;
import com.agis.AdminService.repository.ProductRepository;
import com.agis.AdminService.repository.StateRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public long createNewProduct(ProductRequest productRequest) {

        log.info(" Creating New Product : {}", productRequest);
        List<CountryRequest> countriesRequest = productRequest.getCountries();
        List<Country> countries = new ArrayList<>();
        for (CountryRequest countryRequest:countriesRequest) {
            List<StateRequest> stateRequests = countryRequest.getStates();
            List<State> states = new ArrayList<>();
            for (StateRequest stateRequest:stateRequests) {
                 State state = State.builder()
                         .stateCode(stateRequest.getStateCode())
                         .stateName(stateRequest.getStateName())
                         .build();
                 states.add(state);
            }
            Country country = Country.builder()
                  .countryCode(countryRequest.getCountryCode())
                  .countryName(countryRequest.getCountryName())
                  .states(states)
                  .build();
            countries.add(country);
        }

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productCode(productRequest.getProductCode())
                .productStatus(Boolean.TRUE).build();
        product.setCreatedBy("ADMIN");
        product.setCreatedDate(Instant.now());

        productRepository.save(product);

        for (Country country: countries) {
            country.setProduct(product);
            countryRepository.save(country);
            for (State state: country.getStates()) {
                state.setCountry(country);
                stateRepository.save(state);
            }
        }
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
