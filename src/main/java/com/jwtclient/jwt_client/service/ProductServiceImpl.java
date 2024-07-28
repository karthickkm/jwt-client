package com.jwtclient.jwt_client.service;

import com.jwtclient.jwt_client.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private WebClient webClient;

    @Override
    public String authenticate(AuthRequest authRequest) throws Exception {
        return webClient.post().uri("/products/authenticate").bodyValue(authRequest).retrieve().bodyToMono(String.class).block();
    }

    @Override
    public List<?> getAllProducts(String jwtToken) throws Exception {
        return webClient.get().uri("/products/all").headers(httpHeaders -> httpHeaders.setBearerAuth(jwtToken)).retrieve().bodyToMono(List.class).block();
    }

    @Override
    public String productApiTest() throws Exception {
        return webClient.get().uri("/products/welcome").retrieve().bodyToMono(String.class).block();
    }

}
