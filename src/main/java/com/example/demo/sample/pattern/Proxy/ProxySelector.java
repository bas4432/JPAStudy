package com.example.demo.sample.pattern.Proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Member;

public class ProxySelector implements Selector {

	private final QuerySelector queryselector;

	public ProxySelector(QuerySelector queryselector) {// 실제 객체를 프록시객체에 DI 주입 (프록시는 실제 객체를 가지고 있어야한다)
		this.queryselector = queryselector;
	}

	@Override
	public void select() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// Transaction - Begin
		entityTransaction.begin();

		try {
            System.out.println("프록시가 대신 실제 객체 호출");
			queryselector.select();

			// Transaction - Commit
			entityTransaction.commit();

		} catch (Exception e) {
			entityTransaction.rollback();
			// Tranaction = ROllback
		} finally {
			entityManager.close();
			// transaction = closed;
		}

	}
}
