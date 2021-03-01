package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Service
@Transactional
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    private EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CustomerBOImpl(){
    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
        customerDAO.save(mapper.getCustomer(dto));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        customerDAO.update(mapper.getCustomer(dto));
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        customerDAO.delete(customerId);
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        List<CustomerDTO> collect = mapper.getCustomerDTOs(customerDAO.getAll());
        return collect;
    }
}
