package lk.ijse.dep.web.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-27
 **/
public class HibernateUtilTest {

    @Test
    public void getSessionFactory() {
        assertNotNull(HibernateUtil.getSessionFactory());
        assertNotNull(HibernateUtil.getSessionFactory().openSession());
    }
}
