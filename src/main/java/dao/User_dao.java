package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.User_dto;

public class User_dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(User_dto dto) {
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
	}
	
	public User_dto login(String user_name) {
	    TypedQuery<User_dto> query = entityManager.createQuery("SELECT u FROM User_dto u WHERE u.user_name = :user_name", User_dto.class);
	    query.setParameter("user_name", user_name);
	    User_dto user;
	    try {
	        user = query.getSingleResult();
	    } catch (NoResultException e) {
	        user = null;
	    }
	    return user;
	}
}
