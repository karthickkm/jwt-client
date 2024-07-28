package com.jwtclient.jwt_client.service;

import com.jwtclient.jwt_client.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private WebClient webClient;

    @Override
    public String productApiTest() throws Exception {

        String str = webClient.get().uri("/products/welcome").retrieve().bodyToMono(String.class).block();
        return str;
    }

    /*@Override
    public List<Product> getAllProducts() {
        List<Product> productList = webClient.get()
    }*/
}
