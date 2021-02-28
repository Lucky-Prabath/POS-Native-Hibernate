package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Component
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    private Session session;
    private EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CustomerBOImpl(){
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session = session;
        customerDAO.setSession(session);
    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
        session.beginTransaction();
        customerDAO.save(mapper.getCustomer(dto));
        session.getTransaction().commit();
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        session.beginTransaction();
        customerDAO.update(mapper.getCustomer(dto));
        session.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        session.beginTransaction();
        customerDAO.delete(customerId);
        session.getTransaction().commit();
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        session.beginTransaction();
        List<CustomerDTO> collect = mapper.getCustomerDTOs(customerDAO.getAll());
        session.getTransaction().commit();
        return collect;
    }
}
