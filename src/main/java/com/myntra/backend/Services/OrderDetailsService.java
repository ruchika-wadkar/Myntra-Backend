package com.myntra.backend.Services;

import com.myntra.backend.Entities.OrderDetail;
import com.myntra.backend.Entities.Product;
import com.myntra.backend.vo.OrderDetailVo;

public class OrderDetailsService {
    public static OrderDetail convertToOrderDetail(OrderDetailVo orderDetailsVo) {
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        product.setProductID(orderDetailsVo.getProductID());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());
        return orderDetail;
    }
}
