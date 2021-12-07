package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.TicketDto;
import ir.maktab.btrs.btrsa.repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {
    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }


    @Override
    public List<Ticket> searchByFromAndTo(TicketDto ticketDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = criteriaBuilder.createQuery(getEntityClass());
        Root<Ticket> root = query.from(getEntityClass());
        Predicate from = criteriaBuilder.like(root.get("start_point"),
                "%" + ticketDto.getFrom() + "%");

        Predicate to = criteriaBuilder.like(root.get("end_point"),
                "%" + ticketDto.getTo() + "%");

        Predicate date = criteriaBuilder.like(root.get("depart_time"),
                "%" + ticketDto.getDate() + "%");

        query.where(criteriaBuilder.and(from, to, date));

        return entityManager.createQuery(query).getResultList();


      /*  try {
        } *//*catch (Exception e) {
            return null;
        }*/
    }

    @Override
    public List<Ticket> sortByAirLineName(String name) {
        TypedQuery<Ticket> query = entityManager.createQuery("select t from Ticket t where t.id = : name",
                Ticket.class
        ).setParameter("name", name);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
//        select t.air_line

    }

    @Override
    public List<Ticket> sortedByPrice(int choose) {
        switch (choose) {
            case 1:
                TypedQuery<Ticket> query = entityManager.createQuery("select t from Ticket t order by t.price_ticket", getEntityClass());
                try {
                    return query.getResultList();
                } catch (NoResultException e) {
                    return null;
                }

            case 2:
                TypedQuery<Ticket> ticketTypedQuery = entityManager.createQuery("select t from Ticket t order by t.price_ticket desc ", getEntityClass());
                try {
                    return ticketTypedQuery.getResultList();
                } catch (NoResultException e) {
                    return null;
                }

            default:
                return null;

        }
    }
}
