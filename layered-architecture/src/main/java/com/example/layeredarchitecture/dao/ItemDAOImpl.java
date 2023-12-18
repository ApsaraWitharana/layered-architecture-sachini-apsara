package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
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
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> loadAllItem = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));

            loadAllItem.add(itemDTO);

        }
        return loadAllItem;
    }



    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, dto.getCode());
//        pstm.setString(2, dto.getDescription());
//        pstm.setBigDecimal(3, dto.getUnitPrice());
//        pstm.setInt(4, dto.getQtyOnHand());
//        return pstm.executeUpdate() >0;
    return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }
@Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//                PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//                pstm.setString(1, dto.getDescription());
//                pstm.setBigDecimal(2, dto.getUnitPrice());
//                pstm.setInt(3, dto.getQtyOnHand());
//                pstm.setString(4, dto.getCode());
//               return pstm.executeUpdate()>0;

    return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
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
    public ItemDTO search(String s) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, s);
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",s);
        //ResultSet rst = pstm.executeQuery();
        rst.next();
        return new ItemDTO(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));

  //  return SQLUtil.execute("SELECT * FROM Item WHERE code=?",s);
    }




}
