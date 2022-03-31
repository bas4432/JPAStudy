package com.example.demo.sample.pattern.Proxy;

public class ProxyMain {

	public static void main(String[] args) {

		Selector selector = new ProxySelector(new QuerySelector());
		
		selector.select();// 프록시 호출
	}

}
