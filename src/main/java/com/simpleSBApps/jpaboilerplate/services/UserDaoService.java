package com.simpleSBApps.jpaboilerplate.services;

import com.simpleSBApps.jpaboilerplate.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public class UserDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public UUID insertUser(User user) {
        entityManager.persist(user);
        return user.getId();
    }


}
