package lk.ijse.dep.web.dao;

import org.hibernate.Session;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface SuperDAO {

    void setSession(Session session) throws Exception;
}
