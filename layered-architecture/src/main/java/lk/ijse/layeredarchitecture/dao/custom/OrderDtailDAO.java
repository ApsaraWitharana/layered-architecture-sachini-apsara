package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.CrudDAO;
import lk.ijse.layeredarchitecture.entity.OrderDetails;

public interface OrderDtailDAO extends CrudDAO<OrderDetails> {

    //boolean saveOrderDetail(String orderId,OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
