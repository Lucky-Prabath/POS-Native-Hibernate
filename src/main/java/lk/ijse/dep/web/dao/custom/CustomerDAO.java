package lk.ijse.dep.web.dao.custom;

import lk.ijse.dep.web.dao.CrudDAO;
import lk.ijse.dep.web.entity.Customer;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface CustomerDAO extends CrudDAO<Customer, String> {

    List<Customer> searchCustomerByName(String name) throws Exception;
}
