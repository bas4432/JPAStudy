
  package com.example.demo.sample;
  
  
  public class ProxyServer implements ProxyInterface{
  
  private final ProxyInterface proxyInf;
  
  public ProxyServer(ProxyInterface proxyInf) { this.proxyInf = proxyInf; }
  
  @Override public void consume() {
  
  // implement - 구현부 
	  proxyInf.consume();
  
  
  } }
 