package com.example.demo.sample.pattern.Proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import com.example.demo.entity.Member;

public class QuerySelector implements Selector {

	@Override
	public void select() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("실제 객체");
		Member member = new Member();
		member.setTeamId(2L);
		member.setUsername("RealSub");
		entityManager.persist(member);

	}

}
