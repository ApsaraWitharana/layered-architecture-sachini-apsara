package lk.ijse.layeredarchitecture.dao;


import lk.ijse.layeredarchitecture.dao.impl.*;

public class DAOFactory {
    // singaetion

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null)?daoFactory = new DAOFactory():daoFactory;
    }


    public enum DAOTypes {
        CUSTOMER ,ITEM,ORDER,ORDER_DETAIL,QUERY
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:

                return new CustomerDAOImpl();
            case ITEM:

                return new ItemDAOImpl();

            case ORDER:
                return new OrderDAOImpl();

            case ORDER_DETAIL:

                return new OrderDetailsDAOImpl();

            case QUERY:

                return new QueryDAOImpl();

            default: return null;
        }
    }
}
