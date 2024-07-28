package com.jwtclient.jwt_client.service;

import com.jwtclient.jwt_client.dto.AuthRequest;
import com.jwtclient.jwt_client.dto.Product;

import java.util.List;

public interface ProductService {

    String productApiTest() throws Exception;

    String authenticate(AuthRequest authRequest) throws Exception;

    List<?> getAllProducts(String jwtToken) throws Exception;

    Product getProduct(int prodId, String jwtToken) throws Exception;
}
