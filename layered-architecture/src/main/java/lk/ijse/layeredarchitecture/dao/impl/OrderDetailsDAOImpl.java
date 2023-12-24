package lk.ijse.layeredarchitecture.dao.impl;

import lk.ijse.layeredarchitecture.dao.custom.OrderDtailDAO;
import lk.ijse.layeredarchitecture.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDtailDAO {

//    @Override
//    public boolean saveOrderDetail(String orderId ,OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection= DBConnection.getDbConnection().getConnection();
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
//        stm.setString(1, orderId);
//        stm.setString(2, dto.getItemCode());
//        stm.setBigDecimal(3, dto.getUnitPrice());
//        stm.setInt(4, dto.getQty());
//        return stm.executeUpdate()>0;

//      SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
//
  //  }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genereteNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    //
}
