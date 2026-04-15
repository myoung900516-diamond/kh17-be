package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//인터셉터
//-스프링에서 발생하는 여러 작업들을 구체적으로 개입 할 수 있는 도구 
//-요청이 발생해서 응답으로 나가기 전까지 대부분의 과정을 확인하거나 제지할 수 있다. 
//-용도가 뚜렷하고 정해진 작업만 할 수 있기 때문에 (자유도가 없기 때문에) 상속을 받아서 구현함 
//-HandlerInterceptor를 상속받아서 필요한 메소드를 구현한다 
  //-preHandler() 매소드는 컨트롤러가 일을 시작하기 전 시점에 개입할 수 있다 (중지가능, 차단기능)
     //-return true는 통과, return false는 차단 
  //-postHandle()메소드는 컨트롤러가 일을 마친 후 시점에 개입
  //-afterCompletion() 메소드는 화면이 만들어진 후 시점에 개입할 수 있다. 

//@Component //단순한 하나의 작업 처리
@Service //거대한 하나의 작업 처리
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("테스트 인터셉터가 실행되었습니다");
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
