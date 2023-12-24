package lk.ijse.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;
//T ona comman parameter type tiyagnna puluwn wenn t dnne

// crudDAO - comman method thiya gann hadanne
public interface CrudDAO <T> extends SuperDAO{

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;


    boolean save(T dto) throws SQLException, ClassNotFoundException ;


    boolean update(T dto) throws SQLException, ClassNotFoundException ;


    void delete(String id) throws SQLException, ClassNotFoundException ;



    boolean exist(String id) throws SQLException, ClassNotFoundException ;




    String genereteNewId() throws SQLException, ClassNotFoundException ;

    T search(String s) throws SQLException, ClassNotFoundException ;

//unit method
 //   void customerCount(){

 //   }

}
