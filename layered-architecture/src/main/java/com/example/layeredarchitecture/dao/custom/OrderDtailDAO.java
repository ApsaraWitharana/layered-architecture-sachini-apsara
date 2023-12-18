package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDtailDAO {

    boolean saveOrderDetail(String orderId,OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
