package lk.ijse.dep.web.dao.custom;

import lk.ijse.dep.web.dao.SuperDAO;
import lk.ijse.dep.web.entity.CustomEntity;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface QueryDAO extends SuperDAO {

    List<CustomEntity> getOrderInfo(String customerId) throws Exception;
}
