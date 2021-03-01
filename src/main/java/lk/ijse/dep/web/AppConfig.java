package lk.ijse.dep.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Configuration
@ComponentScan
@Import(HibernateConfig.class)
public class AppConfig {
}
