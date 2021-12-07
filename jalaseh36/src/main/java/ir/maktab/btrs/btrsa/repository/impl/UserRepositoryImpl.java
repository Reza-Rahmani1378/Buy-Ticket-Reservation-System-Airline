package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.User;
import ir.maktab.btrs.btrsa.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }


    @Override
    public User existByUsername(String username) {
        TypedQuery<User> user_name = entityManager.createQuery(
                "from User u where u.username = :username",
                User.class
        ).setParameter("username", username);
        try {
            return user_name.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}
