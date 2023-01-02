package com.myntra.backend.Services;

import com.myntra.backend.Entities.Customer;
import com.myntra.backend.Entities.Order;
import com.myntra.backend.Entities.OrderDetail;
import com.myntra.backend.Entities.Shipper;

import com.myntra.backend.Exceptions.*;
import com.myntra.backend.Repository.CustomerRepository;
import com.myntra.backend.Repository.OrderDetailsRepository;
import com.myntra.backend.Repository.OrderRepository;
import com.myntra.backend.Repository.ShipperRepository;
import com.myntra.backend.vo.OrderDetailVo;
import com.myntra.backend.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ShipperRepository shipperRepository;


    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public void addOrders(OrderVo order) throws ParseException {
       Order order1 = convertToOrder(order);
       if(customerRepository.findById(order.getCustomerID()).isEmpty())
           throw new CustomerException(("customer not found"));
        if(shipperRepository.findById(order.getShipperID()).isEmpty())
            throw new ShipperException("shipper not found");
        orderRepository.save(order1);

    }

    static Order convertToOrder(OrderVo orderVo) throws ParseException{
        Order order = new Order();
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getOrderDate()));
        Customer customers = new Customer();
        customers.setCustomerID(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shipper shippers = new Shipper();
        shippers.setShipperID(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetail> orderDetails = new ArrayList<>(); // Generics
        for(OrderDetailVo orderDetailsVo : orderVo.getOrderDetails()){ //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
