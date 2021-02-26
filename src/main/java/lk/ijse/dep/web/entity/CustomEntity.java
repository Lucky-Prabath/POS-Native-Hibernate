package lk.ijse.dep.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomEntity implements SuperEntity{

    private String customerId;
    private String customerName;
    private String orderId;
    private Date orderDate;
    private BigDecimal orderTotal;
}
