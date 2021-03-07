package lk.ijse.dep.web.business.util;

import lk.ijse.dep.web.WebAppInitializer;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.dto.OrderDetailDTO;
import lk.ijse.dep.web.entity.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Mapper(componentModel = "spring")
public abstract class EntityDTOMapper {

//    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Autowired
    private CustomerDAO customerDAO;

    /*customer conversions----------------*/
    public abstract Customer getCustomer(CustomerDTO dto);

    public abstract CustomerDTO getCustomerDTO(Customer customer);

    public abstract List<CustomerDTO> getCustomerDTOs(List<Customer> customers);

    /*item conversions------------------*/
    public abstract Item getItem(ItemDTO dto);

    public abstract ItemDTO getItemDTO(Item item);

    public abstract List<ItemDTO> getItemDTOs(List<Item> items);

    /*order conversions-------------------*/
    @Mapping(source = "orderId", target = "id")
    @Mapping(source = ".", target = "date")
    @Mapping(source = ".", target = "customer")
    public abstract Order getOrder(OrderDTO dto);

    public Date toDate(OrderDTO dto){
        return Date.valueOf(dto.getOrderDate());
    }

    public Customer getCustomer(OrderDTO dto) throws Exception {  //todo:check
        return customerDAO.get(dto.getCustomerId());
    }

    /*order detail conversions--------------------*/
    public abstract List<OrderDetail> getOrderDetails(List<OrderDetailDTO> dtos);

    @Mapping(source = ".", target = "orderDetailPK", qualifiedByName = "pk")
    public abstract OrderDetail getOrderDetail(OrderDetailDTO dto);

    @Named("pk")
    public OrderDetailPK toOrderDetailPK(OrderDetailDTO dto){
        return new OrderDetailPK(dto.getOrderId(), dto.getItemCode());
    }

}
