package com.example.demo.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.demo.entity.Member;

public class JPAMain {
	  public static void main(String[] args) {

	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

	        EntityManager entityManager = entityManagerFactory.createEntityManager();

	        EntityTransaction entityTransaction = entityManager.getTransaction();

	        entityTransaction.begin();

	        try{
	        	
	        	
	        	
	        	Member member = new Member();
				/* member.setId(2L); */
	            
	            member.setUsername("Hello");
	            entityManager.persist(member); // 1�� ĳ�÷� ��� ����
	       
	            entityTransaction.commit();//���⼭ insert
				 
	        }catch (Exception exception){
	            entityTransaction.rollback();
	        }finally {
	            entityManager.close();
	        }

	        entityManagerFactory.close();
	    }

}