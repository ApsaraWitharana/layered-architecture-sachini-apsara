package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.SuperDAO;
import lk.ijse.layeredarchitecture.dto.CustomDTO;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;

public interface QueryDAO  extends SuperDAO {

    void customerOrderDetails(CustomerDTO customerDTO);

    void customerOrderDetails(CustomDTO customDTO) throws SQLException, ClassNotFoundException;

    //  void customerOrderDetails(CustomDTO customDTO)throws SQLException, ClassNotFoundException  ;
}
