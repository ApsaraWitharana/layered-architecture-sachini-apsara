package lk.ijse.layeredarchitecture.dao.impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.QueryDAO;
import lk.ijse.layeredarchitecture.dto.CustomDTO;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;


import java.sql.ResultSet;
import java.sql.SQLException;

//public class QueryDAOImpl implements QueryDAO {
//
//
//    // join query
//    @Override
//    public void customerOrderDetails(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
////       Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm =connection.prepareStatement("select * from customer\n" +
////               "left join\n" +
////               "orders\n" +
////               "on customer. id = orders.customerID;\n");
////
////
//
////          pstm.setString(1,id);
////          pstm.setString(2,name);
////          pstm.setString(3,code);
////          pstm.setString(4,description);
////          pstm.setBigDecimal(5,unitPrice);
////          pstm.setInt(6,qtyOnHand);
//
//        //   pstm.executeQuery().next();
//
//         SQLUtil.execute("select * from customer\n" +
//                "left join\n" +
//                "orders\n" +
//                "on customer. id = orders.customerID;\n",customDTO);
//    }
//}


public class QueryDAOImpl implements QueryDAO {


    @Override
    public void customerOrderDetails(CustomerDTO customerDTO) {
        try {
            ResultSet resultSet = SQLUtil.execute("SELECT cu.id,cu.name,cu.address,o.oid,o.date,o2.itemCode,o2.qty,o2.unitPrice FROM customer cu JOIN company.orders o ON cu.id = o.customerID JOIN company.orderdetails o2 ON o.oid = o2.oid JOIN (SELECT customerID,MAX(o.oid) AS max_oid FROM customer cu JOIN company.orders o ON cu.id = o.customerID GROUP BY customerID) last_order ON o.customerID = last_order.customerID AND o.oid = last_order.max_oid;\n");
            while (resultSet.next()){
                System.out.printf("%-10s %-20s %-20s %-10s %-20s %-10s %-10s %-10s%n",
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("oid"),
                        resultSet.getString("date"),
                        resultSet.getString("itemCode"),
                        resultSet.getString("qty"),
                        resultSet.getString("unitPrice"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
}
}

    @Override
    public void customerOrderDetails(CustomDTO customDTO) throws SQLException, ClassNotFoundException {

    }
}
