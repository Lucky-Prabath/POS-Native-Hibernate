package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface CustomerBO extends SuperBO {

    void saveCustomer(CustomerDTO dto) throws Exception;

    void updateCustomer(CustomerDTO dto) throws  Exception;

    void deleteCustomer(String customerId) throws Exception;

    List<CustomerDTO> findAllCustomers() throws Exception;

    CustomerDTO findCustomer(String customerId) throws  Exception;
}
