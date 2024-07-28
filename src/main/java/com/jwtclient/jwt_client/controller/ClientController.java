package com.jwtclient.jwt_client.controller;

import com.jwtclient.jwt_client.dto.AuthRequest;
import com.jwtclient.jwt_client.dto.Product;
import com.jwtclient.jwt_client.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String ClientAPITest() throws Exception {
        return productService.productApiTest();
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts() throws Exception {
        AuthRequest authRequest = new AuthRequest("admin", "admin");
        String jwtToken = productService.authenticate(authRequest);
        logger.info("Token : {}",jwtToken);
        List<Product> productList;
        if(StringUtils.hasText(jwtToken)) {
            productList = (List<Product>) productService.getAllProducts(jwtToken);
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
