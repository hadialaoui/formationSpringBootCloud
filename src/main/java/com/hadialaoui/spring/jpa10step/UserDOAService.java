package com.hadialaoui.spring.jpa10step;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDOAService {

	@PersistenceContext
	EntityManager entityManager;
	
	public Long insert(UserMetier user) {
		entityManager.persist(user);	
		return user.getId();
	}
}
