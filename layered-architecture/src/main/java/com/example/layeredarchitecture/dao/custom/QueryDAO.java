package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface QueryDAO {

    void customerOrderDetails(CustomerDTO customerDTO);

    void customerOrderDetails(CustomDTO customDTO)throws SQLException, ClassNotFoundException  ;
}
