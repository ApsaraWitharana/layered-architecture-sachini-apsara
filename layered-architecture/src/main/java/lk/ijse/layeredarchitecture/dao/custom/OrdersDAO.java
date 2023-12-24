package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.CrudDAO;
import lk.ijse.layeredarchitecture.entity.Order;

import java.sql.SQLException;

public interface OrdersDAO extends CrudDAO<Order> {
        String generateID() throws SQLException, ClassNotFoundException;
        //  String generateID() throws SQLException, ClassNotFoundException;

//           boolean getOrderDetail(String orderId) throws SQLException, ClassNotFoundException ;
//
//    boolean save(Order entity) throws SQLException, ClassNotFoundException;
//
//    boolean update(Order entity) throws SQLException, ClassNotFoundException;
//
//    String generateID() throws SQLException, ClassNotFoundException;

    // String generateNewOrderId() throws SQLException, ClassNotFoundException ;

          // boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException ;

        }
