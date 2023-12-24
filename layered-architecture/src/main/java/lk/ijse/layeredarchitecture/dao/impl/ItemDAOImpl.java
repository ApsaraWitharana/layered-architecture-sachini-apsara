package lk.ijse.layeredarchitecture.dao.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.ItemDAO;
import lk.ijse.layeredarchitecture.db.DBConnection;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
//    @Override
//    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean save(T dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public void update(T dto) throws SQLException, ClassNotFoundException {
//
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
//    public T search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//    @Override
//    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean save(T dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public void update(T dto) throws SQLException, ClassNotFoundException {
//
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
//    public T search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");


        while (rst.next()) {
            allItems.add( new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")));



        }
        return allItems;
    }



    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, dto.getCode());
//        pstm.setString(2, dto.getDescription());
//        pstm.setBigDecimal(3, dto.getUnitPrice());
//        pstm.setInt(4, dto.getQtyOnHand());
//        return pstm.executeUpdate() >0;
    return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }
@Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//                PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//                pstm.setString(1, dto.getDescription());
//                pstm.setBigDecimal(2, dto.getUnitPrice());
//                pstm.setInt(3, dto.getQtyOnHand());
//                pstm.setString(4, dto.getCode());
//               return pstm.executeUpdate()>0;

    return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand(),entity.getCode());
    }
@Override
public boolean exist(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();

    // ekpara retern krnn ba resalt set ekkat aran tmyi retern krnne

    ResultSet rst= SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
    return rst.next();
    }
@Override
    public void delete(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        pstm.executeUpdate();
    SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public String genereteNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
            if (rst.next()) {
                String id = rst.getString("code");
                int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
                return String.format("I00-%03d", newItemId);
            } else {
                return "I00-001";
            }
    }
@Override
    public Item search(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, code);
        //ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",s);
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code+"");
        rst.next();
    return new Item(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

  //  return SQLUtil.execute("SELECT * FROM Item WHERE code=?",s);
    }




}
