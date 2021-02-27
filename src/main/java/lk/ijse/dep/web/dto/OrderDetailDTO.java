package lk.ijse.dep.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderDetailDTO implements Serializable {

    private String orderId;
    private String itemCode;
    private Integer qty;
    private BigDecimal unitPrice;

}
