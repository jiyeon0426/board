package com.sesac.board.config.secure;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class HandlerLoginFailure implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("===== onAuthenticationFailure ==== "+exception.getMessage());

        // 실패시 메세지
        String strErrorMsg = exception.getMessage();

        String strMsg="";
            if(strErrorMsg==null){
                strMsg = "입력하신 계정을 찾지 못했습니다.";
            }else{
                strMsg = exception.getMessage()+"(비밀번호를 체크해 주세요.)";
            }

            strMsg= URLEncoder.encode(strMsg,"UTF-8");//한글 인코딩 깨지는 문제 방지
            System.out.println("onAuthenticationFailure:"+ strMsg);
            String strUrl="/secure/login?message=";

            // 이동위치
            response.sendRedirect(strUrl +strMsg);
    }
}
