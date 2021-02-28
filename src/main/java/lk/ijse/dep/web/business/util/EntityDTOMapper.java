package lk.ijse.dep.web.business.util;

import lk.ijse.dep.web.AppInitializer;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.dto.OrderDetailDTO;
import lk.ijse.dep.web.entity.*;
import lk.ijse.dep.web.util.HibernateUtil;
import org.hibernate.Session;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    /*customer conversions----------------*/
    Customer getCustomer(CustomerDTO dto);

    CustomerDTO getCustomerDTO(Customer customer);

    List<CustomerDTO> getCustomerDTOs(List<Customer> customers);

    /*item conversions------------------*/
    Item getItem(ItemDTO dto);

    ItemDTO getItemDTO(Item item);

    List<ItemDTO> getItemDTOs(List<Item> items);

    /*order conversions-------------------*/
    @Mapping(source = "orderId", target = "id")
    @Mapping(source = ".", target = "date")
    @Mapping(source = ".", target = "customer")
    Order getOrder(OrderDTO dto);

    default Date toDate(OrderDTO dto){
        return Date.valueOf(dto.getOrderDate());
    }

    default Customer getCustomer(OrderDTO dto){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            CustomerDAO customerDAO = AppInitializer.getContext().getBean(CustomerDAO.class);
            try {
                customerDAO.setSession(session);
                return customerDAO.get(dto.getCustomerId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*order detail conversions--------------------*/
    List<OrderDetail> getOrderDetails(List<OrderDetailDTO> dtos);

    @Mapping(source = ".", target = "orderDetailPK", qualifiedByName = "pk")
    OrderDetail getOrderDetail(OrderDetailDTO dto);

    @Named("pk")
    default OrderDetailPK toOrderDetailPK(OrderDetailDTO dto){
        return new OrderDetailPK(dto.getOrderId(), dto.getItemCode());
    }

}
