package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {


    // join query
    @Override
    public void customerOrderDetails(CustomDTO customDTO) throws SQLException, ClassNotFoundException {
//       Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm =connection.prepareStatement("select * from customer\n" +
//               "left join\n" +
//               "orders\n" +
//               "on customer. id = orders.customerID;\n");
//
//

//          pstm.setString(1,id);
//          pstm.setString(2,name);
//          pstm.setString(3,code);
//          pstm.setString(4,description);
//          pstm.setBigDecimal(5,unitPrice);
//          pstm.setInt(6,qtyOnHand);

        //   pstm.executeQuery().next();

         SQLUtil.execute("select * from customer\n" +
                "left join\n" +
                "orders\n" +
                "on customer. id = orders.customerID;\n",customDTO);
    }
}
