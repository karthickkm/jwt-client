package com.jwtclient.jwt_client.controller;

import com.jwtclient.jwt_client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ClientController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String ClientAPITest() throws Exception {
        return productService.productApiTest();
    }

}
