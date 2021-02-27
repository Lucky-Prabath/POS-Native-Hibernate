package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.OrderDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface OrderBO extends SuperBO {

    void placeOrder(OrderDTO dto) throws Exception;

    List<OrderDTO> searchOrderByCustomerName(String name) throws Exception;
}
