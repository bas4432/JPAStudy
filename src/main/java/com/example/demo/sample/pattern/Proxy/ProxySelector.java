package com.example.demo.sample.pattern.Proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.demo.entity.Member;

public class ProxySelector implements Selector {

	private final QuerySelector querySelector;
	private final Code code;

	public ProxySelector(QuerySelector querySelector, Code code) {// 실제 객체를 프록시객체에 DI 주입
		super();
		this.querySelector = querySelector;
		this.code = code;
	}

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Object select() {
		// Transaction - Begin
		entityTransaction.begin();

		try {

			if (Code.LAZY == code) {
				System.out.println("Loading");

			} else {

				this.querySelector.select();
			}
			/*
			 * Member findmember = entityManager.getReference(Member.class, 1l);
			 */
			Member member = new Member();
			member.setTeamId(1L);
			member.setUsername("Prxoy");
			entityManager.persist(member);

			// Transaction - Commit
			entityTransaction.commit();

		} catch (Exception e) {
			entityTransaction.rollback();
			// Tranaction = ROllback
		} finally {
			entityManager.close();
			// transaction = closed;
		}
		return null;
	}
}
