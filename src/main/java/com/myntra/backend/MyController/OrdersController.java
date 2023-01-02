package com.myntra.backend.MyController;


import com.myntra.backend.Services.OrderService;
import com.myntra.backend.Entities.Order;
import com.myntra.backend.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@Controller
@Validated  //why?
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/v1/order")
    ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/api/v1/order")
    ResponseEntity<String> addOrders(@RequestBody @Valid OrderVo order) throws ParseException {
        orderService.addOrders(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
