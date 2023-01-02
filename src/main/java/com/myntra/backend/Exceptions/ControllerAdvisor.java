package com.myntra.backend.Exceptions;

import org.hsqldb.HsqlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomerException.class)
    ResponseEntity<String> customerNotFound(CustomerException customerException){
        return new ResponseEntity<>(customerException.getMessage(),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ShipperException.class)
    ResponseEntity<String> shipperNotFound(ShipperException shipperException){
        return new ResponseEntity<>(shipperException.getMessage(),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(SupplierException.class)
    ResponseEntity<String> supplierNotFound(SupplierException supplierException){
        return new ResponseEntity<>(supplierException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductException.class)
    ResponseEntity<String> ProductNotFound(ProductException productException){
        return new ResponseEntity<>(productException.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(OrderException.class)
    ResponseEntity<String> orderNotFound(OrderException orderException){
        return new ResponseEntity<>(orderException.getMessage(),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(HsqlException.class)
    ResponseEntity<String> HsqlDb(HsqlException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
