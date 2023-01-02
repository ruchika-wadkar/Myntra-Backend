package com.myntra.backend.Services;

import com.myntra.backend.Entities.Product;
import com.myntra.backend.Entities.Supplier;
import com.myntra.backend.Exceptions.*;

import com.myntra.backend.Repository.ProductRepository;
import com.myntra.backend.Repository.SuppliersRepository;
import com.myntra.backend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SuppliersRepository suppliersRepository;
    //GET all products
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    // GET product by ID
    public ResponseEntity<Product> getProductByPid(Integer pid)  {
        return new ResponseEntity<>(productRepository.findById(pid).orElseThrow(() -> new ProductException("product not found with this id")), HttpStatus.OK);
    }

    //POST MAPPING
     @Transactional(readOnly = false, propagation = Propagation.REQUIRED)


    public void addProduct(List<ProductVo> products)  {
        // FOR-EACH LOOP (JAVA 5 FEATURE)
        for (ProductVo product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductException("product already exists");
            }
            productRepository.save(getEntity(product));
        }
    }
    //PUT MAPPING
    public void updateProduct(List<ProductVo> products)  {
        for (ProductVo p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductException("product not found");
            }
            productRepository.save(getEntity(p));
        }
    }
    //DELETE MAPPING
       public void deleteProductByID(Integer pid){
        productRepository.delete(productRepository.findById(pid).orElseThrow(() -> new ProductException("Product not found with this id")));
       }

    public Product getEntity(ProductVo product){
                Product P1 = new Product();
                P1.setProductID(product.getProductID());
                P1.setPrice(product.getPrice());
                P1.setProductName(product.getProductName());
                P1.setUnit(product.getUnit());
                Optional<Supplier> supplier = suppliersRepository.findById(product.getSupplierID());
                if(supplier.isEmpty()){
                    throw new SupplierException("Supplier not found");
                }
                P1.setSupplier(supplier.get());
                return P1;
    }
}