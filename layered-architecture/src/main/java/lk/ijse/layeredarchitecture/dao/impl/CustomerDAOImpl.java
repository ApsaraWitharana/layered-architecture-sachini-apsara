package lk.ijse.layeredarchitecture.dao.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.CustomerDAO;
import lk.ijse.layeredarchitecture.db.DBConnection;
import lk.ijse.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
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
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer>allCustomer = new ArrayList<>();

        while (rst.next()) {
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(entity);
        }
        return allCustomer;
    }
@Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
//        pstm.setString(1, dto.getId());
//        pstm.setString(2, dto.getName());
//        pstm.setString(3, dto.getAddress());
       return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",entity.getId(),entity.getName(),entity.getAddress());



        }
@Override
        public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//               PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
//                pstm.setString(1,dto.getName());
//                pstm.setString(2,dto.getName());
//                pstm.setString(3, dto.getId());
//                pstm.executeUpdate();

    return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",entity.getName(),entity.getAddress(),entity.getId());
        }
@Override
        public void delete(String id) throws SQLException, ClassNotFoundException {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
//            pstm.setString(1, id);
//            pstm.executeUpdate();
    SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
        }
@Override
        public boolean exist(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();
   ResultSet rst =SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
    return rst.next();

        }
@Override
        public String genereteNewId() throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDbConnection().getConnection();
            ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
            if (rst.next()) {
                String id = rst.getString("id");
                int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
                return String.format("C00-%03d", newCustomerId);
            } else {
                return "C00-001";
            }
    //return SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        }
@Override
        public Customer search(String id) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
//    String newValue = null;
//        pstm.setString(1, id);
//        ResultSet rst = pstm.executeQuery();
    ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id);
     rst.next();


 return new Customer(id+"",rst.getString("name"),rst.getString("address"));
        }



        }





