package com.myntra.backend.MyController;

import ch.qos.logback.core.CoreConstants;
import com.myntra.backend.Entities.Product;
import com.myntra.backend.Exceptions.ProductException;

import com.myntra.backend.Exceptions.*;
import com.myntra.backend.Services.ProductService;

import com.myntra.backend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@Validated
@RestController

@CrossOrigin
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/v1/products/{pid}")
    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) {
        return productService.getProductByPid(pid);
    }

    @PostMapping("/api/v1/products")
    ResponseEntity<String> addProduct(@RequestBody @Valid List<ProductVo> products)  {
        productService.addProduct(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/products")
    ResponseEntity<String> updateProduct(@RequestBody @Valid List<ProductVo> products)  {
        productService.updateProduct(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/products/{pid}")
    ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer pid){
        productService.deleteProductByID(pid);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}