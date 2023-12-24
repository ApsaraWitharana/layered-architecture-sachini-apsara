package lk.ijse.layeredarchitecture.bo.custom;

import lk.ijse.layeredarchitecture.bo.SuperBO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;


import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

     boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
     ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

     void deleteItem(String code) throws SQLException, ClassNotFoundException;

     String genereteNewItemId() throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException;


}
