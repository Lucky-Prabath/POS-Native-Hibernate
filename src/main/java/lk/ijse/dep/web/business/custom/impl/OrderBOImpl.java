package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.OrderBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.DAOFactory;
import lk.ijse.dep.web.dao.DAOTypes;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dao.custom.ItemDAO;
import lk.ijse.dep.web.dao.custom.OrderDAO;
import lk.ijse.dep.web.dao.custom.OrderDetailDAO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.entity.Item;
import lk.ijse.dep.web.entity.OrderDetail;
import org.hibernate.Session;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    private ItemDAO itemDAO;
    private CustomerDAO customerDAO;
    private Session session;
    private EntityDTOMapper mapper = EntityDTOMapper.instance;

    public OrderBOImpl() {
        orderDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDER);
        orderDetailDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDER_DETAIL);
        itemDAO = DAOFactory.getInstance().getDAO(DAOTypes.ITEM);
        customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session = session;
        itemDAO.setSession(session);
        orderDAO.setSession(session);
        orderDetailDAO.setSession(session);
        customerDAO.setSession(session);
    }

    @Override
    public void placeOrder(OrderDTO dto) throws Exception {
        session.beginTransaction();
        try {
            boolean result = false;

            /* 1. Saving the order */
            orderDAO.save(mapper.getOrder(dto));

            /* 2. Saving Order Details -> Updating the stock */
            List<OrderDetail> orderDetails = mapper.getOrderDetails(dto.getOrderDetails());
            for (OrderDetail orderDetail : orderDetails) {
                orderDetailDAO.save(orderDetail);

                /* 3. Let's update the stock */
                Item item = itemDAO.get(orderDetail.getOrderDetailPK().getItemCode());
                if (item.getQtyOnHand() - orderDetail.getQty() < 0) {
                    throw new RuntimeException("Invalid stock");
                }
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                itemDAO.update(item);

            }

            session.getTransaction().commit();

        } catch (Throwable t) {
            session.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<OrderDTO> searchOrderByCustomerName(String name) throws Exception {
        return null;
    }
}
