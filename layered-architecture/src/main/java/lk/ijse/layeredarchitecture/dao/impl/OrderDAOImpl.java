package lk.ijse.layeredarchitecture.dao.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.OrdersDAO;
import lk.ijse.layeredarchitecture.entity.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrdersDAO {
//@Override
//  public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
////      Connection connection = DBConnection.getDbConnection().getConnection();
////      PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
////      stm.setString(1, dto.getOrderId());
////      stm.setDate(2, Date.valueOf(dto.getOrderDate()));
////      stm.setString(3, dto.getCustomerId());
//
//     // return stm.executeUpdate()>0;
//
//    return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
//
//  }
//@Override
//  public String generateNewOrderId() throws SQLException, ClassNotFoundException {
//      Connection connection = DBConnection.getDbConnection().getConnection();
//      Statement stm = connection.createStatement();
//      ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//      return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
//
//
//  }
//  @Override
//    public boolean getOrderDetail(String orderId) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
////        stm.setString(1, orderId);
////        return stm.executeQuery().next();
//
//    ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
//    return rst.next();
//
//    }
//
//    @Override
//    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public void delete(String id) throws SQLException, ClassNotFoundException {
//
//    }
//
//    @Override
//    public boolean exist(String id) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public String genereteNewId() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Orders (oid, date, customerID) VALUES (?,?,?)",entity.getOrderId(),Date.valueOf(entity.getOrderDate()),entity.getCustomerId());
    }

    @Override
    public boolean update(Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM Orders WHERE oid=?",id);
        return rst.next();
    }

    @Override
    public String genereteNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM Orders ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
    }

    @Override
    public Order search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}
