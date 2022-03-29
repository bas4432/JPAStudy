package com.example.demo.sample;

public class ProxyTargetImpl implements ProxyInterface{
    
	@Override
    public void consume() {
        System.out.println("Proxy Implement!!");
    }
}
