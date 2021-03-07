package lk.ijse.dep.web.api;

import lk.ijse.dep.web.business.custom.OrderBO;
import lk.ijse.dep.web.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-07
 **/

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderBO orderBO;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    public void placeOrder(@RequestBody OrderDTO orderDTO) throws Exception{
        orderBO.placeOrder(orderDTO);
    }
}
