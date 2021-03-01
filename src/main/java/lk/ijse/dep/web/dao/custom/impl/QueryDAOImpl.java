package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.custom.QueryDAO;
import lk.ijse.dep.web.entity.CustomEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Repository
public class QueryDAOImpl implements QueryDAO {

    @Autowired
    private Session session;

    @Override
    public List<CustomEntity> getOrderInfo(String customerId) throws Exception {

        List<Object[]> rows = session.createNativeQuery("SELECT c.id AS customer_id, c.name AS customer_name, o.id AS order_id, o.date AS order_date,\n" +
                "       SUM(od.qty * od.unit_price) as order_detail\n" +
                "FROM customer c\n" +
                "INNER JOIN `order` o on c.id = o.customer_id\n" +
                "INNER JOIN order_detail od on o.id = od.order_id\n" +
                "WHERE c.id=? GROUP BY o.id;").list();

        List<CustomEntity> orders = new ArrayList<>();
        for (Object[] row : rows) {
            orders.add(new CustomEntity(row[0].toString(),
                    row[1].toString(),
                    row[2].toString(),
                    (Date) row[3],
                    (BigDecimal) row[4]));
        }

        return orders;
    }
}
