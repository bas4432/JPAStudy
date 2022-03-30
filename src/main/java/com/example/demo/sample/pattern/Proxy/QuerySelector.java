package com.example.demo.sample.pattern.Proxy;

import com.example.demo.entity.Member;

public class QuerySelector implements Selector {

	@Override
	public Object select() {

		System.out.println("실제 객체");
		Member member = new Member();
		member.setTeamId(2L);
		member.setUsername("RealSub");

		return member;

	}

}
