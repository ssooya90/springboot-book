package com.ssooya.book.springboot.config.auth;

import com.ssooya.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver{

	private final HttpSession httpSession;

	@Override
	public boolean supportsParameter(MethodParameter parameter){

		// 컨트롤러 메서드으이 특정 파라미터 지원유무 판단
		// 여기서는 파라미터에 @LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionUser.class 인 경우 true를 반환

		boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
		boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
		return isLoginUserAnnotation && isUserClass;

	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 파라미터에 전달한 객체를 생성합니다.
		// 여기서는 세션에서 객체를 가져온다

		return httpSession.getAttribute("user");
	}
}
