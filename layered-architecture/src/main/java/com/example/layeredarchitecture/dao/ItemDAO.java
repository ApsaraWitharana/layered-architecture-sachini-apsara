package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

     boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;


     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;


     boolean exciteItem(String code) throws SQLException, ClassNotFoundException ;



     void deleteItem(String code) throws SQLException, ClassNotFoundException ;


   String genereteNewId() throws SQLException, ClassNotFoundException ;

   ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException ;



    }
