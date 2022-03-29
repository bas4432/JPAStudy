package com.example.demo.sample.pattern.Proxy;

import javax.persistence.Query;

public class ProxySelector implements Selector {
	
	private final QuerySelector querySelector;
	private final Code code;

	
	public ProxySelector(QuerySelector querySelector, Code code) {
		super();
		this.querySelector = querySelector;
		this.code = code; 
	}


	@Override
	public Object select() {
		// TODO Auto-generated method stub
		
		//Transaction - Begin
		
		
		if(Code.LAZY == code) {
			System.out.println("Loading만되었어");
		}else {
			this.querySelector.select();
		}
		
		
		//Transaction - Commit
		
		//Tranaction = ROllback
	
		//transaction = closed;
		
		
		return null;
	}
	
	
	
	
	

}
