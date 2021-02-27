package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-26
 **/
public interface CrudDAO<T extends SuperEntity, K extends Serializable> extends SuperDAO{

    void save(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(K key) throws  Exception;

    List<T> getAll() throws Exception;

    T get(K key) throws Exception;
 }
