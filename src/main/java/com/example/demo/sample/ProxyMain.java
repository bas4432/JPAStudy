package com.example.demo.sample;

public class ProxyMain {

    public static void main(String[] args) {
    	  // 첫번째 과제
    	ProxyInterface proxyInf = new ProxyServer(new ProxyTargetImpl());
        
		/* 
		 * @Override public void consume() { System.out.println("Proxy Implement!!"); }
		 */
        
        proxyInf.consume();

        // @FunctionalInterface 를 도입하여 익명함수로 아래와 같이 구현부를 작성한다.
        ProxyInterface proxyInfWithLambda = new ProxyServer(
        	() -> {
            System.out.println("System Interface");
        });
        
        
        
        
     
        
        proxyInfWithLambda.consume();
       
		 
    }
}
