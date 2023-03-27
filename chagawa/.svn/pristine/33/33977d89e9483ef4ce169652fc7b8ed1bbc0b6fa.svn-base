package com.chagawa.main;

public class Execute {

	public static Object run(ServiceInterface service, Object obj) throws Exception {
		System.out.println("Execute.run() : 실행되는 서비스 - " + service.getClass().getSimpleName());
		System.out.println("Execute.run() : 전달되는 데이터 - " + obj);
		Object result = service.service(obj);
		System.out.println("Execute.run() : 결과 데이터 - " + result);
		return result;
	}

}
