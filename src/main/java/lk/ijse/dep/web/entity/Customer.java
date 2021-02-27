package lk.ijse.dep.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "customer")                                //use javax persistence to import
public class Customer implements SuperEntity{
    @Id
    private  String id;
    private String name;
    private String address;
}
