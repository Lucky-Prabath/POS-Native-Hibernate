package lk.ijse.dep.web;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-01
 **/

@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setHibernateProperties(hibernateProperties());
        lsfb.setPackagesToScan("lk.ijse.dep.web.entity");
        lsfb.setDataSource(dataSource());
        return lsfb;
    }

    /*put datasource in to container*/
    @Bean
    public DataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(env.getRequiredProperty("dbcp.connection.driver_class"));
        bds.setUsername(env.getRequiredProperty("dbcp.connection.username"));
        bds.setPassword(env.getRequiredProperty("dbcp.connection.password"));
        bds.setUrl(env.getRequiredProperty("dbcp.connection.url"));
        bds.setInitialSize(env.getRequiredProperty("dbcp.initial_size", Integer.class));
        bds.setMaxTotal(env.getRequiredProperty("dbcp.max_total", Integer.class));
        return bds;
    }

    private Properties hibernateProperties(){
        Properties prop = new Properties();
        prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return prop;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        return  new HibernateTransactionManager(sessionFactory);
    }
}
