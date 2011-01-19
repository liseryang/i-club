package com.iclub.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.iclub.dao.UserDao;
import com.iclub.member.vo.AuthenticateUser;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	public List<AuthenticateUser> userByName(String username) {
		String queryStr = "SELECT u FROM AuthenticateUser u WHERE u.username= ? ";
		return entityManager.createQuery(queryStr)
			   .setParameter(1,username).getResultList();
	}
}
