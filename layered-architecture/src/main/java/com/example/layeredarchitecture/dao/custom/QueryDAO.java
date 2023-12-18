package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;

public interface QueryDAO {

    void customerOrderDetails(CustomDTO customDTO)throws SQLException, ClassNotFoundException  ;
}
