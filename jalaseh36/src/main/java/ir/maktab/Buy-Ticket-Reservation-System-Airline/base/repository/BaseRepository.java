package ir.maktab.home_work17.base.repository;


import ir.maktab.home_work17.base.domain.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    void delete(E e);

    E findById(ID id);

    List<E> findAll();

    boolean existById(ID id);

    EntityManager getEntityManager();
}
