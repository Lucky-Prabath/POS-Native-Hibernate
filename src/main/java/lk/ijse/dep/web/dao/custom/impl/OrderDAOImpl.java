package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.CrudDAOImpl;
import lk.ijse.dep.web.dao.custom.OrderDAO;
import lk.ijse.dep.web.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {
}
