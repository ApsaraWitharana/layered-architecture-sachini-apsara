package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrdersDAO {

           boolean getOrderDetail(String orderId) throws SQLException, ClassNotFoundException ;

           String generateNewOrderId() throws SQLException, ClassNotFoundException ;

           boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException ;

        }
